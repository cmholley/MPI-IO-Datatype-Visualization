package sample;

import sample.MPI_Datatypes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ChrisHolley on 7/25/2016.
 */
public class Model {

    private ArrayList<FileSetViewEvent> fileViewEvents;
    private ArrayList<FilePointerPositionEvent> filePointerEvents;
    private ArrayList<FileOpenEvent> fileOpenEvents;


    //Constructors
    Model(){}

    //Reads model data from file
    Model(String filename){
        fileViewEvents = new ArrayList<FileSetViewEvent>();
        filePointerEvents = new ArrayList<FilePointerPositionEvent>();
        fileOpenEvents = new ArrayList<FileOpenEvent>();

        Scanner inFile = null;

        File file = new File(filename);
        try {

            inFile = new Scanner(file);
            inFile.useDelimiter(";");

            //Loop to read in all data
            while (inFile.hasNextLine()) {
                //Read in next int to determine evemt type
                int eventType = inFile.nextInt();
                double timestamp; //All event types have a timestamp
                int processId; //Two event types include processId
                switch(eventType){
                    case(100)://File open event
                        //Parameters filename; timestamp; filesize; number of processes
                        //Read in all parameters
                        String eventFilename = inFile.next();
                        timestamp = 0;//inFile.nextDouble();
                        int filesize = inFile.nextInt();
                        int numOfProcs = inFile.nextInt();

                        //Add to list of open events
                        fileOpenEvents.add(new FileOpenEvent(
                                eventFilename,timestamp,filesize, numOfProcs));
                        inFile.nextLine();//Moves cursor to next line
                        break;
                    case(101)://File set view event
                        //Parameters: process id; timestamp; no_of_entries; List of <offset,length>
                        //Read in all parameters
                        processId = inFile.nextInt();
                        timestamp = inFile.nextDouble();
                        int numberOfEntries = inFile.nextInt();
                        ArrayList<OffsetLengthPair> offsetsAndLengths = new ArrayList<OffsetLengthPair>();
                        for(int i = 0; i < numberOfEntries; i++){
                            offsetsAndLengths.add(new OffsetLengthPair(inFile.nextLong(),inFile.nextLong()));
                        }

                        //Add to list of file view events
                        fileViewEvents.add(new FileSetViewEvent(processId, timestamp, numberOfEntries,offsetsAndLengths));
                        inFile.nextLine();//Moves cursor to next line
                        break;
                    case(102)://File Pointer Position Update
                        //Parameters: process id; timestamp; old position; new position; operation
                        //Read in all parameters
                        processId = inFile.nextInt();
                        timestamp = inFile.nextDouble();
                        long oldPosition = inFile.nextLong();
                        long newPosition = inFile.nextLong();
                        FilePointerOperation operationType = null;
                        int operationInt = inFile.nextInt();
                        switch (operationInt) {
                            case (1)://Write operation
                                operationType = FilePointerOperation.WRITE;
                                break;
                            case (2)://READ
                                operationType = FilePointerOperation.READ;
                                break;
                            case (3):
                                operationType = FilePointerOperation.SEEK;
                                break;
                            default:
                                System.out.println("Invalid File Pointer Operation Int");
                                System.exit(1);
                        }
                        filePointerEvents.add(new FilePointerPositionEvent(processId, timestamp,
                                oldPosition, newPosition, operationType));
                        inFile.nextLine();//Moves cursor to next line
                        break;
                }
            }
            inFile.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Getter and Setters
    public ArrayList<FileSetViewEvent> getFileViewEvents() {
        return fileViewEvents;
    }

    public void setFileViewEvents(ArrayList<FileSetViewEvent> fileViewEvents) {
        this.fileViewEvents = fileViewEvents;
    }

    public ArrayList<FilePointerPositionEvent> getFilePointerEvents() {
        return filePointerEvents;
    }

    public void setFilePointerEvents(ArrayList<FilePointerPositionEvent> filePointerEvents) {
        this.filePointerEvents = filePointerEvents;
    }

    public ArrayList<FileOpenEvent> getFileOpenEvents() {
        return fileOpenEvents;
    }

    public void setFileOpenEvents(ArrayList<FileOpenEvent> fileOpenEvents) {
        this.fileOpenEvents = fileOpenEvents;
    }
}
