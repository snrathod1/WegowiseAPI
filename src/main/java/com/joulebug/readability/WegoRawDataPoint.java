package com.joulebug.readability;

/**
 * Created by shraddharathod on 8/12/15.
 */
/*
 {
    "id": 1,
    "delivery_charge": null,
    "end_date": "2014-01-31",
    "fuel_charge": null,
    "total_charge": "10.0",
    "start_date": "2014-01-01",
    "gallons": null,
    "kwh": "0.292997363023733",
    "btu": 1000,
    "demand_charge": null,
    "demand_kw": null,
    "fixed_charge": null,
    "off_peak_charge": null,
    "off_peak_kwh": null,
    "peak_charge": null,
    "peak_kwh": null,
  }
 */
public class WegoRawDataPoint {
    private Integer id;
    private String delivery_charge;
    private String end_date;
    private String fuel_charge;
    private String total_charge;
    private String start_date;
    private String gallons;
    private String kwh;
    private Integer btu;
    private String demand_charge;
    private String demand_kw;
    private String fixed_charge;
    private String off_peak_charge;
    private String off_peak_kwh;
    private String peak_charge;
    private String peak_kwh;

    public Integer getId() { return id; }

    public void setId(Integer id) {this.id = id; }

    public String getDelivery_charge(){ return delivery_charge; }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getEnd_date(){
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getFuel_charge(){
        return fuel_charge;
    }

    public void setFuel_charge(String fuel_charge) {
        this.fuel_charge = fuel_charge;
    }

    public String getTotal_charge(){
        return total_charge;
    }

    public void setTotal_charge(String total_charge) {
        this.total_charge = total_charge;
    }

    public String getStart_date(){
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getGallons(){
        return gallons;
    }

    public void setGallons(String gallons) {
        this.gallons = gallons;
    }

    public String getKwh(){
        return kwh;
    }

    public void setKwh(String kwh) {
        this.kwh = kwh;
    }

    public Integer getBtu(){
        return btu;
    }

    public void setBtu(Integer btu) {
        this.btu = btu;
    }

    public String getDemand_charge(){
        return demand_charge;
    }

    public void setDemand_charge(String demand_charge) {
        this.demand_charge = demand_charge;
    }

    public String getDemand_kw(){
        return demand_kw;
    }

    public void setDemand_kw(String demand_kw) {
        this.demand_kw = demand_kw;
    }

    public String getFixed_charge(){
        return fixed_charge;
    }

    public void setFixed_charge(String fixed_charge) {
        this.fixed_charge = fixed_charge;
    }

    public String getOff_peak_charge(){
        return off_peak_charge;
    }

    public void setOff_peak_charge(String off_peak_charge) {
        this.off_peak_charge = off_peak_charge;
    }

    public String getOff_peak_kwh(){
        return off_peak_kwh;
    }

    public void setOff_peak_kwh(String off_peak_kwh) {
        this.off_peak_kwh = off_peak_kwh;
    }

    public String getPeak_charge(){
        return peak_charge;
    }

    public void setPeak_charge(String peak_charge) {
        this.peak_charge = peak_charge;
    }

    public String getPeak_kwh(){
        return peak_kwh;
    }

    public void setPeak_kwh(String peak_kwh) {
        this.peak_kwh = peak_kwh;
    }

}


