package com.example.website.Repository;

import com.example.website.Entity.AnhGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AnhGiayRepository extends JpaRepository<AnhGiay, UUID> {
    @Query("SELECT pic FROM AnhGiay pic WHERE pic.giay_chi_tiet.id = ?1")
    List<AnhGiay> getListAnhByIdGiayChiTiet(UUID id);
}
