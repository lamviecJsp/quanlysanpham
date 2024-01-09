package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "loaisanphams")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaisanphamid")
    private int loaiSanPhamId;
    @Column(name = "ten")
    private String tenLoaiSanPham;
    @OneToMany(mappedBy = "loaiSanPham")
    @JsonManagedReference
    private Set<SanPham> sanPhams;
}
