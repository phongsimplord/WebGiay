package com.example.website.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GiamGiaSanPhamController {

    @RequestMapping("/admin/product-promotion")
    public String hienthi() {
        return "ProductPromotion/giam_gia_san_pham_hien_thi";
    }
}
