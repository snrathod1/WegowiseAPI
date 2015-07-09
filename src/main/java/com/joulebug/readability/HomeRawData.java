package com.joulebug.readability;

/**
 * Created by shraddharathod on 7/9/15.
 */
/*
{
  "start_date": "2012-02-01",
  "end_date": "2012-03-04",
  "btu": "100000",
  "total_charge": "300.0",
  "delivery_charge": "100.0",
  "fixed_charge": "80.0"
}
 */
public class HomeRawData {
    private String start_date;
    private String end_date;
    private String btu;
    private String total_charge;
    private String delivery_charge;
    private String fixed_charge;

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getBtu() {
        return btu;
    }

    public void setBtu (String btu) { this.btu = btu; }

    public String getTotal_charge() {
        return total_charge;
    }

    public void setTotal_charge(String total_charge) {
        this.total_charge = total_charge;
    }

    public String getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getFixed_charge() {
        return fixed_charge;
    }

    public void setFixed_charge(String fixed_charge) {
        this.fixed_charge = fixed_charge;
    }
}
