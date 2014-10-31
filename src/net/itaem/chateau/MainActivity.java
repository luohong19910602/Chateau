package net.itaem.chateau;

import net.itaem.chateau.activity.about.AboutActivity;
import net.itaem.chateau.activity.help.HelpActivity;
import net.itaem.chateau.activity.order.OrderActivity;
import net.itaem.chateau.activity.shopping.ProductDetailActivity;
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
	    
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"帮助", "关于", "商品列表", "商品详情", "我的订单"});
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
				}
				
				startActivity(intent);
			}
		    
		});
		
	}
}
