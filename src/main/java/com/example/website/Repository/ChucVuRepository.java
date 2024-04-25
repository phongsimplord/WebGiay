package com.example.website.Repository;

import com.example.website.Entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {

    @Query("SELECT cv FROM ChucVu cv")
    Page<ChucVu> findAllPageChucVu(Pageable pageable);

    @Query("SELECT cv FROM ChucVu cv WHERE cv.ma = ?1")
    ChucVu getChucVuByMa(String ma);
}
