public class ImageProcessing {
    int color;

    public ImageProcessing(int color) {
        this.color = color;
    }

    public int lighter(int percent) {
        color = ((255 - color) * percent / 100) + color;
        return color;
    }

    public int darkest(int percent) {
        color = color - (color * percent / 100);

        return color;
    }

}

