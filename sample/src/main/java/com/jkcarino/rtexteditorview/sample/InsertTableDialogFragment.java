package com.jkcarino.rtexteditorview.sample;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class InsertTableDialogFragment extends AppCompatDialogFragment {

    private OnInsertClickListener listener;

    public static InsertTableDialogFragment newInstance() {
        return new InsertTableDialogFragment();
    }

    public void setOnInsertClickListener(@NonNull OnInsertClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        if (manager.findFragmentByTag(tag) == null) {
            super.show(manager, tag);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_insert_table, null);
        final TextInputEditText columnCountEditText = view.findViewById(R.id.column_count);
        final TextInputEditText rowCountEditText = view.findViewById(R.id.row_count);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(R.string.title_insert_table);
        dialog.setView(view);
        dialog.setPositiveButton(R.string.insert, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String colCount = columnCountEditText.getText().toString().trim();
                String rowCount = rowCountEditText.getText().toString().trim();

                if (listener != null) {
                    listener.onInsertClick(Integer.valueOf(colCount), Integer.valueOf(rowCount));
                }
            }
        });
        dialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return dialog.create();
    }

    public interface OnInsertClickListener {
        void onInsertClick(int colCount, int rowCount);
    }
}
