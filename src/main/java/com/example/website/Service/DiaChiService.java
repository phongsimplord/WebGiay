package com.example.website.Service;

import com.example.website.Entity.DiaChi;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.DiaChiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DiaChiService {

    @Autowired
    DiaChiRepository diaChiRepository;

    public List<DiaChi> getListDiaChi() {
        return diaChiRepository.findAll();
    }

    public List<DiaChi> getListDiaChiOrderByNgayThem() {
        return diaChiRepository.findAllDistrictByNgayThemDesc();
    }

    public PageDTO<DiaChi> getPageDiaChi(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(diaChiRepository.findAllPageDistrictByNgayThemDesc(pageable));
    }

    public PageDTO<DiaChi> getPageDiaChiByKhachHang(String maKH, Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(diaChiRepository.findAllPageDistrictByNgayThemDescByKhachHang(maKH, pageable));
    }

    public List<DiaChi> getListDiaChiByKhachHang(String maKH) {

        return diaChiRepository.findAllDistrictByKhachHang(maKH);
    }

    public DiaChi createDiaChi(DiaChi diaChi) {
        diaChi.setNgay_them(LocalDateTime.now());
        return diaChiRepository.save(diaChi);
    }

    public DiaChi updateDiaChi(DiaChi diaChi) {
        return diaChiRepository.save(diaChi);
    }

    public void deleteDiaChi(UUID id) {
        diaChiRepository.deleteById(id);
    }

    public DiaChi findDiaChiByMa(String ma) {
        return diaChiRepository.getDiaChiByMa(ma);
    }

    public DiaChi findDiaChiByID(UUID id) {
        return diaChiRepository.findById(id).orElse(null);
    }
}
