package sample.MPI_Datatypes;

/**
 * Created by ChrisHolley on 8/6/2016.
 */
public class FilePointerPositionEvent {


    private int processId; //Id of process moving its pointer
    private double timestamp; //The timestamp of the event in seconds
    private long oldPosition; //The previous position of the pointer
    private long newPosition; //The postition the pointer is moving to
    private FilePointerOperation operationType; //The type of operation occuring

    //Constructor
    public FilePointerPositionEvent(int processId, double timestamp, long oldPosition,
                                    long newPosition, FilePointerOperation operationType) {
        this.processId = processId;
        this.timestamp = timestamp;
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
        this.operationType = operationType;
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

    public long getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(long oldPosition) {
        this.oldPosition = oldPosition;
    }

    public long getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(long newPosition) {
        this.newPosition = newPosition;
    }

    public FilePointerOperation getOperationType() {
        return operationType;
    }

    public void setOperationType(FilePointerOperation operationType) {
        this.operationType = operationType;
    }
}
