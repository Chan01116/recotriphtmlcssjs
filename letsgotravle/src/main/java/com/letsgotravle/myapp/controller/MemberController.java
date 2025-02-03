package com.letsgotravle.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsgotravle.myapp.service.MemberService;
import com.letsgotravle.myapp.util.UserIp;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
//	@Autowired(required=false)
//	private UserIp userip;
//	
//	@Autowired
//	private MemberService memberService;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
}
