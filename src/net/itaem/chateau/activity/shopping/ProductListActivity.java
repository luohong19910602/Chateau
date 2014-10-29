package net.itaem.chateau.activity.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.itaem.chateau.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * 查看商品列表activity
 * 
 * */
public class ProductListActivity extends Activity {
    private ListView productList;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_activity_product_list);
	    
		productList = (ListView) findViewById(R.id.product_list);
	    SimpleAdapter sa = new SimpleAdapter(this, getDatas(), R.layout.shop_product_list_item, new String[]{"name", "money", "remark"}, new int[]{R.id.name, R.id.money, R.id.remark});
		//ProductListAdapter adapter = new ProductListAdapter(this, new ArrayList<Product>());
	    productList.setAdapter(sa);
	}
	
	List<Map<String, Object>> getDatas(){
		List<Map<String,Object>> datas = new ArrayList<Map<String, Object>>();
		for(int i=0;i<3;i++){
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("name", "iSomm");
			data.put("remark", "remark");
			data.put("money", "$2000");
			
			datas.add(data);
		}
		return datas;
	}

}
