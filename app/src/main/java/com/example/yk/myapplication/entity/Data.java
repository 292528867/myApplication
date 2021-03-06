package com.example.yk.myapplication.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yk on 15/6/29.
 */
public class Data {
    @Expose
    private String country;
    @SerializedName("country_id")
    @Expose
    private String countryId;
    @Expose
    private String area;
    @SerializedName("area_id")
    @Expose
    private String areaId;
    @Expose
    private String region;
    @SerializedName("region_id")
    @Expose
    private String regionId;
    @Expose
    private String city;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @Expose
    private String county;
    @SerializedName("county_id")
    @Expose
    private String countyId;
    @Expose
    private String isp;
    @SerializedName("isp_id")
    @Expose
    private String ispId;
    @Expose
    private String ip;

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     *
     * @param countryId
     * The country_id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     *
     * @return
     * The area
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     * The area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     *
     * @return
     * The areaId
     */
    public String getAreaId() {
        return areaId;
    }

    /**
     *
     * @param areaId
     * The area_id
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
     *
     * @return
     * The region
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region
     * The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     *
     * @return
     * The regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     *
     * @param regionId
     * The region_id
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The cityId
     */
    public String getCityId() {
        return cityId;
    }

    /**
     *
     * @param cityId
     * The city_id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @return
     * The county
     */
    public String getCounty() {
        return county;
    }

    /**
     *
     * @param county
     * The county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     *
     * @return
     * The countyId
     */
    public String getCountyId() {
        return countyId;
    }

    /**
     *
     * @param countyId
     * The county_id
     */
    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    /**
     *
     * @return
     * The isp
     */
    public String getIsp() {
        return isp;
    }

    /**
     *
     * @param isp
     * The isp
     */
    public void setIsp(String isp) {
        this.isp = isp;
    }

    /**
     *
     * @return
     * The ispId
     */
    public String getIspId() {
        return ispId;
    }

    /**
     *
     * @param ispId
     * The isp_id
     */
    public void setIspId(String ispId) {
        this.ispId = ispId;
    }

    /**
     *
     * @return
     * The ip
     */
    public String getIp() {
        return ip;
    }

    /**
     *
     * @param ip
     * The ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

}
