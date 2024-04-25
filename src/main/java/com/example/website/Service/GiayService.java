package com.example.website.Service;

import com.example.website.Entity.Giay;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.GiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GiayService {

    @Autowired
    private GiayRepository giayRepository;

    public List<Giay> getListGiay() {
        return giayRepository.findAll();
    }

    public List<Giay> getListGiayOrderByNgayNhap() {
        return giayRepository.findAllOrderByNgayNhapDesc();
    }

    public PageDTO<Giay> getPageGiay(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(giayRepository.findAllPageOrderByNgayNhapDesc(pageable));
    }

    public Giay createGiay(Giay giay) {
        giay.setNgay_nhap(LocalDateTime.now());
        return giayRepository.save(giay);
    }

    public Giay updateGiay(Giay giay) {
        return giayRepository.save(giay);
    }

    public void deleteGiay(UUID idGiay) {
        giayRepository.deleteById(idGiay);
    }

    public Giay findGiayByMa(String ma) {
        return giayRepository.getGiayByMa(ma);
    }

    public Giay findGiayByID(UUID id) {
        return giayRepository.findById(id).orElse(null);
    }
}
