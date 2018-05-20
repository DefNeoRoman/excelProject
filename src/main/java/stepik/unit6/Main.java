package stepik.unit6;

public class Main {
    public static void main(String[] args) {

        RobotConnectionManager robotConnectionManager = () -> new RobotConnection() {
            @Override
            public void moveRobotTo(int x, int y) {

            }

            @Override
            public void close() {

            }
        };
        for(int i=0; i<3; i++){
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {

            } catch (RobotConnectionException e) {
                if(i==3){
                    throw new RobotConnectionException("third Fail");
                }
            }
        }
    }
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean ok = false;
        if(!ok){
            for(int i=0; i<3; i++){
                try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                    robotConnection.moveRobotTo(toX,toY);
                    ok = true;
                } catch (RobotConnectionException e) {

                }
           }
            if(!ok){
                throw new RobotConnectionException("fail");
            }
        }
    }
}
