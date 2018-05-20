package stepik.unit7Logging;

import java.util.Map;

public class RealMailService implements MailService {
    private static int counter = 0;

    private String name;

    public RealMailService() {
        counter++;
        name = "RealMailService"+counter;
    }

    public RealMailService(String name){
        counter++;
        this.name = name;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        System.out.println("RealMailService: "+name+"");
        return mail;
    }
}
