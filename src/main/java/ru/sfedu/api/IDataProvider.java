package ru.sfedu.api;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.sfedu.beans.Storekeeper;

import java.io.IOException;
import java.util.List;

public interface IDataProvider {

    List<Storekeeper> selectStorekeepers();
    Storekeeper getById(long id);
    void insertStorekeeper(Storekeeper storekeeper) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException;

    void deleteStorekeeper(long id);
    void updateStorekeeper(long id, Storekeeper storekeeper) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException;
}
