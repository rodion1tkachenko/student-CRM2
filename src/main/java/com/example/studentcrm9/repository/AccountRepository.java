package com.example.studentcrm9.repository;

import com.example.studentcrm9.database.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account>getAccountById(Long id);
    void deleteAccountByLogin(String login);
    default boolean saveAccount(Account account){
        save(account);
        return true;
    }
}
