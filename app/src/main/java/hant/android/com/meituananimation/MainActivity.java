package hant.android.com.meituananimation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import hant.android.com.meituananimation.widget.XListView;

public class MainActivity extends Activity implements XListView.IXListViewListener {

    private XListView mListView;

    private ArrayAdapter<String> mAdapter;
    private ArrayList<String> items = new ArrayList<>();
    private Handler mHandler;
    private int mIndex = 0;
    private int mRefreshIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getItems();
        initView();
    }

    private void getItems() {
        for (int i = 0; i < 20; i++) {
            items.add("Test XListView item " + (++mIndex));
        }
    }

    private void initView() {
        mHandler = new Handler();
        mListView = (XListView) findViewById(R.id.list_view);
        mListView.setPullRefreshEnable(true);
        mListView.setPullLoadEnable(true);
        mListView.setXListViewListener(this);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIndex = ++mRefreshIndex;
                items.clear();
                getItems();
                mAdapter.notifyDataSetChanged();
                onComplete();
            }
        }, 1500);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getItems();
                mAdapter.notifyDataSetChanged();
                onComplete();
            }
        }, 1500);
    }


    private void onComplete() {
        mListView.stopRefresh();
        mListView.stopLoadMore();
    }
}
