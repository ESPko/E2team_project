package bitc.fullstack503.e2teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
<<<<<<< HEAD
=======
    
>>>>>>> 65f34337a2668b5b6f80dc5eab7efa8ba95ffc8e
  @RequestMapping("/")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView("/login/login");
    mav.addObject("title", "Home Page");
    return mav;
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> 65f34337a2668b5b6f80dc5eab7efa8ba95ffc8e
