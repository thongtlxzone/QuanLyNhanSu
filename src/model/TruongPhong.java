package model;

import java.util.ArrayList;
import java.util.List;

public class TruongPhong extends ConNguoi{
    public int soLuongNhanVienQuanLy;

    public int getSoLuongNhanVienQuanLy() {
        return soLuongNhanVienQuanLy;
    }

    public void setSoLuongNhanVienQuanLy(int soLuongNhanVienQuanLy) {
        this.soLuongNhanVienQuanLy = soLuongNhanVienQuanLy;
    }

    public TruongPhong(){
        this.chucVu = "Truong phong";
    };

    public TruongPhong(String maSo, String hoTen, String sdt, int soNgayLamViec) {
        super(maSo, hoTen, sdt, soNgayLamViec);
        this.luong1Ngay = 200;
        this.chucVu = "Truong phong";
        this.soLuongNhanVienQuanLy = 0;
    }

    @Override
    public int tinhLuong() {
        return soLuongNhanVienQuanLy * 100 + luong1Ngay*soNgayLamViec;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.luong1Ngay = 200;
        this.chucVu = "Truong phong";
    }
    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("So luong nhan vien dang quan ly: " + soLuongNhanVienQuanLy);
    }
}
