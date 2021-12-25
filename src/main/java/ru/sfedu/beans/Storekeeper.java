package ru.sfedu.beans;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Root(name="root")
public class Storekeeper {
    @Element
    @CsvBindByPosition(position = 0)
    private long id;
    @Element
    @CsvBindByPosition(position = 1)
    private String name;
    @Element
    @CsvBindByPosition(position = 2)
    private String address;
    @Element
    @CsvBindByPosition(position = 3)
    private String phone_number;

//    private LocalDateTime createdDate;

    public Storekeeper(){}
    public Storekeeper(long id, String name, String address, String phone_number){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    };
//    public Storekeeper(long id, String name, String address, String phone_number, LocalDateTime createdDate){
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.phone_number = phone_number;
//        this.createdDate = createdDate;
//    };
//

    public long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber(){
        return phone_number;
    }
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }

    @Override
    public String toString() {
        return "Storekeeper{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storekeeper)) return false;
        Storekeeper storekeeper = (Storekeeper) o;
        return  getId()==(storekeeper.getId()) &&
                getName().equals(storekeeper.getName()) &&
                getAddress().equals(storekeeper.getAddress()) &&
                getPhoneNumber().equals(storekeeper.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress(), getPhoneNumber());
    }
}
