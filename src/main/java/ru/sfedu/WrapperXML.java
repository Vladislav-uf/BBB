package ru.sfedu;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "xml")
public class WrapperXML<T> {
    @ElementList(name = "cont")
    private T container;

    public WrapperXML(T container){
        this.container = container;
    }

    public WrapperXML() {

    }

    public T getContainer() {
        return container;
    }

    public void setContainer() {
        this.container = container;
    }

    @Override
    public String toString() {
        return "{" +
                ", container=" + container +
                '}';
    }
}
