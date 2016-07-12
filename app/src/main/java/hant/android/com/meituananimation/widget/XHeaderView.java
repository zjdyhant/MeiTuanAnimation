package hant.android.com.meituananimation.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import hant.android.com.meituananimation.R;


/**
 * The header view for {@link hant.android.com.meituananimation.widget.XListView}
 * @author markmjw
 * @date 2013-10-08
 */
public class XHeaderView extends LinearLayout {

    public final static int STATE_NORMAL = 0;
    public final static int STATE_READY = 1;
    public final static int STATE_REFRESHING = 2;

    private View mContainer;
    private ImageView mArrowImageView;

    private int mState = STATE_NORMAL;

    private boolean mIsFirst;

    public XHeaderView(Context context) {
        super(context);
        initView(context);
    }

    public XHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        // Initial set header view height 0
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0);
        mContainer =  LayoutInflater.from(context).inflate(R.layout.view_listview_header, null);
        addView(mContainer, lp);
        mArrowImageView = (ImageView) findViewById(R.id.header_arrow);
    }

    public void setState(int state) {

        if (state == mState && mIsFirst) {
            mIsFirst = true;
            return;
        }
        switch (state) {
            case STATE_NORMAL:
                mArrowImageView.setBackgroundResource(R.drawable.pull_image);
                break;

            case STATE_READY:
                if(mState == STATE_NORMAL){
                    mArrowImageView.setBackgroundResource(R.drawable.anim_pull);
                    AnimationDrawable animationDrawable = (AnimationDrawable) mArrowImageView.getBackground();
                    animationDrawable.start();
                    int duration = 0;
                    for (int i = 0; i < animationDrawable.getNumberOfFrames(); i++) {
                        duration += animationDrawable.getDuration(i);
                    }
                    mArrowImageView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mArrowImageView.setBackgroundResource(R.drawable.anim_refreshing);
                            AnimationDrawable animationDrawable = (AnimationDrawable) mArrowImageView.getBackground();
                            animationDrawable.start();
                        }
                    }, duration - 50);
                }
                break;

            case STATE_REFRESHING:
                break;

            default:
                break;
        }

        mState = state;
    }

    /**
     * Set the header view visible height.
     *
     * @param height
     */
    public void setVisibleHeight(int height) {
        if (height < 0) height = 0;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContainer.getLayoutParams();
        lp.height = height;
        mContainer.setLayoutParams(lp);
    }

    /**
     * Get the header view visible height.
     *
     * @return
     */
    public int getVisibleHeight() {
        return mContainer.getHeight();
    }

}
