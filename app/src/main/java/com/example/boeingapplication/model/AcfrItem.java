package com.example.boeingapplication.model;

public class AcfrItem {
    private String scanCode;
    private String partNo;
    private String minMaxAmc;
    private String shipQty;
    private String shipDt;
    private String orderQty;
    private String orderDt;
    private String onHandQty1;
    private String onHandQty2;
    private String lastScanDate;

    // Constructor
    public AcfrItem(String scanCode, String partNo, String minMaxAmc, String shipQty, String shipDt,
                    String orderQty, String orderDt, String onHandQty1, String onHandQty2, String lastScanDate) {
        this.scanCode = scanCode;
        this.partNo = partNo;
        this.minMaxAmc = minMaxAmc;
        this.shipQty = shipQty;
        this.shipDt = shipDt;
        this.orderQty = orderQty;
        this.orderDt = orderDt;
        this.onHandQty1 = onHandQty1;
        this.onHandQty2 = onHandQty2;
        this.lastScanDate = lastScanDate;
    }

    // Getters
    public String getScanCode() { return scanCode; }
    public String getPartNo() { return partNo; }
    public String getMinMaxAmc() { return minMaxAmc; }
    public String getShipQty() { return shipQty; }
    public String getShipDt() { return shipDt; }
    public String getOrderQty() { return orderQty; }
    public String getOrderDt() { return orderDt; }
    public String getOnHandQty1() { return onHandQty1; }
    public String getOnHandQty2() { return onHandQty2; }
    public String getLastScanDate() { return lastScanDate; }
}