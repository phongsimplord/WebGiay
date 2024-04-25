package com.example.website.Controller.Admin;

import com.example.website.Entity.AnhGiay;
import com.example.website.Entity.Giay;
import com.example.website.Entity.GiayChiTiet;
import com.example.website.Entity.PageDTO;
import com.example.website.Service.AnhGiayService;
import com.example.website.Service.ChatLieuService;
import com.example.website.Service.CloudinaryService;
import com.example.website.Service.DeGiayService;
import com.example.website.Service.GiayChiTietService;
import com.example.website.Service.GiayService;
import com.example.website.Service.KichCoService;
import com.example.website.Service.LoaiGiayService;
import com.example.website.Service.MauSacService;
import com.example.website.Service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Controller
public class SanPhamController {

    @Autowired
    private AnhGiayService anhGiayService;

    @Autowired
    private GiayService giayService;

    @Autowired
    private ChatLieuService chatLieuService;

    @Autowired
    private DeGiayService deGiayService;

    @Autowired
    private LoaiGiayService loaiGiayService;

    @Autowired
    private ThuongHieuService thuongHieuService;

    @Autowired
    private GiayChiTietService giayChiTietService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private KichCoService kichCoService;

    @Autowired
    private CloudinaryService cloudinaryService;

    // Start Product Controller
    @RequestMapping("/admin/product")
    public String ViewAllProduct(@ModelAttribute("Giay") Giay giay,
                                 @RequestParam("page") Optional<Integer> page,
                                 Model model) {
        PageDTO<Giay> pageGiay = giayService.getPageGiay(page.orElse(0));
        model.addAttribute("pageGiay", pageGiay);
        model.addAttribute("listGiay", giayService.getListGiayOrderByNgayNhap());
        model.addAttribute("listChatLieu", chatLieuService.getListChatLieu());
        model.addAttribute("listDeGiay", deGiayService.getListDeGiay());
        model.addAttribute("listLoaiGiay", loaiGiayService.getListLoaiGiay());
        model.addAttribute("ListThuongHieu", thuongHieuService.getListThuongHieu());
        return "Product/san_pham_hien_thi";
    }

    @PostMapping("/admin/product/create-product")
    public String CreateProduct(@ModelAttribute("Giay") Giay giay) {
        giayService.createGiay(giay);
        return "redirect:/admin/product";
    }

    @RequestMapping("/admin/product/delete-product/{idGiay}")
    public String DeleteProduct(@PathVariable("idGiay") UUID idGiay) {
        giayService.deleteGiay(idGiay);
        return "redirect:/admin/product";
    }
    // End Product Controller

    // Start Detail Product Controller
    @RequestMapping("/admin/product-detail")
    public String ViewAllDetailProduct(@ModelAttribute("GiayChiTiet") GiayChiTiet giayChiTiet,
                                       @RequestParam("page") Optional<Integer> page,
                                       Model model) {
        model.addAttribute("listGiay", giayService.getListGiay());
        model.addAttribute("listMauSac", mauSacService.getAllMauSac());
        model.addAttribute("listKichCo", kichCoService.getAllKichCo());
        model.addAttribute("listChatLieu", chatLieuService.getListChatLieu());
        model.addAttribute("listDeGiay", deGiayService.getListDeGiay());
        model.addAttribute("listLoaiGiay", loaiGiayService.getListLoaiGiay());
        model.addAttribute("listThuongHieu", thuongHieuService.getListThuongHieu());
        model.addAttribute("pageGiayChiTiet", giayChiTietService.getPageGiayChiTiet(page.orElse(0)));
        return "Product/san_pham_chi_tiet_hien_thi";
    }

    @PostMapping("/admin/product-detail/create-product-detail")
    public String CreateProductDetail(@ModelAttribute("GiayChiTiet") GiayChiTiet GiayChiTiet) {
        giayChiTietService.createGiayChiTiet(GiayChiTiet);
        return "redirect:/admin/product-detail";
    }

