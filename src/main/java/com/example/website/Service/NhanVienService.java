package com.example.website.Service;

import com.example.website.Entity.NhanVien;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public PageDTO<NhanVien> getPageNhanVien(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(nhanVienRepository.findAllPageOrderByNgayVaoLamDesc(pageable));
    }

    public NhanVien createNhanVien(NhanVien nhanVien) {
        nhanVien.setNgay_vao_lam(LocalDateTime.now());
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    public NhanVien findByMa(String ma) {
        return nhanVienRepository.getNhanVienByMa(ma);
    }

    public NhanVien findById(UUID id) {
        return nhanVienRepository.findById(id).orElse(null);
    }
}
