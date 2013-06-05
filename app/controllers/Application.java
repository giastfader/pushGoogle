package controllers;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class Application extends Controller {
  final static Form<User> userForm=Form.form(User.class);
  final static Form<String> messaggioForm=Form.form(String.class);
	
  public static Result index() {
	  return ok(index.render(userForm, messaggioForm));
  }
  
  public static Result register(){
	  Form<User> filledForm= userForm.bindFromRequest();
	  if (filledForm.hasErrors()){
		  return badRequest(index.render(userForm, messaggioForm));
	  } else {
		  User temp=filledForm.get();
		  return (Push.register(temp.username, temp.registrationID));
	  }
  }
  
  public static Result unregister(){
	  Form<User> filledForm= userForm.bindFromRequest();
	  if (filledForm.hasErrors()){
		  return badRequest(index.render(userForm, messaggioForm));
	  } else {
		  User temp=filledForm.get();
		  return (Push.unregister(temp.registrationID));
	  }
  }
  public static Result send(){
	  Form<User> filledForm= userForm.bindFromRequest();
	  Form<String> filledForm1=messaggioForm.bindFromRequest();
	  if ((filledForm.hasErrors()) || (filledForm1.hasErrors())){
		  return badRequest(index.render(userForm, messaggioForm));
	  } else {
		  User temp=filledForm.get();
		  String messaggio=filledForm1.get();
		  return (Push.send(temp.username,messaggio));
	  }
  }
    
}