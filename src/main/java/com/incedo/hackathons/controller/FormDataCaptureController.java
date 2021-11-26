package com.incedo.hackathons.controller;

import com.incedo.hackathons.services.SaveFormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormDataCaptureController {

    @Autowired
    private SaveFormDataService saveFormData;

    @PostMapping("/UploadServlet")
    public void saveData(){
        saveFormData.saveData();
    }

}
