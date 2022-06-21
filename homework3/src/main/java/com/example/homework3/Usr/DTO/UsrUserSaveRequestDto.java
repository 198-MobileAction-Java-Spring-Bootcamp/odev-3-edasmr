package com.example.homework3.Usr.DTO;

import com.example.homework3.Usr.Enum.EnumUsrUserType;
import lombok.Data;

@Data
public class UsrUserSaveRequestDto {

    private Long id;
    private String name;
    private String shortName;
    private String username;
    private String password;
    private String imageUrl;
    private EnumUsrUserType usrUserType;
}