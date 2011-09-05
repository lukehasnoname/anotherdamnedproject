package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Messages extends Controller {
	
	public static void showMain() {
		List<User> users = User.findAll();
		List<Message> rootMessages = Message.find("parent = ? ORDER BY date", 0L).fetch(1, 30);
		render(users, rootMessages);
	}
	
	public static void create() {
		render();
	}
	
	public static void create_post(String link, String text, String title) {
		User submitter = User.findById(session.get("userID"));		
		new Message(0L, submitter.username, new Date(), title, link, text).save();
		showMain();
	}
	
	public static void reply() {
		
	}
	
	public static void reply_post() {
		
	}
	
	public static void show() {
		
	}
	

}