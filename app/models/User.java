package models;
 
import java.util.*;
import javax.persistence.*;

import extras.BCrypt;
 
import play.data.validation.*;
import play.db.jpa.*;
 
@Entity
public class User extends Model {
	
	@MinSize(3)
	@MaxSize(20)
	@Required
	@Match("[\\w\\s]+")
	public String username;
	
	@Required
	public String password;
	
	@Email
	@Required
	public String email;
	
	@Required
	public Date created;
	
	
	public User (String username, String password, String email, Date date) {
		this.username = username;
		this.password = BCrypt.hashpw(password);
		this.email = email;
		this.created = date;		
	}
	
	public User (User copy) {
		this.username = copy.username;
		this.password = copy.password;
		this.email = copy.email;
		this.created = copy.created;
	}
	
	public String toString() {
		return this.username;
	}
	
	public static User findByUsername(String username) {
		return User.find("username = ?", username).first();	
	}
	
	public static User findByEmail(String email) {
		return User.find("email = ?", email).first();
	}
	
	public boolean checkPassword(String password) {
		return BCrypt.checkpw(password, this.password);
	}
	
	
}