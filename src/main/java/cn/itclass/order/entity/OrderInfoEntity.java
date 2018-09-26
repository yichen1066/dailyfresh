package cn.itclass.order.entity;

import cn.itclass.common.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class OrderInfoEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 订单id，主键
     */
    @Id
    @GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    @GeneratedValue(generator = "uuidGenerator")
    @Column(name="order_id")
    private String orderId;

    /**
     * 订单编号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private String orderStatus;

    /**
     * 支付状态
     */
    @Column(name = "pay_status")
    private String payStatus;

    /**
     * 物流状态
     */
    @Column(name = "logistics_status")
    private String logisticsStatus;

    /**
     * 用户服务
     */
    @Column(name = "customer_service")
    private String customerService;

    /**
     * 商品数量
     */
    @Column(name = "product_count")
    private Integer productCount;

    /**
     * 商品总计
     */
    @Column(name = "commodity_total")
    private BigDecimal commodityTotal;

    /**
     * 订单总计
     */
    @Column(name = "order_total")
    private BigDecimal orderTotal;

    /**
     * 运费
     */
    @Column(name = "order_freight")
    private BigDecimal orderFreight;

    /**
     * 是否开发票
     */
    @Column(name = "invoice_or_not")
    private Boolean invoiceOrNot;

    /**
     * 发票id
     */
    @Column(name = "invoice_id")
    private String invoiceId;

    /**
     * 订单地址id
     */
    @Column(name = "address_id")
    private String addressId;

    /**
     * 下单时间
     */
    @Column(name = "place_order_time")
    private Date placeOrderTime;

    /**
     * 支付方式
     */
    @Column(name = "pay_channel")
    private String payChannel;

    /**
     * 是否删除
     */
    @Column(name = "delete_or_not")
    private Boolean deleteOrNot;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(String logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getCustomerService() {
        return customerService;
    }

    public void setCustomerService(String customerService) {
        this.customerService = customerService;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getCommodityTotal() {
        return commodityTotal;
    }

    public void setCommodityTotal(BigDecimal commodityTotal) {
        this.commodityTotal = commodityTotal;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public BigDecimal getOrderFreight() {
        return orderFreight;
    }

    public void setOrderFreight(BigDecimal orderFreight) {
        this.orderFreight = orderFreight;
    }

    public Boolean getInvoiceOrNot() {
        return invoiceOrNot;
    }

    public void setInvoiceOrNot(Boolean invoiceOrNot) {
        this.invoiceOrNot = invoiceOrNot;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Date getPlaceOrderTime() {
        return placeOrderTime;
    }

    public void setPlaceOrderTime(Date placeOrderTime) {
        this.placeOrderTime = placeOrderTime;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public Boolean getDeleteOrNot() {
        return deleteOrNot;
    }

    public void setDeleteOrNot(Boolean deleteOrNot) {
        this.deleteOrNot = deleteOrNot;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
