package sample.MPI_Datatypes;

/**
 * Created by ChrisHolley on 8/6/2016.
 */
public class OffsetLengthPair {

    private long offset; //The offset in bytes
    private long length; //The length accessible from the offset

    //Constructor
    public OffsetLengthPair(long offset, long length) {
        this.offset = offset;
        this.length = length;
    }

    //Getters and Setters
    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
