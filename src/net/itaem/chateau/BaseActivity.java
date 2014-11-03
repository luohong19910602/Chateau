package net.itaem.chateau;

import net.itaem.chateau.activity.about.AboutActivity;
import net.itaem.chateau.activity.help.HelpActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


/*
 * 要使用baseActivity 必须把
 * super.onCreate(savedInstanceState);
 * 放在setContentView() 犯法的下面
 * 
 */
public class BaseActivity  extends Activity {

	
	protected LinearLayout layoutRightMenu;
	
	protected int MAX_WIDTH=0;			//菜单宽度
	
	protected final int SPEED = 30;		//显示速度
	
	
	protected ImageView wineStartingBtn,settingBtn,addWineBtn,wifiBtn,onlineStoreBtn,
					  helpBtn,aboutBtn;
	protected ImageView showRightMenuBtn,hideRightMenuBtn,leftImageviewBtn;
	
	private TextView mainTitle,subTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initRightMenuCompoments();
		initActionBarCompoments();
		
		
		
		//获取屏幕的11/20宽度
		MAX_WIDTH=getWindowManager().getDefaultDisplay().getWidth()*11/20;	

	}
	
	/*
	 * 设置actionbar 位置的标题
	 */
	public void setMainTitle(String str){
		mainTitle.setText(str);
	}
	
	
	/*
	 * 设置actionbar位置下面的子标题
	 */
	public void setSubTitle(String str){
		subTitle.setText(str);
	}
	
	/*
	 * 设置返回 键的图标
	 */
	public void setActionBarLeftImage(int id){
		leftImageviewBtn.setImageResource(id);
	}
	/*
	 * 初始化 右边菜单 
	 * 并且添加监听
	 */
	public void initRightMenuCompoments(){
		
		layoutRightMenu=(LinearLayout) findViewById(R.id.right_menu);
		
		//防止事件冒泡
		layoutRightMenu.setOnTouchListener(new OnTouchListener() {
		
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				 
				return true;
			}
		});
		
		
		wineStartingBtn=(ImageView) findViewById(R.id.wine_starting);	//不是我们的模块
		settingBtn=(ImageView) findViewById(R.id.setting);				//不是我们的模块
		addWineBtn=(ImageView) findViewById(R.id.add_wine);				//不是我们的模块
		wifiBtn=(ImageView) findViewById(R.id.wifi);					//不是我们的模块
	
		onlineStoreBtn=(ImageView) findViewById(R.id.online_store);
		helpBtn=(ImageView) findViewById(R.id.help);
		aboutBtn=(ImageView) findViewById(R.id.about);
		
		
		
		onlineStoreBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(BaseActivity.this, "暂时是未开发", Toast.LENGTH_SHORT).show();
			}
		});
		
		helpBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(BaseActivity.this,HelpActivity.class));
			}
		});
		aboutBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(BaseActivity.this,AboutActivity.class));
			}
		});
	}
	
	
 
	/*
	 * 初始化actionbar 组件
	 * 并且添加监听
	 */
	public void initActionBarCompoments(){
		showRightMenuBtn=(ImageView) findViewById(R.id.action_bar_right_imageview);
		hideRightMenuBtn=(ImageView) findViewById(R.id.hide_right_menu);
		leftImageviewBtn=(ImageView) findViewById(R.id.action_bar_left_imageview);
		
		mainTitle=(TextView) findViewById(R.id.action_bar_title);
		subTitle=(TextView) findViewById(R.id.action_bar_sub_title);
		
		showRightMenuBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("显示menu");
				showRightMenu();
			}
		});
		hideRightMenuBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("显示menu");
				hideRightMenu();
			}
		});
		
		leftImageviewBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			 finish();
			}
		});
 
	}
 
	/*
	 * 显示菜单
	 */
	public void showRightMenu(){
		new AsynMove().execute(-SPEED);
	}
	
	/*
	 * 隐藏菜单
	 */
	public void hideRightMenu() {
		new AsynMove().execute(SPEED);
	}

	
	public	class AsynMove extends AsyncTask<Integer, Integer, Void> {

 
 
		@Override
		protected Void doInBackground(Integer... params) {
			int times = 0;
 
			if (MAX_WIDTH % Math.abs(params[0]) == 0) 
				times = MAX_WIDTH / Math.abs(params[0]);
			else
				times = MAX_WIDTH / Math.abs(params[0]) + 1; 

			for (int i = 0; i < times; i++) {
				publishProgress(params[0]);
				try {
					 
					Thread.sleep(Math.abs(params[0]));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			return null;
		}
		

		/**
		 * update UI
		 */
		@Override
		protected void onProgressUpdate(Integer... values) {
			RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)
					layoutRightMenu.getLayoutParams();
			
			if (values[0] > 0) {
				layoutParams.leftMargin = Math.min(layoutParams.leftMargin
						+ values[0], 0);
			 
			} else {
				 
				layoutParams.leftMargin = Math.max(layoutParams.leftMargin
						+ values[0], -MAX_WIDTH);
			}
			layoutRightMenu.setLayoutParams(layoutParams);
		}
	}
}
