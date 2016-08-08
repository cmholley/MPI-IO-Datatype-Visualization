package sample.MPI_Datatypes;

/**
 * Created by ChrisHolley on 8/6/2016.
 */
public class FileOpenEvent {
    private String filename; //name of file opened
    private double timestamp; //time in seconds
    private int fileSize; //ignore
    private int numberOfProcs; //number of processess writing to the file

    //Constructor
    public FileOpenEvent(String filename, double timestamp, int fileSize, int numberOfProcs) {
        this.filename = filename;
        this.timestamp = timestamp;
        this.fileSize = fileSize;
        this.numberOfProcs = numberOfProcs;
    }


    //Getters and Setters
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getNumberOfProcs() {
        return numberOfProcs;
    }

    public void setNumberOfProcs(int numberOfProcs) {
        this.numberOfProcs = numberOfProcs;
    }
}
