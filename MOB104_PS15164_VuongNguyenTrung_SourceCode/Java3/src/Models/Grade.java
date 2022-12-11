/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author trieu
 */
public class Grade {
    private int id;
    private String maSV, fullName;
    private int anhVan, tinHoc, gdtc;

    public Grade() {
    }

    public Grade(int id, String maSV, String fullName, int anhVan, int tinHoc, int gdtc) {
        this.id = id;
        this.maSV = maSV;
        this.fullName = fullName;
        this.anhVan = anhVan;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAnhVan() {
        return anhVan;
    }

    public void setAnhVan(int anhVan) {
        this.anhVan = anhVan;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGdtc() {
        return gdtc;
    }

    public void setGdtc(int gdtc) {
        this.gdtc = gdtc;
    }

    
    public double getDiemTB(){
        return (getAnhVan()+getTinHoc()+getGdtc())/3;
    }
    
    public String getXepLoai(){
        String xl="";
        double dtb = getDiemTB();
        if(dtb>=8){
            xl= "GIỎI";
        }else if (dtb >=6.5){
            xl= "KHÁ";
        }else if (dtb >=5) {
            xl= "TRUNG BÌNH";
        }else{
            xl= "YẾU";
        }
        return xl;
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", maSV=" + maSV + ", fullName=" + fullName + ", anhVan=" + anhVan + ", tinHoc=" + tinHoc + ", gdtc=" + gdtc + '}';
    }
    
    
    
}
