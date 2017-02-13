package com.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("menuController")
@ComponentScan("org.cmsapiservice")
@RequestMapping("admin/menu")
public class MenuController {

}
