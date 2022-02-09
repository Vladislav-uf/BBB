package ru.sfedu.api;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.Constants;
import ru.sfedu.WrapperXML;
import ru.sfedu.beans.Storekeeper;
import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProviderXML implements IDataProvider{
    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());

    @Override
    public void insertStorekeeper(List<Storekeeper> storekeeper) throws  IOException {
        Serializer serializer = new Persister();
        WrapperXML wrap = new WrapperXML<>();
        wrap.setContainer(storekeeper);
        FileWriter result = new FileWriter(Constants.XML_PATH);
        WrapperXML<Storekeeper> xml = new WrapperXML<>();
        log.info("storekeeper = " + storekeeper);
        try{
            serializer.write(wrap, result);
        try{
            result.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        log.info("writer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
    public List<Storekeeper> selectStorekeepers(){
//        log.info("writer1");
        List <Storekeeper> loaded = null;
        try{
        Serializer serializer = new Persister();
        FileReader file = new FileReader(Constants.XML_PATH);
//        log.info("writer3");
        WrapperXML xml = serializer.read(WrapperXML.class, file);
        log.info("xml = " + xml);
//        loaded = (List<Storekeeper>) xml;
        file.close();
        loaded = xml.getContainer();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        log.info("loaded = " + loaded);
        return loaded ;
//        list.forEach(System.out::println);

    }
    @Override
    public Storekeeper getById(long id) {
        Storekeeper list = selectStorekeepers().stream()
                .filter(x -> (x).getId() == (id))
                .findFirst().orElse(null);
//        log.info("Id2");
        log.info(list);
        return list;
    }


    //
    @Override
    public void deleteStorekeeper(long id) {
        Storekeeper en = getById(id);
        log.info(id);
        if (en == null){
            return;
        }
        List<Storekeeper> keepers = selectStorekeepers();
        log.info("keepers = " + keepers);
        keepers.removeIf(del -> (del.getId() == id));
        log.info("keepersdel = " + keepers);
        Writer writer = null;
        try {
            insertStorekeeper(keepers);

        } catch (IOException e) {
            log.throwing(e);
        }
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            log.throwing(e);
        }
    }


    @Override
    public void updateStorekeeper(long id, List<Storekeeper> storekeeper){
        Storekeeper en = getById(id);
        if (en == null){
            return;
        }
        deleteStorekeeper(id);
        try {
            insertStorekeeper(storekeeper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



