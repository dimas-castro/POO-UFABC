import java.awt.Color;

/**
 * Image Utils static class.
 */
public final class ImageUtils {

    private ImageUtils() {}

    /**
     * Generates the histogram of a grayscale picture.
     * @param picture the input picture
     * @return the histogram array, with 256 positions
     */
    public static int[] histogram(Picture picture) {
        // TODO: completar
        int width = picture.width();
        int height = picture.height();
        int[] hist = new int[256];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Color cor = picture.get(col, row);
                int r = cor.getRed();
                hist[r]++;
            }
        }
        return hist;
    }
}
