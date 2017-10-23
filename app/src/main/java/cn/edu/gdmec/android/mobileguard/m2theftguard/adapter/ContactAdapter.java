package cn.edu.gdmec.android.mobileguard.m2theftguard.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.edu.gdmec.android.mobileguard.R;
import cn.edu.gdmec.android.mobileguard.m2theftguard.entity.ContactInfo;

/**
 * Created by Administrator on 2017/10/19.
 */

public class ContactAdapter extends BaseAdapter{
    private List<ContactInfo> contactInfos;
    private Context context;
    public ContactAdapter(List<ContactInfo> contactInfos,Context context) {
        super();
        this.contactInfos = contactInfos;
        this.context = context;
    }

    public int getCount() {
        return contactInfos.size();
    }

    public Object getItem(int i) {
        return contactInfos.get(i);
    }

    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = View.inflate(context, R.layout.item_list_contact_select, null);
            holder = new ViewHolder();
            holder.mNameTv = (TextView) view.findViewById(R.id.tv_name);
            holder.mPhoneTv = (TextView) view.findViewById(R.id.tv_phone);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.mNameTv.setText(contactInfos.get(i).name);
        holder.mPhoneTv.setText(contactInfos.get(i).phone);
        return view;
    }

    static class ViewHolder{
        TextView mNameTv;
        TextView mPhoneTv;
    }

}
