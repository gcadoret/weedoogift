package com.weedoogift.domain.service.endowment;

import com.weedoogift.domain.exception.UnsufficientBalanceCompanyException;
import com.weedoogift.domain.model.*;
import com.weedoogift.domain.port.CompanyRepository;
import com.weedoogift.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EndowmentServiceImpl implements EndowmentService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Override
    public User distributeGift(Long idCompany, Long idUser, int amount) {
        var company = companyRepository.findById(idCompany);
        checkBalanceCompany(amount, company);
        Endowment gift = new Gift(amount, company);
        return distribute(idUser, amount, company, gift);
    }

    @Override
    public User distributeMeal(Long idCompany, Long idUser, int amount) {
        var company = companyRepository.findById(idCompany);
        checkBalanceCompany(amount, company);
        Endowment meal = new Meal(amount, company);
        return distribute(idUser, amount, company, meal);
    }

    private void checkBalanceCompany(int amount, Company company) {
        if (company.getBalance() < amount) {
            throw new UnsufficientBalanceCompanyException();
        }
    }

    private User distribute(Long idUser, int amount, Company company, Endowment gift) {
        company.debit(amount);
        companyRepository.save(company);
        User user = userRepository.findById(idUser);
        List<Endowment> endowments = user.getEndowments();
        endowments.add(gift);
        userRepository.save(user);
        return user;
    }


}