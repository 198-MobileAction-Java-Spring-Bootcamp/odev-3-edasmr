package com.example.homework3.Usr.Sevice.entityService;

import com.example.homework3.Usr.DAO.UsrUserDAO;
import com.example.homework3.Usr.Entity.UsrUser;
import com.example.homework3.Usr.Enum.EnumUsrUserType;
import com.example.homework3.Usr.Sevice.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrUserEntityService extends BaseEntityService<UsrUser, UsrUserDAO> {


    public UsrUserEntityService(UsrUserDAO dao) {
        super(dao);
    }

    public UsrUser findByUsername(String username){
        return getDao().findByUsername(username);
    }

    public List<UsrUser> findAllByUsrUserTypeOrderById(EnumUsrUserType usrUserType){
        return getDao().findAllByUsrUserTypeOrderById(usrUserType);
    }
}