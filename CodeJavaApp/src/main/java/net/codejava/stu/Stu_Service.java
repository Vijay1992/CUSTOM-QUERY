package net.codejava.stu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Stu_Service {

	@Autowired
	private Stu_Repository stu_repo;
	
	public List<stu> listAll(){
		return stu_repo.findAll();
	}
	
	public stu save_Student(stu s) {
		return stu_repo.save(s);
	}
	
	public stu get(Integer id) {
        return stu_repo.findById(id).get();
    }
     
    public void delete(Integer id) {
    	stu_repo.deleteById(id);
    }
}
