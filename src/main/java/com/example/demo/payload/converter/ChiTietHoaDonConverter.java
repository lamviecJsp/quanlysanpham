package com.example.demo.payload.converter;

import com.example.demo.entity.ChiTietHoaDon;
import com.example.demo.payload.dto.ChiTietHoaDonDTO;
import com.example.demo.payload.request.ThemChiTietHoaDonRequest;
import org.springframework.stereotype.Component;

@Component
public class ChiTietHoaDonConverter {
    public ChiTietHoaDonDTO entityToDTO(ChiTietHoaDon chiTietHoaDon) {
        ChiTietHoaDonDTO dto = new ChiTietHoaDonDTO();
        dto.setHoaDonId(chiTietHoaDon.getHoaDonId());
        dto.setDvt(chiTietHoaDon.getDvt());
        dto.setSanPhamId(chiTietHoaDon.getSanPhamId());
        dto.setThanhTien(chiTietHoaDon.getThanhTien());
        dto.setSoLuong(chiTietHoaDon.getSoLuong());
        return dto;
    }

    public ChiTietHoaDon themCTHD(ThemChiTietHoaDonRequest request) {
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
        chiTietHoaDon.setHoaDonId(request.getHoaDonId());
        chiTietHoaDon.setDvt(request.getDvt());
        chiTietHoaDon.setSanPhamId(request.getSanPhamId());
        chiTietHoaDon.setThanhTien(request.getThanhTien());
        chiTietHoaDon.setSoLuong(request.getSoLuong());
        return chiTietHoaDon;
    }
}
