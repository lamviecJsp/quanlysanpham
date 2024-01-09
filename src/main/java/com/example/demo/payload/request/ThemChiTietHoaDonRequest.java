package com.example.demo.payload.request;

import lombok.Data;

@Data
public class ThemChiTietHoaDonRequest {
    private int hoaDonId;
    private int sanPhamId;
    private int soLuong;
    private String dvt;
    private double thanhTien = 0;
}
