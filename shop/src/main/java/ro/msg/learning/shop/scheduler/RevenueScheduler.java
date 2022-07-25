package ro.msg.learning.shop.scheduler;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dto.OrderDetailDTO;
import ro.msg.learning.shop.dto.OrderSchedulerDTO;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.Revenue;
import ro.msg.learning.shop.mapper.OrderDetailMapper;
import ro.msg.learning.shop.mapper.OrderSchedulerMapper;
import ro.msg.learning.shop.repository.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@Service
public class RevenueScheduler {

    @Autowired
    private  OrdersRepository ordersRepository;
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private  OrderDetailRepository orderDetailRepository;
    @Autowired
    private  LocationRepository locationRepository;
    @Autowired
    private   RevenueRepository revenueRepository;

    @Scheduled(cron = "0 0 10 * * *")
    @Transactional
    public void revenuesReportsForToday() {
        System.out.println("Cron started");
        LocalDate today = LocalDate.now();
        LocalDateTime atStart = today.minusDays(1).atStartOfDay();
        LocalDateTime atEnd = today.atStartOfDay();

        List<OrderSchedulerDTO> ordersPlacedToday = OrderSchedulerMapper.fromEntityListToDtoList(ordersRepository.findOrdersBetweenDates(atStart, atEnd));

        Map<Integer, List<Integer>> ordersAndLocations = ordersAndListOfLocations(ordersPlacedToday);

        Map<Integer, BigDecimal> revenueAtLocation = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : ordersAndLocations.entrySet()) {
            List<OrderDetailDTO> orderDetailDTOS = OrderDetailMapper.fromListEntityToListDto(orderDetailRepository.findAllByOrderId(entry.getKey()));

            BigDecimal sum = BigDecimal.ZERO;
            for (OrderDetailDTO orderDetailDTO : orderDetailDTOS) {
                Optional<Product> orderProduct = productRepository.findById(orderDetailDTO.getProductId());
                if (orderProduct.isPresent()) {
                    BigDecimal totalRevenue = BigDecimal.valueOf(orderProduct.get().getPrice() * orderDetailDTO.getQuantity());
                    sum = sum.add(totalRevenue);
                }
            }
            for (Integer locationID : entry.getValue())
                revenueAtLocation.put(locationID, sum);


        }
        for (Map.Entry<Integer, BigDecimal> entry : revenueAtLocation.entrySet()) {
            Optional<Location> location = locationRepository.findById(entry.getKey());
            if (location.isPresent()) {
                Revenue revenueToAdd = Revenue.builder()
                        .sum(entry.getValue())
                        .date(LocalDate.now().atStartOfDay())
                        .location(location.get())
                        .build();
                revenueRepository.save(revenueToAdd);
            }

        }

    }

    public Map<Integer, List<Integer>> ordersAndListOfLocations(List<OrderSchedulerDTO> ordersPlacedToday) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (OrderSchedulerDTO orderSchedulerDTO : ordersPlacedToday) {
            List<Integer> orderForCurrentLocation = new ArrayList<>();

            orderForCurrentLocation.add(orderSchedulerDTO.getLocation().getId());
            result.put(orderSchedulerDTO.getOrderId(), orderForCurrentLocation);
        }
        return result;
    }
}
