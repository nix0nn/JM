package org.jm.java.robot;
/**
 * отвечает за установку соединения
 * метод getConnection(); делает попытку собединения с роботом
 * и возврощает установленное соединение, через которое можно отдовать команды роботу
 */
public interface RobotConnectionManager {
    RobotConnection getConnection();
}
