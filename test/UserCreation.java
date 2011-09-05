import org.junit.*;

import controllers.Application;

import java.util.*;
import play.test.*;
import models.*;

public class UserCreation extends UnitTest {

	
	@Before
	public void setup() {
		Fixtures.deleteAllModels();
	}
	
    @Test
    public void usernameCreation() {
       boolean fail = new User("luke?", "hohohoho", "goo@bar.com", new Date()).validateAndCreate();
       User one = User.findByEmail("goo@bar.com");
       assertEquals("luke", one.username);
       assertEquals(fail, true);
    }

}
