package com.example.website.Repository;

import com.example.website.Entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, UUID> {

    @Query("SELECT th FROM ThuongHieu th ORDER BY th.ngay_them DESC")
    Page<ThuongHieu> findAllPageOrderByNgayNhapDesc(Pageable pageable);
}
