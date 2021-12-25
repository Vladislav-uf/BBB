package ru.sfedu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.beans.Order;
import ru.sfedu.beans.Storekeeper;
import ru.sfedu.utils.ConfigurationUtil;
import java.io.File;
import java.io.IOException;

public class TestClient {
        private static final Logger log = LogManager.getLogger(TestClient.class.getName());
//        public static void main (String[] args) throws Exception {
//            System.out.println("orderObject");
//        File f = new File("store.xml");
//            System.out.println("orderObject");
//        Serializer ser = new Persister();
//            System.out.println("orderObject");
//            OrderObject xml;
//        xml = ser.read(OrderObject.class, f);
//            System.out.println("orderObject");
//
//        System.out.println(xml);
//    }
//        public static void main (String[] args)throws IOException{
//            try {
//                CsvToBeanBuilder<Storekeeper> beanBuilder = new CsvToBeanBuilder<>(new InputStreamReader(new FileInputStream(Constants.CSV_PATH)));
//
//                beanBuilder.withType(Storekeeper.class);
//                // build methods returns a list of Beans
//                beanBuilder.build().parse().forEach(e -> log.error(e.toString()));
//
//            } catch (FileNotFoundException e) {
//                log.error(e.getMessage(), e);
//            }
//        }
//            logBasicSystemInfo();
//            try {
//                log.info(ConfigurationUtil.getConfigurationEntry(Constants.APP_NAME));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                log.info(ConfigurationUtil.getConfigurationEntry(Constants.PATH_TO_HOME));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }}}

//        public TestClient() {
//            log.debug("ru.sfedu.TestClient: starting application.........");
//        }

        private static void logBasicSystemInfo() {
//            log.info("Launching the application...");
//            log.info(
//                    "Operating System: " + System.getProperty("os.name") + " "
//                            + System.getProperty("os.version")
//            );
//            log.info("JRE: " + System.getProperty("java.version"));
//            log.info("Java Launched From: " + System.getProperty("java.home"));
//            log.info("Class Path: " + System.getProperty("java.class.path"));
//            log.info("Library Path: " + System.getProperty("java.library.path"));
//            log.info("User Home Directory: " + System.getProperty("user.home"));
//            log.info("User Working Directory: " + System.getProperty("user.dir"));
//            log.info("Test INFO logging.");
       }
    }
