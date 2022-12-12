public class Color {
    int r;
    int g;
    int b;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Color(int r, int g, int b) throws Exception {

        if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {

            this.r = r;
            this.g = g;
            this.b = b;
        } else {
            throw new Exception("Wrong pixel value");
        }
    }
}
