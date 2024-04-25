package com.example.website.Repository;

import com.example.website.Entity.DiaChi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DiaChiRepository extends JpaRepository<DiaChi, UUID> {
    @Query("SELECT dc FROM DiaChi dc ORDER BY dc.ngay_them DESC")
    List<DiaChi> findAllDistrictByNgayThemDesc();

    @Query("SELECT dc FROM DiaChi dc ORDER BY dc.ngay_them DESC")
    Page<DiaChi> findAllPageDistrictByNgayThemDesc(Pageable pageable);

    @Query("SELECT dc FROM DiaChi dc where dc.khachHang.ma = ?1 ORDER BY dc.ngay_them DESC")
    Page<DiaChi> findAllPageDistrictByNgayThemDescByKhachHang(String ma, Pageable pageable);

    @Query("SELECT dc FROM DiaChi dc where dc.khachHang.ma = ?1")
    List<DiaChi> findAllDistrictByKhachHang(String ma);

    @Query("SELECT dc FROM DiaChi dc WHERE dc.ma = ?1")
    DiaChi getDiaChiByMa(String ma);
}
