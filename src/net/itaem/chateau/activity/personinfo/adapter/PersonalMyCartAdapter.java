package net.itaem.chateau.activity.personinfo.adapter;

import java.util.List;

import net.itaem.chateau.R;
import net.itaem.chateau.activity.personinfo.vo.PersonalMyCartVo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalMyCartAdapter extends BaseAdapter{

	private List<PersonalMyCartVo> list;
	
	private Context context;
	
	private LayoutInflater layoutInflater;
	
	public PersonalMyCartAdapter(Context cxt,List<PersonalMyCartVo> list) {
		this.context=cxt;
		this.list=list;
		layoutInflater=LayoutInflater.from(context);
		
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 
		if(convertView == null ){
			convertView=layoutInflater.inflate(R.layout.util_personal_mycart_list_item,parent, false);
		}
		
		ImageView imageView=(ImageView) convertView.findViewById(R.id.personal_mycart_product_image);
		TextView productName= (TextView) convertView.findViewById(R.id.personal_mycart_product_name);
		TextView productDesc= (TextView) convertView.findViewById(R.id.personal_mycart_product_desc);
		TextView cost= (TextView) convertView.findViewById(R.id.personal_mycart_product_cost);
		TextView productNum= (TextView) convertView.findViewById(R.id.personal_mycart_product_num);
		Button  isSelectBtn = (Button) convertView.findViewById(R.id.personal_mycart_product_select);
		
		cost.setText(list.get(position).getCost());
		productNum.setText(list.get(list.get(position).getNum())+"");  
		productName.setText(list.get(position).getProductName());
		productDesc.setText(list.get(position).getProductDescription());
		imageView.setImageResource(R.drawable.product);
		
		if(list.get(position).isSelected()){
			isSelectBtn.setBackgroundResource(R.drawable.personal_mycart_selected);	
		}else{
			isSelectBtn.setBackgroundResource(R.drawable.personal_mycart_no_selected);			
		}
		
		return convertView;
	}

}
