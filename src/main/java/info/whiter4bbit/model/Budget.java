package info.whiter4bbit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Budget")
public class Budget extends BaseModel implements Serializable {

	private static final long serialVersionUID = -3618774625663547288L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	private Money amount;
	
	private Boolean deleted;
	
	@Temporal(TemporalType.DATE)
	private Date created;
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Date getCreated() {
		return created;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Boolean isDeleted() {
		return deleted;
	}

	@Override
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
}
