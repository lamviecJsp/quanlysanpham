package com.example.demo.payload.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HoaDonDTO {
    private int khacHangId;
    private String tenHoaDon;
    private String maGiaoDich;
    private LocalDate thoiGianTao = LocalDate.now();
    private LocalDate thoiGianCapNhat = LocalDate.now();
    private String ghiChu;
    private double tongTien = 0;
}
