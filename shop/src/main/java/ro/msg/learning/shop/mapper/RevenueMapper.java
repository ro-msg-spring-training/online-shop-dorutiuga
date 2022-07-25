package ro.msg.learning.shop.mapper;

import ro.msg.learning.shop.dto.RevenueDTO;
import ro.msg.learning.shop.entity.Revenue;

import java.util.ArrayList;
import java.util.List;

public class RevenueMapper {

    public static RevenueDTO fromEntityToDto(Revenue revenue){
        return RevenueDTO.builder()
                .date(revenue.getDate())
                .locationId(revenue.getLocation().getId())
                .sum(revenue.getSum())
                .build();
    }

    public static List<RevenueDTO> fromEntityListToListDto(List<Revenue> revenueList){
        List<RevenueDTO> result = new ArrayList<>();

        for(Revenue revenue : revenueList){
            result.add(fromEntityToDto(revenue));
        }
        return result;
    }
}
