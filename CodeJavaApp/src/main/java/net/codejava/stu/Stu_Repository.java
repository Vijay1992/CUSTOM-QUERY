package net.codejava.stu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Stu_Repository extends JpaRepository<stu, Integer>{

}
