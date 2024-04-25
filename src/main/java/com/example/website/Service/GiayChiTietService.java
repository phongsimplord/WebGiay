package com.example.website.Service;

import com.example.website.Entity.GiayChiTiet;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.GiayChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GiayChiTietService {

    @Autowired
    GiayChiTietRepository giayChiTietRepository;

    public PageDTO<GiayChiTiet> getPageGiayChiTiet(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(giayChiTietRepository.findAllGCTPageOrderByNgayThemDesc(pageable));
    }

    public GiayChiTiet createGiayChiTiet(GiayChiTiet giayChiTiet) {
        giayChiTiet.setNgay_them(LocalDateTime.now());
        giayChiTiet.setGia_sau_khuyen_mai(giayChiTiet.getGiaban());
        return giayChiTietRepository.save(giayChiTiet);
    }

    public GiayChiTiet updateGiayChiTiet(GiayChiTiet giayChiTiet) {
        return giayChiTietRepository.save(giayChiTiet);
    }

    public void deleteGiayChiTiet(UUID id) {
        giayChiTietRepository.deleteById(id);
    }

    public List<GiayChiTiet> findGiayChiTietByGiayID(UUID idGiay) {
        return giayChiTietRepository.findGCTByGiayId(idGiay);
    }

    public PageDTO<GiayChiTiet> findPageGiayChiTietByGiayID(Integer page, UUID idGiay) {
        Pageable pageable = PageRequest.of(page, 10);
        return new PageDTO<>(giayChiTietRepository.findGCTByGiayId(idGiay, pageable));
    }

    public GiayChiTiet findGCTByID(UUID id) {
        return giayChiTietRepository.findById(id).orElse(null);
    }
}
