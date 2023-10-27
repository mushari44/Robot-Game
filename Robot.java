    class Robot {
        private int x;
        private int y;
      static Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void turnLeft() {
            direction = direction.turnLeft();
        }

        public void turnRight() {
            direction = direction.turnRight();
        }

        public void stepForward() {
            x += direction.dx();
            y += direction.dy();


        }

        public Direction getDirection() {
            return direction;
        }

        public void setX(int x) {

            this.x=x;

        }

        public void setY(int y) {

            this.y = y;
        }


        public int getX() {
            return x;
        }
                public int getY() {
            return y;

        }
    }



