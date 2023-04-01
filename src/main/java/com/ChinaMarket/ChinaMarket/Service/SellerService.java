package com.ChinaMarket.ChinaMarket.Service;


import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.Repository.SellerRepository;
import com.ChinaMarket.ChinaMarket.RequestDto.SellerRequestDto;
import com.ChinaMarket.ChinaMarket.convertor.SellerConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {


    @Autowired
    SellerRepository sellerRepo;

    public String addSeller(SellerRequestDto sellerRequestDto) {

        Seller seller = SellerConvertor.SellerRequestDtoToSeller(sellerRequestDto);
        sellerRepo.save(seller);

        return "Congrats! Now you can sell on China Market !!!";

    }

    public  List<Seller> getSeller(){
        return sellerRepo.findAll();
    }

    //pancard
    public String findByPanNo(String panNo){
        Seller seller = sellerRepo.findByPanNo(panNo);
        return " Seller Name : " + seller.getName() + " | Seller Mobile Number : " + seller.getMobNo();
    }
}
