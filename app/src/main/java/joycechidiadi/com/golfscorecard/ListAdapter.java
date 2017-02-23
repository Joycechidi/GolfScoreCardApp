package joycechidiadi.com.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    private  final Context mContext;
    private final Hole[] Holes;

    public  ListAdapter (Context context, Hole[] holes) {
        mContext = context;
        Holes = holes;
    }
    @Override
    public int getCount() {
        return Holes.length;
    }

    @Override
    public Object getItem(int position) {
        return Holes[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;//Not implemented
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final  ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.holeLabel = (TextView) convertView.findViewById(R.id.holeLabel);
            holder.strokeCount = (TextView) convertView.findViewById(R.id.strokeCount);
            holder.removeStrokeButton = (Button) convertView.findViewById(R.id.removeStrokeButton);
            holder.addStrokeButton = (Button) convertView.findViewById(R.id.addStrokeButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.holeLabel.setText(Holes[position].getLabel());
        holder.strokeCount.setText(Holes[position].getStrokeCount());
        holder.removeStrokeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int updatedStrokeCount = Holes[position].getStrokeCount() - 1;
                if (updatedStrokeCount < 0) updatedStrokeCount = 0;
                Holes[position].setStrokeCount(updatedStrokeCount);
                holder.strokeCount.setText(updatedStrokeCount + "");
            }
        });
        holder.addStrokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedSrokeCount = Holes[position].getStrokeCount() + 1;
                Holes[position].setStrokeCount(updatedSrokeCount);
                holder.strokeCount.setText(updatedSrokeCount + "");
            }
        });
        return convertView;
    }
    private static class ViewHolder {
        TextView holeLabel;
        TextView strokeCount;
        Button removeStrokeButton;
        Button addStrokeButton;
    }
}
