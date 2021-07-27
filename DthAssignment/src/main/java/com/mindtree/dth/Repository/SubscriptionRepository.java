package com.mindtree.dth.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.dth.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

	@Transactional
	@Modifying
	@Query(value = "call deletesubscription(?,?)", nativeQuery = true)
	void deleteBySubscription(int channelId, Long subscriberId);

	@Transactional
	@Query(value = "call `fetchQuery`(?)", nativeQuery = true)
	List<Subscription> findAllById(Long subscriberId);

}
