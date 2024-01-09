package com.example.demo.Controller;

import com.example.demo.payload.dto.HoaDonDTO;
import com.example.demo.payload.request.SuaHoaDonRequest;
import com.example.demo.payload.request.ThemHoaDonRequest;
import com.example.demo.payload.response.ResponseObject;
import com.example.demo.service.Services.HoaDonSevices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

@RestController
public class HoaDonController {
    private final HoaDonSevices _HoaDonSevice;

    public HoaDonController(HoaDonSevices hoaDonSevice) {
        _HoaDonSevice = hoaDonSevice;
    }

    @PostMapping(value = "themhoadon", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<HoaDonDTO> themHoaDon(@RequestBody ThemHoaDonRequest request) {
        return _HoaDonSevice.themHoaDon(request);
    }

    @PutMapping(value = "suahoadon", produces = MediaType.APPLICATION_JSON_VALUE)
    public String suaHoaDon(@RequestParam int hoaDonId, @RequestBody SuaHoaDonRequest request) {
        return _HoaDonSevice.suaHoaDon(hoaDonId, request);
    }

    @DeleteMapping(value = "xoahoadon", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaHoaDon(@RequestParam int hoaDonId) {
        return _HoaDonSevice.xoaHoaDon(hoaDonId);
    }

    @GetMapping(value = "theothoigiantao", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HoaDonDTO> hienthisapxeptheothoigiantao(@RequestParam int pageSize, @RequestParam int pageNumber) {
        return _HoaDonSevice.hienthisapxeptheothoigiantao(pageSize, pageNumber);
    }

    @GetMapping(value = "theothang", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HoaDonDTO> theothang(@RequestParam Month thang, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _HoaDonSevice.theothang(thang, pageSize, pageNumber);
    }

    @GetMapping(value = "theonam", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HoaDonDTO> theonam(@RequestParam int year, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _HoaDonSevice.theonam(year, pageSize, pageNumber);
    }

    @GetMapping(value = "layhoadontheongay", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HoaDonDTO> layhoadonngay(@RequestParam LocalDate tuNgay, @RequestParam LocalDate denNgay, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _HoaDonSevice.layhoadonngay(tuNgay, denNgay, pageSize, pageNumber);
    }

    @GetMapping(value = "layhoadontheotongtien", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HoaDonDTO> layhoadontheotongtien(@RequestParam double tuTien, @RequestParam double denTien, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _HoaDonSevice.layhoadontheotongtien(tuTien, denTien, pageSize, pageNumber);
    }

    @GetMapping(value = "timkiem", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<HoaDonDTO> timkiem(@RequestParam String tenHoaDon, @RequestParam String maGiaoDich, @RequestParam int pageSize, @RequestParam int pageNumber) {
        return _HoaDonSevice.timkiem(tenHoaDon, maGiaoDich, pageSize, pageNumber);
    }
}
