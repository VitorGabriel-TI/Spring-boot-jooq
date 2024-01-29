package br.com.vitorgabrielti.springbootjooq;

import br.com.vitorgabrielti.springbootjooq.public_.tables.records.UsersRecord;

public interface UserRepository {
    UsersRecord findById(String username);
    UsersRecord create(UserDTO userDTO);
}
