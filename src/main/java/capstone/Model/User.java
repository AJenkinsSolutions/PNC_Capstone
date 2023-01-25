package capstone.Model;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *  * The central Pojo that contains all information about a registered user
 * Each user has a unique identifier Pk id
 * @author apjenkins
 *
 */
@Entity
@Table(name= "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "user_id")
	private int user_id;
	
	@Column(name = "username", unique = true, nullable = false)
	private String userName;
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="profile_picture")
	private String profile_picture;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> posts;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private Set<Post> likedPost;
	
	
	@ManyToMany
	@JoinTable(name = "followers",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "follower_id"))
	private Set<User> followers = new HashSet<>();
	
	
	//inveresecolumn is used to specify the name of the columns un the other table
	//that is used to join with the primary keys= of the current table specifiy and rename
	
	@ManyToMany
	@JoinTable(name = "following",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "following_id"))
	private Set<User> following;
	
	
	
	
	
	

}
