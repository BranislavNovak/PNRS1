package inc.company.list2_my_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by student on 27.3.2018.
 */

public class CharacterAdapter extends BaseAdapter{
    // na ovaj context crtamo (this)
    private Context mContext;
    private ArrayList<Model> mCharacters;
    // <inc.company.list2_my_application.Model> je klasa koja je kreirana i koja sadrzi image i text


    // konstruktor
    public CharacterAdapter(Context context) {
        mContext = context;
        mCharacters = new ArrayList<Model>();
    }

    // osvezava adapter i listu, poziva se uvek posle menjanja liste ili adaptera
    public void AddCharacter(Model model){
        mCharacters.add(model);
        notifyDataSetChanged();
    }

    // vraca koliko itema ima u isti, poziva se kada se kreira base adapter
    @Override
    public int getCount() {
        return mCharacters.size();
    }

    // vraca item
    @Override
    public Object getItem(int position) {
        Object rv = null;
        try{
            rv = mCharacters.get(position);
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return rv;
    }

    // vraca Id itema
    @Override
    public long getItemId(int position) {
        return position;
    }

    // povezujem row_item i listu  (gde hocemo da setujemo, view koji pravimo (row_item), grupa view-a u koji smestamo view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // inflater se koristi da se view koji je NULL obezbedimo da moze da se ubaci u listu
            convertView = inflater.inflate(R.layout.row_item, null);
            // klasa koja opisuje row_item sa dva polja kao u row_item-u
            ViewHolder holder = new ViewHolder();
            // convertView. ide jer pristupam u tacno odredjenom View-u u celom Parentu (koji sadrzi View-ove i time predstavlja View group)
            holder.image = (ImageView) convertView.findViewById(R.id.mImage);
            holder.name = (TextView) convertView.findViewById(R.id.mName);
            // setuje se Tag da bi se znalo koji se holder koristi
            convertView.setTag(holder);
        }

        Model model = (Model) getItem(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.image.setImageDrawable(model.mImage);
        holder.name.setText(model.mName);

        return convertView;
    }

    // opisuje row_item
    private class ViewHolder{
        public ImageView image = null;
        public TextView name = null;
    }
}
