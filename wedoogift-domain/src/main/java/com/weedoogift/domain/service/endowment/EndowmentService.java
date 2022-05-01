package com.weedoogift.domain.service.endowment;

import com.weedoogift.domain.model.User;

public interface EndowmentService {
    User distributeGift(Long idCompany, Long idUser, int amount);
    User distributeMeal(Long idCompany, Long idUser, int amount);
}
