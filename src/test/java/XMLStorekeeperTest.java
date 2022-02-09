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
        List<Storekeeper> list = new ArrayList<>();
        DataProviderXML dpc = new DataProviderXML();
        Storekeeper storekeeper1 = new Storekeeper(1, "vghj", "cvbn", "51351");
        log.info("num1");
//        log.info(idtime);
//        dpc.insertStorekeeper(storekeeper1);
        Storekeeper storekeeper2 = new Storekeeper(2, "vghj", "cvbn", "51351");
//        dpc.insertStorekeeper(storekeeper2);
        list.add(storekeeper1);
        list.add(storekeeper2);
        log.info("list =" + list);
        dpc.insertStorekeeper(list);
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
    @Test
    public void testStorekeeperUpdate() {
        DataProviderXML dpc = new DataProviderXML();
        List<Storekeeper> list = new ArrayList<>();
        Storekeeper storekeeper = new Storekeeper(idtime, "vghj", "cvbn", "51351");
        list.add(storekeeper);
        dpc.updateStorekeeper(idtime, list);
        Storekeeper storekeeperById = dpc.getById(idtime);
//        assertEquals(storekeeper, storekeeperById);
    }
//
    @Test
    public void testStorekeeperWDelete() {
        DataProviderXML dpc = new DataProviderXML();
        dpc.deleteStorekeeper(2);
        log.info("delete");
        Storekeeper list = dpc.getById(2);
        log.info(list);
//        assertEquals(null, list);
    }
}


