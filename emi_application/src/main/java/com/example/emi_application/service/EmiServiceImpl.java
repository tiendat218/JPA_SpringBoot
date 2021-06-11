package com.example.emi_application.service;

import com.example.emi_application.model.Customer;
import com.example.emi_application.model.Emi;
import com.example.emi_application.repository.EmiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmiServiceImpl implements EmiService {
    @Autowired
    private EmiRepository emiRepository;

    @Override
    public List<Emi> getEmiByCust(Long cust_id) {
        try {
            List<Emi> list = emiRepository.getEmiByCust(cust_id);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveEmi(Emi emi) {
        try {
            emi.setCreatedAt(new Date());
            emi.setUpdatedAt(new Date());
            emiRepository.save(emi);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmi(Emi emi) {
        try {
            emi.setUpdatedAt(new Date());
            emiRepository.save(emi);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmi(Long emi_id) {
        try{
            emiRepository.deleteById(emi_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Emi getEmiById(Long emi_id) {
        try{
            Emi emi = emiRepository.findById(emi_id).get();
            return emi;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

