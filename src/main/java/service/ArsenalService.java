package service;

import  java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.ArsenalMapper;
import model.Arsenal;
@Service
@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED)
public class ArsenalService implements IArsenalService{
	
	@Autowired
	private ArsenalMapper am;
	
	@Transactional(readOnly=true)
	public List<Arsenal> findAll() throws Exception{
		List<Arsenal> arsenals = am.selectAll();
		return arsenals;
	}

	public void removeById(Arsenal arsenal) throws Exception {
		
		am.delById(arsenal);
	}

	@Transactional(readOnly=true)
	public Arsenal findById(Arsenal arsenal) throws Exception {
		Arsenal ar = am.selectById(arsenal);
		return ar;
	}

	public void motify(Arsenal arsenal) throws Exception {
		am.update(arsenal);
	}

	public void save(Arsenal arsenal) throws Exception{
		am.insert(arsenal);
	}
}
