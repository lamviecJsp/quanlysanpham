package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "hoadons")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hoadonid")
    private int hoaDonId;
    @ManyToOne
    @JoinColumn(name = "khachhangid", insertable = false, updatable = false)
    @JsonBackReference
    private KhachHang khachHang;
    @Column(name = "khachhangid")
    private int khacHangId;

    @Column(name = "tenhoadon")
    private String tenHoaDon;
    @Column(name = "magiaodich")
    private String maGiaoDich;
    @Column(name = "thoigiantao")
    private LocalDate thoiGianTao = LocalDate.now();
    @Column(name = "thoigiancapnhat")
    private LocalDate thoiGianCapNhat = LocalDate.now();
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "tongtien")
    private double tongTien = 0;

    @OneToMany(mappedBy = "hoaDon")
    @JsonManagedReference
    private Set<ChiTietHoaDon> chiTietHoaDons;
}
