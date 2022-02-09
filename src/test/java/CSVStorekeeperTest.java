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

import static org.junit.Assert.*;

public class CSVStorekeeperTest {

    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());
    DataProviderCsv dpc = new DataProviderCsv();
    long idtime = 9;

    @Test
    public void testStorekeeperInsert() throws CsvRequiredFieldEmptyException, IOException, CsvDataTypeMismatchException {
        List<Storekeeper> list = new ArrayList<>();
        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        log.info("num1");
        log.info(idtime);
        dpc.insertStorekeeper(storekeeper);
        list.add(storekeeper);
        Storekeeper lists = dpc.getById(idtime);
        assertEquals(storekeeper,lists);
    }

    @Test
    public void testStorekeeperSelect() {
        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        Storekeeper list = dpc.getById(idtime);
        log.info(idtime);
        assertEquals(storekeeper, list);
    }

//    @Test
//    public void testSendHistory() {
//        dpc.sendHistory("History", "method", "51351", Status.SUCCESS);
////        log.info(idtime);
//    }



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



    @Test
    public void testStorekeeperInsertFail() {
        try {
            Storekeeper storekeeper = null;

            log.info("num1");
            log.info(idtime);
            dpc.insertStorekeeper(storekeeper);

            fail("Error insert");
        } catch (Exception e) {
            log.info("insert off");
           assertTrue(true);

        }
    }

    @Test
    public void testStorekeeperSelectFail() {
        try {
//            Storekeeper storekeeper = null;
//            Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
            log.info("num1");
            List <Storekeeper> sen= dpc.selectStorekeepers();
            sen.get(10000000);
            fail("Error select");
        }
        catch (Exception e) {
        log.info("select off");
        assertTrue(true);
    }
    }

    @Test
    public void testStorekeeperGetByIdFail() {
        try {
//            Storekeeper storekeeper = null;
//            Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
            log.info("num1");
            Storekeeper name  = dpc.getById(System.currentTimeMillis());
            log.info(name);
            if(name == null){
                log.info("select off");
                assertTrue(true);
            }
            else{
            fail("Error GetById");
            }
        }
        catch (Exception e) {
            log.info("select off");
            assertTrue(true);
        }
    }

    @Test
    public void testStorekeeperUpdateFail() {

        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        dpc.updateStorekeeper(idtime, storekeeper);
        Storekeeper storekeeperById = dpc.getById(idtime);

        try {
//            Storekeeper storekeeper = null;
//            Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
            log.info("num1");
            assertEquals(storekeeper, storekeeperById);

            fail("Error select");
        }
        catch (Exception e) {
            log.info("select off");
            assertTrue(true);
        }
    }

    @Test
    public void testStorekeeperWDeleteFail() {

        dpc.deleteStorekeeper(idtime);
        log.info("num2");
        Storekeeper list = dpc.getById(idtime);
        try {
//            Storekeeper storekeeper = null;
//            Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
            log.info("num1");
            List <Storekeeper> sen= dpc.selectStorekeepers();
            sen.get(10000000);
            fail("Error select");
        }
        catch (Exception e) {
            log.info("delete off");
            assertTrue(true);
        }
    }

}



