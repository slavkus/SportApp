package hr.foi.mtlab.sportify.Facebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import hr.foi.mtlab.sportify.R;

public class FacebookLoginFragment extends Fragment {

    public FacebookLoginFragmentInterface mListenerActivity;
    private TextView mTextDetails;
    private CallbackManager mCallbackManager;
    private AccessTokenTracker mTokenTracker;
    private ProfileTracker mProfileTracker;
    private FacebookCallback<LoginResult> mFacebookCallback = new FacebookCallback<LoginResult>() {

        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.d("Slavkus & Tomi", "onSuccess");
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
            mTextDetails.setText(constructWelcomeMessage(profile));
            if (accessToken !=null){
                mListenerActivity.onFacebookLoginAttempted(true);
            }

        }




        @Override
        public void onCancel() {
            Log.d("Slavkus & Tomi", "onCancel");
        }

        @Override
        public void onError(FacebookException e) {
            if (Profile.getCurrentProfile()==null){
                mListenerActivity.onFacebookLoginAttempted(false);
            }
            Log.d("Slavkus & Tomi", "onError " + e);
        }
    };


    public FacebookLoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getContext());
        mCallbackManager = CallbackManager.Factory.create();
        setupTokenTracker();
        setupProfileTracker();

        mTokenTracker.startTracking();
        mProfileTracker.startTracking();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.facebook_login_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setupTextDetails(view);
        setupLoginButton(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        mTextDetails.setText(constructWelcomeMessage(profile));
    }

    @Override
    public void onStop() {
        super.onStop();
        mTokenTracker.stopTracking();
        mProfileTracker.stopTracking();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void setupTextDetails(View view) {
        mTextDetails = (TextView) view.findViewById(R.id.welcomemsg);
    }

    private void setupTokenTracker() {
        mTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
            /**@Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                Log.d("Slavkus & Tomi", "" + currentAccessToken);
            }*/
        };
    }

    private void setupProfileTracker() {
        mProfileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                Log.d("Slavkus & Tomi", "" + currentProfile);
                mTextDetails.setText(constructWelcomeMessage(currentProfile));
            }
        };
    }

    private void setupLoginButton(View view) {
        LoginButton mButtonLogin = (LoginButton) view.findViewById(R.id.login_button);
        mButtonLogin.setFragment(this);
        mButtonLogin.setReadPermissions("user_friends");
        mButtonLogin.registerCallback(mCallbackManager, mFacebookCallback);
    }

    private String constructWelcomeMessage(Profile profile) {
        StringBuffer stringBuffer = new StringBuffer();
        if (profile != null) {
            stringBuffer.append("Welcome " + profile.getName());
        }
        return stringBuffer.toString();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FacebookLoginFragmentInterface){
            mListenerActivity = (FacebookLoginFragmentInterface) context;
        }
        else mListenerActivity = null;
    }

}