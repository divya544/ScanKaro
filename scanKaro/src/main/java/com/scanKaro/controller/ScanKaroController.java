package com.scanKaro.controller;

import com.scanKaro.dto.ItemDescription;
import com.scanKaro.repository.ScanKaroRepo;
import com.scanKaro.service.ScanKaroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScanKaroController {

    @Autowired
    ScanKaroService scanKaroService;

    @Autowired
    ScanKaroRepo scanKaroRepo;

    @GetMapping("/home")
    public String home(){
        return "Home";
    }

    @PostMapping("/addItem")
    public String saveDataInDatabase(@RequestBody ItemDescription itemDescription){
        String msg= scanKaroService.saveRequestDataInDatabase(itemDescription);
        return msg;
    }

    @GetMapping("/getQrCode")
    public String generateQRCode(){
        scanKaroService.generate_qr();
        return "QR code is generated successfully";
    }

    @PostMapping("/updateItem")
    public void updateItem(@RequestBody ItemDescription itemDescription){

        scanKaroService.updateItem(itemDescription.getFoodName());

    }
//    @GetMapping("/editOrder/{foodName}")
//    public String editCustomerOrder(@PathVariable("foodName") String foodName, ItemDescription itemDescription) {
//        ItemDescription o = scanKaroRepo.findById(foodName).orElse(null);
//        itemDescription.addAttribute("newOrder", o);
//        return "CustomerOrder";
//    }
    @DeleteMapping("/deleteItem")
    public String deleteItem(@RequestBody ItemDescription itemDescription){
         scanKaroService.deleteItem(itemDescription.getFoodName());
         return "Item is deleted successfully";
    }



}
