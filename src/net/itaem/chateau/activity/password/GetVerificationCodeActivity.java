package net.itaem.chateau.activity.password;

import net.itaem.chateau.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 获取验证码
 * */
public class GetVerificationCodeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forget_password_first_step);
		Button btn = (Button) findViewById(R.id.sendVerificationBtn);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    Intent intent = new Intent(GetVerificationCodeActivity.this, ValidateVodeActivity.class);
			    startActivity(intent);
			}
		});
	}
    
}

