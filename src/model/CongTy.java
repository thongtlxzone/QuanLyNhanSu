package model;

import java.security.PublicKey;
import java.util.*;

public class CongTy {
    public String tenCongTy;
    public String maSoThue;
    public int doanhThuThang;
    public List<ConNguoi> danhSachThanhVien = new ArrayList<>();

    public void nhapThongTinCongTy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten cong ty");
        tenCongTy = scanner.nextLine();
        System.out.println("Nhap ma so thue");
        maSoThue = scanner.nextLine();
        System.out.println("Nhap doanh thu cong ty");
        doanhThuThang = scanner.nextInt();
    }

    public void tuyenNhanVien() {
        String chucVu;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuc vu can tuyen");
        System.out.println("1. Nhan vien");
        System.out.println("2. Truong phong");
        System.out.println("0. Giam doc");
        chucVu = scanner.nextLine();
        if (chucVu.equals("1")){
            NhanVien nhanVien = new NhanVien();
            do{
                nhanVien.nhapThongTin();
            }while (kiemTraTrungMaNhanVien(nhanVien));
            System.out.println("Nhap ma truong phong");
            String maTruongPhong = scanner.nextLine();
            for(var i : danhSachThanhVien){
                if(i.getMaSo().equals(maTruongPhong)){
                    nhanVien.setQuanLy((TruongPhong)i);
                    ((TruongPhong) i).soLuongNhanVienQuanLy++;
                    break;
                }
            }
            danhSachThanhVien.add(nhanVien);
        }else if(chucVu.equals("2")){
            TruongPhong truongPhong = new TruongPhong();
            do{
                truongPhong.nhapThongTin();
            }while (kiemTraTrungMaNhanVien(truongPhong));
            danhSachThanhVien.add(truongPhong);
        }else {
            GiamDoc giamDoc = new GiamDoc();
            do{
                giamDoc.nhapThongTin();
            }while (kiemTraTrungMaNhanVien(giamDoc));
            danhSachThanhVien.add(giamDoc);
        }
    }

    private boolean kiemTraTrungMaNhanVien(ConNguoi nguoi) {
        for(var i : danhSachThanhVien){
            if (i.getMaSo().equals(nguoi.getMaSo())){
                return true;
            }
        }
        return false;
    }

    public void xuatDanhSachNhanVien() {
        int count = 1;
        for (var i : this.danhSachThanhVien) {
            System.out.print(count + ". ");
            if(i.getChucVu().equals("Nhan vien")){
                ((NhanVien)i).xuatThongTin();
            }else if(i.getChucVu().equals("Truong phong")){
                ((TruongPhong)i).xuatThongTin();
            }else {
                ((GiamDoc)i).xuatThongTin();
            }
            count++;
        }
    }

    public void thangChucTruongPhong() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can thang chuc:" );
        String maNhanVien = scanner.nextLine();
        for (var i : this.danhSachThanhVien) {
            if(i.maSo.equals(maNhanVien)){
                TruongPhong truongPhongMoi = new TruongPhong();
                truongPhongMoi.setSoLuongNhanVienQuanLy(0);
                truongPhongMoi.setMaSo(i.getMaSo());
                truongPhongMoi.setHoTen(i.getHoTen());
                truongPhongMoi.setSdt(i.getSdt());
                truongPhongMoi.setLuong1Ngay(200);
                truongPhongMoi.setSoNgayLamViec(i.soNgayLamViec);
                danhSachThanhVien.add(truongPhongMoi);
                ((NhanVien)i).quanLy.soLuongNhanVienQuanLy--;
                danhSachThanhVien.remove(i);
                break;
            }
        }
    }

    public void saThaiNhanVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien muon sa thai: ");
        String saThai = scanner.nextLine();
        for(var nhanVienSaThai : danhSachThanhVien){
            if((nhanVienSaThai.getMaSo()).equals(saThai)){
                if(nhanVienSaThai.getChucVu().equals("Nhan vien")){
                    (((NhanVien)nhanVienSaThai).quanLy).soLuongNhanVienQuanLy--;
                    danhSachThanhVien.remove(nhanVienSaThai);
                    break;
                } else if (nhanVienSaThai.getChucVu().equals("Truong phong")) {
                    for(var j : danhSachThanhVien){
                        if(j.getChucVu().equals("Nhan vien")){
                            if(((NhanVien)j).quanLy.getMaSo().equals(nhanVienSaThai.getMaSo())){
                                ((NhanVien)j).setQuanLy(null);
                            }
                        }
                    }
                    danhSachThanhVien.remove(nhanVienSaThai);
                    break;
                }
            }
        }
    }

    public int tinhTongLuong() {
        int tongLuong = 0;
        for(var i : danhSachThanhVien){
            if(i.getChucVu().equals("Nhan vien") || i.getChucVu().equals("Giam doc")){
                tongLuong+=i.tinhLuong();
            }else {
                tongLuong+=((TruongPhong)i).tinhLuong();
            }
        }
        return tongLuong;
    }

    public void nhanVienLuongCaoNhat() {
        int luongCaoNhat = 0;
        String maSoNhanVienLuongCaoNhat = "";
        for(var i : danhSachThanhVien){
            if(i.getChucVu().equals("Nhan vien") && i.tinhLuong() > luongCaoNhat){
                luongCaoNhat = i.tinhLuong();
                maSoNhanVienLuongCaoNhat = i.getMaSo();
            }
        }
        timNhanVienTheoMa(maSoNhanVienLuongCaoNhat);
    }

    private void timNhanVienTheoMa(String maNhanVien) {
        for(var i : danhSachThanhVien){
            if(i.getMaSo().equals(maNhanVien))
                i.xuatThongTin();
        }
    }

    public void truongPhongCoNhieuNhanVienNhat() {
        int soNhanVienCaoNhat = 0;
        String maSoTruongPhong = "";
        for(var i : danhSachThanhVien){
            if(i.getChucVu().equals("Truong phong") && ((TruongPhong)i).getSoLuongNhanVienQuanLy() > soNhanVienCaoNhat){
                soNhanVienCaoNhat = ((TruongPhong)i).getSoLuongNhanVienQuanLy();
                maSoTruongPhong = i.getMaSo();
            }
        }
        timNhanVienTheoMa(maSoTruongPhong);
    }

    public void sapXepNhanVienTheoThuTuABC() {
        xepTheoABC(danhSachThanhVien);
    }

    private void xepTheoABC(List<ConNguoi> danhSachThanhVien) {
        danhSachThanhVien.sort(((o1, o2) -> o1.getHoTen().compareTo(o2.getHoTen())));
    }


    public void capNhatQuanLy() {
        for(var i : danhSachThanhVien){
            if(i.getChucVu().equals("Nhan vien")&&((NhanVien)i).getQuanLy()!=null){
                ((NhanVien)i).getQuanLy().soLuongNhanVienQuanLy++;
            }
        }
    }

    public void timGiamDocCoNhieuCoPhanNhat() {
        float coPhanLonNhat = 0;
        String maSoGiamDocNhieuCoPhanNhat = "";
        for(var i : danhSachThanhVien){
            if(i.getChucVu().equals("Giam doc") && ((GiamDoc)i).getCoPhan() > coPhanLonNhat){
                coPhanLonNhat = ((GiamDoc)i).getCoPhan();
                maSoGiamDocNhieuCoPhanNhat = i.getMaSo();
            }
        }
        timNhanVienTheoMa(maSoGiamDocNhieuCoPhanNhat);
    }

    public void tinhTongThuNhapCuaTungGiamDoc() {
        for (var i : danhSachThanhVien){
            if(i.getChucVu().equals("Giam doc")){
                ((GiamDoc)i).xuatThongTin();
                System.out.println("Tong thu nhap :" + (((GiamDoc)i).tinhLuong() + ((GiamDoc)i).getCoPhan()*(this.doanhThuThang-this.tinhTongLuong())));
            }
        }
    }

    public void sapXepNhanVienTheoLuong() {
        xepTheoLuong(danhSachThanhVien);
    }

    private void xepTheoLuong(List<ConNguoi> danhSachThanhVien) {
        danhSachThanhVien.sort(((o1, o2) -> o2.tinhLuong()- o1.tinhLuong()));
    }
}

