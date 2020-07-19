package techSavvy.its;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    Context ctx;
    String name[];
    int logo[];
    LayoutInflater inflter1;

    public MyAdapter(Context ctx, int[] logo, String name[]) {

        this.ctx=ctx;
        this.logo=logo;
        this.name=name;
        inflter1 = (LayoutInflater.from(ctx));
    }

    @Override
    public int getCount() {
        return logo.length;

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
    public View getView(int position, View v, ViewGroup parent) {

        v = inflter1.inflate(R.layout.mylayout,null); // inflate the layout
        ImageView icon = (ImageView) v.findViewById(R.id.myimage);
        TextView tx = (TextView) v.findViewById(R.id.mytext);
        icon.setImageResource(logo[position]);
        tx.setText(name[position]);
        return v;
    }

}
