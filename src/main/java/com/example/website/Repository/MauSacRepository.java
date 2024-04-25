package com.example.website.Repository;

import com.example.website.Entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {

    @Query("SELECT ms FROM MauSac ms ORDER BY ms.ngay_them DESC")
    Page<MauSac> findAllPageOrderByNgayNhapDesc(Pageable pageable);
}
