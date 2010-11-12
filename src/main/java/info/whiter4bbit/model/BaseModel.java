package info.whiter4bbit.model;

import java.util.Date;

public abstract class BaseModel {
	
	public abstract Long getId();

	public abstract void setId(Long id);

	public abstract Date getCreated();

	public abstract void setCreated(Date created);
	
	public abstract Boolean isDeleted();
	
	public abstract void setDeleted(Boolean deleted);
	
}
