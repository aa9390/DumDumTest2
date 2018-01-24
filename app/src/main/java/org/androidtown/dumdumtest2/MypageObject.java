package org.androidtown.dumdumtest2;

import android.widget.TextView;

/**
 * Created by User on 2018-01-23.
 */

public class MypageObject {

    private TextView textView;

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public MypageObject(TextView textView) {
        this.textView = textView;
    }
}
