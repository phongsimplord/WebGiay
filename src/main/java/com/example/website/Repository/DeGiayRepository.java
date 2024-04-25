package com.example.website.Repository;

import com.example.website.Entity.DeGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DeGiayRepository extends JpaRepository<DeGiay, UUID> {
    @Query("SELECT dg FROM DeGiay dg ORDER BY dg.ngay_them DESC")
    Page<DeGiay> findAllPageOrderByNgayNhapDesc(Pageable pageable);
}
