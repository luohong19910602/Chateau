package net.itaem.chateau.activity.password;

import net.itaem.chateau.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 验证验证码activity
 * */
public class ValidateVodeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_password_second_step);

		Button btn = (Button) findViewById(R.id.nextBtn);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ValidateVodeActivity.this, SetNewPasswordActivity.class);
				startActivity(intent);
			}
		});
	}
}
