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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @PostMapping("/nuevaclase")
    public String newCombatClass(Model model, CombatClass combatClass) throws IOException {

        CombatClass newCombatClass = combatClassService.save(combatClass);

        model.addAttribute("combatclassId", newCombatClass.getId());

        return "redirect:/Admin/combatclasses/"+newCombatClass.getId();
    }

    @GetMapping("/Admin/combatclasses/{id}/delete")
    public String deleteCombatClass(Model model, @PathVariable long id) {

        combatClassService.delete(id);

        return "combatclasses";
    }

    @GetMapping("/Admin/combatclasses/formcombatclass")
    public String showClassForm(){
        return "formcombatclass";
    }

}
