package com.example.demo.Controller;

import com.example.demo.payload.dto.ChiTietHoaDonDTO;
import com.example.demo.payload.request.ThemChiTietHoaDonRequest;
import com.example.demo.payload.response.ResponseObject;
import com.example.demo.service.Services.ChiTietHoaDonSevices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChiTietHoaDonController {
    private final ChiTietHoaDonSevices _ChiTietHoaDonSevices;

    public ChiTietHoaDonController(ChiTietHoaDonSevices chiTietHoaDonSevices) {
        _ChiTietHoaDonSevices = chiTietHoaDonSevices;
    }

    @PostMapping(value = "themchitiethoadon", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ChiTietHoaDonDTO> themChiTietHoaDon(@RequestBody ThemChiTietHoaDonRequest request) {
        return _ChiTietHoaDonSevices.themChiTietHoaDon(request);
    }

    @GetMapping(value = "themchitiethoadon", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> thanhTien(@RequestParam int hoaDonId) {
        return _ChiTietHoaDonSevices.thanhTien(hoaDonId);
    }
}
