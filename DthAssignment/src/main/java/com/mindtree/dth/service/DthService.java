package com.mindtree.dth.service;

import java.util.List;

import com.mindtree.dth.entity.Channel;
import com.mindtree.dth.entity.Subscription;


public interface DthService {

	List<Channel> getChannels();

	void subscribingChannel(Subscription subscription);

	void editSubscription(Subscription subscription);

	List<Subscription> getSubscribers(Subscription subscription);

//	void saveSubscription(Long subscriberId, String date, String channelName);
//
//	void editSubscription(Long subscriberId, String channelName);

}
