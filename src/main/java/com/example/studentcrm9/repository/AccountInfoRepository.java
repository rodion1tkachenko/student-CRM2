package com.example.studentcrm9.repository;

import com.example.studentcrm9.database.entity.Account;
import com.example.studentcrm9.database.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountInfoRepository extends CrudRepository<AccountInfo,Long> {
    default Optional<AccountInfo> saveAccount(AccountInfo accountInfo){
        return Optional.of(save(accountInfo));
    }
}
