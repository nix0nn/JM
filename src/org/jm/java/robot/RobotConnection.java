package org.jm.java.robot;
/**
* Подключение к роботу представляется в программе интерфейсом RobotConnection:
* RobotConnection - это временно устанавливаемое соединение, которое надо закрывать.
*/
 public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
