package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends Identifiable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1356513258813749457L;

	private String name;

	@Column(name = "USERNAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> commentList;

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public boolean addComment(Comment comment) {
		if (this.commentList == null) {
			this.commentList = new ArrayList<>();
		}
		comment.setUser(this);
		return this.commentList.add(comment);
	}

}
