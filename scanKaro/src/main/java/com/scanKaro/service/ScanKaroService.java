package com.scanKaro.service;

import com.scanKaro.dto.ItemDescription;
import com.scanKaro.repository.ScanKaroRepo;
import com.sun.jdi.InvalidTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
public class ScanKaroService {

    @Autowired
    ScanKaroRepo scanKaroRepo;

    public String saveRequestDataInDatabase(ItemDescription itemDescription) {
        scanKaroRepo.save(itemDescription);
        return "saved successfully";
    }

    public String generate_qr() {
        try {
            String qrCodeData = String.valueOf(scanKaroRepo.findAll());
            String xyz= String.valueOf(scanKaroRepo.findAll());
            System.out.println(xyz);
            for (ItemDescription itemDescription: scanKaroRepo.findAll()) {
                System.out.println(itemDescription);
            }
            System.out.println("1123252");
            String filePath = "C:\\Users\\Divya_Intern\\Desktop\\FinalYearProject\\scanKaro\\restaurantItem.png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map< EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap< EncodeHintType, ErrorCorrectionLevel >();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(qrCodeData.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToPath(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), Paths.get(filePath));
            return "QR Code image created successfully!";
        } catch (Exception e) {
            System.err.println(e);
            return"exception";
        }
    }

    public void updateItem(String foodName){

        }


    public void deleteItem(String foodName){
        scanKaroRepo.deleteById(foodName);
        System.out.println("Item with id " + foodName + " deleted...");

    }
}
