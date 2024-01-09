package com.example.demo.service;

import com.example.demo.payload.dto.HoaDonDTO;
import com.example.demo.payload.request.SuaHoaDonRequest;
import com.example.demo.payload.request.ThemHoaDonRequest;
import com.example.demo.payload.response.ResponseObject;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

public interface iHoaDonSevices {
    ResponseObject<HoaDonDTO> themHoaDon(ThemHoaDonRequest request);

    String suaHoaDon(int hoaDonId, SuaHoaDonRequest request);

    String xoaHoaDon(int hoaDonId);

    Set<HoaDonDTO> hienthisapxeptheothoigiantao(int pageSize, int pageNumber);

    Set<HoaDonDTO> theonam(int year, int pageSize, int pageNumber);

    Set<HoaDonDTO> theothang(Month thang, int pageSize, int pageNumber);

    Set<HoaDonDTO> layhoadonngay(LocalDate tuNgay, LocalDate denNgay, int pageSize, int pageNumber);

    Set<HoaDonDTO> layhoadontheotongtien(double tuTien, double denTien, int pageSize, int pageNumber);

    Set<HoaDonDTO> timkiem(String tenHoaDon, String maGiaoDich, int pageSize, int pageNumber);
}
