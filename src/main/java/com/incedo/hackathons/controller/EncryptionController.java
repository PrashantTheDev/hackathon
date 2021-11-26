package com.incedo.hackathons.controller;

import com.incedo.hackathons.services.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class EncryptionController {

    @Autowired
    private EncryptionService encryptionService;

    @GetMapping("/post")
    public String encryptFiles(){
        encryptionService.createEncryption2();
        return "File Saved Successfully In Spring JSP";
    }




}
