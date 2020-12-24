package com.example.passio.View.order;

import android.graphics.Bitmap;

import java.util.List;

public class SanPham {
    String masp;
    Bitmap image;
    String tensp;
    String mota;
    int soluong;
    int gia;
    List<Bitmap> danhSachHinhAnh;
    public SanPham() {
    }
    public SanPham(Bitmap image, String tensp, String mota, int soluong, int gia) {
        this.image = image;
        this.tensp = tensp;
        this.mota = mota;
        this.soluong = soluong;
        this.gia = gia;
    }
    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public List<Bitmap> getDanhSachHinhAnh() {
        return danhSachHinhAnh;
    }

    public void setDanhSachHinhAnh(List<Bitmap> danhSachHinhAnh) {
        this.danhSachHinhAnh = danhSachHinhAnh;
    }
    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }
}