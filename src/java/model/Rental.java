package model;

public class Rental {

    private int rentalId;
    private int userId;
    private int equipmentId;
    private int quantity;
    private String rentalDate;
    private String equipmentName;

    public Rental() {
    }

    public Rental(int rentalId,
                  int userId,
                  int equipmentId,
                  int quantity,
                  String rentalDate) {

        this.rentalId = rentalId;
        this.userId = userId;
        this.equipmentId = equipmentId;
        this.quantity = quantity;
        this.rentalDate = rentalDate;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }
}
