package net.itaem.chateau.activity.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.itaem.chateau.R;
import net.itaem.chateau.entity.Order;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * 我的订单activity
 * 我的订单一共有五个状态：
 * 
 * 未付款
 * 已付款，未发货
 * 已付款，已发货
 * 已收到货
 * 已取消
 * 
 * 这5个状态都是类似的activity，界面元素基本相同，所以这里使用一个activity来表示5个状态，根据订单状态，来显示不同的界面元素
 * */
public class OrderActivity extends Activity {

	private ListView listView;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.order_activity);

		listView = (ListView) findViewById(R.id.order_list);



		//构建3个订单，每个订单5个商品的数据
		List<OrderVo> orderVoList = new ArrayList<OrderVo>();
		for(int j=0; j<5; j++){

			OrderVo orderVo = new OrderVo();

			orderVo.setOrderId("44512510251545");
			orderVo.setNumber("4416221992");
			orderVo.setTime("2014-10-10");
			orderVo.setStoreName("OFFICIAL STORE");
			orderVo.setInflaterFlag(OrderVo.ORDER_INFO);			
			
			orderVoList.add(orderVo);
			

			//5个商品
			for(int i=0; i<2; i++){
				OrderVo product1 = new OrderVo();

				product1.setProductId("12120215");
				product1.setProductMoney(1000);
				product1.setProductName("iSomm");
				product1.setProductPicture("www.hao123.com");
				product1.setProductRemark("this is the remark");
				product1.setInflaterFlag(OrderVo.PRODUCT_INFO);

				orderVoList.add(product1);
			}

			//钱和按钮
			OrderVo money = new OrderVo();
			money.setMoney(5000);
			money.setFreight(1000);
			money.setInflaterFlag(OrderVo.ORDER_MONEY_AND_BUTTON_INFO);
			if(j == 0){
				money.setFlag(Order.OERDER_CANCEL);
			}
			if(j == 1){
				money.setFlag(Order.OERDER_NOT_PAY);
			}
			if(j == 2){
				money.setFlag(Order.OERDER_PAY_SEND);
			}
			
			if(j == 3){
				money.setFlag(Order.OERDER_RECIEVE);
			}
			
			if(j == 4){
				money.setFlag(Order.OERDER_PAY_NOT_SEND);
			}
			orderVoList.add(money);
		}

		if(listView != null){   //
			OrderAdapter oa = new OrderAdapter(this);
			oa.setOrderVoList(orderVoList);  //设置订单

			listView.setAdapter(oa);
		}

	}

	/**
	 * 这是adapter
	 * */
	private class OrderAdapter extends BaseAdapter{
		private LayoutInflater inflater;
		private List<OrderVo> orderVoList;

		public void setOrderVoList(List<OrderVo> orderVoList) {
			this.orderVoList = orderVoList;
		}

		public OrderAdapter(Context context){
			inflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			return orderVoList.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		/**
		 * 从这里获得order item
		 * 因为order item中包含adapter，所以这里需要嵌套adapter
		 * */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			//加载这个界面
			View view = null;
			/**
			 * 根据当前的order vo来判断加载的xml文件
			 * */
			OrderVo ov = orderVoList.get(position);
			switch(ov.getInflaterFlag()){
			case OrderVo.ORDER_INFO:  //订单基本信息
				view = inflater.inflate(R.layout.order_info, null);
				break;
			case OrderVo.PRODUCT_INFO:   //商品信息
				view = inflater.inflate(R.layout.order_product, null);
				break;
			case OrderVo.ORDER_MONEY_AND_BUTTON_INFO:  //各种按钮
				view = inflater.inflate(R.layout.order_money_and_button_info, null);
				//因为这里需要订单状态来显示不一样的按钮，所以这里必须根据现在订单的状态来做出变化
				System.out.println("ov flag is " + ov.getFlag());
				switch(ov.getFlag()){
				case OrderVo.OERDER_CANCEL:
					Button cancelled = (Button) view.findViewById(R.id.cancelled);
					cancelled.setVisibility(View.VISIBLE);
					break;
				case OrderVo.OERDER_NOT_PAY:
					Button pendingBtn = (Button) view.findViewById(R.id.pendingPayment);
					pendingBtn.setVisibility(View.VISIBLE);
					Button cancelBtn = (Button) view.findViewById(R.id.cancellOrder);
					cancelBtn.setVisibility(View.VISIBLE);
					Button ordersPaid = (Button) view.findViewById(R.id.ordersPaid);
					ordersPaid.setVisibility(View.VISIBLE);
					break;
				case OrderVo.OERDER_RECIEVE:
					Button comments = (Button) view.findViewById(R.id.comments);
					comments.setVisibility(View.VISIBLE);
					break;
				case OrderVo.OERDER_PAY_NOT_SEND:
					Button toBeShipped = (Button) view.findViewById(R.id.toBeShipped);
					toBeShipped.setVisibility(View.VISIBLE);
					Button cancellOrder = (Button) view.findViewById(R.id.cancellOrder);
					cancellOrder.setVisibility(View.VISIBLE);
					break;
				case OrderVo.OERDER_PAY_SEND:
					//查看物流
					Button viewLogistics = (Button) view.findViewById(R.id.viewLogistics);
					viewLogistics.setVisibility(View.VISIBLE);
					
					//已发送
					Button shipped = (Button) view.findViewById(R.id.shipped);
					shipped.setVisibility(View.VISIBLE);
					
					//确认收货
					Button confirmReceipt = (Button) view.findViewById(R.id.confirmReceipt);
					confirmReceipt.setVisibility(View.VISIBLE);
					
					break;
				}
				break;
			}

			return view;
		}

		/** 

		 * 设置Listview的高度 

		 */  

		private void setListViewHeight(ListView listView) {   

			ListAdapter listAdapter = listView.getAdapter();    

			if (listAdapter == null) {   

				return;   

			}   

			int totalHeight = 0;   

			for (int i = 0; i < listAdapter.getCount(); i++) {   

				View listItem = listAdapter.getView(i, null, listView);   

				listItem.measure(0, 0);   

				totalHeight += listItem.getMeasuredHeight();   

			}   

			ViewGroup.LayoutParams params = listView.getLayoutParams();   

			params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));   

			listView.setLayoutParams(params);  

		}  


		/**
		 * 填充每个product数据
		 * */
		private List<Map<String, Object>> getProductDatas() {
			List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();

			for(int i=0; i<3; i++){
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("name", "iSomm");
				data.put("remark", "this is the remark");
				data.put("money", "$200");

				datas.add(data);
			}
			return datas;
		}

	}
}
