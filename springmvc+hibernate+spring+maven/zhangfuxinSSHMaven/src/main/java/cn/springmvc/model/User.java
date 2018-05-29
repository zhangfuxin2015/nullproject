package cn.springmvc.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "zfxtest")
public class User implements java.io.Serializable {

	private Integer id;
	private String name;
	private Date dateee;

	public User() {
	}

	public User(String name, Date dateee) {
		this.name = name;
		this.dateee = dateee;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 1000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateee", length = 19)
	public Date getDateee() {
		return this.dateee;
	}

	public void setDateee(Date dateee) {
		this.dateee = dateee;
	}

}