package controllers;

import models.Message;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	static Form<Message> text=Form.form(Message.class);
	
	public static Result index() {   
        return ok(views.html.index.render(text));
    }
    
    public static Result sendMessage(){
    	return TODO;  
    }
  
}
