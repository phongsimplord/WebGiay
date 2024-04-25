package com.example.website.Controller.Admin;

import com.example.website.Entity.ChucVu;
import com.example.website.Entity.NhanVien;
import com.example.website.Entity.PageDTO;
import com.example.website.Service.ChucVuService;
import com.example.website.Service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Controller
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ChucVuService chucVuService;

    @RequestMapping("/admin/staff")
    public String NhanVienHienThi(@ModelAttribute("NhanVien") NhanVien nhanVien,
                                  @RequestParam("page") Optional<Integer> page,
                                  Model model) {
        PageDTO<NhanVien> pageNhanVien = nhanVienService.getPageNhanVien(page.orElse(0));
        model.addAttribute("pageNhanVien", pageNhanVien);
        model.addAttribute("ListChucVu", chucVuService.getAllChucVu());
        return "Staff/nhan_vien_hien_thi";
    }

    @RequestMapping("/admin/staff/office")
    public String ChucVuHienThi(@ModelAttribute("ChucVu") ChucVu chucVu,
                                @RequestParam("page") Optional<Integer> page,
                                Model model) {
        PageDTO<ChucVu> pageChucVu = chucVuService.getPageChucVu(page.orElse(0));
        model.addAttribute("pageChucVu", pageChucVu);
        return "Staff/chuc_vu_hien_thi";
    }

    @PostMapping("/admin/staff/create-staff")
    public String createNhanVien(@ModelAttribute("NhanVien") NhanVien nhanVien) {
        nhanVienService.createNhanVien(nhanVien);
        return "redirect:/admin/staff";
    }

    @RequestMapping("/admin/staff/delete-staff/{id}")
    public String deleteNhanVien(@PathVariable("id") UUID id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/admin/staff";
    }

    @PostMapping("/admin/staff/update-staff")
    public String updateNhanVien(@RequestParam("id") UUID id,
                                 @RequestParam("ma") String ma,
                                 @RequestParam("ho_ten") String ho_ten,
                                 @RequestParam("ngay_sinh") Date ngay_sinh,
                                 @RequestParam("anh") String anh,
                                 @RequestParam("sdt") String sdt,
                                 @RequestParam("email") String email,
                                 @RequestParam("mat_khau") String mat_khau,
                                 @RequestParam("xa") String xa,
                                 @RequestParam("huyen") String huyen,
                                 @RequestParam("thanh_pho") String thanh_pho,
                                 @RequestParam("dia_chi") String dia_chi,
                                 @RequestParam("chuc_vu") UUID chuc_vu,
                                 @RequestParam("trang_thai") int trang_thai) {
        NhanVien nhanVien = nhanVienService.findById(id);
        nhanVien.setMa(ma);
        nhanVien.setHo_ten(ho_ten);
        nhanVien.setNgay_sinh(ngay_sinh);
        nhanVien.setAnh(anh);
        nhanVien.setSdt(sdt);
        nhanVien.setEmail(email);
        nhanVien.setMat_khau(mat_khau);
        nhanVien.setXa(xa);
        nhanVien.setHuyen(huyen);
        nhanVien.setThanh_pho(thanh_pho);
        nhanVien.setDia_chi(dia_chi);
        nhanVien.setChucVu(chucVuService.findChucVuByID(chuc_vu));
        if (trang_thai == 0) {
            nhanVien.setTrangthai(trang_thai);
            nhanVien.setNgay_nghi_viec(LocalDateTime.now());
        } else if (trang_thai == 1) {
            nhanVien.setTrangthai(trang_thai);
            nhanVien.setNgay_nghi_viec(null);
        }
        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/admin/staff";
    }

    @PostMapping("/admin/staff/office/create-office")
    public String createChucVu(@ModelAttribute("ChucVu") ChucVu chucVu) {
        chucVuService.createChucVu(chucVu);
        return "redirect:/admin/staff/office";
    }

    @PostMapping("/admin/staff/office/update-office")
    public String updateChucVu(@RequestParam("id") UUID id,
                               @RequestParam("ma") String ma,
                               @RequestParam("ten") String ten,
                               @RequestParam("trang_thai") int trang_thai) {
        ChucVu chucVu = chucVuService.findChucVuByID(id);
        chucVu.setMa(ma);
        chucVu.setTen(ten);
        chucVu.setTrangthai(trang_thai);
        chucVuService.createChucVu(chucVu);
        return "redirect:/admin/staff/office";
    }

    @RequestMapping("/admin/staff/office/delete-office/{id}")
    public String deleteChucVu(@PathVariable("id") UUID id) {
        chucVuService.deleteChucVu(id);
        return "redirect:/admin/staff/office";
    }
}
