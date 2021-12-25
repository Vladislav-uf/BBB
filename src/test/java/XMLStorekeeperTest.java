import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import ru.sfedu.Constants;
import ru.sfedu.api.DataProviderCsv;
import ru.sfedu.api.DataProviderXML;
import ru.sfedu.beans.Storekeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class XMLStorekeeperTest {

    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());

    long idtime = Constants.ID_TIME;

    @Test
    public void testStorekeeperInsert() throws IOException {
        DataProviderXML dpc = new DataProviderXML();
        Storekeeper storekeeper1 = new Storekeeper(1, "vghj", "cvbn", "51351");
        log.info("num1");
//        log.info(idtime);
        List<Storekeeper> list = new ArrayList<>();
//        dpc.insertStorekeeper(storekeeper1);
        Storekeeper storekeeper2 = new Storekeeper(2, "vghj", "cvbn", "51351");
//        dpc.insertStorekeeper(storekeeper2);
        list.add(storekeeper1);
        list.add(storekeeper2);
        log.info("list =" + list);
        dpc.insertStorekeeper(list.get(0));
//        Storekeeper list = dpc.getById(idtime);
//        assertEquals(storekeeper,list);
    }

    @Test
    public void testStorekeeperSelect() {
        DataProviderXML dpc = new DataProviderXML();
//        Storekeeper storekeeper = new Storekeeper(2, "vghj", "cvbn", "51351");
//        Storekeeper list = dpc.getById(idtime);
        dpc.selectStorekeepers();
//        log.info(storekeeper);
//        assertEquals(storekeeper, list);
    }


    @Test
    public void testStorekeeperGetById() {
        DataProviderXML dpc = new DataProviderXML();
//        Storekeeper storekeeper = new Storekeeper(2, "vghj", "cvbn", "51351");
        dpc.getById(2);
        Storekeeper ById = dpc.getById(2);
//        assertEquals(storekeeper, ById);
    }
//
//    @Test
//    public void testStorekeeperUpdate() {
//
//        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
//        dpc.updateStorekeeper(idtime, storekeeper);
//        Storekeeper storekeeperById = dpc.getById(idtime);
//        assertEquals(storekeeper, storekeeperById);
//    }
//
//    @Test
//    public void testStorekeeperWDelete() {
//        dpc.deleteStorekeeper(idtime);
//        log.info("num2");
//        Storekeeper list = dpc.getById(idtime);
//        log.info(list);
//        assertEquals(null, list);
//    }
}


