package com.example.demo.service;

import com.example.demo.payload.dto.ChiTietHoaDonDTO;
import com.example.demo.payload.request.ThemChiTietHoaDonRequest;
import com.example.demo.payload.response.ResponseObject;

import java.util.List;

public interface iChiTietHoaDonSevices {
    ResponseObject<ChiTietHoaDonDTO> themChiTietHoaDon(ThemChiTietHoaDonRequest request);

    List<String> thanhTien(int hoaDonId);
}
