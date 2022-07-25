package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.RevenueDTO;
import ro.msg.learning.shop.entity.Revenue;
import ro.msg.learning.shop.mapper.RevenueMapper;
import ro.msg.learning.shop.service.RevenueService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/revenues")
public class RevenueController {
    @Autowired
    private RevenueService revenueService;


    @GetMapping(value = "/{givenDate}", produces = {"application/json"})
    public ResponseEntity<List<RevenueDTO>> exportRevenuesForAGivenDate(@PathVariable String givenDate) {
        LocalDate date = LocalDate.parse(givenDate);
        List<Revenue> revenues = revenueService.getRevenuesForAGivenDate(date.atStartOfDay());
        List<RevenueDTO> revenueDTOS = RevenueMapper.fromEntityListToListDto(revenues);
        return new ResponseEntity<>(revenueDTOS, HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<RevenueDTO>> allRevenues() {
        List<Revenue> revenues = revenueService.allRevenues();
        List<RevenueDTO> revenueDTOS = revenues.stream().map(RevenueMapper::fromEntityToDto).collect(Collectors.toList());
        return new ResponseEntity<>(revenueDTOS, HttpStatus.OK);
    }
}
