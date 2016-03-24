package U2.L3.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ксения on 19.03.2016.
 * сделать чтобы каждая линия рисовалась своим цветом
 */
public class PaintFrame extends JFrame {

    private static final long serialVersionUID = 5282566357923102964L;

//    private List<Line2D.Float> lines = new ArrayList<>();
    private List<Line2DColor> lines = new ArrayList<>();
    //последняя точка, которую пользователь ввел (постоянно будем ее обнулять)
    private Point lastPoint;
    private DrawPanel panel;
    private Color color = Color.BLACK;

    //private List<Color> listColor = new ArrayList<>();

    public PaintFrame() {
        super("Super color paint");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new DrawPanel();
        add(panel);
        add(new ButtonPanel(), BorderLayout.NORTH);
        //теперь нам надо сделать слушателя, чтобы установить его на панельку
        //удобнее всего слушателя реализовывать через адаптер,
        // тогда мы сможем реализовать те методы, которые нам необходимы
        DrawListener drawListener = new DrawListener();

        //добавляем слушателя к панели
        panel.addMouseListener(drawListener);
        panel.addMouseMotionListener(drawListener); // слушатель на движение мыши
    }
//не рекомендуется создавать экземляры интерфейса из главного потока!!!!!!!!!!!

    public static void main(String[] args) {
        //магическое заклинание, которое подключается к GUI-потоку,
        // и когда нибудь потом приклеем к нему новый Runnable
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PaintFrame();
                frame.setVisible(true);
            }
        });
    }

    private class Line2DColor extends Line2D.Float{
        private static final long serialVersionUID = 2953167204358356996L;

        private Color color;

        public Line2DColor(Point lastPoint, Point currentPoint, Color color) {
            super(lastPoint, currentPoint);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    private class DrawPanel extends JPanel {

        private static final long serialVersionUID = 2085516060806112949L;


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); //как канваз на котором мы рисуем
            Graphics2D g2d = (Graphics2D) g;
//            g2d.setColor(color);
//            for (Line2D.Float line : lines ) {
//                g2d.draw(line);
//            }
            for (Line2DColor line : lines) {
                g2d.setColor(line.getColor());
                g2d.draw(line);
            }
        }
    }

    private class ButtonPanel extends JPanel implements ActionListener {
        private static final long serialVersionUID = -4940608114958271810L;
        public static final String RED = "RED";
        public static final String BLUE = "BLUE";
        public static final String BLACK = "BLACK";
        public static final String GREEN = "GREEN";

        public ButtonPanel() {
            addGeneratedButton(RED, Color.red);
            addGeneratedButton(GREEN, Color.green);
            addGeneratedButton(BLACK, Color.black);
            addGeneratedButton(BLUE, Color.blue);
        }

        private void addGeneratedButton(String name, Color c) {
            JButton button = new JButton(name);
            button.setBackground(c);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setActionCommand(name);
            button.addActionListener(this);
            add(button);
        }

        @Override
        //наблюдает за тем как на вьюшке нажата кнопочка
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case RED:
                    color = Color.RED;
                    break;
                case BLUE:
                    color = Color.BLUE;
                    break;
                case BLACK:
                    color = Color.BLACK;
                    break;
                case GREEN:
                    color = Color.GREEN;
                    break;
            }
        }
    }


    private class DrawListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
           lastPoint = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            Point currentPoint = e.getPoint();
            if (lastPoint == null) {
                lastPoint = currentPoint;
                return;
            }
            lines.add(new Line2DColor(lastPoint, currentPoint, color));

            lastPoint = currentPoint;

            panel.repaint();
        }


    }
}
