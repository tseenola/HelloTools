package tools.com.hellolibrary.hello_sound;

import android.content.Context;
import android.media.SoundPool;

import tools.com.hellolibrary.R;

/**
 * Created by lijun on 2017/1/18.
 * 描述：SoundPool的封装
 */

public class SoundUtils {
    private static SoundUtils instance = null;
    private SoundPool soundPool = null;
    private int errorSoundID;
    private int successSoundID;

    public SoundUtils(Context context) {
        this.soundPool = new SoundPool(1, 5, 100);
        this.errorSoundID = this.soundPool.load(context, R.raw.wrong, 1);
        this.successSoundID = this.soundPool.load(context, R.raw.beep, 1);
    }

    public static SoundUtils getInstance(Context context) {
        if(instance == null) {
            instance = new SoundUtils(context);
        }

        return instance;
    }

    public void playErrorSound() {
        this.soundPool.play(this.errorSoundID, 1.0F, 1.0F, 0, 0, 1.0F);
    }

    public void playSuccessSound() {
        this.soundPool.play(this.successSoundID, 1.0F, 1.0F, 0, 0, 1.0F);
    }
}
