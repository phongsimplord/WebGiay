package com.example.website.Controller.Admin;

import com.example.website.Entity.ChatLieu;
import com.example.website.Entity.DeGiay;
import com.example.website.Entity.KichCo;
import com.example.website.Entity.LoaiGiay;
import com.example.website.Entity.MauSac;
import com.example.website.Entity.PageDTO;
import com.example.website.Entity.ThuongHieu;
import com.example.website.Service.ChatLieuService;
import com.example.website.Service.DeGiayService;
import com.example.website.Service.KichCoService;
import com.example.website.Service.LoaiGiayService;
import com.example.website.Service.MauSacService;
import com.example.website.Service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
public class ThuocTinhGiayController {

    @Autowired
    ThuongHieuService thuongHieuService;

    @Autowired
    ChatLieuService chatLieuService;

    @Autowired
    DeGiayService deGiayService;

    @Autowired
    LoaiGiayService loaiGiayService;

    @Autowired
    KichCoService kichCoService;

    @Autowired
    MauSacService mauSacService;

    @RequestMapping("/admin/product/product-attribution")
    public String ViewAllProduct(@ModelAttribute("ThuongHieu") ThuongHieu thuongHieu,
                                 @ModelAttribute("ChatLieu") ChatLieu chatLieu,
                                 @ModelAttribute("DeGiay") DeGiay deGiay,
                                 @ModelAttribute("LoaiGiay") LoaiGiay loaiGiay,
                                 @ModelAttribute("KichCo") KichCo kichCo,
                                 @ModelAttribute("MauSac") MauSac mauSac,
                                 @RequestParam("pageth") Optional<Integer> pageth,
                                 @RequestParam("pagecl") Optional<Integer> pagecl,
                                 @RequestParam("pagedg") Optional<Integer> pagedg,
                                 @RequestParam("pagelg") Optional<Integer> pagelg,
                                 @RequestParam("pagekc") Optional<Integer> pagekc,
                                 @RequestParam("pagems") Optional<Integer> pagems,
                                 Model model) {
        PageDTO<ThuongHieu> pageThuongHieu = thuongHieuService.getPageThuongHieu(pageth.orElse(0));
        PageDTO<ChatLieu> pageChatLieu = chatLieuService.getPageChatLieu(pagecl.orElse(0));
        PageDTO<DeGiay> pageDeGiay = deGiayService.getPageDeGiay(pagedg.orElse(0));
        PageDTO<LoaiGiay> pageLoaiGiay = loaiGiayService.getPageLoaiGiay(pagelg.orElse(0));
        PageDTO<KichCo> pageKichCo = kichCoService.getPageKichCo(pagekc.orElse(0));
        PageDTO<MauSac> pageMauSac = mauSacService.getPageMauSac(pagems.orElse(0));
        model.addAttribute("pageThuongHieu", pageThuongHieu);
        model.addAttribute("pageChatLieu", pageChatLieu);
        model.addAttribute("pageDeGiay", pageDeGiay);
        model.addAttribute("pageLoaiGiay", pageLoaiGiay);
        model.addAttribute("pageKichCo", pageKichCo);
        model.addAttribute("pageMauSac", pageMauSac);
        return "Product/thuoc_tinh_giay_hien_thi";
    }

    // Start Thương hiệu
    @PostMapping("/admin/product-attribution/create-thuong-hieu")
    public String CreateThuongHieu(@ModelAttribute("ThuongHieu") ThuongHieu thuongHieu) {
        thuongHieuService.createThuongHieu(thuongHieu);
        return "redirect:/admin/product/product-attribution";
    }

    @RequestMapping("/admin/product-attribution/delete-thuong-hieu/{id}")
    public String DeleteThuongHieu(@PathVariable("id") UUID id) {
        thuongHieuService.deleteThuongHieu(id);
        return "redirect:/admin/product/product-attribution";
    }

    @PostMapping("/admin/product-attribution/update-thuong-hieu")
    public String UpdateThuongHieu(@RequestParam("id") UUID id,
                                   @RequestParam("ma") String ma,
                                   @RequestParam("ten") String ten,
                                   @RequestParam("anh") String anh,
                                   @RequestParam("trangthai") int trangthai) {
        ThuongHieu thuongHieu = thuongHieuService.findByID(id);
        thuongHieu.setMa(ma);
        thuongHieu.setTen(ten);
        thuongHieu.setTen_url_anh(anh);
        thuongHieu.setTrangthai(trangthai);
        thuongHieuService.updateThuongHieu(thuongHieu);
        return "redirect:/admin/product/product-attribution";
    }
    // End Thương hiệu

    // Start Chất liệu
    @PostMapping("/admin/product-attribution/create-chat-lieu")
    public String CreateChatLieu(@ModelAttribute("ChatLieu") ChatLieu chatLieu) {
        chatLieuService.createChatLieu(chatLieu);
        return "redirect:/admin/product/product-attribution";
    }

    @RequestMapping("/admin/product-attribution/delete-chat-lieu/{id}")
    public String DeleteChatLieu(@PathVariable("id") UUID id) {
        chatLieuService.deleteChatLieu(id);
        return "redirect:/admin/product/product-attribution";
    }

