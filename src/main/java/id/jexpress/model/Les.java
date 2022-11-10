package id.jexpress.model;

import java.util.Date;

public class Les {

	private int id;
	private String name;
	private String address;
	private Date bornDate;
	private String kelas;
	private int kelasId;
	private String jurusan;
	private int jurusanId;
	private String jenisPertemuan;
	private int jenisPertemuanId;
	private String jadwal;
	private int jadwalId;
	private String status;

	private Date createdTime;
	private String createdby;
	private Date updatedTime;
	private String updatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public int getKelasId() {
		return kelasId;
	}

	public void setKelasId(int kelasId) {
		this.kelasId = kelasId;
	}

	public String getJurusan() {
		return jurusan;
	}

	public void setJurusan(String jurusan) {
		this.jurusan = jurusan;
	}

	public int getJurusanId() {
		return jurusanId;
	}

	public void setJurusanId(int jurusanId) {
		this.jurusanId = jurusanId;
	}

	public String getJenisPertemuan() {
		return jenisPertemuan;
	}

	public void setJenisPertemuan(String jenisPertemuan) {
		this.jenisPertemuan = jenisPertemuan;
	}

	public int getJenisPertemuanId() {
		return jenisPertemuanId;
	}

	public void setJenisPertemuanId(int jenisPertemuanId) {
		this.jenisPertemuanId = jenisPertemuanId;
	}

	public String getJadwal() {
		return jadwal;
	}

	public void setJadwal(String jadwal) {
		this.jadwal = jadwal;
	}

	public int getJadwalId() {
		return jadwalId;
	}

	public void setJadwalId(int jadwalId) {
		this.jadwalId = jadwalId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
