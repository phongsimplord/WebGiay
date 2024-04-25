package com.example.website.Service;

import com.example.website.Entity.KhachHang;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHang> getListKhachHang() {
        return khachHangRepository.findAll();
    }

    public List<KhachHang> getListKhachHangOrderByNgayNhap() {
        return khachHangRepository.findAllOrderByNgayTaoDesc();
    }

    public PageDTO<KhachHang> getPageKhachHang(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(khachHangRepository.findAllPageOrderByNgayTaoDesc(pageable));
    }

    public KhachHang createKhachHang(KhachHang khachHang) {
        khachHang.setNgay_tao(LocalDateTime.now());
        return khachHangRepository.save(khachHang);
    }

    public KhachHang updateKhachHang(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    public void deleteKhachHang(UUID id) {
        khachHangRepository.deleteById(id);
    }

    public KhachHang findKhachHangByMa(String ma) {
        return khachHangRepository.getKhachHangByMa(ma);
    }

    public KhachHang findKhachHangByID(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }
}
