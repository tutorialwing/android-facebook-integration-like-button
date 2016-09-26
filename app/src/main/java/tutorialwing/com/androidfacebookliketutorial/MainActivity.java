package tutorialwing.com.androidfacebookliketutorial;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addLikeFragment();
	}

	private void addLikeFragment() {
		LikeFragment likeFragment = new LikeFragment();
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.add(R.id.facebook_like_button, likeFragment);
		fragmentTransaction.commit();
	}
}
