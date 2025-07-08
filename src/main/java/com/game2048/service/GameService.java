package com.game2048.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    private final int SIZE = 4;
    private int[][] board = new int[SIZE][SIZE];
    private final Random rand = new Random();

    public GameService() {
        addRandomTile();
        addRandomTile();
    }

    public int[][] getBoard() {
        return board;
    }

    public void resetGame() {
        board = new int[SIZE][SIZE];
        addRandomTile();
        addRandomTile();
    }

    public void move(String direction) {
        switch (direction) {
            case "up": moveUp(); break;
            case "down": moveDown(); break;
            case "left": moveLeft(); break;
            case "right": moveRight(); break;
        }
        addRandomTile();
    }

    private void addRandomTile() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (board[x][y] != 0);
        board[x][y] = rand.nextInt(10) == 0 ? 4 : 2;
    }

    private void moveLeft() {
        for (int i = 0; i < SIZE; i++) {
            int[] row = board[i];
            int[] newRow = new int[SIZE];
            int index = 0;
            boolean merged = false;
            for (int j = 0; j < SIZE; j++) {
                if (row[j] == 0) continue;
                if (index > 0 && newRow[index - 1] == row[j] && !merged) {
                    newRow[index - 1] *= 2;
                    merged = true;
                } else {
                    newRow[index++] = row[j];
                    merged = false;
                }
            }
            board[i] = newRow;
        }
    }

    private void moveRight() {
        reverseRows();
        moveLeft();
        reverseRows();
    }

    private void moveUp() {
        transpose();
        moveLeft();
        transpose();
    }

    private void moveDown() {
        transpose();
        moveRight();
        transpose();
    }

    private void transpose() {
        int[][] temp = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                temp[i][j] = board[j][i];
        board = temp;
    }

    private void reverseRows() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE / 2; j++) {
                int temp = board[i][j];
                board[i][j] = board[i][SIZE - j - 1];
                board[i][SIZE - j - 1] = temp;
            }
        }
    }
}
