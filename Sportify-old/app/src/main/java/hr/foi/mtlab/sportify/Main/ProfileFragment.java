package hr.foi.mtlab.sportify.Main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.squareup.picasso.Picasso;

import hr.foi.mtlab.sportify.R;

/**
 * Created by Alen on 3.5.2016..
 */
public class ProfileFragment extends android.support.v4.app.Fragment {
    private  static  final String ARG_COLUMN_COUNT = "column-count";
    private OnListFragmentInteractionListener mListener;


    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(int position) {
        ProfileFragment profileFragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, position);
        profileFragment.setArguments(args);
        return profileFragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getContext());
        View view = inflater.inflate(R.layout.fragment_profile, container ,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DisplayUsername();
        DisplayProfilePicture();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    public void DisplayUsername(){
        TextView usernameTxt = (TextView) getView().findViewById(R.id.txtProfileName);
        Profile prof = Profile.getCurrentProfile();
        if(prof != null)
            usernameTxt.setText(prof.getName());
    }

    public void DisplayProfilePicture(){
        ImageView userImg = (ImageView) getView().findViewById(R.id.ivProfileUser);
        Profile prof = Profile.getCurrentProfile();
        if(prof != null)
            Picasso.with(getActivity()).load(prof.getProfilePictureUri(0, 300)).into(userImg);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
