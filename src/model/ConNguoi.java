package model;

import java.util.Scanner;

public class ConNguoi {
    public String maSo;
    public String hoTen;
    public String sdt;
    public int soNgayLamViec;
    public int luong1Ngay;
    public String chucVu = "";

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public int getLuong1Ngay() {
        return luong1Ngay;
    }

    public void setLuong1Ngay(int luong1Ngay) {
        this.luong1Ngay = luong1Ngay;
    }

    public String getChucVu(){return chucVu;}
    public ConNguoi() {

    }
    public ConNguoi(String maSo, String hoTen, String sdt, int soNgayLamViec) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.soNgayLamViec = soNgayLamViec;
    }

    public int tinhLuong(){
        return luong1Ngay*soNgayLamViec;
    }
    public void nhapThongTin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma so");
        this.maSo = scanner.nextLine();
        System.out.println("Nhap ten");
        this.hoTen = scanner.nextLine();
        System.out.println("Nhap sdt");
        this.sdt = scanner.nextLine();
        System.out.println("Nhap so ngay lam viec");
        this.soNgayLamViec = scanner.nextInt();
    }

    public void xuatThongTin() {
        System.out.println("Ma so nhan vien: " + this.maSo);
        System.out.println("Ten nhan vien: " + this.hoTen);
        System.out.println("SDT lien lac: " + this.sdt);
        System.out.println("Chuc vu: " + this.chucVu);
    }
}
