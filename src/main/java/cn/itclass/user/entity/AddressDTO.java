package cn.itclass.user.entity;

import javax.persistence.Column;

public class AddressDTO {
    private String addressId;

    /**
     * 收件人
     */
    private String receiver;

    /**
     * 收货地址
     */
    private String location;

    /**
     * 详细收货地址
     */
    @Column(name = "detail_site")
    private String detailSite;

    /**
     * 邮编
     */
    @Column(name = "zip_code")
    private String zipCode;

    /**
     * 收件人手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetailSite() {
        return detailSite;
    }

    public void setDetailSite(String detailSite) {
        this.detailSite = detailSite;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
