package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "sanphams")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanphamid")
    private int sanPhamId;
    @ManyToOne
    @JoinColumn(name = "loaisanphamid", insertable = false, updatable = false)
    @JsonBackReference
    private LoaiSanPham loaiSanPham;
    @Column(name = "loaisanphamid")
    private int loaiSanPhamId;

    @Column(name = "tensanpham")
    private String tenSanPham;
    @Column(name = "giathanh")
    private double giaThanh;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "ngayhethan")
    private LocalDate ngayHetHan;
    @Column(name = "kyhieusanpham")
    private String kyHieuSanPham;
    @OneToMany(mappedBy = "sanPham")
    @JsonManagedReference
    private Set<ChiTietHoaDon> chiTietHoaDons;
}
