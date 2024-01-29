package br.com.vitorgabrielti.springbootjooq;

import br.com.vitorgabrielti.springbootjooq.public_.tables.records.UsersRecord;

public class UserMapper {
    public static UserDTO toUserDTO(UsersRecord usersRecord){
        return new UserDTO(
            usersRecord.getUsername(),
            usersRecord.getPassword(),
            usersRecord.getEmail());
    }
}
