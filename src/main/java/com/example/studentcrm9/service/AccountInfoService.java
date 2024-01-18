package com.example.studentcrm9.service;

import com.example.studentcrm9.database.entity.AccountInfo;
import com.example.studentcrm9.database.enums.Faculty;
import com.example.studentcrm9.database.enums.Role;
import com.example.studentcrm9.dto.AccountInfoDto;
import com.example.studentcrm9.mapper.AccountInfoMapper;
import com.example.studentcrm9.repository.AccountInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountInfoService {
    private final AccountInfoMapper accountInfoMapper;
    private final AccountInfoRepository accountInfoRepository;

    public Optional<AccountInfo>save(AccountInfoDto accountInfoDto){
        return Optional.of(accountInfoRepository
                .save(accountInfoMapper.mapToAccountInfo(accountInfoDto)));
    }


    public String registrationRedirect(AccountInfoDto accountInfoDto,
                                        BindingResult bindingResult,
                                        RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return redirectToRegistration(accountInfoDto, bindingResult, redirectAttributes);
        }
        return redirectToAccount(accountInfoDto);

    }
    private String redirectToAccount(AccountInfoDto accountInfoDto) {
        Optional<AccountInfo> account = save(accountInfoDto);
        return "redirect:/students";
    }

    private static String redirectToRegistration(AccountInfoDto accountInfoDto,
                                                 BindingResult bindingResult,
                                                 RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("accountInfoDto", accountInfoDto);
        redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
        return "redirect:/students/registration";
    }
}
