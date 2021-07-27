package com.mindtree.dth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String subscriptionDate;

	
	@ManyToOne
	@JoinColumn(name = "subscriber_id")
	private Customer customer;

	
	@OneToOne
	@JoinColumn(name = "channel_id")
	private Channel channel;

	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscription(int id, String subscriptionDate, Customer customer, Channel channel) {
		super();
		this.id = id;
		this.subscriptionDate = subscriptionDate;
		this.customer = customer;
		this.channel = channel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(String subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", subscriptionDate=" + subscriptionDate + ", customer=" + customer
				+ ", channel=" + channel + "]";
	}

	
}
