package com.incedo.hackathons.controller;

import com.incedo.hackathons.dto.CandidateDTO;
import com.incedo.hackathons.services.SaveFormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.WebServlet;

@RestController
public class FormDataCaptureController {

    @Autowired
    private SaveFormDataService saveFormData;

    @PostMapping("/UploadServlet")
    public String saveData(CandidateDTO candidateInfo){
        saveFormData.saveData(candidateInfo);
        System.out.println(candidateInfo);
        return "File Data Saved";
    }



}
