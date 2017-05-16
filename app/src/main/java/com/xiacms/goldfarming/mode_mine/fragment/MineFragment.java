package com.xiacms.goldfarming.mode_mine.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.xiacms.goldfarming.R;
import com.xiacms.goldfarming.activity.LoginAndRegisterActivity;
import com.xiacms.goldfarming.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {
    private ImageView imageTitleLogin;

    @Override
    public View initView() {
        View inflate = View.inflate(mContext, R.layout.fragment_mine, null);
        imageTitleLogin = (ImageView) inflate.findViewById(R.id.mine_title_eg);
        imageTitleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginAndRegisterActivity.class);
                startActivity(intent);
            }
        });
        return inflate;
    }
}
