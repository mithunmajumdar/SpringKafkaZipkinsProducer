package com.example.SpringKafkaZipkins;

import java.util.concurrent.ExecutionException;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.credit.message.CreditMessageProducer;

@RestController
public class SpringKafkaZipkinsProducerControllers {

	//private Logger logger=LoggerFactory.getLogger(this.getClass());
	//********Default call***********//
	
	@GetMapping("/creditmessageproducer") //where {from} and {to} represents the column   
	//return a bean back  
	public void callCreditMessageProducer() throws ExecutionException, InterruptedException  
	{  
		CreditMessageProducer creditMessageProducer = new CreditMessageProducer();
		creditMessageProducer.callCreditMessageProducer();
	}
	
}
