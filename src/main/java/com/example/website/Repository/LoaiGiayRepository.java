package com.example.website.Repository;

import com.example.website.Entity.LoaiGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface LoaiGiayRepository extends JpaRepository<LoaiGiay, UUID> {
    @Query("SELECT lg FROM LoaiGiay lg ORDER BY lg.ngay_them DESC")
    Page<LoaiGiay> findAllPageOrderByNgayNhapDesc(Pageable pageable);
}
