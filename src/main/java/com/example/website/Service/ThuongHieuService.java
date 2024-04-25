package com.example.website.Service;

import com.example.website.Entity.PageDTO;
import com.example.website.Entity.ThuongHieu;
import com.example.website.Repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ThuongHieuService {

    @Autowired
    ThuongHieuRepository thuongHieuRepository;

    public List<ThuongHieu> getListThuongHieu() {
        return thuongHieuRepository.findAll();
    }

    public ThuongHieu findByID(UUID id) {
        return thuongHieuRepository.findById(id).orElse(null);
    }

    public PageDTO<ThuongHieu> getPageThuongHieu(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(thuongHieuRepository.findAllPageOrderByNgayNhapDesc(pageable));
    }

    public ThuongHieu createThuongHieu(ThuongHieu thuongHieu) {
        thuongHieu.setNgay_them(LocalDateTime.now());
        return thuongHieuRepository.save(thuongHieu);
    }

    public ThuongHieu updateThuongHieu(ThuongHieu thuongHieu) {
        return thuongHieuRepository.save(thuongHieu);
    }

    public void deleteThuongHieu(UUID id) {
        thuongHieuRepository.deleteById(id);
    }
}
