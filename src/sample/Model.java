package sample;

import sample.MPI_Datatypes.FileOpenEvent;
import sample.MPI_Datatypes.FilePointerPositionEvent;
import sample.MPI_Datatypes.FileSetViewEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChrisHolley on 7/25/2016.
 */
public class Model {

    private ArrayList<FileSetViewEvent> fileViewEvents;
    private ArrayList<FilePointerPositionEvent> filePointerEvent;
    private ArrayList<FileOpenEvent> fileOpenEvents;

    //Constructors
    Model(){}

    //Reads model data from file
    Model(String filename){

    }

    //Getter and Setters
    public ArrayList<FileSetViewEvent> getFileViewEvents() {
        return fileViewEvents;
    }

    public void setFileViewEvents(ArrayList<FileSetViewEvent> fileViewEvents) {
        this.fileViewEvents = fileViewEvents;
    }

    public ArrayList<FilePointerPositionEvent> getFilePointerEvent() {
        return filePointerEvent;
    }

    public void setFilePointerEvent(ArrayList<FilePointerPositionEvent> filePointerEvent) {
        this.filePointerEvent = filePointerEvent;
    }

    public ArrayList<FileOpenEvent> getFileOpenEvents() {
        return fileOpenEvents;
    }

    public void setFileOpenEvents(ArrayList<FileOpenEvent> fileOpenEvents) {
        this.fileOpenEvents = fileOpenEvents;
    }
}
