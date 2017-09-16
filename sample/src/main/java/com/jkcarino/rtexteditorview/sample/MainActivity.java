package com.jkcarino.rtexteditorview.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.jkcarino.rtexteditorview.RTextEditorButton;
import com.jkcarino.rtexteditorview.RTextEditorToolbar;
import com.jkcarino.rtexteditorview.RTextEditorView;

public class MainActivity extends AppCompatActivity implements ColorPickerDialogListener {

    private static final String TAG = "RTextEditorView";

    private static final int DIALOG_TEXT_FORE_COLOR_ID = 0;
    private static final int DIALOG_TEXT_BACK_COLOR_ID = 1;

    private RTextEditorView editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editor = findViewById(R.id.editor_view);
        // Enable keyboard's incognito mode
        editor.setIncognitoModeEnabled(true);

        RTextEditorToolbar editorToolbar = findViewById(R.id.editor_toolbar);
        editorToolbar.setEditorView(editor);

        // Set initial content
        editor.setHtml("<p><b><i><u><strike>"
                + "The quick brown fox jumps over the lazy dog."
                + "</strike></u></i></b></p>");

        // Listen to the editor's text changes
        editor.setOnTextChangeListener(new RTextEditorView.OnTextChangeListener() {
            @Override
            public void onTextChanged(String content) {
                Log.d(TAG, "onTextChanged: " + content);
            }
        });

        // Text foreground color
        RTextEditorButton textForeColorButton = findViewById(R.id.text_fore_color);
        textForeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialog.newBuilder()
                        .setDialogId(DIALOG_TEXT_FORE_COLOR_ID)
                        .setDialogTitle(R.string.dialog_title_text_color)
                        .setShowAlphaSlider(false)
                        .setAllowCustom(true)
                        .show(MainActivity.this);
            }
        });

        // Text background color
        RTextEditorButton textBackColorButton = findViewById(R.id.text_back_color);
        textBackColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialog.newBuilder()
                        .setDialogId(DIALOG_TEXT_BACK_COLOR_ID)
                        .setDialogTitle(R.string.dialog_title_text_back_color)
                        .setShowAlphaSlider(false)
                        .setAllowCustom(true)
                        .show(MainActivity.this);
            }
        });

        // Insert table
        RTextEditorButton insertTableButton = findViewById(R.id.insert_table);
        insertTableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertTableDialogFragment dialog = InsertTableDialogFragment.newInstance();
                dialog.setOnInsertClickListener(onInsertTableClickListener);
                dialog.show(getSupportFragmentManager(), "insert-table-dialog");
            }
        });

        // Insert Link
        RTextEditorButton insertLinkButton = findViewById(R.id.insert_link);
        insertLinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertLinkDialogFragment dialog = InsertLinkDialogFragment.newInstance();
                dialog.setOnInsertClickListener(onInsertLinkClickListener);
                dialog.show(getSupportFragmentManager(), "insert-link-dialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_undo) {
            editor.undo();
            return true;
        } else if (id == R.id.action_redo) {
            editor.redo();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        editor.setOnTextChangeListener(null);
        editor.removeAllViews();
        editor.destroy();
        editor = null;
    }

    private final InsertTableDialogFragment.OnInsertClickListener onInsertTableClickListener =
            new InsertTableDialogFragment.OnInsertClickListener() {
                @Override
                public void onInsertClick(int colCount, int rowCount) {
                    editor.insertTable(colCount, rowCount);
                }
            };

    private final InsertLinkDialogFragment.OnInsertClickListener onInsertLinkClickListener =
            new InsertLinkDialogFragment.OnInsertClickListener() {
                @Override
                public void onInsertClick(@NonNull String title, @NonNull String url) {
                    editor.insertLink(title, url);
                }
            };

    @Override
    public void onColorSelected(int dialogId, int color) {
        if (dialogId == DIALOG_TEXT_FORE_COLOR_ID) {
            editor.setTextColor(color);
        } else if (dialogId == DIALOG_TEXT_BACK_COLOR_ID) {
            editor.setTextBackgroundColor(color);
        }
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }
}
