package com.nashintern.travelagent.service;

import com.nashintern.travelagent.model.Agent;

public interface AgentService {
    Agent getAgentById(int id);
    void saveAgent(Agent agent);
    void deleteAgent(int id);
}