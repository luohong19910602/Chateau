package net.itaem.chateau.activity.personinfo;

import java.io.ByteArrayOutputStream;

import net.itaem.chateau.BaseActivity;
import net.itaem.chateau.R;
import net.itaem.chateau.activity.personinfo.view.ClipImageLayout;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PersonalImageClipActivity extends BaseActivity implements OnClickListener{

	private ClipImageLayout mClipImageLayout;
	
	private Button btnCancel,btnOk;
	
	public static boolean isHeadImage=false;
	
	
	/***
	 * 从Intent获取图片路径的KEY
	 */
	public static final String KEY_PHOTO_PATH = "photo_path";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		setContentView(R.layout.util_personal_clip_image);
		super.onCreate(savedInstanceState); 
		setHeadInfo();
		
		System.out.println("进入PersonalImageClipActivity");
		initCompoments();
		mClipImageLayout = (ClipImageLayout) findViewById(R.id.id_clipImageLayout);
		 
		System.out.println("结束PersonalImageClipActivity");

	}
	
	
	public void setHeadInfo(){
		 setMainTitle("Personal Center");
		 setSubTitle("MOVE AND ZOOM");
		 setActionBarLeftImage(R.drawable.btn_left);
		 
	}
	
	public void initCompoments(){
		
		System.out.println("得到的imagepath："+getIntent().getStringExtra(KEY_PHOTO_PATH));
		btnCancel=(Button) findViewById(R.id.personal_clip_image_btn_cancel);
		btnOk=(Button) findViewById(R.id.personal_clip_image_btn_ok);
		
		btnCancel.setOnClickListener(this);
		btnOk.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		 
		switch (v.getId()) {
		
		case R.id.personal_clip_image_btn_ok:
			
			Bitmap bitmap = mClipImageLayout.clip();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
			byte[] datas = baos.toByteArray();
			
			Intent intent = new Intent(this, PersonalActivity.class);
			intent.putExtra("bitmap", datas);
			intent.putExtra("isHeadImage", isHeadImage);
			startActivity(intent);
			break;
			
		case R.id.personal_clip_image_btn_cancel:
			startActivity(new Intent(this, PersonalActivity.class));
			finish();
			break;
 
		}
		
	}
}
