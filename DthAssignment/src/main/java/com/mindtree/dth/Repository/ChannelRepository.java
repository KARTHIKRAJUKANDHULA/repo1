package com.mindtree.dth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.dth.entity.Channel;
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {

}
