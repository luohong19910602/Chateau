package net.itaem.chateau.activity.personinfo;

 
import net.itaem.chateau.R;
import net.itaem.chateau.activity.personinfo.view.SelectPicActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class PersonalActivity extends Activity implements OnClickListener{

	//个人头像 背景，和个人头像
	private ImageView personal_image_bg,personal_head_image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person_activity_personal);
		initCompoments();
	}

	/*
	 * 初始化组件
	 */
	public void initCompoments(){
		personal_image_bg=(ImageView) findViewById(R.id.personal_bg_image);
		personal_head_image=(ImageView) findViewById(R.id.personal_head_image);
		
		personal_image_bg.setOnClickListener(this);
		personal_head_image.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		 
		switch(v.getId()){
		
		case R.id.personal_bg_image:
				startActivity(new Intent(this, SelectPicActivity.class));
			break;
		
		case R.id.personal_head_image:
			startActivity(new Intent(this, SelectPicActivity.class));
			break;
		}
		
	}
}
