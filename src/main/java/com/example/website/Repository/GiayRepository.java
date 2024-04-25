package com.example.website.Repository;

import com.example.website.Entity.Giay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GiayRepository extends JpaRepository<Giay, UUID> {

    @Query("SELECT g FROM Giay g ORDER BY g.ngay_nhap DESC")
    List<Giay> findAllOrderByNgayNhapDesc();

    @Query("SELECT g FROM Giay g ORDER BY g.ngay_nhap DESC")
    Page<Giay> findAllPageOrderByNgayNhapDesc(Pageable pageable);

    @Query("SELECT g FROM Giay g WHERE g.ma = ?1")
    Giay getGiayByMa(String ma);
}
