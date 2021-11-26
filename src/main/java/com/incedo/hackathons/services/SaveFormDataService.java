package com.incedo.hackathons.services;

import com.incedo.hackathons.dto.CandidateDTO;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class SaveFormDataService {

    public void saveData(CandidateDTO candidateInfo){
        System.out.println("In Service\n\n\n" + candidateInfo);
        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setEncryptFiles(true);
            zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);

            String currentPath = EncryptionService.class.getResource("").getPath();
            String currentYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
            String currentMonth = new SimpleDateFormat("MMM").format(Calendar.getInstance().get(Calendar.MONTH));

            String finalPath = "/home/rmanjrekar/candidate/data";
//            finalPath = finalPath + "/" + currentYear;
//            finalPath = finalPath + "/" + currentMonth;
            finalPath = finalPath +  "/" + candidateInfo.getName() + "_" + candidateInfo.getMobNum();

            System.out.println("In Service\n\n\n" + finalPath);

            File offerLetter = checkFileIfExsits(finalPath, candidateInfo.getOfferLetter());
            File pan = checkFileIfExsits(finalPath, candidateInfo.getPan());

            ZipFile zipFile = new ZipFile(finalPath + ".zip", "Incedo@3_0".toCharArray());
            zipFile.addFile(offerLetter, zipParameters);
            zipFile.addFile(pan, zipParameters);
            zipFile.close();

            offerLetter.delete();
            pan.delete();

            /*if(checkDirIfExists(finalPath)) {
                finalPath = finalPath + "/" + currentYear;
                if(checkDirIfExists(finalPath)) {
                    finalPath = finalPath + "/" + currentMonth;
                    if (checkDirIfExists(finalPath)) {
                        finalPath = finalPath +  "/" + candidateInfo.getName() + "_" + candidateInfo.getMobNum();
                        if (checkDirIfExists(finalPath)) {
                            System.out.println("In Service\n\n\n" + finalPath);

                            File offerLetter = checkFileIfExsits(finalPath, candidateInfo.getOfferLetter());
                            File pan = checkFileIfExsits(finalPath, candidateInfo.getPan());

                            ZipFile zipFile = new ZipFile(finalPath + "/compressed.zip", "Incedo@3_0".toCharArray());
                            zipFile.addFile(offerLetter, zipParameters);
                            zipFile.addFile(pan, zipParameters);
                            zipFile.close();
                        }
                    }
                }
            }*/

            /*ZipFile zipFile = new ZipFile("/home/pnandan/Desktop/My Files/Hackethon/demo/compressed.zip", "incedo".toCharArray());
            zipFile.addFile(new File("/home/pnandan/Desktop/My Files/Hackethon/demo/aFile.txt"), zipParameters);

            File fileToAdd = new File("/home/pnandan/Desktop/My Files/Hackethon/demo/aFile.txt");
            if (!fileToAdd.exists()) {
                fileToAdd.createNewFile();
            }*/

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private File checkFileIfExsits(String finalPath, MultipartFile multipartFile) throws IOException {
        File file = new File(finalPath+ "-" + multipartFile.getOriginalFilename());
        if (!file.exists()) {
            file.createNewFile();
            multipartFile.transferTo(file);
        }
        return file;
    }

    public boolean checkDirIfExists(String path) {
        System.out.println("In checkDirIfExists: 1 \n\n\n" + path);
        boolean retBool = false;
        File filePath = new File(path);
        if (!filePath.exists()) {
            retBool = filePath.mkdirs();
            System.out.println("In checkDirIfExists: 2 \n\n\n" + retBool);
        } else {
            System.out.println("In checkDirIfExists: 3 \n\n\n" + "file exists");
        }
        return retBool;
    }
}
