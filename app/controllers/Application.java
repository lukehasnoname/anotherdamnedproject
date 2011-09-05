package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import java.util.regex.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void register() {
    	render();
    }
    
    public static void register_post(String username, String password1, String password2, String email) {
    	//Username too short
    	if (username.length()<3) {
    		flash.error("Username is too short. It must be at least 3 characters.");
    		flash.put("email", email);
    		register();
    	}
    	
    	//Invalid username characters
    	Pattern validChars = Pattern.compile("[\\w\\s]");
    	Matcher usernameMatch = validChars.matcher(username);
    	if (usernameMatch.find()) {
    		flash.error("Username contains invalid characters.");
    		flash.put("email", email);
    		register();
    	}
    	
    	//Username taken   	
    	User existsUsername = User.findByUsername(username);
    	if (existsUsername != null) {
    		flash.error("Username is taken");
    		flash.put("email", email);
    		register();
    	}
    	
    	//Email used previously
    	User existsEmail = User.findByEmail(email);
    	if (existsEmail != null) {
    		flash.error("Email has been used.");
    		flash.put("username", username);
    		register();
    	}
    	
    	//Password is too short
    	if (password1.length() < 6) {
    		flash.error("Password must be at least 6 characters long.");
    		flash.put("email", email);
    		flash.put("username", username);
    		register();
    		
    	}
    	
    	//Passwords don't match
    	if (!password1.equals(password2)) {
    		flash.error("Passwords don't match.");
    		flash.put("email", email);
    		flash.put("username", username);
    		register();
    	}
    	
    	//Finally, it works!    	
    	new User(username, password1, email, new Date()).save();
    	Messages.showMain();
    }
    
    // ----Helper functions-----//
    
    

}