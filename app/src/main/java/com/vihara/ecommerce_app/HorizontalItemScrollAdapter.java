package com.vihara.ecommerce_app;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.List;

public class HorizontalItemScrollAdapter  extends RecyclerView.Adapter<HorizontalItemScrollAdapter.ViewHolder> {

    private List<HorizontalItemScrollModel> horizontalItemScrollModelList;

    public HorizontalItemScrollAdapter(List<HorizontalItemScrollModel> horizontalItemScrollModelList) {
        this.horizontalItemScrollModelList = horizontalItemScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalItemScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalItemScrollAdapter.ViewHolder viewHolder, int position) {
        int resource = horizontalItemScrollModelList.get(position).getItemImage();
        String title = horizontalItemScrollModelList.get(position).getItemTitle();
        String description = horizontalItemScrollModelList.get(position).getItemDescription();
        String price = horizontalItemScrollModelList.get(position).getItemPrice();

        viewHolder.setItemImage(resource);
        viewHolder.setItemTitle(title);
        viewHolder.setItemDescription(description);
        viewHolder.setItemPrice(price);

    }

    @Override
    public int getItemCount() {
        return horizontalItemScrollModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView itemImage;
        private TextView itemTitle;
        private TextView itemDescription;
        private TextView itemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.h_s_item_image);
            itemTitle = itemView.findViewById(R.id.h_s_item_title);
            itemDescription = itemView.findViewById(R.id.h_s_item_description);
            itemPrice = itemView.findViewById(R.id.h_s_item_price);
        }

        private void setItemImage(int resource){
            itemImage.setImageResource(resource);
        }
        private void setItemTitle(String title){
            itemTitle.setText(title);
        }
        private void setItemDescription(String description){
            itemDescription.setText(description);
        }
        private void setItemPrice(String price){
            itemPrice.setText(price);
        }
    }
}

