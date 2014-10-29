package net.itaem.chateau.activity.personinfo;

import java.util.ArrayList;
import java.util.List;

import net.itaem.chateau.R;
import net.itaem.chateau.activity.personinfo.adapter.PersonalCollectionAdapter;
import net.itaem.chateau.activity.personinfo.vo.PersonalCollectionVo;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class PersonalCollectionActivity extends Activity {

	private PullToRefreshListView mPullRefreshListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.person_activity_my_collection);
		
		mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.person_collection_pull_refresh_list);

		// Set a listener to be invoked when the list should be refreshed.
		mPullRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				mPullRefreshListView.onRefreshComplete();
			}
		});

		// Add an end-of-list listener
		mPullRefreshListView.setOnLastItemVisibleListener(new OnLastItemVisibleListener() {

			@Override
			public void onLastItemVisible() {
				mPullRefreshListView.onRefreshComplete();
			}
		});

		ListView actualListView = mPullRefreshListView.getRefreshableView();

		List<PersonalCollectionVo> list=new ArrayList<PersonalCollectionVo>();
		PersonalCollectionVo pcv=null;
		for(int i=0;i<10;i++){
			pcv=new PersonalCollectionVo("", "haha"+i, "description"+i, "$200"+i);
			list.add(pcv);
		}
		
		actualListView.setAdapter(new PersonalCollectionAdapter(this, list));

	}
}
