package pageutility;

import org.apache.log4j.Logger;

/**
 * @author Kadirdan Abdukerim
 * @create 2022-10-06-10:55 PM
 */
public class Log4j {

    private static final Logger log = Logger.getLogger(Log4j.class);

    public static void info(String message) {
        log.info("\033[42;30;4m" + message + "\033[0m");
    }

    public static void error(String message) {
        log.error("\033[41;30;4m" + message + "\033[0m");
    }
}
