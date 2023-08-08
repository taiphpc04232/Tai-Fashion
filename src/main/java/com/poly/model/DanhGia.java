package com.poly.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="danhgias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DanhGia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDanhGia;
	private String email;
	private String hoVaTen;
	private String hinh;
	private String ngayDanhGia;
	private String nhanXet;
	private int soSao;
	
	@ManyToOne
	@JoinColumn(name = "maGiay",nullable = false)
	private Giay giay;

	public int getMaDanhGia() {
		return maDanhGia;
	}

	public void setMaDanhGia(int maDanhGia) {
		this.maDanhGia = maDanhGia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getNgayDanhGia() {
		return ngayDanhGia;
	}

	public void setNgayDanhGia(String ngayDanhGia) {
		this.ngayDanhGia = ngayDanhGia;
	}

	public String getNhanXet() {
		return nhanXet;
	}

	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}

	public int getSoSao() {
		return soSao;
	}

	public void setSoSao(int soSao) {
		this.soSao = soSao;
	}

	public Giay getGiay() {
		return giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}
	
	
}
