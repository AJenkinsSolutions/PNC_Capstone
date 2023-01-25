package capstone.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int comment_id;
	
	@Column(name = "post_id")
	private int post_id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "creation_date")
	private Date creation_date;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
