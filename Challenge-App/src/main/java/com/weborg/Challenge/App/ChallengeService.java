package com.weborg.Challenge.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ChallengeService {

    //private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    @Autowired
    ChallengeRepository challengeRepository;


    public ChallengeService(){
//       Challenge challenge = new Challenge(1L, "January", "learning a new programming language");
//       challenges.add(challenge);
    }



    public List<Challenge> getAllChallenges(){
        return challengeRepository.findAll();
    }

    public boolean addChallenges(Challenge challenge){
        if(challenge != null){
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        }
        return false;
    }

    public Challenge getChallenge(String month){
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updatedChallenge(Long id, Challenge updated){
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()){
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(updated.getMonth());
            challengeToUpdate.setDescription(updated.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id){
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()){
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
