package model;

import java.util.Scanner;

public class NhanVien extends ConNguoi{
    public TruongPhong quanLy;

    public TruongPhong getQuanLy() {
        return quanLy;
    }

    public void setQuanLy(TruongPhong quanLy) {
        this.quanLy = quanLy;
    }
    public NhanVien(){
        this.chucVu = "Nhan vien";
    };
    public NhanVien(String maSo, String hoTen, String sdt, int soNgayLamViec) {
        super(maSo, hoTen, sdt, soNgayLamViec);
        this.luong1Ngay = 100;
        this.chucVu = "Nhan vien";
    }
    @Override
    public void nhapThongTin(){
        super.nhapThongTin();
        this.luong1Ngay = 100;
        this.chucVu = "Nhan vien";
        this.quanLy = null;
    }
    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        if(quanLy!=null){
            System.out.println("Ma truong phong quan ly: " + quanLy.getMaSo());
        }else{
            System.out.println("Nhan vien chua co quan ly!!");
        }
    }
}
