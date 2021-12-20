package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.Addres;

public interface AddresRepository extends JpaRepository<Addres, Integer> {
	
	@Query(value="select * from address_table ad where ad.id=:addresId And ad.eid_fk=:userId ",nativeQuery = true)
	Addres findByUserId(@Param("addresId")   int addresId,@Param("userId") int userId);
	 

}
