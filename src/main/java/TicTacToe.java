import javax.swing.*;

import java.awt.*;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;


public class TicTacToe {
    static JFrame jfMainWindow = new JFrame();
    static JPanel jp[][] = new JPanel[3][3];
    static JLabel jlStatus = new JLabel();

    static JButton button = new JButton("Retry");

    public static void main(String[] args) {
        jfMainWindow.setSize(350, 350);
        jfMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMainWindow.setLayout(null);
        jfMainWindow.setTitle("Tic Tac Toe 1.0 - Indu");
        jfMainWindow.setResizable(false);
        jfMainWindow.getContentPane().setBackground(Color.PINK);

        for (int i = 0, y = 60; i < 3; i++) {

            for (int j = 0, x = 80; j < 3; j++) {

                jp[i][j] = new JPanel();
                jp[i][j].setSize(45, 45);
                jp[i][j].setLocation(x, y);
                jp[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                jp[i][j].setBackground(Color.CYAN);
                jp[i][j].add(new JLabel());
                jp[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        process(e);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });

                jfMainWindow.add(jp[i][j]);
                x = x + 50;
            }
            y = y + 50;
        }
        jlStatus.setSize(225, 25);
        jlStatus.setLocation(80, 220);
        jfMainWindow.add(jlStatus);

        button.setLocation(100,270);
        button.setSize(100,25);
        button.setBackground(Color.lightGray);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        jfMainWindow.add(button);

        button.addActionListener((e) -> {
            retryGame();
        });
        jfMainWindow.setVisible(true);
    }

    private static void retryGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel jlabel = (JLabel) jp[i][j].getComponent(0);
                jlabel.setText("");
                FirstPlayer = true;
                jp[i][j].setEnabled(true);
            }
        }
        jlStatus.setText("");
    }

    public static boolean FirstPlayer = true;

    public static void process(MouseEvent e) {
        JPanel jpanel = (JPanel) e.getSource();
        JLabel jl = (JLabel) jpanel.getComponent(0);
        jl.setFont(jl.getFont().deriveFont(Font.BOLD, 20f));
        if (jpanel.isEnabled()) {
            if (FirstPlayer) {
                jl.setText("X");
                FirstPlayer = false;
            } else {
                jl.setText("O");
                FirstPlayer = true;
            }
            findWinner();
        }
        jpanel.setEnabled(false);
        String text = jlStatus.getText();
        if(text.equals("The Winner is X") || text.equals("The Winner is O")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(getText(jp[i][j]).equals("")) {
                        jp[i][j].setEnabled(false);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!getText(jp[i][j]).isEmpty()) {
                    count++;
                }
            }
        }
        if (jlStatus.getText().equals("") && count == 9) {
            jlStatus.setText("The match ends in a draw");
        }
    }

    private static String getText(JPanel panel) {
        return ((JLabel) panel.getComponent(0)).getText();
    }

    private static void findWinner() {
        if (getText(jp[0][0]).equals("X") && getText(jp[1][0]).equals("X") && getText(jp[2][0]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[0][1]).equals("X") && getText(jp[1][1]).equals("X") && getText(jp[2][1]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[0][2]).equals("X") && getText(jp[1][2]).equals("X") && getText(jp[2][2]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[0][0]).equals("O") && getText(jp[1][0]).equals("O") && getText(jp[2][0]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
        if (getText(jp[0][1]).equals("O") && getText(jp[1][1]).equals("O") && getText(jp[2][1]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
        if (getText(jp[0][2]).equals("O") && getText(jp[1][2]).equals("O") && getText(jp[2][2]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
        if (getText(jp[0][0]).equals("X") && getText(jp[0][1]).equals("X") && getText(jp[0][2]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[1][0]).equals("X") && getText(jp[1][1]).equals("X") && getText(jp[1][2]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[2][0]).equals("X") && getText(jp[2][1]).equals("X") && getText(jp[2][2]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[0][0]).equals("O") && getText(jp[0][1]).equals("O") && getText(jp[0][2]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
        if (getText(jp[1][0]).equals("O") && getText(jp[1][1]).equals("O") && getText(jp[1][2]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
        if (getText(jp[2][0]).equals("O") && getText(jp[2][1]).equals("O") && getText(jp[2][2]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
        if (getText(jp[0][0]).equals("X") && getText(jp[1][1]).equals("X") && getText(jp[2][2]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[0][2]).equals("X") && getText(jp[1][1]).equals("X") && getText(jp[2][0]).equals("X")) {
            jlStatus.setText("The Winner is X");
        }
        if (getText(jp[0][0]).equals("O") && getText(jp[1][1]).equals("O") && getText(jp[2][2]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
        if (getText(jp[0][2]).equals("O") && getText(jp[1][1]).equals("O") && getText(jp[2][0]).equals("O")) {
            jlStatus.setText("The Winner is O");
        }
    }
}

