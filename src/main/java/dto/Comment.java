package dto;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENT")
public class Comment extends Identifiable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4556559216188754328L;
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private Instant timestamp;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "CHANNEL_ID", nullable = false)
	private Channel channel;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

}
