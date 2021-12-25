package ru.sfedu.beans;

import org.simpleframework.xml.*;

@Root(name = "order")
public class Order
{
    @Element(name = "id")
    private int id;
    @Element(name = "id_address_delivery")
    private AdressDelivery delivery;
    @Element(name = "id_address_invoice")
    private AdressInvoice invoice;


    public Order(int id, AdressDelivery delivery, AdressInvoice invoice)
    {
        this.id = id;
        this.delivery = delivery;
        this.invoice = invoice;
    }

    public Order() {  }





    @Override
    public String toString()
    {
        return "Order{" + "id=" + id + ", delivery=" + delivery + ", invoice=" + invoice + '}';
    }


    @Root()
    public static class AdressDelivery
    {
        @Namespace(reference = "http://www.w3.org/1999/xlink", prefix = "xlink")
        @Attribute(name = "href", required = false)
        private String link;
        @Text()
        private int value;


        public AdressDelivery(String link, int value)
        {
            this.link = link;
            this.value = value;
        }

        AdressDelivery() { }



        // Getter / Setter etc.

        @Override
        public String toString()
        {
            return "AdressDelivery{" + "link=" + link + ", value=" + value + '}';
        }
    }

    @Root()
    public static class AdressInvoice
    {
        @Attribute(name = "href", required = false)
        @Namespace(reference = "http://www.w3.org/1999/xlink", prefix = "xlink")
        private String link;
        @Text()
        private int value;


        public AdressInvoice(String link, int value)
        {
            this.link = link;
            this.value = value;
        }

        AdressInvoice() { }


        // Getter / Setter etc.

        @Override
        public String toString()
        {
            return "AdressInvoice{" + "link=" + link + ", value=" + value + '}';
        }
    }

}
