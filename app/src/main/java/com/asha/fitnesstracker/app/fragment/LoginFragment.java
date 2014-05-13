package com.asha.fitnesstracker.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.asha.fitnesstracker.app.R;
import com.asha.fitnesstracker.app.activities.MainScreen;
import com.asha.fitnesstracker.app.misc.NoticePagerListener;
import com.facebook.*;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;

import java.util.Arrays;

public class LoginFragment extends Fragment {
    private static final String URL_PREFIX_FRIENDS = "https://graph.facebook.com/me/friends?access_token=";
    private static final String TAG = "LoginFragmrnt";

    private Button buttonLoginLogout;
    //private Session.StatusCallback statusCallback = new SessionStatusCallback();

    private UiLifecycleHelper uiHelper;

    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };
    private boolean isToastShown = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        uiHelper = new UiLifecycleHelper(getActivity(), callback);
        uiHelper.onCreate(savedInstanceState);

        buttonLoginLogout = (Button) view.findViewById(R.id.buttonLoginLogout);

        LoginButton authButton = (LoginButton) view.findViewById(R.id.authButton);
        authButton.setFragment(this);
        authButton.setReadPermissions(Arrays.asList("user_likes", "user_status"));

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiHelper = new UiLifecycleHelper(getActivity(), callback);
        uiHelper.onCreate(savedInstanceState);
    }

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            Log.i(TAG, "Logged in...");
            Intent i = new Intent(getActivity(),MainScreen.class);
            getActivity().finish();
            startActivity(i);
           /* if (!isToastShown)
                getUserInfo(session);*/
        } else if (state.isClosed()) {
            Log.i(TAG, "Logged out...");
            Intent i = new Intent(getActivity(),MainScreen.class);
            getActivity().finish();
            startActivity(i);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Session session = Session.getActiveSession();
        if (session != null &&
                (session.isOpened() || session.isClosed()) ) {
            onSessionStateChange(session, session.getState(), null);
        }

        uiHelper.onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    private void getUserInfo(Session session) {
        Request.executeMeRequestAsync(session,new Request.GraphUserCallback() {
            @Override
            public void onCompleted(GraphUser user, Response response) {
                Toast.makeText(getActivity(),
                        "You are now logged in as " + user.getFirstName() + " " + user.getLastName(),
                        Toast.LENGTH_SHORT).show();
                isToastShown = true;

               /* Intent i = new Intent(getActivity(),MainScreen.class);
//                getActivity().finish();
                startActivity(i);*/

                
            }
        });
    }
}