    @PostMapping("/admin/product-attribution/update-chat-lieu")
    public String UpdateChatLieu(@RequestParam("id") UUID id,
                                 @RequestParam("ma") String ma,
                                 @RequestParam("ten") String ten,
                                 @RequestParam("trangthai") int trangthai) {
        ChatLieu chatLieu = chatLieuService.findByID(id);
        chatLieu.setMa(ma);
        chatLieu.setTen(ten);
        chatLieu.setTrangthai(trangthai);
        chatLieuService.updateChatLieu(chatLieu);
        return "redirect:/admin/product/product-attribution";
    }
    // End Chất liệu

    // Start Đế giày
    @PostMapping("/admin/product-attribution/create-de-giay")
    public String CreateDeGiay(@ModelAttribute("DeGiay") DeGiay deGiay) {
        deGiayService.createDeGiay(deGiay);
        return "redirect:/admin/product/product-attribution";
    }

    @RequestMapping("/admin/product-attribution/delete-de-giay/{id}")
    public String DeleteDeGiay(@PathVariable("id") UUID id) {
        deGiayService.deleteDeGiay(id);
        return "redirect:/admin/product/product-attribution";
    }

    @PostMapping("/admin/product-attribution/update-de-giay")
    public String UpdateDeGiay(@RequestParam("id") UUID id,
                               @RequestParam("ma") String ma,
                               @RequestParam("ten") String ten,
                               @RequestParam("trangthai") int trangthai) {
        DeGiay deGiay = deGiayService.findByID(id);
        deGiay.setMa(ma);
        deGiay.setTen(ten);
        deGiay.setTrangthai(trangthai);
        deGiayService.updateDeGiay(deGiay);
        return "redirect:/admin/product/product-attribution";
    }
    // End Đế giày

    // Start Loại giày
    @PostMapping("/admin/product-attribution/create-loai-giay")
    public String CreateLoaiGiay(@ModelAttribute("LoaiGiay") LoaiGiay loaiGiay) {
        loaiGiayService.createLoaiGiay(loaiGiay);
        return "redirect:/admin/product/product-attribution";
    }

    @RequestMapping("/admin/product-attribution/delete-loai-giay/{id}")
    public String DeleteLoaiGiay(@PathVariable("id") UUID id) {
        loaiGiayService.deleteLoaiGiay(id);
        return "redirect:/admin/product/product-attribution";
    }

    @PostMapping("/admin/product-attribution/update-loai-giay")
    public String UpdateLoaiGiay(@RequestParam("id") UUID id,
                                 @RequestParam("ma") String ma,
                                 @RequestParam("ten") String ten,
                                 @RequestParam("trangthai") int trangthai) {
        LoaiGiay loaiGiay = loaiGiayService.findByID(id);
        loaiGiay.setMa(ma);
        loaiGiay.setTen(ten);
        loaiGiay.setTrangthai(trangthai);
        loaiGiayService.updateLoaiGiay(loaiGiay);
        return "redirect:/admin/product/product-attribution";
    }
    // End Loại giày

    // Start Kích cỡ
    @PostMapping("/admin/product-attribution/create-kich-co")
    public String CreateKichCo(@ModelAttribute("KichCo") KichCo kichCo) {
        kichCoService.createKichCo(kichCo);
        return "redirect:/admin/product/product-attribution";
    }

    @RequestMapping("/admin/product-attribution/delete-kich-co/{id}")
    public String DeleteKichCo(@PathVariable("id") UUID id) {
        kichCoService.deleteKichCo(id);
        return "redirect:/admin/product/product-attribution";
    }

    @PostMapping("/admin/product-attribution/update-kich-co")
    public String UpdateKichCo(@RequestParam("id") UUID id,
                               @RequestParam("ma") String ma,
                               @RequestParam("ten") String ten,
                               @RequestParam("trangthai") int trangthai) {
        KichCo kichCo = kichCoService.getKichCoByID(id);
        kichCo.setMa(ma);
        kichCo.setTen(ten);
        kichCo.setTrangthai(trangthai);
        kichCoService.updateKichCo(kichCo);
        return "redirect:/admin/product/product-attribution";
    }

    // End Kích cỡ

    // Start Màu sắc
    @PostMapping("/admin/product-attribution/create-mau-sac")
    public String CreateMauSac(@ModelAttribute("MauSac") MauSac mauSac) {
        mauSacService.createMauSac(mauSac);
        return "redirect:/admin/product/product-attribution";
    }

    @RequestMapping("/admin/product-attribution/delete-mau-sac/{id}")
    public String DeleteMauSac(@PathVariable("id") UUID id) {
        mauSacService.deleteMauSac(id);
        return "redirect:/admin/product/product-attribution";
    }

    @PostMapping("/admin/product-attribution/update-mau-sac")
    public String UpdateMauSac(@RequestParam("id") UUID id,
                               @RequestParam("ma") String ma,
                               @RequestParam("ten") String ten,
                               @RequestParam("trangthai") int trangthai) {
        MauSac mauSac = mauSacService.getMauSacByID(id);
        mauSac.setMa(ma);
        mauSac.setTen(ten);
        mauSac.setTrangthai(trangthai);
        mauSacService.updateMauSac(mauSac);
        return "redirect:/admin/product/product-attribution";
    }
    // End Màu sắc
}
