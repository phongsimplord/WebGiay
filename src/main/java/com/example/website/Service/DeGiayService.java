package com.example.website.Service;

import com.example.website.Entity.DeGiay;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.DeGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DeGiayService {

    @Autowired
    DeGiayRepository deGiayRepository;

    public List<DeGiay> getListDeGiay() {
        return deGiayRepository.findAll();
    }

    public DeGiay findByID(UUID id) {
        return deGiayRepository.findById(id).orElse(null);
    }

    public PageDTO<DeGiay> getPageDeGiay(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(deGiayRepository.findAllPageOrderByNgayNhapDesc(pageable));
    }

    public DeGiay createDeGiay(DeGiay deGiay) {
        deGiay.setNgay_them(LocalDateTime.now());
        return deGiayRepository.save(deGiay);
    }

    public DeGiay updateDeGiay(DeGiay deGiay) {
        return deGiayRepository.save(deGiay);
    }

    public void deleteDeGiay(UUID id) {
        deGiayRepository.deleteById(id);
    }
}
