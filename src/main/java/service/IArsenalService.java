package service;

import java.util.List;

import model.Arsenal;

public interface IArsenalService {
	
	public List<Arsenal> findAll() throws Exception;
	
	public void removeById(Arsenal arsenal) throws Exception;

	public Arsenal findById(Arsenal arsenal)throws Exception;

	public void motify(Arsenal arsenal)throws Exception;

	public void save(Arsenal arsenal)throws Exception;
}
