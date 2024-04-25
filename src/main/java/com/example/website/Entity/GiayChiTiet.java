package com.example.website.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "giay_chi_tiet")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiayChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_giay")
    private Giay giay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mau_sac")
    private MauSac mau_sac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_kich_co")
    private KichCo kich_co;

    private Integer so_luong_ton;

    private BigDecimal gianhap;

    private BigDecimal giaban;

    private BigDecimal gia_sau_khuyen_mai;

    private LocalDateTime ngay_them;

    private Integer trangthai = 1;

    @OneToMany(mappedBy = "giay_chi_tiet", fetch = FetchType.EAGER)
    private List<AnhGiay> anhGiayList;
}
