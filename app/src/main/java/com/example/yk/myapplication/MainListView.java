package com.example.yk.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yk on 15/6/10.
 */
public class MainListView extends ListView {

    public MainListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
//        return super.onRequestSendAccessibilityEvent(child, event);
        AccessibilityEvent record = AccessibilityEvent.obtain();
        super.onInitializeAccessibilityEvent(record);

        int priority = (Integer) child.getTag();
        String priorityStr = "Priority: " + priority;
        record.setContentDescription(priorityStr);

        event.appendRecord(record);
        return true;
    }
}


final class  MainAdapter extends BaseAdapter{

//    private String[] mLabels = new String[8];
    private Context mContext = null;
    //    private String[] mHidden = null;
    private List<MainEntry> list= null;

    public MainAdapter(Context context,List list1) {
        super();

        mContext = context;
        list = list1;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.main_list_view, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.main_list);
        textView.setText(list.get(position).getTitle());

        TextView textView1 = (TextView) convertView.findViewById(R.id.hidden);
        textView1.setText(list.get(position).getName().toString());

        convertView.setTag(position);

        return convertView;
    }



}