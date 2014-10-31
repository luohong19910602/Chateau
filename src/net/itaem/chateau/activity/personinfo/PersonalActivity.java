package net.itaem.chateau.activity.personinfo;


import net.itaem.chateau.R;
import net.itaem.chateau.activity.order.OrderActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class PersonalActivity extends Activity implements OnClickListener{

	//个人头像 背景，和个人头像
	private ImageView personal_image_bg,personal_head_image;


	private RelativeLayout myOrder,myComments,myFavories,myCart,deliveryAddress;

	/**
	 * 选择文件
	 */
	public static final int TO_SELECT_PHOTO = 3;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person_activity_personal);
		initCompoments();


		byte[] b = getIntent().getByteArrayExtra("bitmap");

		if(b !=null){
			Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);

			if(getIntent().getBooleanExtra("isHeadImage",false) ){
				personal_head_image.setImageBitmap(bitmap);
			}else{
				personal_image_bg.setImageBitmap(bitmap);
			}
		}
	}

	/*
	 * 初始化组件
	 */
	public void initCompoments(){
		personal_image_bg=(ImageView) findViewById(R.id.personal_bg_image);
		personal_head_image=(ImageView) findViewById(R.id.personal_head_image);
		myOrder=(RelativeLayout)findViewById(R.id.personal_relative_layout_my_order);
		myComments=(RelativeLayout)findViewById(R.id.personal_relative_layout_my_comments);
		myFavories=(RelativeLayout)findViewById(R.id.personal_relative_layout_my_favorites);
		myCart=(RelativeLayout)findViewById(R.id.personal_relative_layout_my_carts);
		deliveryAddress=(RelativeLayout)findViewById(R.id.personal_relative_layout_delivery_address);;

		myOrder.setOnClickListener(this);
		myComments.setOnClickListener(this);
		myFavories.setOnClickListener(this);
		myCart.setOnClickListener(this);
		deliveryAddress.setOnClickListener(this);

		personal_image_bg.setOnClickListener(this);
		personal_head_image.setOnClickListener(this);
	}




	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()){

		case R.id.personal_head_image:
			PersonalImageClipActivity.isHeadImage=true;
			intent = new Intent();
			intent.setClass(this,SelectPicActivity.class);
			startActivityForResult(intent, TO_SELECT_PHOTO);
			Toast.makeText(this, "更换头像", Toast.LENGTH_SHORT).show();
			break;

		case R.id.personal_bg_image:
			PersonalImageClipActivity.isHeadImage=false;
			intent = new Intent();
			intent.setClass(this,SelectPicActivity.class);
			startActivityForResult(intent, TO_SELECT_PHOTO);
			Toast.makeText(this, "更换背景", Toast.LENGTH_SHORT).show();
			break;

		case R.id.personal_relative_layout_my_order:
			intent = new Intent(PersonalActivity.this, OrderActivity.class);
			startActivity(intent);
			break;

		case R.id.personal_relative_layout_my_comments:

			break;

		case R.id.personal_relative_layout_my_favorites:
			startActivity(new Intent(this, PersonalCollectionActivity.class));
			break;

		case R.id.personal_relative_layout_my_carts:
			startActivity(new Intent(this, PersonalMyCartActivity.class));
			break;

		case R.id.personal_relative_layout_delivery_address:
			startActivity(new Intent(this, PersonalShoppingAddressActivity.class));
			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == TO_SELECT_PHOTO && resultCode==Activity.RESULT_OK) {

			String	picPath = data.getStringExtra(SelectPicActivity.KEY_PHOTO_PATH);


			System.out.println("接受到返回activity消息" + picPath);

		}
	}


}
