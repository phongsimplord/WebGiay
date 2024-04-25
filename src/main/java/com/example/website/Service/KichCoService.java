package com.example.website.Service;

import com.example.website.Entity.KichCo;
import com.example.website.Entity.PageDTO;
import com.example.website.Repository.KichCoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class KichCoService {

    @Autowired
    KichCoRepository kichCoRepository;

    public List<KichCo> getAllKichCo() {
        return kichCoRepository.findAll();
    }

    public KichCo getKichCoByID(UUID idKichCo) {
        return kichCoRepository.findById(idKichCo).orElse(null);
    }

    public PageDTO<KichCo> getPageKichCo(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new PageDTO<>(kichCoRepository.findAllPageOrderByNgayNhapDesc(pageable));
    }

    public KichCo createKichCo(KichCo kichCo) {
        kichCo.setNgay_them(LocalDateTime.now());
        return kichCoRepository.save(kichCo);
    }

    public KichCo updateKichCo(KichCo kichCo) {
        return kichCoRepository.save(kichCo);
    }

    public void deleteKichCo(UUID id) {
        kichCoRepository.deleteById(id);
    }

}
