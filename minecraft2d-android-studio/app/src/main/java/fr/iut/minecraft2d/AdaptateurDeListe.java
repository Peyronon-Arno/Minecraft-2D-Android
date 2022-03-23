package fr.iut.minecraft2d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Adapter for the part 'list of objects'
 */
public class AdaptateurDeListe extends ArrayAdapter<String> {

    /**
     * List which contains all the items
     */
    private final Integer[] imageList = {
            R.drawable.grass,
            R.drawable.dirt,
            R.drawable.stone,
            R.drawable.bedrock,
            R.drawable.leaves,
            R.drawable.wood,
    };

    /**
     * Constructor of the Adapter
     * @param context used
     * @param values list of objects
     */
    public AdaptateurDeListe(Context context, String[] values) {
        super(context, R.layout.text_row_item, values);
    }

    /**
     * Equals foreach, foreach items in list, display a text view with an imageview
     * @param position of the element treated
     * @param convertView .
     * @param parent .
     * @return one row
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.text_row_item, parent, false);

        //Get TextView and ImageView
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        //Get the position and set the text at the good position, then image and text are in couple
        textView.setText(getItem(position));
        if(convertView == null )
            imageView.setImageResource(imageList[position]);
        else
            rowView = (View)convertView;
        //Return a row (image + text)
        return rowView;
    }



}