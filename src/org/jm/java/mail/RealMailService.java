package org.jm.java.mail;

public class RealMailService implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}
