package me.colleenlavin.decorhome;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

/**
 * Project: DecorHome
 * Written by: mastrgamr
 * Date: 6/10/17
 */

public class SimpleItem extends AbstractItem<SimpleItem, SimpleItem.ViewHolder> {

    public String name;

    public SimpleItem withName(String name) {
        this.name = name;
        return this;
    }

    //The unique ID for this type of item
    @Override
    public int getType() {
        return R.id.simple_item;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.simple_item;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ViewHolder viewHolder, List<Object> payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);

        //bind our data
        //set the text for the name
        viewHolder.name.setText(name);
    }

    //reset the view here (this is an optional method, but recommended)
    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.name.setText(null);
    }

    //Init the viewHolder for this Item
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;

        public ViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.simple_text);
        }
    }
}
