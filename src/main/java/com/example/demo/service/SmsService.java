package com.example.demo.service;

import com.example.demo.client.WebRiskClient;
import com.example.demo.model.SMSData;
import com.example.demo.model.WebRiskResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Component
public class SmsService {
    @Autowired
    private WebRiskClient webRiskClient;
//    @Autowired
//    private GoogleValidatorService validatorService;
    public String sendSms(SMSData smsData) throws IOException {
        System.out.println(smsData.getMessage());
        String url = UrlExtractor.extractURLFromJSON(smsData.getMessage());
        System.out.println(url);

        try {
            WebRiskResponse response = webRiskClient.evaluateUri(url);
            processWebRiskResponse(response);
            // Możesz zwrócić jakąś informację na temat wyniku
            return "URL został sprawdzony: " + response.toString();
        } catch (IOException e) {
            // Obsługa wyjątków
            return "Wystąpił błąd podczas sprawdzania URL: " + e.getMessage();
        }

        // Kontynuacja wysyłania SMS lub podejmowanie innych działań
    }
    public void processWebRiskResponse(WebRiskResponse response) {
        for (WebRiskResponse.Score score : response.getScores()) {
            if ("HIGH".equals(score.getConfidenceLevel()) || "VERY_HIGH".equals(score.getConfidenceLevel())) {
                System.out.println("URL jest potencjalnie niebezpieczny: " + score.getThreatType());
                // Możesz podjąć dalsze działania, takie jak ostrzeżenie użytkownika, zablokowanie URL-a itp.
            }
        }
    }

//        try {
//            validatorService.validate(url);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

}
