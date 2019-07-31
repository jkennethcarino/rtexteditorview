package com.jkcarino.rtexteditorview;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;

public class RTextEditorToolbar extends LinearLayoutCompat {

    private RTextEditorView rTextEditorView;

    public RTextEditorToolbar(Context context) {
        super(context);
    }

    public RTextEditorToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RTextEditorToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        for (int view = 0; view < getChildCount(); view++) {
            final View toolButton = getChildAt(view);

            if (toolButton instanceof RTextEditorButton) {
                final RTextEditorButton button = (RTextEditorButton) toolButton;
                final @ToolType int toolType = button.getToolType();

                button.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rTextEditorView != null) {
                            rTextEditorView.setFormat(toolType);
                        }
                    }
                });
            }
        }
    }

    public void setEditorView(@NonNull RTextEditorView rTextEditorView) {
        this.rTextEditorView = rTextEditorView;
    }
}
