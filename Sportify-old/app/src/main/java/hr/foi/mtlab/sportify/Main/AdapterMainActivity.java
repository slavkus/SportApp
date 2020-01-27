package hr.foi.mtlab.sportify.Main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hr.foi.mtlab.sportify.R;
import hr.foi.mtlab.sportify.dummy.DataItemNotification;
import hr.foi.mtlab.sportify.dummy.DataItemTimeline;


/**
 * Created by Alen on 21.5.2016..
 */

public class AdapterMainActivity extends RecyclerView.Adapter <AdapterMainActivity.MainViewHolder> {

    private int notification ;
    private static final int TYPE_TIMELINE = 0;
    private static final int TYPE_NOTIFICATION = 1;
    private LayoutInflater inflater;
    List<DataItemNotification> dataNotification;
    List<DataItemTimeline> dataTimeline;
    NotificationItemInterface notifListener;
    TimelineItemInterface timelineListener;

    public AdapterMainActivity(Context context, List<DataItemTimeline> dataTimeline, TimelineItemInterface listener){
        inflater = LayoutInflater.from(context);
        this.dataTimeline = dataTimeline;
        this.timelineListener = listener;
    }

    public AdapterMainActivity(Context context, List<DataItemNotification> dataNotification, int notification, NotificationItemInterface listener){
        inflater = LayoutInflater.from(context);
        this.dataNotification = dataNotification;
        this.notification = notification;
        this.notifListener = listener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainViewHolder holder;
        switch (viewType){

            case TYPE_TIMELINE:{
                View view = inflater.inflate(R.layout.timeline_list_item,parent, false);
                holder = new TimelineViewHolder(view);
                return holder;
            }
            case TYPE_NOTIFICATION:{
                View view = inflater.inflate(R.layout.notification_list_item,parent,false);
                holder = new NotificationViewHolder(view);
                return holder;
            }

        }
        return null;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        if (holder.getItemViewType()== TYPE_TIMELINE){
            TimelineViewHolder tholder = (TimelineViewHolder) holder;
            DataItemTimeline current = dataTimeline.get(position);
            tholder.date.setText(current.date);
            tholder.month.setText(current.month);
            tholder.event_sport.setText(current.event_sport);
            tholder.sport.setImageResource(current.sportId);
            tholder.titles.setText(current.titles);
            tholder.bind(current, timelineListener);
        }
        else{
            NotificationViewHolder nholder = (NotificationViewHolder) holder;
            DataItemNotification current = dataNotification.get(position);
            nholder.date.setText(current.date);
            nholder.month.setText(current.month);
            nholder.notificationText.setText(current.notificationText);
            nholder.profil_pic.setImageResource(current.profilId);
            nholder.bind(current, notifListener);
        }
    }


    @Override
    public int getItemCount() {
        if (notification==1)
            return dataNotification.size();
        return dataTimeline.size();
    }


    @Override
    public int getItemViewType(int position) {
        return (notification ==0 ? TYPE_TIMELINE : TYPE_NOTIFICATION );
    }

    public class TimelineViewHolder extends  MainViewHolder{
        TextView date;
        TextView month;
        TextView event_sport;
        ImageView sport;
        TextView titles;
        public TimelineViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.txtDay);
            month = (TextView) itemView.findViewById(R.id.txtMonth);
            event_sport = (TextView) itemView.findViewById(R.id.txtSport);
            titles = (TextView) itemView.findViewById(R.id.txtEventTitle);
            sport = (ImageView) itemView.findViewById(R.id.ivBackImage);

        }
        public void bind(final DataItemTimeline timelineItem, final TimelineItemInterface listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onTimelineItemClick(timelineItem);
                }
            });
        }
    }

    public class NotificationViewHolder extends MainViewHolder {
        TextView date;
        TextView month;
        TextView notification;
        TextView notificationText;
        ImageView profil_pic;
        public NotificationViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.txtDay);
            month = (TextView) itemView.findViewById(R.id.txtMonth);
            notification =(TextView) itemView.findViewById(R.id.notifTxtNotification);
            notificationText = (TextView) itemView.findViewById(R.id.notifTxtNotification);
            profil_pic = (ImageView) itemView.findViewById(R.id.imageView3);
        }

        public void bind(final DataItemNotification notification, final NotificationItemInterface listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnNotifItemClick(notification);
                }
            });
        }
    }

    public class MainViewHolder extends  RecyclerView.ViewHolder{
        public MainViewHolder(View itemView) {
            super(itemView);

        }
    }
}