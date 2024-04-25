package com.example.website.RestController;

import com.example.website.Entity.Giay;
import com.example.website.Service.GiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/giay")
public class GiayRestController {
    @Autowired
    private GiayService giayService;

    @GetMapping("/list")
    public List<Giay> getListGiay() {
        return giayService.getListGiay();
    }

    @GetMapping("/list-order-by-ngay-nhap")
    public List<Giay> getListGiayOrderByNgayNhap() {
        return giayService.getListGiayOrderByNgayNhap();
    }
}
