package com.spartanwrath.controller;

import com.spartanwrath.model.CombatClass;
import com.spartanwrath.model.Membership;
import com.spartanwrath.model.Product;
import com.spartanwrath.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
public class MembershipsController {
    @Autowired
    MembershipService membershipService;

    @GetMapping("/Mymemberships")
    public String showMymemberships(){
        return "mymemberships";
    }

    @GetMapping("/Mymemberships/formsuscripcion")
    public String showFormSuscripcion(){
        return "formsuscripcion";
    }

    @GetMapping("/Mymemberships/{id}")
    public String showMembership(Model model, @PathVariable long id) {

        Optional<Membership> membership = membershipService.findById(id);
        if (membership.isPresent()) {
            model.addAttribute("membership", membership.get());
            return "mymembership";
        } else {
            return "mymemberships";
        }
    }

    @PostMapping("/nuevasuscripcion")
    public String newMembership(Model model, Membership membership) throws IOException {

        Membership newmembership = membershipService.save(membership);

        model.addAttribute("MembershipId", newmembership.getId());

        return "redirect:/Mymembership/"+newmembership.getId();
    }

    @GetMapping("/Mymemberships/{id}/delete")
    public String deleteMembership(Model model, @PathVariable long id) {

        membershipService.delete(id);

        return "mymemberships";
    }
}
