package model;

import java.util.Scanner;

public class GiamDoc extends ConNguoi{
    public float coPhan;

    public float getCoPhan() {
        return coPhan;
    }

    public void setCoPhan(float coPhan) {
        this.coPhan = coPhan;
    }

    public GiamDoc(){
        this.chucVu = "Giam doc";
    };
    public GiamDoc(String maSo, String hoTen, String sdt, int soNgayLamViec, float coPhan) {
        super(maSo, hoTen, sdt, soNgayLamViec);
        this.luong1Ngay = 300;
        this.chucVu = "Giam doc";
        this.coPhan = coPhan;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        this.chucVu = "Giam doc";
        float cp = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so co phan cong ty 0<=cp<=100");
        while ( cp < 0 || cp >100){
            cp = scanner.nextFloat();
            this.coPhan = cp;
        }
    }
    @Override
    public void xuatThongTin(){
        super.xuatThongTin();
        System.out.println("Co phan cong ty: " + coPhan);
    }
}
