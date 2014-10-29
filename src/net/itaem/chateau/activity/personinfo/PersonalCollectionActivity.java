package net.itaem.chateau.activity.personinfo;

import java.util.ArrayList;
import java.util.List;

import net.itaem.chateau.R;
import net.itaem.chateau.activity.personinfo.adapter.PersonalCollectionAdapter;
import net.itaem.chateau.activity.personinfo.vo.PersonalCollectionVo;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class PersonalCollectionActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.person_activity_my_collection);
		
		ListView listView  = (ListView) findViewById(R.id.person_collection_list);

		List<PersonalCollectionVo> list=new ArrayList<PersonalCollectionVo>();
		PersonalCollectionVo pcv=null;
		for(int i=0;i<10;i++){
			pcv=new PersonalCollectionVo("", "haha"+i, "description"+i, "$200"+i);
			list.add(pcv);
		}
		
		listView.setAdapter(new PersonalCollectionAdapter(this, list));

	}
}
