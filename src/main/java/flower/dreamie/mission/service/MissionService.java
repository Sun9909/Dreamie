package flower.dreamie.mission.service;

import flower.dreamie.challenges.entity.Challenges;
import flower.dreamie.mission.entity.Mission;
import flower.dreamie.mission.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;

    public void saveMission(long challengesId, long user_id){
        Mission mission = new Mission();
        mission.setUser_id(user_id);
        mission.setChallanges_id(challengesId);
        missionRepository.save(mission);
    }

    public Mission findByUserId(long userId){
        return missionRepository.findByUserId(userId).orElse(null);
    }

}
