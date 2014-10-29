package net.itaem.chateau.activity.personinfo.adapter;

import java.util.List;

import net.itaem.chateau.R;
import net.itaem.chateau.activity.personinfo.vo.PersonalCollectionVo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonalCollectionAdapter  extends BaseAdapter{

	private List<PersonalCollectionVo> list;
	
	private Context context;
	
	private LayoutInflater layoutInflater;
	
	public PersonalCollectionAdapter(Context cxt,List<PersonalCollectionVo> list) {
		this.list=list;
		this.context=cxt;
		layoutInflater=LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		 
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		 
		return position;
	}

	@Override
	public long getItemId(int position) {
		 
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		 
		if(convertView == null ){
			convertView=layoutInflater.inflate(R.layout.util_personal_collection_item, null);
		}
		
		ImageView imageView=(ImageView) convertView.findViewById(R.id.personal_collection_product_image);
		TextView productName= (TextView) convertView.findViewById(R.id.personal_collection_product_name);
		TextView productDesc= (TextView) convertView.findViewById(R.id.personal_collection_product_desc);
		TextView cost= (TextView) convertView.findViewById(R.id.personal_collection_product_cost);
		
		cost.setText(list.get(position).getCost());
		productName.setText(list.get(position).getProductName());
		productDesc.setText(list.get(position).getProductDescription());
		imageView.setImageResource(R.drawable.product);
		
		return convertView;
	}

}
