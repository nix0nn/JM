package org.jm.java.robot;

public class Robot {
    public static void main(String[] args){
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int step = 0; step < 3; step++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                step = 4;
            } catch (RobotConnectionException e) {
                if (step == 2) {
                    throw new RobotConnectionException("try limit exceeded", e);
                }
            }
        }
    }
}
