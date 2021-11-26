package com.incedo.hackathons.services;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class EncryptionService {
    public static void createEncryption2(){
        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setEncryptFiles(true);
            zipParameters.setCompressionLevel(CompressionLevel.HIGHER);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);


            ZipFile zipFile = new ZipFile("/home/pnandan/Desktop/My Files/Hackethon/demo/compressed.zip", "incedo".toCharArray());
            zipFile.addFile(new File("/home/pnandan/Desktop/My Files/Hackethon/demo/aFile.txt"),zipParameters);

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
}
