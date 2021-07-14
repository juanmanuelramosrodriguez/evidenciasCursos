package com.almaral.guesschat;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionAdapter extends ArrayAdapter<ListRow> {
    private ArrayList<ListRow> listRows;
    private int layoutId;
    private Context context;

    public QuestionAdapter(@NonNull Context context, @LayoutRes int layoutId, @NonNull ArrayList<ListRow> listRows) {
        super(context, layoutId, listRows);

        this.context = context;
        this.layoutId = layoutId;
        this.listRows = listRows;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layoutId, null);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.question_adapter_item_text);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListRow listRow = listRows.get(position);

        holder.textView.setText(String.valueOf(listRow.getText()));

        if (listRow.isQuestion()) {
            holder.textView.setGravity(Gravity.START);
            holder.textView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
        } else {
            holder.textView.setGravity(Gravity.END);
            holder.textView.setBackgroundColor(ContextCompat.getColor(context, R.color.answer_background));
        }

        return convertView;
    }

    private class ViewHolder {
        public TextView textView;
    }
}
