package com.lesson2;

import java.util.Random;

/**
 * Class Matrix created and printed if u want the matrix[4][4] with next conditions:
 * - upper side of matrix should be random numbers form 1 to 10;
 * - down side of matrix should be random numbers form 10 to 20.
 *
 * And printed sum of each side.
 */

public class Matrix {
    final int N = 4;
    Integer [][] createdMatrix;

    /**
     * Default constructor
     */
    public Matrix (){
        createdMatrix = createMatrix();
    }

    /**
     * Method which created matrix with next conditions:
     * - upper side of matrix should be random numbers form 1 to 10;
     * - down side of matrix should be random numbers form 10 to 20.
     *
     */

    private Integer[][] createMatrix (){
        Integer [][] matrix = new Integer[N][N];
        Random rnd = new Random();

        for (int i = 0; i < N; i ++){
            for (int j = 0; j < N; j++){
                if (i == j)
                    matrix [i][j] = 0;
                if (j < i)
                    matrix [i][j] = (rnd.nextInt(10) + 10);
                if (i < j)
                    matrix [i][j] = (rnd.nextInt(9) + 1);
                }
        }

        return matrix;
    }

    /**
     * Method which print matrix
     */
    public void printMatrix(){
        System.out.println("Created matrix:");
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(createdMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Method which print sum of each side.
     */
    public void printSummOfElementsOfMatrix(){
        int summUpperSide = 0;
        int summDownSide = 0;
        for (int i = 0; i < N; i ++){
            for (int j = 0; j < N; j++){
                if (j < i)
                    summDownSide = summDownSide + createdMatrix [i][j];
                if (i < j)
                    summUpperSide = summUpperSide + createdMatrix[i][j];
            }
        }

        System.out.println("Summ of elements upper side:\n" + summUpperSide);
        System.out.println("Summ of elements down side:\n" + summDownSide);
    }

}
