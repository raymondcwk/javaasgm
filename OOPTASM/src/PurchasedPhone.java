class PurchasedPhone {
    private Phone phone;
    private int quantity;
    private int itemNumber;

    public PurchasedPhone(Phone phone, int quantity, int itemNumber) {
        this.phone = phone;
        this.quantity = quantity;
        this.itemNumber = itemNumber;
    }

    public Phone getPhone() {
        return phone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemNumber(int i) {
        return itemNumber;
    }
}
