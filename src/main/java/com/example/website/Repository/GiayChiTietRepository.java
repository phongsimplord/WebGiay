package com.example.website.Repository;

import com.example.website.Entity.GiayChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GiayChiTietRepository extends JpaRepository<GiayChiTiet, UUID> {
    @Query("SELECT gct FROM GiayChiTiet gct ORDER BY gct.ngay_them DESC")
    Page<GiayChiTiet> findAllGCTPageOrderByNgayThemDesc(Pageable pageable);

    @Query("SELECT gct FROM GiayChiTiet gct WHERE gct.giay.id = :giayId")
    List<GiayChiTiet> findGCTByGiayId(UUID giayId);

    @Query("SELECT gct FROM GiayChiTiet gct WHERE gct.giay.id = :giayId")
    Page<GiayChiTiet> findGCTByGiayId(UUID giayId, Pageable pageable);
}
