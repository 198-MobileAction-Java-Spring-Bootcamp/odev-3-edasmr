package com.example.homework3.Usr.Sevice;

import com.example.homework3.Usr.DTO.UsrUserDTO;
import com.example.homework3.Usr.DTO.UsrUserSaveRequestDto;
import com.example.homework3.Usr.Entity.UsrUser;
import com.example.homework3.Usr.Enum.EnumUsrUserType;
import com.example.homework3.Usr.Sevice.entityService.UsrUserEntityService;
import com.example.homework3.Usr.converter.UsrUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserEntityService usrUserEntityService;


    
    public List<UsrUserDTO> findAll() {

        List<UsrUser> usrUserList = usrUserEntityService.findAll();

        List<UsrUserDTO> usrUserDtoList = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUserList);

        return usrUserDtoList;
    }

    public UsrUserDTO findById(Long id) {

        UsrUser usrUser = usrUserEntityService.getById(id);

        UsrUserDTO usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUser);

        return usrUserDto;
    }

    public UsrUserDTO findByUsername(String username) {

        UsrUser usrUser = usrUserEntityService.findByUsername(username);

        if (usrUser == null){
            throw new RuntimeException("User not found!");
        }

        UsrUserDTO usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUser);

        return usrUserDto;
    }

    public UsrUserDTO save(UsrUserSaveRequestDto usrUserSaveRequestDto) {

        validateUserRequest(usrUserSaveRequestDto.getUsername());

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUserSaveRequestDto(usrUserSaveRequestDto);

      //  String encodedPassword = passwordEncoder.encode(usrUser.getPassword());

     //   usrUser.setPassword(encodedPassword);

        usrUser = usrUserEntityService.save(usrUser);

        UsrUserDTO usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUser);

        return usrUserDto;
    }

    public void delete(Long id) {

        UsrUser usrUser = usrUserEntityService.getById(id);

        usrUserEntityService.delete(usrUser);
    }

    public void validateUserRequest(String username) {

        UsrUser user = usrUserEntityService.findByUsername(username);

        if (user != null){
            throw new RuntimeException("Username already in use");
        }
    }


}