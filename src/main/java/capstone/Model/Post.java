package capstone.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**

 * @author apjenkins
 *
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int post_id;
	
//	
//	@Column(name = "user_id")
//	private int user_id;
	
	@Column(name = "caption")
	private String caption;
	
	@Column(name = "image_url")
	private String image_url;
	
	
	/**
	 * Using the Temporal annotation we map a java.data to a TIMESTAMP column of the database
	 */
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creation_date;
	
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
//	
//	@OneToMany(mappedBy = "post")
//	private List<Comment> comments;
	
	@ManyToMany
	@JoinTable(name = "likes",
	joinColumns = @JoinColumn(name = "post_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users;
	

}
