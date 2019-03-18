package com.saler.saler.buy.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saler.saler.buy.option.entity.BuyOption;

/**
 * Buy option repository
 * @author Diego Andre Poli <diegoandrepoli@gmail.com>
 */
@Repository("buyOptionRepository")
public interface BuyOptionRepository extends JpaRepository<BuyOption, Long>{}
