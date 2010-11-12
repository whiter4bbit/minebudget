package info.whiter4bbit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Expense")
public class Expense extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = -3945766589487041594L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true)	
	private Budget budget;
	
	@Embedded
	private Money amount;
	
	private String description;
	
	private Boolean deleted;
	
	@Temporal(TemporalType.DATE)
	private Date created;
	
	public Budget getBudget() {
		return budget;
	}
	
	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
	public Money getAmount() {
		return amount;
	}
	
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
