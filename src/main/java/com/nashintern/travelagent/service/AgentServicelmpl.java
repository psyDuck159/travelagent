package com.nashintern.travelagent.service;

import com.nashintern.travelagent.model.Agent;
import com.nashintern.travelagent.repository.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServicelmpl implements AgentService {
    private AgentRepo agentRepo;
    
    @Autowired
    public AgentServicelmpl(AgentRepo agentRepo) {
        this.agentRepo = agentRepo;
    }
    
    @Override
    public Agent getAgentById(int id) {
        return agentRepo.findById(id).orElse(null);
    }

	@Override
	public void saveAgent(Agent agent) {
		this.agentRepo.save(agent);
		
	}

    @Override
    public void deleteAgent(int id) {
        // TODO Auto-generated method stub
        this.agentRepo.deleteById(id);
    }
}