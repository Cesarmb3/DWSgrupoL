package com.spartanwrath.controller;

import com.spartanwrath.model.CombatClass;
import com.spartanwrath.model.Membership;
import com.spartanwrath.model.Product;
import com.spartanwrath.model.User;
import com.spartanwrath.service.CombatClassService;
import com.spartanwrath.service.MembershipService;
import com.spartanwrath.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/admin/")
    public String showAdmin(){
        return "admin/admin";
    }

    @GetMapping("/admin/users")
    public String showUsers(){
        return "admin/admin/users";
    }
    @GetMapping("/admin/combatclasses")
    public String showCombatClasses(){
        return "admin/admin/combatclasses";
    }
    @GetMapping("/admin/memberships")
    public String showMemberships(){
        return "admin/admin/memberships";
    }

    @GetMapping("/admin/users/{id}")
    public String showUser(Model model, @PathVariable long id) {

        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user";
        } else {
            return "users";
        }
    }

    @GetMapping("/admin/memberships/{id}")
    public String showMembership(Model model, @PathVariable long id) {

        Optional<Membership> membership = membershipService.findById(id);
        if (membership.isPresent()) {
            model.addAttribute("membership", membership.get());
            return "membership";
        } else {
            return "memberships";
        }
    }

    @GetMapping("/admin/combatclasses/{id}")
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
