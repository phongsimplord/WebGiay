package com.example.website.Service;

import com.example.website.Entity.LoaiGiay;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.LoaiGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class LoaiGiayService {

    @Autowired
    LoaiGiayRepository loaiGiayRepository;

    public List<LoaiGiay> getListLoaiGiay() {
        return loaiGiayRepository.findAll();
    }

    public LoaiGiay findByID(UUID id) {
        return loaiGiayRepository.findById(id).orElse(null);
    }

    public PageDTO<LoaiGiay> getPageLoaiGiay(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(loaiGiayRepository.findAllPageOrderByNgayNhapDesc(pageable));
    }

    public LoaiGiay createLoaiGiay(LoaiGiay loaiGiay) {
        loaiGiay.setNgay_them(LocalDateTime.now());
        return loaiGiayRepository.save(loaiGiay);
    }

    public LoaiGiay updateLoaiGiay(LoaiGiay loaiGiay) {
        return loaiGiayRepository.save(loaiGiay);
    }

    public void deleteLoaiGiay(UUID id) {
        loaiGiayRepository.deleteById(id);
    }
}
