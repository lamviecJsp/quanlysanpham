package com.example.demo.Controller;

import com.example.demo.service.Services.KhachHangServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KhachHangController {
    private final KhachHangServices _KhachHangService;

    public KhachHangController(KhachHangServices khachHangService) {
        _KhachHangService = khachHangService;
    }

    @DeleteMapping(value = "xoakhachhang", produces = MediaType.APPLICATION_JSON_VALUE)
    public String xoaKhachHang(@RequestParam int khachHangId) {
        return _KhachHangService.xoaKhachHang(khachHangId);
    }
}
