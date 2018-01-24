package org.androidtown.dumdumtest2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TouristSpotCardAdapter extends ArrayAdapter<TouristSpot> {

    public TouristSpotCardAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        ViewHolder holder;

        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.item_tourist_spot_card, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        TouristSpot spot = getItem(position);

        holder.category.setText(spot.category);
        holder.title.setText(spot.title);
        holder.gukhwa.setText( spot.gukhwa );
        holder.contents.setText( spot.contents );
        //Glide.with(getContext()).load(spot.url).into(holder.image);


        return contentView;
    }

    private static class ViewHolder {
        public TextView category;
        public TextView title;
        public TextView gukhwa;
        public TextView contents;
        public ImageView image;

        public ViewHolder(View view) {
            this.category = (TextView) view.findViewById(R.id.category);
            this.title = (TextView) view.findViewById(R.id.title);
            this.gukhwa = (TextView) view.findViewById(R.id.gukhwa);
            this.contents = (TextView) view.findViewById(R.id.contents);
            //this.image = (ImageView) view.findViewById(R.id.item_tourist_spot_card_image);




        }
    }

}

