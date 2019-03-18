package com.saler.saler.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saler.saler.deal.entity.Deal;

/**
 * Deal repository
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Repository("dealRepository")
public interface DealRepository extends JpaRepository<Deal, Long>{
	
	/**
	 * Custom find id by url
	 * @param deal url 
	 * @return deal id
	 */
	@Query("SELECT id FROM Deal where url = :url") 
    Long findIdUrl(@Param("url") String url);
}
