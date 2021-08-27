//By Hitam Yadav

package Maze;

public class PairInt {

        //variables
        private int x;
        private int y;
        //constructors
        public PairInt(int x, int y){
            this.x = x;
            this.y = y;
        };

        //x getter
        public int getX(){
            return x;
        }

        //y getter
        public int getY(){
            return y;
        }

        //x setter
        public void setX(int x) {
            this.x = x;
        }
        // y setter
        public void setY(int y) {
            this.y = y;
        }

        public boolean equals(Object p){
            if ( p == null) {
                return false;
            }

            PairInt pairInt = (PairInt) p;
            return (this.x == pairInt.x && this.y == pairInt.y);

        }

        public String toString(){

            return "(" + x + ", " + y + ")";
        }
        public PairInt copy(){
            return new PairInt(x, y);
        }
    }

