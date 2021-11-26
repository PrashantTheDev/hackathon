package com.incedo.hackathons.services;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class EncryptionService {
    public void createEncryption2(){
        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setEncryptFiles(true);
            zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);

            String currentPath = EncryptionService.class.getResource("").getPath();
            String currentYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
            String currentMonth = new SimpleDateFormat("MMM").format(Calendar.getInstance().get(Calendar.MONTH));

            if(checkDirIfExists(currentPath + "/data")) {
                if(checkDirIfExists(currentPath + "/" + currentYear)) {
                    if (checkDirIfExists(currentPath + "/" + currentYear + "/" + currentMonth)) {

                    }
                }
            }

            ZipFile zipFile = new ZipFile("/home/pnandan/Desktop/My Files/Hackethon/demo/compressed.zip", "incedo".toCharArray());
            zipFile.addFile(new File("/home/pnandan/Desktop/My Files/Hackethon/demo/aFile.txt"), zipParameters);

            File fileToAdd = new File("/home/pnandan/Desktop/My Files/Hackethon/demo/aFile.txt");
            if (!fileToAdd.exists()) {
                fileToAdd.createNewFile();
            }
            zipFile.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public boolean checkDirIfExists(String path) {
        boolean retBool = false;
        File filePath = new File(path);
        if (!filePath.exists()) {
            retBool = filePath.mkdir();
        }
        return retBool;
    }
}
