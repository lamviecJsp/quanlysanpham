package com.example.demo.service.Services;

import com.example.demo.entity.ChiTietHoaDon;
import com.example.demo.entity.HoaDon;
import com.example.demo.entity.SanPham;
import com.example.demo.payload.converter.ChiTietHoaDonConverter;
import com.example.demo.payload.dto.ChiTietHoaDonDTO;
import com.example.demo.payload.request.ThemChiTietHoaDonRequest;
import com.example.demo.payload.response.ResponseObject;
import com.example.demo.respository.ChiTietHoaDonRepo;
import com.example.demo.respository.HoaDonRepo;
import com.example.demo.respository.SanPhamRepo;
import com.example.demo.service.iChiTietHoaDonSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChiTietHoaDonSevices implements iChiTietHoaDonSevices {
    @Autowired
    private HoaDonRepo _HoaDonRepo;
    @Autowired
    private SanPhamRepo _SanPhamRepo;
    @Autowired
    private ChiTietHoaDonRepo _ChiTietHoaDonRepo;
    @Autowired
    private ChiTietHoaDonConverter _ChiTietHoaDonConverter;
    private SanPham sanpham;
    private HoaDon hoaDon;

    public ResponseObject<ChiTietHoaDonDTO> _ChiTietHoaDonDTOResponseObject;

    public ChiTietHoaDonSevices() {
        _ChiTietHoaDonDTOResponseObject = new ResponseObject<ChiTietHoaDonDTO>();
    }

    public ResponseObject<ChiTietHoaDonDTO> themChiTietHoaDon(ThemChiTietHoaDonRequest request) {
        var hoadon = _HoaDonRepo.findAll().stream().filter(x -> x.getHoaDonId() == request.getHoaDonId());
        if (hoadon == null) {
            return _ChiTietHoaDonDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Hoá đơn  không tồn tại", null);
        }
        var sanPham = _SanPhamRepo.findAll().stream().filter(x -> x.getSanPhamId() == request.getSanPhamId());
        if (sanPham == null) {
            return _ChiTietHoaDonDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "San pham  không tồn tại", null);
        }
        int soluong = request.getSoLuong();
        double giatien = sanpham.getGiaThanh();
        double thanhtien = soluong * giatien;
        var themchitiethoadon = _ChiTietHoaDonConverter.themCTHD(request);
        themchitiethoadon.setThanhTien(thanhtien);
        _ChiTietHoaDonRepo.save(themchitiethoadon);

        double tongtien = 0;
        for (ChiTietHoaDon chiTietHoaDon : hoaDon.getChiTietHoaDons()) {
            tongtien += chiTietHoaDon.getThanhTien();
        }
        hoaDon.setTongTien(tongtien);
        _HoaDonRepo.save(hoaDon);

        return _ChiTietHoaDonDTOResponseObject.responseSuccess("Thêm hoá đơn thành công", _ChiTietHoaDonConverter.entityToDTO(themchitiethoadon));
    }

    public List<String> thanhTien() {
        return null;
    }

    public List<String> thanhTien(int hoaDonId) {
        var checkHoaDon = _HoaDonRepo.findAll().stream().filter(x -> x.getHoaDonId() == hoaDonId).findFirst();
        if (checkHoaDon.isEmpty()) {
            return null;
        }
        var list = _ChiTietHoaDonRepo.findAll();
        List<String> danhsachTT = new ArrayList<>();
        double thanhtien;
        for (var chitiethoadon : list) {
            thanhtien = 0;
            var giatiens = _SanPhamRepo.findAll();
            for (var giatien : giatiens) {
                if (chitiethoadon.getSanPhamId() == giatien.getSanPhamId()) {
                    thanhtien += giatien.getGiaThanh() * chitiethoadon.getSoLuong();
                }
            }
            danhsachTT.add("Tông tiền của hoá đơn đó là : " + thanhtien);
        }
        return danhsachTT;
    }

}
