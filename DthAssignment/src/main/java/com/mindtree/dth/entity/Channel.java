package com.mindtree.dth.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "channels")
public class Channel {

	@Id
	private int channelId;
	private String channelName;
	private double costPerMonth;

	
	@OneToOne(mappedBy = "channel")
	private Subscription subscription;

	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Channel(int channelId, String channelName, double costPerMonth, Subscription subscription) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.costPerMonth = costPerMonth;
		this.subscription = subscription;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public double getCostPerMonth() {
		return costPerMonth;
	}

	public void setCostPerMonth(double costPerMonth) {
		this.costPerMonth = costPerMonth;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", costPerMonth=" + costPerMonth
				+ "]";
	}

	

}
