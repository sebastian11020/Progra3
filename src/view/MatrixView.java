package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import presenter.MatrixPresenter;

public class MatrixView extends JFrame {
    private JTextField[][] matrixFields;
    private JButton transposeButton;
    private JPanel matrixPanel;
    private JPanel resultPanel;

    public MatrixView(int matrixSize, MatrixPresenter presenter) {
        setTitle("Matrix Transpose");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        matrixPanel = new JPanel();
        resultPanel = new JPanel();
        transposeButton = new JButton("Transpose");
        transposeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.transposeMatrix();
            }
        });

        matrixPanel.setLayout(new GridLayout(matrixSize, matrixSize));
        matrixFields = new JTextField[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                JTextField field = new JTextField();
                matrixFields[i][j] = field;
                matrixPanel.add(field);
            }
        }

        matrixPanel.add(transposeButton);
        add(matrixPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
    }

    public String getMatrixValue(int row, int col) {
        return matrixFields[row][col].getText();
    }

    public void displayTranspose(ArrayList<ArrayList<Integer>> transposeMatrix) {
        resultPanel.removeAll();
        resultPanel.setLayout(new GridLayout(transposeMatrix.size(), transposeMatrix.size()));

        for (int i = 0; i < transposeMatrix.size(); i++) {
            for (int j = 0; j < transposeMatrix.size(); j++) {
                JLabel label = new JLabel(String.valueOf(transposeMatrix.get(i).get(j)));
                resultPanel.add(label);
            }
        }

        resultPanel.revalidate();
        resultPanel.repaint();
    }
}
