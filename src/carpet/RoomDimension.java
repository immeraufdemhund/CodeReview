package carpet;

/**
 * Created by snyder on 2015-09-18.
 */
    public class RoomDimension {
        private int length;
        private int width;

        public RoomDimension(int length, int width) {
            this.length = length;
            this.width = width;
        }

        public RoomDimension(RoomDimension dimension){
            this.length = dimension.length;
            this.width = dimension.width;
        }
    }
