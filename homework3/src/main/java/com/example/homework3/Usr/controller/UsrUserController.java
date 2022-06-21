package com.example.homework3.Usr.controller;

import com.example.homework3.Usr.DTO.UsrUserDTO;
import com.example.homework3.Usr.DTO.UsrUserSaveRequestDto;
import com.example.homework3.Usr.Sevice.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
@RequiredArgsConstructor
public class UsrUserController {

    private final UsrUserService usrUserService;

    @GetMapping
    public ResponseEntity getAll(){

        List<UsrUserDTO> usrUserDtoList = usrUserService.findAll();

        return ResponseEntity.ok(usrUserDtoList);
    }


    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        UsrUserDTO usrUserDto = usrUserService.findById(id);

        return ResponseEntity.ok(usrUserDto);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity getByUsername(@PathVariable String username){

        UsrUserDTO usrUserDto = usrUserService.findByUsername(username);

        return ResponseEntity.ok(usrUserDto);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        usrUserService.delete(id);
    }
}