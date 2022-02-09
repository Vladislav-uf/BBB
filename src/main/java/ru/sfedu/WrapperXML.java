package ru.sfedu;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import ru.sfedu.beans.Example;

import java.util.ArrayList;
import java.util.List;


@Root(name = "Examples")
public class WrapperXML<T> {
    @ElementList(name = "cont", inline = true, required = false)
    public List<T> container;

    public WrapperXML() {
    }


    public List<T> getContainer() {
        return container;
    }

    public void setContainer(List<T> container){
        this.container = container;
    }

    @Override
    public String toString() {
        return "{" +
                ", container=" + container +
                '}';
    }

}
