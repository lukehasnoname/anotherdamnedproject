package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.data.validation.*;
import play.db.jpa.*;
 
@Entity
public class Message extends Model {
	
	public long parent;

	@Required
	public String submitter;
	
	@URL
	public String link;
	
	public String title;
	
	@Lob
	public String text;
	
	public Date date;
	
	public Message(long parent, String user, Date date, String title, String link, String text) {
		this.parent = parent;
		this.submitter = user;
		this.date = date;
		this.title = title;
		this.link = link;
		this.text = text;
	}
	
}