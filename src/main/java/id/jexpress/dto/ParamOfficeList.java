package id.jexpress.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ParamOfficeList implements Serializable {

	private static final long serialVersionUID = 6041398175353467593L;

	private Integer id;
	private String name;
	private String address;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private Integer pageSize;
	private Integer page;
	private Integer submitSearch;

	private String byId = "";
	private String byName = "";
	private String byAddress = "";
	private String byLatitude = "";
	private String byLongitude = "";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSubmitSearch() {
		return submitSearch;
	}

	public void setSubmitSearch(Integer submitSearch) {
		this.submitSearch = submitSearch;
	}

	public String getById() {
		return byId;
	}

	public void setById(String byId) {
		this.byId = byId;
	}

	public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public String getByAddress() {
		return byAddress;
	}

	public void setByAddress(String byAddress) {
		this.byAddress = byAddress;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getByLatitude() {
		return byLatitude;
	}

	public void setByLatitude(String byLatitude) {
		this.byLatitude = byLatitude;
	}

	public String getByLongitude() {
		return byLongitude;
	}

	public void setByLongitude(String byLongitude) {
		this.byLongitude = byLongitude;
	}

}
