package com.mindtree.dth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dth.Repository.ChannelRepository;
import com.mindtree.dth.Repository.SubscriptionRepository;
import com.mindtree.dth.entity.Channel;
import com.mindtree.dth.entity.Subscription;

@Service
public class DthServiceImpl implements DthService {

	@Autowired
	ChannelRepository channelRepo;

	@Autowired
	SubscriptionRepository subscriptionRepo;

	@Override
	public List<Channel> getChannels() {

		return channelRepo.findAll();

	}

	@Override
	public void subscribingChannel(Subscription subscription) {

		subscriptionRepo.save(subscription);
	}

	@Override
	public void editSubscription(Subscription subscription) {
		
		subscriptionRepo.deleteBySubscription(subscription.getChannel().getChannelId(),
				subscription.getCustomer().getSubscriberId());
		
	}

	@Override
	public List<Subscription> getSubscribers(Subscription subscription) {
		return subscriptionRepo.findAllById(subscription.getCustomer().getSubscriberId());
		
	}



}
