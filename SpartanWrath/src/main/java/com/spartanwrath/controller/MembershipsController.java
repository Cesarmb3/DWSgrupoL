package com.spartanwrath.controller;

import com.spartanwrath.model.CombatClass;
import com.spartanwrath.model.Membership;
import com.spartanwrath.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class MembershipsController {
    @Autowired
    MembershipService membershipService;

    @GetMapping("/Mymemberships")
    public String showMymemberships(){
        return "mymemberships";
    }

    @GetMapping("/Mymemberships/{id}")
    public String showMembership(Model model, @PathVariable long id) {

        Optional<Membership> membership = membershipService.findById(id);
        if (membership.isPresent()) {
            model.addAttribute("user", membership.get());
            return "mymembership";
        } else {
            return "mymemberships";
        }
    }
}
