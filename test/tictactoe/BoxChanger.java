package tictactoe;

/**
 * Created by snyder on 2015-12-17.
 */
    public class BoxChanger {
        private final Box box;

        public BoxChanger(Box box) {
            this.box = box;
        }

        public void changeBox(){
            box.X += 1;
        }
    }
