package io.pivotal.boothacks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EchoController {

  @RequestMapping(value = "/echo", method = RequestMethod.GET)
  public String get(Model model, @RequestParam String message) {
    model.addAttribute("message", message);
    return "echo";
  }

}