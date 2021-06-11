package com.example.emi_application.service;

import com.example.emi_application.model.Emi;

import java.util.List;

public interface EmiService {
    List<Emi> getEmiByCust(Long cust_id);
    boolean saveEmi(Emi emi);
    boolean updateEmi(Emi emi);
    boolean deleteEmi(Long emi_id);
    Emi getEmiById(Long emi_id);
}
