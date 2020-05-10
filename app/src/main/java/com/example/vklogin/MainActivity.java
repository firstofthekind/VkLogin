package com.example.vklogin;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.api.model.VKUsersArray;

public class MainActivity extends AppCompatActivity {
    private String[] scope = new String[]{VKScope.OFFLINE};
    private ListView listView;
    private TextView textView;
    private String userID;
    private ImageView userPic;
    private ImageView userPic1;
    private ImageView userPic2;
    private ImageView userPic3;
    private ImageView userPic4;
    private ImageView userPic5;
    private TextView userName;
    private TextView userName1;
    private TextView friendName1;
    private TextView friendName2;
    private TextView friendName3;
    private TextView friendName4;
    private TextView friendName5;
    View b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            if (!VKSdk.isLoggedIn()) {
                b = findViewById(R.id.button2);
                b.setVisibility(View.VISIBLE);
                b = findViewById(R.id.exitBtn);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.friendName5);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.friendName4);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.friendName3);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.friendName2);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.friendName1);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userName);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userName1);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userPic);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userPic1);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userPic2);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userPic3);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userPic4);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.userPic5);
                b.setVisibility(View.GONE);
            } else {
                enter();
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                enter();

                Toast.makeText(getApplicationContext(), "Authorised", Toast.LENGTH_LONG).show();
                textView = (TextView) findViewById(R.id.textView);
                textView.setText("Список из пяти друзей:");
                View b = findViewById(R.id.button2);
                b.setVisibility(View.GONE);
                b = findViewById(R.id.exitBtn);
                b.setVisibility(View.VISIBLE);
// Пользователь успешно авторизовался
            }

            int getMyId() {
                final VKAccessToken vkAccessToken = VKAccessToken.currentToken();
                return vkAccessToken != null ? Integer.parseInt(vkAccessToken.userId) : 0;
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(getApplicationContext(), "THAT WAS AN ERROR", Toast.LENGTH_LONG).show();
// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void authorise(View view) {
        VKSdk.login(this, scope);
    }

    public void logout(View view) {
        VKSdk.logout();
        View b = findViewById(R.id.button2);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.exitBtn);
        b.setVisibility(View.GONE);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Авторизуйтесь чтобы увидеть список друзей");
        b = findViewById(R.id.button2);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.exitBtn);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.friendName5);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.friendName4);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.friendName3);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.friendName2);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.friendName1);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userName1);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userName);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userPic);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userPic1);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userPic2);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userPic3);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userPic4);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.userPic5);
        b.setVisibility(View.GONE);
    }

    @SuppressLint("CutPasteId")
    public void enter() {
        userName = (TextView) findViewById(R.id.userName);
        userName1 = (TextView) findViewById(R.id.userName1);
        friendName1 = (TextView) findViewById(R.id.friendName1);
        friendName2 = (TextView) findViewById(R.id.friendName2);
        friendName3 = (TextView) findViewById(R.id.friendName3);
        friendName4 = (TextView) findViewById(R.id.friendName4);
        friendName5 = (TextView) findViewById(R.id.friendName5);

        userPic = (ImageView) findViewById(R.id.userPic);
        userPic1 = (ImageView) findViewById(R.id.userPic1);
        userPic2 = (ImageView) findViewById(R.id.userPic2);
        userPic3 = (ImageView) findViewById(R.id.userPic3);
        userPic4 = (ImageView) findViewById(R.id.userPic4);
        userPic5 = (ImageView) findViewById(R.id.userPic5);


        VKRequest request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "photo_50,first_name, last_name"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                VKList list = (VKList) response.parsedModel;
                userName.setText(list.get(0).toString());
            }

        });
        request = VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "photo_50"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                VKList list = (VKList) response.parsedModel;
                userName.setText(list.get(0).toString());
                String str = response.responseString;
                String resultStr = str.substring(str.indexOf("\"photo_50\":\"") + 12, str.indexOf("\"}") );
                String url = resultStr.replaceAll("\\\\", "");
                Picasso.get()
                        .load(url)
                        .into(userPic);

            }
        });
        request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "photo_50,first_name,last_name", VKApiConst.COUNT, "5"));
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                VKUsersArray array = (VKUsersArray) response.parsedModel;
                friendName1.setText(array.get(0).first_name + " " + array.get(0).last_name);
                friendName2.setText(array.get(1).first_name + " " + array.get(1).last_name);
                friendName3.setText(array.get(2).first_name + " " + array.get(2).last_name);
                friendName4.setText(array.get(3).first_name + " " + array.get(3).last_name);
                friendName5.setText(array.get(4).first_name + " " + array.get(4).last_name);
                Picasso.get()
                        .load(array.get(0).photo_50)
                        .into(userPic1);
                Picasso.get()
                        .load(array.get(1).photo_50)
                        .into(userPic2);
                Picasso.get()
                        .load(array.get(2).photo_50)
                        .into(userPic3);
                Picasso.get()
                        .load(array.get(3).photo_50)
                        .into(userPic4);
                Picasso.get()
                        .load(array.get(4).photo_50)
                        .into(userPic5);
            }
        });
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Список из пяти друзей:");
        textView = (TextView) findViewById(R.id.userName1);
        textView.setText("Вы вошли как:");
        b = findViewById(R.id.button2);
        b.setVisibility(View.GONE);
        b = findViewById(R.id.exitBtn);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.friendName5);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.friendName4);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.friendName3);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.friendName2);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.friendName1);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userName);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userName1);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userPic);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userPic1);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userPic2);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userPic3);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userPic4);
        b.setVisibility(View.VISIBLE);
        b = findViewById(R.id.userPic5);
        b.setVisibility(View.VISIBLE);
    }
}
