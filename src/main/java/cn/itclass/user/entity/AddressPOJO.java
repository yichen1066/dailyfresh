package cn.itclass.user.entity;

import javax.validation.constraints.NotBlank;

public class AddressPOJO {

    /**
     * 收件人
     */
    @NotBlank(message = "收件人信息不能为空")
    private String receiver;

    /**
     * 收货地址
     */
    @NotBlank(message = "收货地址不能为空")
    private String location;

    /**
     * 详细收货地址
     */
    @NotBlank(message = "详细收货地址不能为空")
    private String detailSite;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 收件人手机号
     */
    @NotBlank(message = "收件人手机号不能为空")
    private String phoneNumber;

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
