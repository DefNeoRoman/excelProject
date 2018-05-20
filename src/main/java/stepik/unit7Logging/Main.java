package stepik.unit7Logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final String AUSTIN_POWERS = "Austin Powers";
    private static final String WEAPONS = "weapons";
    private static final String BANNED_SUBSTANCE = "banned substance";
    public static class Inspector implements MailService {
        public Inspector() {
        }

        @Override
        public Sendable processMail(Sendable mail) {
            MailPackage mailPackage;
           
                if (mail instanceof MailPackage) {
                    mailPackage = (MailPackage) mail;
                    if (mailPackage.getContent().getContent().equals(WEAPONS)
                            || mailPackage.getContent().getContent().equals(BANNED_SUBSTANCE)) {
                        throw new IllegalPackageException();
                    }
                    if (mailPackage.getContent().getContent().contains("stones")) {
                        throw new StolenPackageException();
                    }
                }


            return mail;
        }
    }
    public  static class Spy implements MailService{
        private final static Logger LOGGER = Logger.getLogger(Spy.class.getName());

        private Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(AUSTIN_POWERS) || mail.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(),((MailMessage) mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail.getFrom(),mail.getTo()});
                }
            }
            return mail;
        }
    }
    public static class Thief implements MailService {

        private int minPrice;
        private static int stolenValue = 0;

        public Thief(int minPrice) {
            this.minPrice = minPrice;
        }

        public int getStolenValue(){
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            MailPackage pack;
            if (mail instanceof MailPackage) {
                pack = (MailPackage) mail;
                if (pack.getContent().getPrice() >= minPrice) {
                    stolenValue += pack.getContent().getPrice();
                    return new MailPackage(pack.getFrom(), pack.getTo(), new Package("stones instead of " + pack.getContent().getContent(), 0));
                }
            }
            return mail;
        }
    }
    public static class UntrustworthyMailWorker implements MailService{
        private RealMailService realMailService;
        private MailService[] mailServices;
        public UntrustworthyMailWorker(MailService[] mailServices){
            realMailService = new RealMailService("realMailService");
            this.mailServices = mailServices;
        }
        public MailService getRealMailService(){
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable sendable = mail;
            for (MailService service: mailServices){
                sendable = service.processMail(sendable);
            }
            return getRealMailService().processMail(sendable);
        }
    }
    public static class IllegalPackageException extends RuntimeException {
    }
    public static class StolenPackageException extends RuntimeException {
    }
}
