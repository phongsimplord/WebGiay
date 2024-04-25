package com.example.website.Service;

import com.example.website.Entity.MauSac;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MauSacService {

    @Autowired
    MauSacRepository mauSacRepository;

    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }

    public MauSac getMauSacByID(UUID idMauSac) {
        return mauSacRepository.findById(idMauSac).orElse(null);
    }

    public PageDTO<MauSac> getPageMauSac(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(mauSacRepository.findAllPageOrderByNgayNhapDesc(pageable));
    }

    public MauSac createMauSac(MauSac mauSac) {
        mauSac.setNgay_them(LocalDateTime.now());
        return mauSacRepository.save(mauSac);
    }

    public MauSac updateMauSac(MauSac mauSac) {
        return mauSacRepository.save(mauSac);
    }

    public void deleteMauSac(UUID id) {
        mauSacRepository.deleteById(id);
    }
}
