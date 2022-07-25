package ro.msg.learning.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.Revenue;
import ro.msg.learning.shop.repository.RevenueRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RevenueService {

    private final RevenueRepository revenueRepository;

    public List<Revenue> allRevenues(){
        return revenueRepository.findAll();
    }
    public List<Revenue> getRevenuesForAGivenDate(LocalDateTime date){
        return revenueRepository.findAllByDate(date);
    }
}
