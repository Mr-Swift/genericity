package com.apple.developer.dvd;

public class DvdSet {
    private String state = "可出借";
    private String date = " ";
    private int counts = 0;

    public DvdSet() {
    }

    public DvdSet(String state, String date, int counts) {
        this.state = state;
        this.date = date;
        this.counts = counts;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    protected void countsAdd() {           //出借次数+1
        this.counts++;
    }

    protected void reSetCounts() {         //出借次数归零
        this.setCounts(0);
    }

    @Override
    public String toString() {
        return this.getCounts() + "\t\t\t" + this.getState() + "\t\t\t" + this.getDate();
    }
}
