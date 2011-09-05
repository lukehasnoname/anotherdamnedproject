package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Users extends Controller {
	
	public static void profile(String username) {
		User profileUser = User.findByUsername(username);
		render(profileUser);
	}
	
}