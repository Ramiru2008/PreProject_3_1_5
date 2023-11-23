package com.example.preproject_3_1_5;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PreProject315Application {

    public static void main(String[] args) throws IOException {
        org.springframework.boot.SpringApplication.run(PreProject315Application.class, args);
        openHomePage();
    }

    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/");
    }
}