package com.example.yk.myapplication.EM;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.BaseAdapter;
import android.widget.ListView;


import com.example.yk.myapplication.EM.module.Message;

import java.util.List;

/**
 * Created by yk on 15/7/6.
 */
public class DoctorListView extends ListView {

    public DoctorListView(Context context, AttributeSet attrs) {
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


final  class DoctorAdapter extends BaseAdapter{

    private Context mContext = null;
    //    private String[] mHidden = null;
    private List<Message> list= null;

    public DoctorAdapter(Context context,List list1) {
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


        return convertView;
    }
}