    @RequestMapping("/admin/product-detail/delete-product-detail/{idGiayChiTiet}")
    public String DeleteProductDetail(@PathVariable("idGiayChiTiet") UUID idGiayChiTiet) {
        giayChiTietService.deleteGiayChiTiet(idGiayChiTiet);
        return "redirect:/admin/product-detail";
    }

    @PostMapping("/admin/product/view-update/update-giay-chi-tiet1")
    public String UpdateProductDetail3(@RequestParam("idGiay") UUID idGiay,
                                       @RequestParam("idGiayChiTiet") UUID idGiayChiTiet,
                                       @RequestParam("tenGiay") String tenGiay,
                                       @RequestParam("gioiTinh") int gioiTinh,
                                       @RequestParam("soLuongTon") int soLuongTon,
                                       @RequestParam("giaNhap") BigDecimal giaNhap,
                                       @RequestParam("giaBan") BigDecimal giaBan,
                                       @RequestParam("idThuongHieu") UUID idThuongHieu,
                                       @RequestParam("idChatLieu") UUID idChatLieu,
                                       @RequestParam("idDeGiay") UUID idDeGiay,
                                       @RequestParam("idLoaiGiay") UUID idLoaiGiay,
                                       @RequestParam("idMauSac") UUID idMauSac,
                                       @RequestParam("idKichCo") UUID idKichCo,
                                       @RequestParam("trangthai2") int trangthai) {
        // Update lại giày
        Giay giay = giayService.findGiayByID(idGiay);
        giay.setTen(tenGiay);
        giay.setGioi_tinh(gioiTinh);
        giay.setThuong_hieu(thuongHieuService.findByID(idThuongHieu));
        giay.setChat_lieu(chatLieuService.findByID(idChatLieu));
        giay.setDe_giay(deGiayService.findByID(idDeGiay));
        giay.setLoai_giay(loaiGiayService.findByID(idLoaiGiay));
        giayService.updateGiay(giay);

        //Update lại giày chi tiết tương ứng
        GiayChiTiet giayChiTiet = giayChiTietService.findGCTByID(idGiayChiTiet);
        giayChiTiet.setMau_sac(mauSacService.getMauSacByID(idMauSac));
        giayChiTiet.setKich_co(kichCoService.getKichCoByID(idKichCo));
        giayChiTiet.setSo_luong_ton(soLuongTon);
        giayChiTiet.setGianhap(giaNhap);
        giayChiTiet.setGiaban(giaBan);
        giayChiTiet.setTrangthai(trangthai);
        giayChiTietService.updateGiayChiTiet(giayChiTiet);
        return "redirect:/admin/product-detail";
    }
    // End Detail Product Controller

    //    Start View update Product
    @RequestMapping("/admin/product/view-update/{maGiay}")
    public String ViewUpdateProduct(@ModelAttribute("GiayChiTiet") GiayChiTiet giayChiTiet,
                                    @PathVariable("maGiay") String maGiay,
                                    @RequestParam("page") Optional<Integer> page,
                                    Model model) {
        model.addAttribute("GiayDetail", giayService.findGiayByMa(maGiay));
        model.addAttribute("listChatLieu", chatLieuService.getListChatLieu());
        model.addAttribute("listDeGiay", deGiayService.getListDeGiay());
        model.addAttribute("listLoaiGiay", loaiGiayService.getListLoaiGiay());
        model.addAttribute("ListThuongHieu", thuongHieuService.getListThuongHieu());
        model.addAttribute("ListKichCo", kichCoService.getAllKichCo());
        model.addAttribute("ListMauSac", mauSacService.getAllMauSac());
        PageDTO<GiayChiTiet> pageGiayChiTiet = giayChiTietService.findPageGiayChiTietByGiayID(page.orElse(0), giayService.findGiayByMa(maGiay).getId());
        model.addAttribute("pageGiayChiTiet", pageGiayChiTiet);
        return "Product/san_pham_chi_tiet_update";
    }

