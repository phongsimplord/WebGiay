package com.example.website.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "giay")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Giay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String ma;

    private String ten;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_thuong_hieu")
    private ThuongHieu thuong_hieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_chat_lieu")
    private ChatLieu chat_lieu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_de_giay")
    private DeGiay de_giay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_loai_giay")
    private LoaiGiay loai_giay;

    private Integer gioi_tinh;

    private String mota;

    private LocalDateTime ngay_nhap;

    private Integer trangthai = 1;
}

