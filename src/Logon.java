import  java.util.logging.*;
public class Logon {



    public static void main(String[] args) {
        Logger LOGGER = Logger.getLogger("com.javamentor.logging.Test");
        LOGGER.log(Level.INFO, "Все хорошо");
        LOGGER.log(Level.WARNING, "Произошла ошибка");
    }

}
