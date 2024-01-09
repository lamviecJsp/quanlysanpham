package com.example.demo.payload.converter;

import com.example.demo.entity.HoaDon;
import com.example.demo.payload.dto.HoaDonDTO;
import com.example.demo.payload.request.SuaHoaDonRequest;
import com.example.demo.payload.request.ThemHoaDonRequest;
import org.springframework.stereotype.Component;

@Component
public class HoaDonConverter {
    public HoaDonDTO entityToDTO(HoaDon hoaDon) {
        HoaDonDTO dto = new HoaDonDTO();
        dto.setGhiChu(hoaDon.getGhiChu());
        dto.setTenHoaDon(hoaDon.getTenHoaDon());
        dto.setKhacHangId(hoaDon.getKhacHangId());
        dto.setMaGiaoDich(hoaDon.getMaGiaoDich());
        dto.setThoiGianCapNhat(hoaDon.getThoiGianCapNhat());
        dto.setThoiGianTao(hoaDon.getThoiGianTao());
        dto.setTongTien(hoaDon.getTongTien());
        return dto;
    }

    public HoaDon ThemHoaDon(ThemHoaDonRequest request) {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setGhiChu(request.getGhiChu());
        hoaDon.setTenHoaDon(request.getTenHoaDon());
        hoaDon.setKhacHangId(request.getKhacHangId());
        hoaDon.setMaGiaoDich(request.getMaGiaoDich());
        hoaDon.setThoiGianCapNhat(request.getThoiGianCapNhat());
        hoaDon.setThoiGianTao(request.getThoiGianTao());
        hoaDon.setTongTien(request.getTongTien());
        return hoaDon;
    }

    public HoaDon SuaHoaDon(HoaDon hoaDon, SuaHoaDonRequest request) {
        hoaDon.setGhiChu(request.getGhiChu());
        hoaDon.setTenHoaDon(request.getTenHoaDon());
        hoaDon.setKhacHangId(request.getKhacHangId());
        hoaDon.setMaGiaoDich(request.getMaGiaoDich());
        hoaDon.setThoiGianCapNhat(request.getThoiGianCapNhat());
        hoaDon.setThoiGianTao(request.getThoiGianTao());
        hoaDon.setTongTien(request.getTongTien());
        return hoaDon;
    }
}
