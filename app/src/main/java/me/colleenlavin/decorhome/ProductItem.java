package me.colleenlavin.decorhome;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;
import com.squareup.picasso.Picasso;
import com.usebutton.sdk.ButtonDropin;

import java.util.List;

/**
 * Project: DecorHome
 * Written by: mastrgamr
 * Date: 6/11/17
 */

public class ProductItem extends AbstractItem<ProductItem, ProductItem.ViewHolder> {

    public String name;
    public String description;
    public String imgUrl;

    public ProductItem withName(String name) {
        this.name = name;
        return this;
    }

    public ProductItem withDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductItem withImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.product_item;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.product_item;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ViewHolder viewHolder, List<Object> payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);

        //bind our data
        //set the text for the name
        viewHolder.name.setText(name);
        viewHolder.description.setText(description);

        Picasso.with(viewHolder.itemView.getContext()).load(imgUrl).fit().centerInside().into(viewHolder.productImg);

//        final ButtonContext context = ButtonContext.withSubjectLocation(new Location("Feast", 40.7325654,-73.9902567));
//        context.setUserLocation(new Location("Button HQ", 40.7382752, -73.9822849));
//        viewHolder.dropIn.prepareForDisplay(context, new ButtonDropin.Listener() {
//            @Override
//            public void onPrepared(final boolean isReady) {
//                System.out.println("prepped");
//            }
//
//            @Override
//            public void onClick(ButtonDropin buttonDropin) {
//                System.out.println("clicked");
//            }
//        });
    }

    //reset the view here (this is an optional method, but recommended)
    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.name.setText(null);
        holder.description.setText(null);
        holder.dropIn = null;
    }

    //Init the viewHolder for this Item
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView description;
        protected ImageView productImg;
        protected ButtonDropin dropIn;

        public ViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.item_image_name);
            this.description = (TextView) view.findViewById(R.id.item_image_description);
            this.productImg = (ImageView) view.findViewById(R.id.product_img);
            this.dropIn = (ButtonDropin) view.findViewById(R.id.main_dropin);
        }
    }
}
