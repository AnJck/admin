package mapper;

import java.util.List;

import model.Arsenal;

public interface ArsenalMapper {
	
	public List<Arsenal> selectAll();
	
	public void delById(Arsenal arsenal);

	public Arsenal selectById(Arsenal arsenal);

	public void update(Arsenal arsenal);

	public void insert(Arsenal arsenal);
}
