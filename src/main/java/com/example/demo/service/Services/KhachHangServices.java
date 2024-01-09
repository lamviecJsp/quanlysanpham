package com.example.demo.service.Services;

import com.example.demo.respository.KhachHangRepo;
import com.example.demo.service.iKhachHangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServices implements iKhachHangServices {
    @Autowired
    private KhachHangRepo _KhachHangRepo;

    public String xoaKhachHang(int khachHangId) {
        var khachhang = _KhachHangRepo.findAll().stream().filter(x -> x.getKhachHangId() == khachHangId).findFirst();
        if (khachhang.isEmpty()) {
            return "Khách hàng không tồn tại";
        }
        _KhachHangRepo.delete(khachhang.get());
        return "Xoá khách hàng thành công";
    }
}
