package inc.company.list2_my_application;

import android.graphics.drawable.Drawable;

/**
 * Created by student on 27.3.2018.
 */

public class Model {


    public String mName;
    public Drawable mImage;

    public Model(String name, Drawable image) {
        this.mName = name;
        this.mImage = image;
    }


    public String getmName() {
        return mName;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmImage(Drawable mImage) {
        this.mImage = mImage;
    }
}
