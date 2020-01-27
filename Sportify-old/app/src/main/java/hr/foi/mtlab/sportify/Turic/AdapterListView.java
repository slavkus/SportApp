package hr.foi.mtlab.sportify.Turic;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import hr.foi.mtlab.sportify.R;

/**
 * Created by Zvjerka on 24.6.2017..
 */

public class AdapterListView extends ArrayAdapter<String> {
    String[] ime, prezime;
    int[] slika;
    Context cont;

    public AdapterListView(Context context, String[] imen, String[] prezimen, int[] slike) {
        super(context, R.layout.poljelist);

        this.ime = imen;
        this.prezime = prezimen;
        this.slika = slike;
        this.cont = context;
    }

    @Override
    public int getCount() {
        return ime.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        holder hold = new holder();
        if(convertView == null) {
            LayoutInflater inf = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.poljelist, parent, false);

            hold.PROFILNA = (ImageView) convertView.findViewById(R.id.slika_profilna_polje);
            hold.IME = (TextView) convertView.findViewById(R.id.ime_polje);
            hold.PREZIME = (TextView) convertView.findViewById(R.id.prezime_polje);

            convertView.setTag(hold);
        }else
            hold = (holder) convertView.getTag();

        hold.IME.setText(ime[position]);
        hold.PREZIME.setText(prezime[position]);
        hold.PROFILNA.setImageResource(slika[position]);

        return convertView;
    }

    public class holder{
        TextView IME, PREZIME;
        ImageView PROFILNA;

    }
}
