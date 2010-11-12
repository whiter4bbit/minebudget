package info.whiter4bbit.ejb;

import java.util.List;
import info.whiter4bbit.model.Expense;
import javax.ejb.Remote;

@Remote
public interface ExpenseDao extends BaseDao<Expense> {
	List<Expense> find(Long id);
}
