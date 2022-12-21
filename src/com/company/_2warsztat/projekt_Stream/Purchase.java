package com.company._2warsztat.projekt_Stream;

import java.time.LocalDate;

public class Purchase {
    private final Client buyer;
    private final Product product;
    private final long quantity;
    private final Delivery delivery;
    private final Payment payment;
    private final LocalDate when;
    private Status status = Status.PAID;

    public Purchase(Client buyer, Product product, long quantity, Delivery delivery, Payment payment, LocalDate when) {
        this.buyer = buyer;
        this.product = product;
        this.quantity = quantity;
        this.delivery = delivery;
        this.payment = payment;
        this.when = when;
    }

    public Purchase(Purchase p, Status checkOrderStatus) {
        this.buyer = p.buyer;
        this.product = p.product;
        this.quantity = p.quantity;
        this.delivery = p.delivery;
        this.payment = p.payment;
        this.when = p.when;
        this.status = checkOrderStatus;
    }

    public Client getBuyer() {
        return buyer;
    }

    public Product getProduct() {
        return product;
    }

    public long getQuantity() {
        return quantity;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Payment getPayment() {
        return payment;
    }

    public LocalDate getWhen() {
        return when;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "buyer=" + buyer +
                ", product=" + product +
                ", quantity=" + quantity +
                ", delivery=" + delivery +
                ", payment=" + payment +
                ", when=" + when +
                ", status=" + status +
                '}';
    }

    public enum Delivery {
        IN_POST,
        UPS,
        DHL
    }
    public enum Payment {
        CASH,
        BLIK,
        CREDIT_CARD
    }
    public enum Status {
        PAID,
        SENT,
        DONE
    }
}
