import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IOManager {


    private static void ImageInputOutput(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ArrayList<Color> arrayData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String ls = System.getProperty("line.separator");
        String resolution = reader.readLine();
        stringBuilder.append(resolution);
        stringBuilder.append(ls);

        while ((line = reader.readLine()) != null) {
            String[] values = line.split("\\s");
            int r = Integer.parseInt(values[0]);
            int g = Integer.parseInt(values[1]);
            int b = Integer.parseInt(values[2]);
            arrayData.add(new Color(r, g, b));
            if (args[2].equals("lighter")) {
                String newRGB =
                        new ImageProcessing(r).lighter(Integer.parseInt(args[3])) + " " +
                                new ImageProcessing(g).lighter(Integer.parseInt(args[3])) + " " +
                                new ImageProcessing(b).lighter(Integer.parseInt(args[3]));
                stringBuilder.append(newRGB);

            } else {
                String newRGB =
                        new ImageProcessing(r).darkest(Integer.parseInt(args[3])) + " " +
                                new ImageProcessing(g).darkest(Integer.parseInt(args[3])) + " " +
                                new ImageProcessing(b).darkest(Integer.parseInt(args[3]));
                stringBuilder.append(newRGB);
            }
            stringBuilder.append(ls);

        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();

        String content = stringBuilder.toString();



        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(args[1], false));
            out.write(content);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ImageInputOutput(args);

        if (args[4].equals("true")) {
            Thread t1 = new Thread(() -> {
                try {
                    ImageInputOutput(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            });
            t1.start();

        } else {
            ImageInputOutput(args);
        }


    }
}
