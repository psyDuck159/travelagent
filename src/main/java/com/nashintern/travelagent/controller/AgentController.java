package com.nashintern.travelagent.controller;

import com.nashintern.travelagent.model.Agent;
import com.nashintern.travelagent.service.AgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AgentController {
    private AgentService agentService;
    private Logger logger = LoggerFactory.getLogger(AgentController.class);
    
    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }
    
    @GetMapping("agent/{id}")
    public ModelAndView getAgentById(@PathVariable() Integer id) {
        logger.info("agent id: {}", id);
        Agent agent = agentService.getAgentById(id);
        logger.info("agent: {}", agent);
        ModelAndView view = new ModelAndView();
        view.setViewName("agent_detail.html");
        view.addObject("agent", agent);
        return view;
    }

    @GetMapping("/showNewAgentForm")
    public String showNewAgentForm( Model model){
        Agent agent = new Agent();
        model.addAttribute("agent", agent);
        return "new_agent_form";
    }

    @PostMapping("/saveAgent")
    public String saveAgent(@ModelAttribute("agent") Agent agent){
        agentService.saveAgent(agent);
        return "redirect:/agent_detail/" + agent.getId();
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable("id") int id, Model model){
        Agent agent = agentService.getAgentById(id);
        model.addAttribute("agent", agent);
        return "update_agent_form";
    }
    
    @GetMapping("/deleteAgent/{id}")
    public String deleteAgent(@PathVariable("id") int id){
        agentService.deleteAgent(id);
        return "redirect:/agent_detail/" + id;
    }

}
