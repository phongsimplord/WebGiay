package com.example.website.Repository;

import com.example.website.Entity.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface KichCoRepository extends JpaRepository<KichCo, UUID> {
    @Query("SELECT kc FROM KichCo kc ORDER BY kc.ngay_them DESC")
    Page<KichCo> findAllPageOrderByNgayNhapDesc(Pageable pageable);
}
