package com.A1.task3.entity;

public class PostingEntity extends Entity {

    private long matDoc;
    private int item;
    private String docDate;
    private String pstngDate;
    private String materialDescription;
    private int quantity;
    private String BUn;
    private float amountLC;
    private String crcy;
    private String userName;
    private boolean authPost;

    public PostingEntity(long matDoc, int item, String docDate, String pstngDate, String materialDescription, int quantity, String BUn, float amountLC, String crcy, String userName /*boolean authPost*/) {
        this.matDoc = matDoc;
        this.item = item;
        this.docDate = docDate;
        this.pstngDate = pstngDate;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        this.BUn = BUn;
        this.amountLC = amountLC;
        this.crcy = crcy;
        this.userName = userName;
        //this.authPost = authPost;
    }

    public PostingEntity() {
    }

    @Override
    public String toString() {
        return
                matDoc +
                        item +
                        docDate + '\'' +
                        pstngDate + '\'' +
                        materialDescription + '\'' +
                        quantity +
                        BUn + '\'' +
                        amountLC +
                        crcy + '\'' +
                        userName + '\'';
    }

    public long getMatDoc() {
        return matDoc;
    }

    public void setMatDoc(long matDoc) {
        this.matDoc = matDoc;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getPstngDate() {
        return pstngDate;
    }

    public void setPstngDate(String pstngDate) {
        this.pstngDate = pstngDate;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBUn() {
        return BUn;
    }

    public void setBUn(String BUn) {
        this.BUn = BUn;
    }

    public float getAmountLC() {
        return amountLC;
    }

    public void setAmountLC(float amountLC) {
        this.amountLC = amountLC;
    }

    public String getCrcy() {
        return crcy;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
