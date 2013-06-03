package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class User extends Model {
	private static final long serialVersionUID = 1L;
	public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column
	@Constraints.Required
	public String username;  

	@Column
	@Constraints.Required
	public String regId;

}