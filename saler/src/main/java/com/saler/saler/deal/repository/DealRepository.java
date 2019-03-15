package com.saler.saler.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saler.saler.deal.entity.Deal;

/**
 * Deal repository
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Repository("dealRepository")
public interface DealRepository extends JpaRepository<Deal, Long>{}
