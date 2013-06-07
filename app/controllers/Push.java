package controllers;

import java.util.List;

import models.User;

import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.avaje.ebean.Ebean;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;

public class Push extends Controller {

	public static Result register(String username, String regId) {
		ObjectNode result = Json.newObject();

		List<User> list = User.find.where().eq("registrationID", regId).findList();

		if (list.size() > 0) {
			result.put("status", "already registered");
		} else {
			User user = new User();
			user.registrationID = regId;
			user.username = username;
			Ebean.save(user);
			result.put("status", "registered");
		}
		
		return ok(result);
	}
	
	public static Result registerDevice(String regId) {
		ObjectNode result = Json.newObject();

		List<User> list = User.find.where().eq("registrationID", regId).findList();

		if (list.size() > 0) {
			result.put("status", "already registered");
		} else {
			User user = new User();
			user.registrationID = regId;
			user.username = "Prova";
			Ebean.save(user);
			result.put("status", "registered");
		}
		
		return ok(result);
	}

	

	public static Result unregister(String regId) {
		ObjectNode result = Json.newObject();

		List<User> list = User.find.where().eq("registrationID", regId).findList();

		if (list.size() > 0) {
			result.put("status", "unregistered");
			for (User user : list) {
				Ebean.delete(user);
			}
		} else {
			result.put("status", "not registered");
		}

		return ok(result);
	}

	public static Result send(String username, String message) {
		ObjectNode result = Json.newObject();

		List<User> list = User.find.where().eq("username", username).findList();

		if (list.size() > 0) {

			for (User user : list) {
				try {
					Sender sender = new Sender("AIzaSyAkDixjFi97kcU70x3BRozXtkcH6Nq9bqM");
					Message msg = new Message.Builder().addData("message", message).build();
					sender.send(msg, user.registrationID, 5);
				} catch (Exception e) {
					result.put("status", "Error: " + e.getMessage());
					e.printStackTrace();
				}
			}

			result.put("status", "message sent");
		} else {
			result.put("status", "unknown user");
		}

		return ok(result);
	}

}