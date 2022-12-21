import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CongTy congTy = new CongTy();
        GiamDoc giamDoc = new GiamDoc("01","Long","01231231",28,12);
        TruongPhong truongPhong = new TruongPhong("02","Duong","03232323",29);
        congTy.danhSachThanhVien.add(giamDoc);
        congTy.danhSachThanhVien.add(truongPhong);
        NhanVien nhanVien1 = new NhanVien("03","Minh","03132312",25);
        nhanVien1.setQuanLy(truongPhong);
        congTy.danhSachThanhVien.add(nhanVien1);
        NhanVien nhanVien2 = new NhanVien("04","Hai","03132312",26);
        congTy.danhSachThanhVien.add(nhanVien2);
        nhanVien2.setQuanLy(truongPhong);
        NhanVien nhanVien3 = new NhanVien("05","Thien","03132312",27);
        congTy.danhSachThanhVien.add(nhanVien3);
        nhanVien3.setQuanLy(truongPhong);
        congTy.capNhatQuanLy();
        while (true){
            hienMenu();
            Scanner scanner = new Scanner(System.in);
            int chon = scanner.nextInt();
            switch (chon){
                case 1:
                    System.out.println("Moi nhap thong tin cong ty");
                    congTy.nhapThongTinCongTy();
                    break;
                case 2:
                    congTy.thangChucTruongPhong();
                    break;
                case 3:
                    congTy.tuyenNhanVien();
                    break;
                case 4:
                    congTy.saThaiNhanVien();
                    break;
                case 5:
                    congTy.xuatDanhSachNhanVien();
                    break;
                case 6:
                    System.out.println("Tong luong cong ty la: "+ congTy.tinhTongLuong());
                    break;
                case 7:
                    System.out.println("Nhan vien luong cao nhat la: ");
                    congTy.nhanVienLuongCaoNhat();
                    break;
                case 8:
                    System.out.println("Truong phong co nhieu nhan vien nhat la: ");
                    congTy.truongPhongCoNhieuNhanVienNhat();
                    break;
                case 9:
                    congTy.sapXepNhanVienTheoThuTuABC();
                    System.out.println("Danh sach nhan vien theo ABC la:");
                    congTy.xuatDanhSachNhanVien();
                    break;
                case 10:
                    System.out.println("Danh sach nhan vien theo luong");
                    congTy.sapXepNhanVienTheoLuong();
                    congTy.xuatDanhSachNhanVien();
                    break;
                case 11:
                    System.out.println("Giam doc co nhieu co phan nhat la: ");
                    congTy.timGiamDocCoNhieuCoPhanNhat();
                    break;
                case 12:
                    System.out.println("Tong thu nhap cua tung giam doc la: ");
                    congTy.tinhTongThuNhapCuaTungGiamDoc();
                    break;
                case 0:
                    break;
            }
        }
    }

    private static void hienMenu() {
        System.out.println("===============================MENU===============================");
        System.out.println("1. Nhap thong tin cong ty");
        System.out.println("2. Phan bo nhan vien thanh truong phong");
        System.out.println("3. Tuyen nhan vien");
        System.out.println("4. Xoa nhan vien");
        System.out.println("5. Xuat danh sach toan bo nhan su");
        System.out.println("6. Xuat tong luong toan cong ty");
        System.out.println("7. Tim nhan vien co luong cao nhat");
        System.out.println("8. Tim truong phong co nhieu nhan vien nhat");
        System.out.println("9. Xap sep nhan vien theo abc");
        System.out.println("10. Xap sep nhan vien theo luong giam dan");
        System.out.println("11. Tim giam doc co nhieu co phan nhat");
        System.out.println("12. Tinh va xuat tong thu nhap cua tung giam doc");
        System.out.println("0. Thoat");
    }
}