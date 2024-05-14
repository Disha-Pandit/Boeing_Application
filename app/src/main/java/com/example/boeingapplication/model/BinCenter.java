package com.example.boeingapplication.model;

public class BinCenter {
    private String binCenter;
    private String totalBins;
    private String lastScanDate;

    public BinCenter(String binCenter, String totalBins, String lastScanDate) {
        this.binCenter = binCenter;
        this.totalBins = totalBins;
        this.lastScanDate = lastScanDate;
    }

    public String getBinCenter() {
        return binCenter;
    }

    public String getTotalBins() {
        return totalBins;
    }

    public String getLastScanDate() {
        return lastScanDate;
    }
}