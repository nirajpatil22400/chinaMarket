package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.RequestDto.SellerRequestDto;
import com.ChinaMarket.ChinaMarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerRequestDto sellerRequestDto){
        return sellerService.addSeller(sellerRequestDto);
    }


    // Get all sellers
    @GetMapping("/get_seller")
    List<Seller> getSeller(){
        return sellerService.getSeller();
    }

    // get a seller by PAN No
    @GetMapping("/find_by_PanNo")
    public String getSellerByPanNo(@RequestParam("panNo") String panNo){
        return sellerService.findByPanNo(panNo);
    }

    // find sellers of a particular age
}
