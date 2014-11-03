package net.itaem.chateau.activity.personinfo;

import java.util.ArrayList;
import java.util.List;

import net.itaem.chateau.BaseActivity;
import net.itaem.chateau.R;
import net.itaem.chateau.activity.personinfo.adapter.PersonalMyCartAdapter;
import net.itaem.chateau.activity.personinfo.vo.PersonalMyCartVo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PersonalMyCartActivity  extends BaseActivity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setContentView(R.layout.person_activity_my_cart);
		super.onCreate(savedInstanceState);
		setHeadInfo();
		
		ImageView imageView=(ImageView) findViewById(R.id.action_bar_left_imageview);
		imageView.setImageResource(R.drawable.shopping_back);
		TextView text=(TextView) findViewById(R.id.action_bar_title);
		text.setText("ONLINE STORE");
		text.setVisibility(0);
		ListView listView=(ListView) findViewById(R.id.person_mycart_list);
		
		List<PersonalMyCartVo> list=new ArrayList<PersonalMyCartVo>();
		PersonalMyCartVo vo=null;
		for(int i=0;i<5;i++){
			vo=new PersonalMyCartVo("", "description", "name"+i, "200"+i, i, i%2==0);
			list.add(vo);
		}
		
		
		
		listView.setAdapter(new PersonalMyCartAdapter(this,list));
		
	}
	
	
	public void setHeadInfo(){
		 setMainTitle("ONLINE STORE");
		 setSubTitle("SHOPPING CART");
		 setActionBarLeftImage(R.drawable.shopping_back);
		 
	}
}
