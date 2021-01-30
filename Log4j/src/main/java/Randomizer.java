import java.util.Random;
import org.apache.log4j.Logger;

public class Randomizer {
    private static final Logger log = Logger.getLogger(Randomizer.class);

    public int generateRandomNum() {
        Random random = new Random();
        int generatedNumber = random.nextInt(10);
        if (generatedNumber <= 5) {
            try {
                throw new Exception("Сгенерированное число – X");
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        } else {
            log.info("Приложение успешно запущено");
        }
        return generatedNumber;
    }
}
