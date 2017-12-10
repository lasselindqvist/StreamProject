package dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHANNEL")
public class Channel extends Identifiable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7446631918662613066L;

	@Column(name = "NAME", unique = true)
	private String name;

	@OneToMany(targetEntity = Comment.class, mappedBy = "channel", cascade = CascadeType.ALL)
	private List<Comment> commentList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
