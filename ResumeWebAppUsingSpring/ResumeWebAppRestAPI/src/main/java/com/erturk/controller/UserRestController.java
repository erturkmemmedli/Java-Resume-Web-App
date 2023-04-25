package com.erturk.controller;

import com.erturk.dto.ResponseDTO;
import com.erturk.dto.UserDTO;
import com.erturk.entity.User;
import com.erturk.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    @Qualifier("userService")
    private UserServiceInter userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(@RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "surname", required = false) String surname,
                                                @RequestParam(name = "age", required = false) Integer age) {
        List<User> users = userService.getAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for (User u: users) {
            userDTOs.add(new UserDTO(u));
        }

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.of(userDTOs));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") int id) {
        User user = userService.getById(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") int id) {
        User user = userService.getById(id);
        userService.removeUser(id);

        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Successfully deleted!"));
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setPassword(userDto.getPassword());

        userService.addUser(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());

        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully added!"));
    }
}
