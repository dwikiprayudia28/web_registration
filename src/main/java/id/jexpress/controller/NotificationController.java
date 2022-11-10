package id.jexpress.controller;

import id.jexpress.model.ParamNotifDetail;
import id.jexpress.service.GreeterService;
import id.jexpress.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotificationController {
	
//    @Autowired
    public SimpMessagingTemplate template;
    
    @Autowired
	private UserService userService;

    @RequestMapping(value = "/notif")
    public String home(){
        return "notif";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/dwiki/greetings")
    public GreeterService greeting(ParamNotifDetail param, Principal principal) throws Exception {
    	
    	String userSender = param.getUserSender();
    	String ticketId = param.getJtrId();
    	String msgNotif = param.getMsgNotif();
    	String typeNotif = param.getTypeNotif();
    	
    	return new GreeterService(userSender 
    			+ ";" + ticketId 
    			+ ";" + msgNotif
    			+ ";" + typeNotif);
    }
    
//    @SubscribeMapping("/topic/{recipientId}/greetings")
//    public GreeterService greeting2(@DestinationVariable String recipientId,
//    		ParamNotifDetail param, 
//    		Principal principal) throws Exception {
//    	
//    	String userSender = param.getUserSender();
//    	String ticketId = param.getJtrId();
//    	String msgNotif = param.getMsgNotif();
//    	String typeNotif = param.getTypeNotif();
//    	System.out.println("recipientId: " + recipientId);
//    	
////    	this.template.convertAndSend("/topic/dwiki/greetings", msgNotif);
//    	
//    	return new GreeterService(userSender 
//    			+ ";" + ticketId 
//    			+ ";" + msgNotif
//    			+ ";" + typeNotif);
//    }

    @RequestMapping(value = "/simMessage")
    public String greeting() throws Exception {
        template.convertAndSend("/topic/greetings",
                new GreeterService("Hello, Other!"));
//        return "sample";
        return null;
    }
}
