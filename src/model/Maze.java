package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lorenzop on 12/18/16.
 */
public class Maze {
    public static final int ROWS = 20;
    public static final int COLS = 24;

    private String mazeName;
    private String mazePath;
    private Difficulty difficulty;
    public char[][] mazeArray;

    public Maze(String mazeName, String mazePath, Difficulty difficulty) {
        this.mazeName = mazeName;
        this.mazePath = mazePath;
        this.difficulty = difficulty;
        mazeArray = new char[20][24];
        loadMaze();
    }

    /**
     * Read from the .txt file in which the maze is.
     * It uses the FileReader  and BufferedReader classes to read from file and calls the function readFromFile() to create
     * the array on which all the actions will be performed.
     */
    public void loadMaze(){
        try{
            FileReader fr = new FileReader(mazePath);
            BufferedReader br = new BufferedReader(fr);
            readFromFile(br);
        }catch (FileNotFoundException e){
            System.out.println("Maze path not found " + e.getMessage());
        }
    }

    /**
     * Create the array on which the program works.
     * Initially the array indexes are initialised otherwise the program could throw an OutOfBoundsException at a further call
     * of this method.
     * This method uses the built-in method readLine() of BufferedReader to read one line at a time. Then it reads character by
     * character until the end of file and updates the array of chars.
     */
    public void readFromFile(BufferedReader br){
        int i=0;
        int j=0;

        try{
            String line =new String();
            while((line = br.readLine()) != null){
                for (j = 0; j<line.length();j++){
                    mazeArray[i][j] = line.charAt(j);
                }
                i++;
            }
        }catch(IOException e){
            System.out.println("IOException when reading the maze: " + e.getMessage());
        }
    }
}
