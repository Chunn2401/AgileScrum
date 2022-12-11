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
public class Students {
    private String maSV;
    private String fullname;
    private String email;
    private String phone;
    private String sex;
    private String address;
    private String avatar;

    public Students() {
        
    }
    
    public Students(String maSV, String fullname, String email, String phone, String sex, String address, String avatar) {
        this.maSV = maSV;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.address = address;
        this.avatar = avatar;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Students{" + "maSV=" + maSV + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone + ", sex=" + sex + ", address=" + address + ", avatar=" + avatar + '}';
    }
    
    
    
    
    
}
