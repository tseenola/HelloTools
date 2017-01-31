package core;

import tools.com.hellolibrary.helllo_my_inter.WorkingKeyWriterTemplate;

/**
 * Created by lenovo on 2017/2/1.
 * 描述：工作密钥写入者
 */

public class WorkingKeyWriter extends WorkingKeyWriterTemplate{

    private WorkingKeyWriter(){};

    public static boolean doWriteWorkKey(){
        return new WorkingKeyWriter().writeWorkingKey();
    }

    @Override
    public boolean writeMacKey() {
        return false;
    }

    @Override
    public boolean writePinKey() {
        return false;
    }

    @Override
    public boolean writeTrackKey() {
        return false;
    }
}
