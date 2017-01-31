package tools.com.hellolibrary.helllo_my_inter;

/**
 * Created by lenovo on 2017/2/1.
 * 描述：
 */

public abstract class WorkingKeyWriterTemplate extends MaxqManagerHelper{
    public abstract boolean writeMacKey();
    public abstract boolean writePinKey();
    public abstract boolean writeTrackKey();


    protected boolean writeWorkingKey(){
        return writeMacKey()&&
                writePinKey()&&
                writeTrackKey();
    }
}
