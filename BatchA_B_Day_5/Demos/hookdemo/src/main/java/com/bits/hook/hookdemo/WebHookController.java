package com.bits.hook.hookdemo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RequestMapping("/hooks")
@RestController
public class WebHookController {

	Logger logger
    = LoggerFactory.getLogger(WebHookController.class);

	@GetMapping("/getData")
	public String sayHello()
	{
		return "Hello Welcome!!!";
	}
	@PostMapping("/webhook")
	public void receiveWebhook(@RequestBody String payload) {
	      //process the webhook payload
		ObjectMapper objectMapper = new ObjectMapper();
		   try {
			Payload parsedPayload = objectMapper.readValue(payload, Payload.class);
			logger.info("Received webhook with event type: {} and payload: {}", parsedPayload.getEventType(), parsedPayload);
	//REPO/SERVICE
		   } catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
}
