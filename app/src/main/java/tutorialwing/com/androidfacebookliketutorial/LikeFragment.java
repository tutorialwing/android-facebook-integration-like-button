package tutorialwing.com.androidfacebookliketutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.widget.LikeView;

public class LikeFragment extends Fragment {

	private CallbackManager callbackManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Initialize facebook SDK.
		FacebookSdk.sdkInitialize(getActivity().getApplicationContext());

		// Create a callbackManager to handle the login responses.
		callbackManager = CallbackManager.Factory.create();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_like, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setLikeButton(view);
	}

	private void setLikeButton(View view) {
		LikeView likeView = (LikeView) view.findViewById(R.id.likeView);
		likeView.setLikeViewStyle(LikeView.Style.STANDARD);
		likeView.setFragment(this);
		likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);

		String pageUrlToLike = "https://www.facebook.com/FacebookDevelopers";
		likeView.setObjectIdAndType(pageUrlToLike, LikeView.ObjectType.PAGE);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// Call callbackManager.onActivityResult to pass login result to the LoginManager via callbackManager.
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}
}