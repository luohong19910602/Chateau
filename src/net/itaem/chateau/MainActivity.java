package net.itaem.chateau;

import net.itaem.chateau.activity.about.AboutActivity;
import net.itaem.chateau.activity.help.HelpActivity;
import net.itaem.chateau.activity.login.LoginActivity;
import net.itaem.chateau.activity.order.OrderActivity;
import net.itaem.chateau.activity.password.GetVerificationCodeActivity;
import net.itaem.chateau.activity.personinfo.PersonalActivity;
import net.itaem.chateau.activity.personinfo.PersonalCollectionActivity;
import net.itaem.chateau.activity.personinfo.PersonalMyCartActivity;
import net.itaem.chateau.activity.personinfo.PersonalShoppingAddressActivity;
import net.itaem.chateau.activity.register.RegisterActivity;
import net.itaem.chateau.activity.shopping.ProductDetailActivity;
import net.itaem.chateau.activity.shopping.ProductGraphicDetailActivity;
import net.itaem.chateau.activity.shopping.ProductListActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * */
public class MainActivity extends Activity {

	ListView activityList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		activityList = (ListView) findViewById(R.id.activityList);
	    
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"帮助", "关于", 
				"商品列表", "商品详情", "我的订单", "个人中心", "我的收藏", "收货地址", "我的购物车", "商品图文详情", "登录", "注册", "找回密码"});
		activityList.setAdapter(adapter);
		
		activityList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = null;
				
				if(position == 0){
					intent = new Intent(MainActivity.this, HelpActivity.class);
				}else if(position == 1){
					intent = new Intent(MainActivity.this, AboutActivity.class);
				}else if(position == 2){
					intent = new Intent(MainActivity.this, ProductListActivity.class);
				}else if(position == 3){
					intent = new Intent(MainActivity.this, ProductDetailActivity.class);
				}else if(position == 4){
					intent = new Intent(MainActivity.this, OrderActivity.class);
				}else if(position == 5){
					intent = new Intent(MainActivity.this, PersonalActivity.class);
				}else if(position == 6){
					intent = new Intent(MainActivity.this, PersonalCollectionActivity.class);
				}else if(position == 7){
					intent= new Intent(MainActivity.this, PersonalShoppingAddressActivity.class);
				}else if(position == 8){
					intent= new Intent(MainActivity.this, PersonalMyCartActivity.class);
				}else if(position == 9){
					intent= new Intent(MainActivity.this, ProductGraphicDetailActivity.class);
				}else if(position == 10){
					intent = new Intent(MainActivity.this, LoginActivity.class);
				}else if(position == 11){
					intent = new Intent(MainActivity.this, RegisterActivity.class);
				}else if(position == 12){
					intent = new Intent(MainActivity.this, GetVerificationCodeActivity.class);
				}
				startActivity(intent);
			}
		    
		});
		
	}
}
