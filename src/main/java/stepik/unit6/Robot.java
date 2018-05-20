package stepik.unit6;



public class Robot {
    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.UP;
    public Direction getDirection() {
        return direction;
    }

    public int getX() {
       return x;
    }

    public int getY() {
       return y;
    }

    public void turnLeft() {
       Direction currentDirection = getDirection();
        int ordinal = currentDirection.ordinal();
        if(ordinal == 0){
            direction = Direction.LEFT;
        }else if(ordinal == 3){
            direction = Direction.UP;
        }else{
            Direction[] dirs = Direction.values();
            direction = dirs[ordinal+1];
        }

    }

    public void turnRight() {
        Direction currentDirection = getDirection();
        int ordinal = currentDirection.ordinal();
        if(ordinal == 0){
            direction = Direction.RIGHT;
        }else if(ordinal == 3){
            direction = Direction.DOWN;
        }else{
            Direction[] dirs = Direction.values();
            direction = dirs[ordinal-1];
        }
    }

    public void stepForward() {
        String name = direction.name();
        switch (name){
            case "UP": y++;
            break;
            case "DOWN": y--;
            break;
            case "RIGHT":x++;
            break;
            case "LEFT":x--;
            break;
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
