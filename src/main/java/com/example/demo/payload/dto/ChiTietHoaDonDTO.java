package com.example.demo.payload.dto;

import lombok.Data;

@Data
public class ChiTietHoaDonDTO {
    private int hoaDonId;
    private int sanPhamId;
    private int soLuong;
    private String dvt;
    private double thanhTien = 0;
}
