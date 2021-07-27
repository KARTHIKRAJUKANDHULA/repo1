package com.mindtree.dth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.dth.entity.Channel;
import com.mindtree.dth.entity.Subscription;
import com.mindtree.dth.service.DthService;

@Controller
public class DthController implements ErrorController{

	@Autowired
	DthService dthService;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/viewDetails")
	public String viewDetails() {
		return "viewDetails.jsp";
	}

	@RequestMapping("/channel")
	public ModelAndView addChannels() {

		ModelAndView mv = new ModelAndView("channel.jsp");

		List<Channel> channels = dthService.getChannels();
		mv.addObject("channel", channels);
		return mv;

	}
	

	@RequestMapping("/edit")
	public ModelAndView edit() {

		ModelAndView mv = new ModelAndView("edit.jsp");

		List<Channel> channels = dthService.getChannels();
		mv.addObject("channel", channels);
		return mv;

	}
	
	@RequestMapping("/subscribeChannel")
	public String subscribeChannel(Subscription subscription) {
		dthService.subscribingChannel(subscription);
		return "home.jsp";
		
	}
	
	@RequestMapping("/editSubscription")
	public String editSubscription(Subscription subscription) {
		dthService.editSubscription(subscription);
		return "home.jsp";
		
	}
	
	@RequestMapping("/subscriptionDetails")
	public ModelAndView viewDetails(Subscription subscription) {
		ModelAndView mv = new ModelAndView("subscriptionDetails.jsp");
		List<Subscription> subscribers = dthService.getSubscribers(subscription);
		double total = 100;
		for(Subscription sub : subscribers) {
			total = total + sub.getChannel().getCostPerMonth();
		}
		
		mv.addObject("subscriber", subscribers);
		mv.addObject("total", total);
		return mv;
	}
	
	@RequestMapping("/admin")
	public ModelAndView Admin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin.jsp");
		return mv;
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error.jsp";
	}
	
}
