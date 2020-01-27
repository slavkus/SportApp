package hr.foi.mtlab.sportify.EventDetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hr.foi.mtlab.sportify.R;
import hr.foi.mtlab.sportify.dummy.DataItemPlayers;

/**
 * Created by TheSlavkusMaximus on 19/04/2017.
 */

public class AdapterEventDetails extends RecyclerView.Adapter<AdapterEventDetails.MainViewHolder> {

    List<DataItemPlayers> dataPlayers;
    private LayoutInflater inflater;

    public AdapterEventDetails(Context context, List<DataItemPlayers> dataTimeline){
        inflater = LayoutInflater.from(context);
        this.dataPlayers = dataPlayers;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainViewHolder holder;

                View view = inflater.inflate(R.layout.notification_list_item,parent,false);
                holder = new PlayersViewHolder(view);
                return holder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        PlayersViewHolder nholder = (PlayersViewHolder) holder;
        DataItemPlayers current = dataPlayers.get(position);
        nholder.playerNm.setText(current.playerName);
        nholder.profil_pic.setImageResource(current.profilId);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlayersViewHolder extends MainViewHolder {
        TextView player;
        TextView playerNm;
        ImageView profil_pic;
        public PlayersViewHolder(View itemView) {
            super(itemView);
            player =(TextView) itemView.findViewById(R.id.playerName);
            playerNm = (TextView) itemView.findViewById(R.id.playerName);
            profil_pic = (ImageView) itemView.findViewById(R.id.imageView3);
        }

    }

    public class MainViewHolder extends  RecyclerView.ViewHolder{
        public MainViewHolder(View itemView) {
            super(itemView);

        }
    }
}
