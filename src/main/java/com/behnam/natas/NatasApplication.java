package com.behnam.natas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class NatasApplication {

	@Autowired
	Natas15 natas15;

	@Autowired
	Natas16 natas16;

	@Autowired
	Natas17 natas17;

	@Autowired
	Natas18 natas18;

	@Autowired
	Natas19 natas19;


	@PostConstruct
	public void init(){
//		natas15.solve();
//		natas16.solve();
//		natas17.solve();
//		natas18.solve();
		natas19.solve();
	}

	public static void main(String[] args) {
		SpringApplication.run(NatasApplication.class, args);
	}

}