    @PostMapping("/admin/product/view-update/create-giay-chi-tiet")
    public String CreateProductDetail2(@RequestParam("maGiay") String maGiay,
                                       @RequestParam("idMauSac") UUID idMauSac,
                                       @RequestParam("idKichCo") UUID idKichCo,
                                       @RequestParam("soLuongTon") int soLuongTon,
                                       @RequestParam("giaNhap") BigDecimal giaNhap,
                                       @RequestParam("giaBan") BigDecimal giaBan,
                                       @RequestParam("trangthai1") int trangthai) {
        GiayChiTiet giayChiTiet = new GiayChiTiet();
        giayChiTiet.setGiay(giayService.findGiayByMa(maGiay));
        giayChiTiet.setMau_sac(mauSacService.getMauSacByID(idMauSac));
        giayChiTiet.setKich_co(kichCoService.getKichCoByID(idKichCo));
        giayChiTiet.setSo_luong_ton(soLuongTon);
        giayChiTiet.setGianhap(giaNhap);
        giayChiTiet.setGiaban(giaBan);
        giayChiTiet.setTrangthai(trangthai);
        giayChiTietService.createGiayChiTiet(giayChiTiet);
        return "redirect:/admin/product/view-update/" + maGiay;
    }

    @RequestMapping("/admin/product-detail/delete-product-detail2/{idGiayChiTiet}/{maGiay}")
    public String DeleteProductDetail2(@PathVariable("idGiayChiTiet") UUID idGiayChiTiet,
                                       @PathVariable("maGiay") String maGiay) {
        giayChiTietService.deleteGiayChiTiet(idGiayChiTiet);
        return "redirect:/admin/product/view-update/" + maGiay;
    }

    @PostMapping("/admin/product/create-product2")
    public String CreateProduct2(@ModelAttribute("Giay") Giay giay) {
        giayService.createGiay(giay);
        return "redirect:/admin/product/view-update/" + giay.getMa();
    }

    @PostMapping("/admin/product/view-update/update-giay-chi-tiet")
    public String UpdateProductDetail2(@RequestParam("idGiayChiTiet") UUID idGiayChiTiet,
                                       @RequestParam("idMauSac") UUID idMauSac,
                                       @RequestParam("idKichCo") UUID idKichCo,
                                       @RequestParam("soLuongTon") int soLuongTon,
                                       @RequestParam("giaNhap") BigDecimal giaNhap,
                                       @RequestParam("giaBan") BigDecimal giaBan,
                                       @RequestParam("trangthai2") int trangthai) {
        GiayChiTiet giayChiTiet = giayChiTietService.findGCTByID(idGiayChiTiet);
        giayChiTiet.setMau_sac(mauSacService.getMauSacByID(idMauSac));
        giayChiTiet.setKich_co(kichCoService.getKichCoByID(idKichCo));
        giayChiTiet.setSo_luong_ton(soLuongTon);
        giayChiTiet.setGianhap(giaNhap);
        giayChiTiet.setGiaban(giaBan);
        giayChiTiet.setTrangthai(trangthai);
        giayChiTietService.updateGiayChiTiet(giayChiTiet);
        return "redirect:/admin/product/view-update/" + giayChiTiet.getGiay().getMa();
    }

    @PostMapping("/admin/product/upload-images")
    public String uploadImages(@RequestParam("files") MultipartFile[] files, @RequestParam("gctID") UUID gctID) {
        try {
            for (MultipartFile file : files) {
                String publicId = cloudinaryService.uploadImage(file);
                AnhGiay anhGiay = new AnhGiay();
                anhGiay.setGiay_chi_tiet(giayChiTietService.findGCTByID(gctID));
                anhGiay.setTen_anh(publicId);
                anhGiayService.createAnhGiay(anhGiay);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/admin/product/view-update/" + giayChiTietService.findGCTByID(gctID).getGiay().getMa();
    }

    @PostMapping("/admin/product/delete-image/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable("imageId") UUID imageId) {
        AnhGiay anhGiay = anhGiayService.geAnhGiayById(imageId);
        if (anhGiay != null) {
            cloudinaryService.deleteImage(anhGiay.getTen_anh());
            anhGiayService.deleteImage(imageId);
            return ResponseEntity.ok("Xóa ảnh thành công");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy ảnh");
        }
    }
    //    End View update Product
}
