package com.example.website.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanHangTaiQuayController {

    @RequestMapping("/admin/sale")
    public String hienthi() {
        return "Sale/ban_hang_tai_quay";
    }
}
