package com.example.website.Controller.Admin;

import com.example.website.Entity.DiaChi;
import com.example.website.Entity.KhachHang;
import com.example.website.Entity.PageDTO;
import com.example.website.Service.DiaChiService;
import com.example.website.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class KhachHangController {

    @Autowired
    KhachHangService khachHangService;

    @Autowired
    DiaChiService diaChiService;

    //Start Customer
    @RequestMapping("/admin/customer")
    public String ViewAllCustomer(@ModelAttribute("KhachHang") KhachHang khachHang,
                                  @RequestParam("page") Optional<Integer> page,
                                  Model model) {
        PageDTO<KhachHang> pageKhachHang = khachHangService.getPageKhachHang(page.orElse(0));
        model.addAttribute("pageKhachHang", pageKhachHang);
        return "Customer/khach_hang_hien_thi";
    }

    @PostMapping("/admin/customer/create-customer")
    public String createKhachHang(@ModelAttribute("KhachHang") KhachHang khachHang) {
        khachHangService.createKhachHang(khachHang);
        return "redirect:/admin/customer";
    }

    @RequestMapping("/admin/customer/delete-customer/{id}")
    public String deleteKhachHang(@PathVariable("id") UUID id) {
        khachHangService.deleteKhachHang(id);
        return "redirect:/admin/customer";
    }

    @PostMapping("/admin/customer/update-customer")
    public String updateKhachHang(@RequestParam("id") UUID id,
                                  @RequestParam("ma") String ma,
                                  @RequestParam("ho_ten") String ho_ten,
                                  @RequestParam("ngay_sinh") Date ngay_sinh,
                                  @RequestParam("anh") String anh,
                                  @RequestParam("sdt") String sdt,
                                  @RequestParam("email") String email,
                                  @RequestParam("mat_khau") String mat_khau,
                                  @RequestParam("trang_thai") int trang_thai) {
        KhachHang khachHang = khachHangService.findKhachHangByID(id);
        khachHang.setMa(ma);
        khachHang.setHo_ten(ho_ten);
        khachHang.setNgay_sinh(ngay_sinh);
        khachHang.setAvatar(anh);
        khachHang.setSdt(sdt);
        khachHang.setEmail(email);
        khachHang.setMat_khau(mat_khau);
        khachHang.setTrangthai(trang_thai);
        khachHangService.updateKhachHang(khachHang);
        return "redirect:/admin/customer";
    }
    //End customer

    //Start Detail Customer
    @RequestMapping("/admin/customer/detail-customer/{maKH}")
    public String ViewAllDetailCustomer(@PathVariable("maKH") String maKH,
                                        @RequestParam("page") Optional<Integer> page,
                                        @ModelAttribute("DiaChi") DiaChi diaChi,
                                        Model model) {
        KhachHang khachHang = khachHangService.findKhachHangByMa(maKH);
        PageDTO<DiaChi> pageDiaChi = diaChiService.getPageDiaChiByKhachHang(maKH, page.orElse(0));
        model.addAttribute("khachHangDetail", khachHang);
        model.addAttribute("pageDiaChi", pageDiaChi);
        return "Customer/chi_tiet_khach_hang";
    }

    @PostMapping("/admin/customer/detail-customer/update-customer")
    public String updateKhachHangDetail(@RequestParam("id") UUID id,
                                        @RequestParam("ma") String ma,
                                        @RequestParam("ho_ten") String ho_ten,
                                        @RequestParam("ngay_sinh") Date ngay_sinh,
                                        @RequestParam("sdt") String sdt,
                                        @RequestParam("email") String email,
                                        @RequestParam("mat_khau") String mat_khau,
                                        @RequestParam("trang_thai") int trang_thai) {
        KhachHang khachHang = khachHangService.findKhachHangByID(id);
        khachHang.setMa(ma);
        khachHang.setHo_ten(ho_ten);
        khachHang.setNgay_sinh(ngay_sinh);
        khachHang.setSdt(sdt);
        khachHang.setEmail(email);
        khachHang.setMat_khau(mat_khau);
        khachHang.setTrangthai(trang_thai);
        khachHangService.updateKhachHang(khachHang);
        return "redirect:/admin/customer/detail-customer/" + khachHang.getMa();
    }

    @RequestMapping("/admin/customer/detail-customer/delete-district/{id}/{maKH}")
    public String deleteDiaChi(@PathVariable("id") UUID id, @PathVariable("maKH") String maKH) {
        diaChiService.deleteDiaChi(id);
        return "redirect:/admin/customer/detail-customer/" + maKH;
    }

    @PostMapping("/admin/customer/detail-customer/create-district/{maKH}")
    public String CreateDiaChi(@PathVariable("maKH") String maKH, @ModelAttribute("DiaChi") DiaChi diaChi) {
        diaChi.setKhachHang(khachHangService.findKhachHangByMa(maKH));
        diaChi.setTrangthai(0);
        diaChiService.createDiaChi(diaChi);
        return "redirect:/admin/customer/detail-customer/" + maKH;
    }

    @PostMapping("/admin/customer/detail-customer/update-district")
    public String updateDiaChi(@RequestParam("id") UUID id,
                               @RequestParam("ma") String ma,
                               @RequestParam("maKH") String maKH,
                               @RequestParam("ten_nguoi_nhan") String ten_nguoi_nhan,
                               @RequestParam("sdt_nguoi_nhan") String sdt_nguoi_nhan,
                               @RequestParam("xa") String xa,
                               @RequestParam("huyen") String huyen,
                               @RequestParam("thanh_pho") String thanh_pho) {
        DiaChi diaChi = diaChiService.findDiaChiByID(id);
        diaChi.setMa(ma);
        diaChi.setTen_nguoi_nhan(ten_nguoi_nhan);
        diaChi.setSdt_nguoi_nhan(sdt_nguoi_nhan);
        diaChi.setXa(xa);
        diaChi.setHuyen(huyen);
        diaChi.setThanh_pho(thanh_pho);
        diaChiService.updateDiaChi(diaChi);
        return "redirect:/admin/customer/detail-customer/" + maKH;
    }

    @RequestMapping("/admin/customer/detail-customer/set-default-district/{id}/{maKH}")
    public String setDefaultDiaChi(@PathVariable("id") UUID id, @PathVariable("maKH") String maKH) {
        List<DiaChi> diaChiList = diaChiService.getListDiaChiByKhachHang(maKH);
        for (DiaChi x : diaChiList) {
            x.setTrangthai(0);
            diaChiService.updateDiaChi(x);
        }
        DiaChi diaChi = diaChiService.findDiaChiByID(id);
        diaChi.setTrangthai(1);
        diaChiService.updateDiaChi(diaChi);
        return "redirect:/admin/customer/detail-customer/" + maKH;
    }

    //End Detail Customer

}
