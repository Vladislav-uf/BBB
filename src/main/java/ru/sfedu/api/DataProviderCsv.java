package ru.sfedu.api;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;
import ru.sfedu.beans.HistoryContent;
import ru.sfedu.beans.Status;
import ru.sfedu.beans.Storekeeper;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import ru.sfedu.utils.HistoryMongo;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.currentThread;

public class DataProviderCsv implements IDataProvider{
    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());

    @Override
    public void insertStorekeeper(List<Storekeeper> storekeeper) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        CSVWriter writer = null;
        try {
            writer =new CSVWriter(new FileWriter(Constants.CSV_PATH,true));
        } catch (IOException e) {
            log.error(e);
        }
        ColumnPositionMappingStrategy<Storekeeper> mappingStrategy = new ColumnPositionMappingStrategy<>();
        mappingStrategy.setType(Storekeeper.class);
        mappingStrategy.setColumnMapping(String.valueOf(storekeeper.getId()),storekeeper.getName(),storekeeper.getAddress(),storekeeper.getPhoneNumber());
        StatefulBeanToCsv<Storekeeper> beanToCsv = new StatefulBeanToCsvBuilder<Storekeeper>(writer).withMappingStrategy(mappingStrategy).build();
        try{
            String method = currentThread().getStackTrace()[1].getMethodName();
            beanToCsv.write(storekeeper);
//            sendHistory(storekeeper.getClass().getSimpleName(), method, null, Status.SUCCESS);
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
        try{
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        log.info("writer");
    }

    @Override
    public List<Storekeeper> selectStorekeepers() {
        CSVReader csvReader = null;
//        log.info("writer1");
        try {
            csvReader = new CSVReader(new FileReader(Constants.CSV_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        log.info("writer2");
        List<Storekeeper> list = new CsvToBeanBuilder<Storekeeper>(Objects.requireNonNull(csvReader,"Not found file"))
                .withType(Storekeeper.class)
                .build()
                .parse();
//        log.info("writer3");
        try {
            csvReader.close();
        } catch (IOException e) {
            log.error(e);
        }
//        sendHistory(keepers.getClass().getSimpleName(), method, null, Status.SUCCESS);
//        list.forEach(System.out::println);
        return list;

    }
    @Override
    public Storekeeper getById(long id) {
        Storekeeper list = selectStorekeepers().stream()
                .filter(x -> (x).getId() == (id))
                .findFirst().orElse(null);
//        log.info("Id2");
//        log.info(list);
        return list;
    }

    @Override
    public void deleteStorekeeper(long id) {
        Storekeeper en = getById(id);
        if (en == null){
            return;
        }
        List<Storekeeper> keepers = selectStorekeepers();
        keepers.removeIf(del -> (del.getId() == id));
        Writer writer = null;
        try {
            writer = new FileWriter(Constants.CSV_PATH);
        } catch (IOException e) {
            log.throwing(e);
        }
        StatefulBeanToCsv<Storekeeper> beanToCsv = new StatefulBeanToCsvBuilder<Storekeeper>(writer).build();
        try {
            beanToCsv.write(keepers);
            String method = currentThread().getStackTrace()[1].getMethodName();
//            sendHistory(keepers.getClass().getSimpleName(), method, null, Status.SUCCESS);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
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
    public void updateStorekeeper(long id, Storekeeper storekeeper) {
        Storekeeper en = getById(id);
        if (en == null){
            return;
        }
        deleteStorekeeper(id);
        try {
            insertStorekeeper(storekeeper);
            String method = currentThread().getStackTrace()[1].getMethodName();
//            sendHistory(storekeeper.getClass().getSimpleName(), method, null, Status.SUCCESS);
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendHistory(String className, String methodName, Object object, Status status){
        long id = System.currentTimeMillis();
        Date createdDate = new Date();
        String actor = Constants.DEFAULT_ACTOR;
        HistoryContent history = new HistoryContent(id, className, createdDate,
                actor, methodName, object, status);
        HistoryMongo.record(history);
    }
}
