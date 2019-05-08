package com.example.tm;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import android.content.Context;
public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<dataModel> foodsList;

    public CustomAdapter(Context context, int layout, ArrayList<dataModel> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtName, txtPrice,txd;
        Spinner dis;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txd = (TextView) row.findViewById(R.id.type);
            holder.txtName = (TextView) row.findViewById(R.id.name);
            holder.txtPrice = (TextView) row.findViewById(R.id.version_number);
            holder.imageView = (ImageView) row.findViewById(R.id.item_info);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        dataModel foodd = foodsList.get(position);

        holder.txd.setText(foodd.getDistrict());
        holder.txtName.setText(foodd.getPlace());
        holder.txtPrice.setText(foodd.getDescr());

        byte[] foodImage = foodd.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
        /*extends ArrayAdapter<dataModel> implements View.OnClickListener{

    private ArrayList<dataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView info;
    }



    public CustomAdapter(ArrayList<dataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;
    }


    @Override
    public void onClick(View v) {


        int position=(Integer) v.getTag();
        Object object= getItem(position);
        dataModel dataModel=(dataModel)object;


        switch (v.getId())
        {

            case R.id.item_info:

//                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();

                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        dataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;


        viewHolder.txtName.setText(dataModel.getPlace());
        viewHolder.txtType.setText(dataModel.getDistrict());
        viewHolder.txtVersion.setText(dataModel.getDescr());
        //  viewHolder.txtVersion.setText(dataModel.getVersion_number());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }

}*/
