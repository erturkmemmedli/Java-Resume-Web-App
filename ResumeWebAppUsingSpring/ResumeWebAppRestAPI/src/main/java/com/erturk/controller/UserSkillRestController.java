package com.erturk.controller;

import com.erturk.dto.ResponseDTO;
import com.erturk.dto.SkillDTO;
import com.erturk.dto.UserSkillDTO;
import com.erturk.entity.UserSkill;
import com.erturk.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserSkillRestController {
    @Autowired
    @Qualifier("userSkillService")
    private UserSkillServiceInter userSkillService;

    @GetMapping("/users/{id}/skills")
    public ResponseEntity<ResponseDTO> getUserSkills(@PathVariable("id") int id) {
        List<UserSkill> userSkills = userSkillService.getAllByUserId(id);
        List<UserSkillDTO> userSkillDTOs = new ArrayList<>();

        for (UserSkill u: userSkills) {
            userSkillDTOs.add(new UserSkillDTO(u));
        }

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(userSkillDTOs));
    }

    @DeleteMapping("/users/{id}/skills/{userSkillId}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id,
                                                  @PathVariable("userSkillId") int userSkillId) {
        UserSkill userSkill = userSkillService.getById(userSkillId);
        userSkillService.removeUserSkill(userSkillId);

        return ResponseEntity.ok(ResponseDTO.of(new UserSkillDTO(userSkill), "Successfully deleted!"));
    }

    @PostMapping("/users/{id}/skills")
    public ResponseEntity<ResponseDTO> addUser(@PathVariable("id") int id,
                                               @RequestBody UserSkillDTO userSkillDto) {
        UserSkill userSkill = new UserSkill();
        userSkill.setUserId(id);
        userSkill.setSkillId(userSkillDto.getSkill().getId());
        userSkill.setPower(userSkillDto.getPower());

        userSkillService.addUserSkill(userSkill);

        SkillDTO skill = new SkillDTO();
        skill.setId(userSkillDto.getSkill().getId());
        skill.setName(userSkillDto.getSkill().getName());
        UserSkillDTO userSkillDTO = new UserSkillDTO(id, userSkillDto.getPower(), skill);

        return ResponseEntity.ok(ResponseDTO.of(userSkillDTO, "Successfully added!"));
    }
}
