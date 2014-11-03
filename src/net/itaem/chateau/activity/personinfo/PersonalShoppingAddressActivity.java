package net.itaem.chateau.activity.personinfo;

import net.itaem.chateau.BaseActivity;
import net.itaem.chateau.R;
import android.app.Activity;
import android.os.Bundle;

public class PersonalShoppingAddressActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.personal_shopping_address);
		super.onCreate(savedInstanceState);
		
		setHeadInfo();
	}
	
	public void setHeadInfo(){
		 setMainTitle("Personal Center");
		 setSubTitle("DELIVERY ADDRESS");
		 setActionBarLeftImage(R.drawable.btn_left);
		 
	}
}
