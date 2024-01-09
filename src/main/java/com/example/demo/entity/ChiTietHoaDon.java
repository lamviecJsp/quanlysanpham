package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "chitiethoadons")
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int chiTietHoaDonId;
    @ManyToOne
    @JoinColumn(name = "hoadonid", insertable = false, updatable = false)
    @JsonBackReference
    private HoaDon hoaDon;
    @Column(name = "hoadonid")
    private int hoaDonId;
    @ManyToOne
    @JoinColumn(name = "sanphamid", insertable = false, updatable = false)
    @JsonBackReference
    private SanPham sanPham;
    @Column(name = "sanphamid")
    private int sanPhamId;

    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "dvt")
    private String dvt;
    @Column(name = "thanhtien")
    private double thanhTien = 0;

}
