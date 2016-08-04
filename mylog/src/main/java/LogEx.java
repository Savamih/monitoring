import org.apache.log4j.Logger;

public class LogEx {
    private static final Logger logger = Logger.getLogger(LogEx.class);

    public static void main(String[] args) {

        LogEx obj = new LogEx();
        obj.runMe("hi");

    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }


}
