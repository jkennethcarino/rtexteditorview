package com.jkcarino.rtexteditorview;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageButton;

public class RTextEditorButton extends AppCompatImageButton {

    @ToolType
    private int toolType;

    public RTextEditorButton(Context context) {
        super(context);
    }

    public RTextEditorButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        final TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RTextEditorButton,
                0, 0);

        try {
            toolType = a.getInteger(R.styleable.RTextEditorButton_toolType, 0);
        } finally {
            a.recycle();
        }
    }

    public RTextEditorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @ToolType
    public int getToolType() {
        return toolType;
    }

    public void setToolType(@ToolType int toolType) {
        this.toolType = toolType;
    }
}
