package minesweeper.numberDisplay.formatter;

import javafx.scene.image.Image;

/**
 * Created by snyder on 2015-07-14.
 */
    public abstract class ImageResources {
        public static DigitalNumberImageResources clock = new DigitalNumberImageResources();
        public static MineNumberImageResources mines = new MineNumberImageResources();

        static Image loadImage(String folder, String imageName){
            return new Image(ImageResources.class
                    .getClass()
                    .getResource(folder + imageName)
                    .toExternalForm());
        }

        static class DigitalNumberImageResources{
            private static final String folder = "/images/digitalnumber/";
            public static Image one = loadImage(folder, "one.png");
            //...
            public static Image nine = loadImage(folder, "nine.png");
        }

        static class MineNumberImageResources {
            private static final String folder = "/images/mines/";
            public static Image one = loadImage(folder, "one.png");
            //...
            public static Image eight = loadImage(folder, "eight.png");
        }
    }
