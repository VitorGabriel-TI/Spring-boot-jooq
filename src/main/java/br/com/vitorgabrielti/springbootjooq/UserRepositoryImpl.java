package br.com.vitorgabrielti.springbootjooq;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import br.com.vitorgabrielti.springbootjooq.public_.tables.Users;
import br.com.vitorgabrielti.springbootjooq.public_.tables.records.UsersRecord;

@Repository
public class UserRepositoryImpl implements UserRepository{
    private final DSLContext ctx;

    public UserRepositoryImpl(DSLContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public UsersRecord findById(String username) {
        return ctx.selectFrom(Users.USERS)
        .where(Users.USERS.USERNAME.eq(username))
        .fetchOne();
    }

    @Override
    public UsersRecord create(UserDTO userDTO) {
        var usersRecord = ctx.newRecord(Users.USERS);
        usersRecord.setUsername(userDTO.username());
        usersRecord.setPassword(userDTO.password());
        usersRecord.setEmail(userDTO.email());
        int stored =  usersRecord.store();

        if (stored == 1){
            return usersRecord;
        } else {
            throw new RuntimeException("User not created");
        }
    }
    
}
