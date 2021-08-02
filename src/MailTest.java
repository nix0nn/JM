import java.util.logging.*;

public class MailTest {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) {
        Package cdrom = new Package("ASOT", 1000);
        MailMessage messaga = new MailMessage("Scholl","8uffonn", "hi");
        MailPackage pack = new MailPackage("Scholl", "8uffonn", cdrom);

        Package prize = new Package("teroopia", 1500);
        MailMessage messaga2 = new MailMessage("pig", "rebbit", "hello");
        MailPackage pack2 = new MailPackage("pig", "rabbir", prize);

        Thief onen = new Thief(1500);
        onen.processMail(messaga2);
        onen.processMail(pack2);

        System.out.println(onen.sumAllStolen);


    }
    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public interface MailService {
        Sendable processMail(Sendable mail);
    }
    /*
    Интерфейс: сущность, которую можно отправить по почте.
    У такой сущности можно получить от кого и кому направляется письмо.
    */
    public interface Sendable {
        String getFrom();
        String getTo();
    }
    /*
    Абстрактный класс,который позволяет абстрагировать логику хранения
    источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }
    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }
    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }
    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    public class RealMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {}
    public static class StolenPackageException extends RuntimeException {}

    /*
    Вор
     */
    public static class Thief implements MailService {
        private final int minPriceContent;
        private int sumAllStolen;

        public Thief(int minPriceContent) {
            this.minPriceContent = minPriceContent;
        }

        public int getStolenValue() {
            return sumAllStolen;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                Package box = ((MailPackage) mail).getContent();
                if (box.getPrice() >= minPriceContent) {
                    sumAllStolen += box.getPrice();
                    return new MailPackage(mail.getFrom(), mail.getTo(),
                            new Package("stones instead of " + box.getContent(), 0));
                }
            }
            return mail;
        }
    }

    /*
    Инспектор
     */
    public static class Inspector implements MailService{
        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailPackage) {
                Package box = ((MailPackage)mail).getContent();
                String content = box.getContent();
                if(content.equals(WEAPONS) || content.equals(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                if(content.indexOf("stones") == 0) {
                    throw new StolenPackageException();
                }
            }
            return mail;
        }
    }

    /*
     Сотрудник почт. отделения
     */
    public static class UntrustworthyMailWorker implements MailService {
        private final MailService realMailService = new RealMailService();
        private MailService[] mailServices;

        public UntrustworthyMailWorker(MailService[] services) {
            mailServices = services;
        }

        public MailService getRealMailService(){
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            Sendable processed = mail;
            for (int i = 0; i < mailServices.length; i++) {
                processed = mailServices[i].processMail(processed);
            }
            return realMailService.processMail(mail);
        }
    }

    /*
    Шпион
     */
    public static class Spy {
    }





}
