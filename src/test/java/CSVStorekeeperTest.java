import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.Constants;
import ru.sfedu.api.DataProviderCsv;
import ru.sfedu.beans.Status;
import ru.sfedu.beans.Storekeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVStorekeeperTest {

    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());
    DataProviderCsv dpc = new DataProviderCsv();
    long idtime = 1640187691957l;

    @Test
    public void testStorekeeperInsert() throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        log.info("num1");
        log.info(idtime);
        dpc.insertStorekeeper(storekeeper);
        Storekeeper list = dpc.getById(idtime);
        assertEquals(storekeeper,list);
    }

    @Test
    public void testStorekeeperSelect() {
        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        Storekeeper list = dpc.getById(idtime);
        log.info(idtime);
        assertEquals(storekeeper, list);
    }

    @Test
    public void testSendHistory() {
        dpc.sendHistory("History", "method", "51351", Status.SUCCESS);
//        log.info(idtime);
    }



    @Test
    public void testStorekeeperGetById() {
        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        dpc.getById(idtime);
        Storekeeper ById = dpc.getById(idtime);
        assertEquals(storekeeper, ById);
    }

    @Test
    public void testStorekeeperUpdate() {

        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        dpc.updateStorekeeper(idtime, storekeeper);
        Storekeeper storekeeperById = dpc.getById(idtime);
        assertEquals(storekeeper, storekeeperById);
    }

    @Test
    public void testStorekeeperWDelete() {
        dpc.deleteStorekeeper(idtime);
        log.info("num2");
        Storekeeper list = dpc.getById(idtime);
        log.info(list);
        assertEquals(null, list);
    }
}


