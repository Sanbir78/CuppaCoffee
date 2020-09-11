package android.example.cuppacoffee;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListView extends ArrayAdapter<String> {
          private String[] names;
          private  String[] prices;
          private Integer[] images;
          private Activity context;
    public CustomListView(Activity context, String[] names,String[] prices,Integer[] images) {
        super(context, R.layout.list_view,names);
        this.context=context;
        this.names=names;
        this.prices=prices;
        this.images=images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder=null;
        if (r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.list_view,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) r.getTag();
        }
        viewHolder.ivw.setImageResource(images[position]);

        viewHolder.tvw1.setText(names[position]);
        viewHolder.tvw2.setText(prices[position]);

        return r;
    }
    static class ViewHolder{
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
       Button cart;
        ViewHolder(View v)
        {
            tvw1=v.findViewById(R.id.type);
            tvw2=v.findViewById(R.id.dollars);
            ivw=v.findViewById(R.id.imageVI);
            cart=v.findViewById(R.id.add_cart);

        }
    }
}
