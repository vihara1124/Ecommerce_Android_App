package com.vihara.ecommerce_app;

        import android.graphics.Color;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.List;

public class GridItemLayoutAdapter extends BaseAdapter {

    List<HorizontalItemScrollModel> horizontalItemScrollModelList;

    public GridItemLayoutAdapter(List<HorizontalItemScrollModel> horizontalItemScrollModelList) {
        this.horizontalItemScrollModelList = horizontalItemScrollModelList;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item_layout,null);

            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            ImageView itemImage = view.findViewById(R.id.h_s_item_image);
            TextView itemTitle = view.findViewById(R.id.h_s_item_title);
            TextView itemDescription = view.findViewById(R.id.h_s_item_description);
            TextView itemPrice = view.findViewById(R.id.h_s_item_price);


            itemImage.setImageResource(horizontalItemScrollModelList.get(position).getItemImage());
            itemTitle.setText(horizontalItemScrollModelList.get(position).getItemTitle());
            itemDescription.setText(horizontalItemScrollModelList.get(position).getItemDescription());
            itemPrice.setText(horizontalItemScrollModelList.get(position).getItemPrice());

        }else{
            view = convertView;
        }
        return view;
    }
}
