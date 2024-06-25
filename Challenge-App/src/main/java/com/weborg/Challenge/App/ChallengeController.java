package com.weborg.Challenge.App;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getAllChallenges(){
       return challengeService.getAllChallenges();
    }

    @PostMapping
    public String addChallenges(@RequestBody Challenge challenge){
        if(challengeService.addChallenges(challenge)){
            return "Challenge added succesfully";
        } else {
            return "Challenge not added succesfully";
        }
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if(challenge != null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Challenge updated){
        boolean isUpdated = challengeService.updatedChallenge(id, updated);
        if(isUpdated){
            return new ResponseEntity<>("Challenge has been updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Challenge is not updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        boolean isDeleted = challengeService.deleteChallenge(id);
        if(isDeleted){
            return new ResponseEntity<>("Challenge has been deleted successfully", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Challenge is Not Deleted", HttpStatus.NOT_FOUND);
        }
    }
}
