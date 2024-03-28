package com.spartanwrath.controller;

import com.spartanwrath.model.CombatClass;
import com.spartanwrath.model.Membership;
import com.spartanwrath.model.User;
import com.spartanwrath.service.CombatClassService;
import com.spartanwrath.service.MembershipService;
import com.spartanwrath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AdminControler {
    @Autowired
    UserService userService;
    @Autowired
    MembershipService membershipService;
    @Autowired
    CombatClassService combatClassService;

    @GetMapping("/Admin")
    public String showAdmin(){
        return "admin";
    }

    @GetMapping("/Admin/combatclasses")
    public String showCombatClasses(){
        return "combatclasses";
    }

    @GetMapping("/Admin/combatclasses/{id}")
    public String showCombatClass(Model model, @PathVariable long id) {

        Optional<CombatClass> combatClass = combatClassService.findById(id);
        if (combatClass.isPresent()) {
            model.addAttribute("user", combatClass.get());
            return "combatclass";
        } else {
            return "combatclasses";
        }
    }
}
