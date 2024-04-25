package com.example.website.Service;

import com.example.website.Entity.ChucVu;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuService {

    @Autowired
    ChucVuRepository chucVuRepository;

    public List<ChucVu> getAllChucVu() {
        return chucVuRepository.findAll();
    }

    public PageDTO<ChucVu> getPageChucVu(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(chucVuRepository.findAllPageChucVu(pageable));
    }

    public ChucVu findChucVuByMa(String ma) {
        return chucVuRepository.getChucVuByMa(ma);
    }

    public ChucVu findChucVuByID(UUID id) {
        return chucVuRepository.findById(id).orElse(null);
    }

    public ChucVu createChucVu(ChucVu chucVu) {
        return chucVuRepository.save(chucVu);
    }

    public void deleteChucVu(UUID id) {
        chucVuRepository.deleteById(id);
    }
}
