package com.example.website.Service;

import com.example.website.Entity.AnhGiay;
import com.example.website.Repository.AnhGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnhGiayService {
    @Autowired
    private AnhGiayRepository anhGiayRepository;

    public List<AnhGiay> getListAnhGiayByIdGCT(UUID id) {
        return anhGiayRepository.getListAnhByIdGiayChiTiet(id);
    }

    public AnhGiay createAnhGiay(AnhGiay anhGiay) {
        return anhGiayRepository.save(anhGiay);
    }

    public AnhGiay geAnhGiayById(UUID id) {
        return anhGiayRepository.findById(id).get();
    }

    public void deleteImage(UUID uuid) {
        anhGiayRepository.deleteById(uuid);
    }
}
