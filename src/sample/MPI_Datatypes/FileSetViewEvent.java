package sample.MPI_Datatypes;

import java.util.List;

/**
 * Created by ChrisHolley on 8/6/2016.
 */
public class FileSetViewEvent {

    private int processId; //ID of the process accessing the file
    private double timestamp; //timestamp of event in seconds
    private int numberOfEntries; //The number offsets and lengths
    private List<OffsetLengthPair> offsetsAndLengths; //The list of offsets and pairs

    //Constructor
    public FileSetViewEvent(int processId, double timestamp, int numberOfEntries,
                            List<OffsetLengthPair> offsetsAndLengths) {
        this.processId = processId;
        this.timestamp = timestamp;
        this.numberOfEntries = numberOfEntries;
        this.offsetsAndLengths = offsetsAndLengths;
    }

    //Getters and Setters
    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public List<OffsetLengthPair> getOffsetsAndLengths() {
        return offsetsAndLengths;
    }

    public void setOffsetsAndLengths(List<OffsetLengthPair> offsetsAndLengths) {
        this.offsetsAndLengths = offsetsAndLengths;
    }
}
