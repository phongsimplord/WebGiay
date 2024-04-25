package com.example.website.Repository;

import com.example.website.Entity.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ChatLieuRepository extends JpaRepository<ChatLieu, UUID> {
    @Query("SELECT cl FROM ChatLieu cl ORDER BY cl.ngay_them DESC")
    Page<ChatLieu> findAllPageOrderByNgayNhapDesc(Pageable pageable);
}
