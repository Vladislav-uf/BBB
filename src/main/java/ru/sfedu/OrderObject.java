package ru.sfedu;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "prestashop")
@Namespace(reference = "http://www.w3.org/1999/xlink", prefix = "xlink")
public class OrderObject
{
    @ElementList(required = false, inline = true)
    private List<Order> list;


    public OrderObject()
    {
        this.list = new ArrayList<>();
    }


    public List<Order> getList()
    {
        return list;
    }


    // ...

    @Override
    public String toString()
    {
        return "OrderObject{" + "list=" + list + '}';
    }

}