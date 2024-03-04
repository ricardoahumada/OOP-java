package com.banana.bananamint.services;


import com.banana.bananamint.Payload.Debt;

import java.util.List;

public interface DebtService {
    public List<Debt> showAll(Long idCustomer) throws DebtException;

    public Debt open(Long idCustomer, Debt account) throws DebtException;
}
