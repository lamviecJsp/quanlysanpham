package com.example.demo.service.Services;

import com.example.demo.payload.converter.HoaDonConverter;
import com.example.demo.payload.dto.HoaDonDTO;
import com.example.demo.payload.request.SuaHoaDonRequest;
import com.example.demo.payload.request.ThemHoaDonRequest;
import com.example.demo.payload.response.ResponseObject;
import com.example.demo.respository.ChiTietHoaDonRepo;
import com.example.demo.respository.HoaDonRepo;
import com.example.demo.respository.KhachHangRepo;
import com.example.demo.service.iHoaDonSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HoaDonSevices implements iHoaDonSevices {
    @Autowired
    private HoaDonRepo _HoaDonRepo;
    @Autowired
    private KhachHangRepo _KhachHangRepo;
    @Autowired
    private HoaDonConverter _HoaDonConverter;
    @Autowired
    private ChiTietHoaDonRepo _ChiTietHoaDonRepo;

    public ResponseObject<HoaDonDTO> _HoaDonDTOResponseObject;

    public HoaDonSevices() {
        _HoaDonDTOResponseObject = new ResponseObject<HoaDonDTO>();
    }

    public ResponseObject<HoaDonDTO> themHoaDon(ThemHoaDonRequest request) {
        var khachhang = _KhachHangRepo.findAll().stream().filter(x -> x.getKhachHangId() == request.getKhacHangId());
        if (khachhang == null) {
            return _HoaDonDTOResponseObject.responseError(HttpURLConnection.HTTP_NOT_FOUND, "Khách hàng không tồn tại", null);
        }
        var themhoadon = _HoaDonConverter.ThemHoaDon(request);
        _HoaDonRepo.save(themhoadon);
        return _HoaDonDTOResponseObject.responseSuccess("Thêm hoá đon thành công", _HoaDonConverter.entityToDTO(themhoadon));
    }

    public String suaHoaDon(int hoaDonId, SuaHoaDonRequest request) {
        var hoadon = _HoaDonRepo.findAll().stream().filter(x -> x.getHoaDonId() == hoaDonId).findFirst();
        if (hoadon.isEmpty()) {
            return "Hoá đơn không tồn tại";
        }
        var suaHoaDon = _HoaDonConverter.SuaHoaDon(hoadon.get(), request);
        _HoaDonRepo.save(suaHoaDon);
        return "Sửa thành công ";
    }

    public String xoaHoaDon(int hoaDonId) {
        var hoadon = _HoaDonRepo.findAll().stream().filter(x -> x.getHoaDonId() == hoaDonId).findFirst();
        if (hoadon.isEmpty()) {
            return "Hoá đơn không tồn tại";
        }
        _ChiTietHoaDonRepo.deleteAllById(Collections.singleton(hoaDonId));
        _HoaDonRepo.delete(hoadon.get());
        return "Xoá thành công";
    }

    public Set<HoaDonDTO> hienthisapxeptheothoigiantao(int pageSize, int pageNumber) {
        return _HoaDonRepo.findAll().stream().sorted((s1, s2) -> s2.getThoiGianTao().compareTo(s1.getThoiGianTao())).skip((pageNumber - 1) * pageSize).limit(pageSize)
                .map(x -> _HoaDonConverter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<HoaDonDTO> theothang(Month thang, int pageSize, int pageNumber) {
        return _HoaDonRepo.findAll().stream().filter(x -> x.getThoiGianTao().getMonth() == thang)
                .skip((pageNumber - 1) * pageSize).limit(pageSize)
                .map(x -> _HoaDonConverter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<HoaDonDTO> layhoadonngay(LocalDate tuNgay, LocalDate denNgay, int pageSize, int pageNumber) {
        return _HoaDonRepo.findAll().stream().filter(x -> x.getThoiGianTao().isAfter(tuNgay) == true && x.getThoiGianTao().isBefore(denNgay) == true)
                .skip((pageNumber - 1) * pageSize).limit(pageSize)
                .map(x -> _HoaDonConverter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<HoaDonDTO> layhoadontheotongtien(double tuTien, double denTien, int pageSize, int pageNumber) {
        return _HoaDonRepo.findAll().stream().filter(x -> x.getTongTien() >= tuTien && x.getTongTien() <= denTien)
                .skip((pageNumber - 1) * pageSize).limit(pageSize)
                .map(x -> _HoaDonConverter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<HoaDonDTO> timkiem(String tenHoaDon, String maGiaoDich, int pageSize, int pageNumber) {
        return _HoaDonRepo.findAll().stream().filter(x -> x.getTenHoaDon() == tenHoaDon && x.getMaGiaoDich() == maGiaoDich)
                .skip((pageNumber - 1) * pageSize).limit(pageSize)
                .map(x -> _HoaDonConverter.entityToDTO(x))
                .collect(Collectors.toSet());
    }

    public Set<HoaDonDTO> theonam(int year, int pageSize, int pageNumber) {
        return _HoaDonRepo.findAll().stream().filter(x -> x.getThoiGianTao().getYear() == year)
                .skip((pageNumber - 1) * pageSize).limit(pageSize)
                .map(x -> _HoaDonConverter.entityToDTO(x))
                .collect(Collectors.toSet());
    }
}
