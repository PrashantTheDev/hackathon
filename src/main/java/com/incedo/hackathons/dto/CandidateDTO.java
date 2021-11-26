package com.incedo.hackathons.dto;


import org.springframework.web.multipart.MultipartFile;

public class CandidateDTO {


    private String name;

    private String mobNum;

    private String joiningDate;

    private MultipartFile offerLetter;

    private MultipartFile pan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNum() {
        return mobNum;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public MultipartFile getOfferLetter() {
        return offerLetter;
    }

    public void setOfferLetter(MultipartFile offerLetter) {
        this.offerLetter = offerLetter;
    }

    public MultipartFile getPan() {
        return pan;
    }

    public void setPan(MultipartFile pan) {
        this.pan = pan;
    }

    @Override
    public String toString() {
        return "CandidateDTO{" +
                "name='" + name + '\'' +
                ", mobNum='" + mobNum + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", offerLetter=" + offerLetter +
                ", pan=" + pan +
                '}';
    }
}
