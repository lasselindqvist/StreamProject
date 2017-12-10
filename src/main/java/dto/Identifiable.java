package dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Identifiable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4744817522214936085L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
