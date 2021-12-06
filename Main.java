import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {

    int[] arr = new int[600];
    Random rand = new Random();
    boolean done = false;
    int comp_count = 0;
    int changes = 0;

    public static void main(String[] args) throws InterruptedException {
        Main t = new Main();
    }

    Main() throws InterruptedException {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bubble Sort Visualiser");
        setResizable(false);

        setVisible(true);

        for (int i = 0; i < 600; i++) {
            arr[i] = (rand.nextInt(350)+1);
        }

        int b;
        int else_cout;

        for (int k = 0; k < 600; k++) {
            else_cout = 0;
            for (int l = 0; l < 599; l++) {
                if (arr[l] > arr[l+1]) {
                    b = arr[l];
                    arr[l] = arr[l+1];
                    arr[l+1] = b;

                    changes++;
                } else {
                    else_cout++;
                }

                comp_count++;
            }

            Thread.sleep(100);
            repaint();
            if (else_cout == 599) {
                break;
            }
        }

        done = true;
        repaint();
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setBackground(Color.black);

        if (!done) {
            g2D.clearRect(0, 0, 600, 400);
            for (int i = 0; i < 600; i++) {
                g2D.setColor(Color.white);
                g2D.drawLine(i, 400, i, 400-arr[i]);
            }
        } else {
            for (int i = 0; i < 600; i++) {
                g2D.setColor(Color.green);
                g2D.drawLine(i, 400, i, 400-arr[i]);
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {}
            }
        }

        g2D.setColor(Color.white);
        g2D.drawString("Comparisons: " + comp_count, 10, 45);
        g2D.drawString("Changes on Array: " + changes, 10, 60);
        g2D.drawString("Delay: ~100ms", 10, 75);
        g2D.drawString("Screen updates: 1 / 600 iterations", 10, 90);
    }
}
