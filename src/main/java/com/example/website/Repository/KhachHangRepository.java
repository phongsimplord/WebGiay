package com.example.website.Repository;

import com.example.website.Entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {

    @Query("SELECT kh FROM KhachHang kh ORDER BY kh.ngay_tao DESC")
    List<KhachHang> findAllOrderByNgayTaoDesc();

    @Query("SELECT kh FROM KhachHang kh ORDER BY kh.ngay_tao DESC")
    Page<KhachHang> findAllPageOrderByNgayTaoDesc(Pageable pageable);

    @Query("SELECT kh FROM KhachHang kh WHERE kh.ma = ?1")
    KhachHang getKhachHangByMa(String ma);
}
