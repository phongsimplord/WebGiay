package com.example.website.Repository;

import com.example.website.Entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    @Query("SELECT nv FROM NhanVien nv ORDER BY nv.ngay_vao_lam DESC")
    List<NhanVien> findAllOrderByNgayVaoLamDesc();

    @Query("SELECT nv FROM NhanVien nv ORDER BY nv.ngay_vao_lam DESC")
    Page<NhanVien> findAllPageOrderByNgayVaoLamDesc(Pageable pageable);

    @Query("SELECT nv FROM NhanVien nv WHERE nv.ma = ?1")
    NhanVien getNhanVienByMa(String ma);
}
