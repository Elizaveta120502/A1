package com.A1.task3.reader;

import com.A1.task3.entity.LoginEntity;
import com.A1.task3.entity.PostingEntity;
import com.A1.task3.logger.LoggerProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile implements Readable {

    private static ReadFile readFile;

    public static ReadFile getInstance() {
        if (readFile == null) {
            readFile = new ReadFile();
        }
        return readFile;
    }

    @Override
    public List readFile(String filename) throws IOException {


        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<LoginEntity> textListLogin = new ArrayList<>();
        List<PostingEntity> textListPosting = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (filename.equals("C:/A1/src/main/resources/logins.csv")) {

                String[] splitData = line.split(",");
                LoginEntity loginEntity = new LoginEntity();
                loginEntity.setApplication(splitData[0]);
                loginEntity.setAppAccountName(splitData[1]);
                loginEntity.setIsActive(splitData[2]);
                loginEntity.setJobTitle(splitData[3]);
                loginEntity.setDepartment(splitData[4]);

                loginEntity = new LoginEntity(loginEntity.getApplication(), loginEntity.getAppAccountName(),
                        loginEntity.getIsActive(), loginEntity.getJobTitle(), loginEntity.getDepartment());
                textListLogin.add(loginEntity);
                LoggerProvider.getLOG().info(loginEntity);
            }



            if (filename.equals("C:/A1/src/main/resources/postings.csv")) {

                String[] splitData = line.split(";\t");
                PostingEntity postingEntity = new PostingEntity();
                postingEntity.setMatDoc(Long.parseLong(splitData[0]));
                postingEntity.setItem(Integer.parseInt(splitData[1]));
                postingEntity.setDocDate(splitData[2]);
                postingEntity.setPstngDate(splitData[3]);
                postingEntity.setMaterialDescription(splitData[4]);
                postingEntity.setQuantity(Integer.parseInt(splitData[5]));
                postingEntity.setBUn(splitData[6]);
                postingEntity.setAmountLC(Float.parseFloat(splitData[7]));
                postingEntity.setCrcy(splitData[8]);
                postingEntity.setUserName(splitData[9]);

                postingEntity = new PostingEntity(postingEntity.getMatDoc(),
                        postingEntity.getItem(), postingEntity.getDocDate(),
                        postingEntity.getPstngDate(), postingEntity.getMaterialDescription(),
                        postingEntity.getQuantity(), postingEntity.getBUn(),
                        postingEntity.getAmountLC(), postingEntity.getCrcy(),
                        postingEntity.getUserName());
                textListPosting.add(postingEntity);
                LoggerProvider.getLOG().info(postingEntity);
            }
        }


        if (textListPosting.isEmpty()){
            return textListLogin;
        }
        return textListPosting;

    }
}
