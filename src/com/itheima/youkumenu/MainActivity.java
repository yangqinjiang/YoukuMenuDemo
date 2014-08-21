package com.itheima.youkumenu;

import com.itheima.youkumenu.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private ViewGroup rl_level2;
	private ViewGroup rl_level3;
	private boolean isDispalyLevel3=true;
	private boolean isDispalyLevel2=true;

	private void initView() {
		// 二级菜单
		rl_level2 = (ViewGroup) findViewById(R.id.rl_level2);
		// 三级菜单
		rl_level3 = (ViewGroup) findViewById(R.id.rl_level3);

		findViewById(R.id.ib_home).setOnClickListener(this);
		findViewById(R.id.ib_menu).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(Utils.isStartingOut() || Utils.isStartingin())return;//如果正在执行动画
		switch (v.getId()) {
		case R.id.ib_home:
			Toast.makeText(getApplicationContext(), "ib_home", 0).show();
			if(isDispalyLevel2){
				long startOffset=0;
				if(isDispalyLevel3){
					Utils.startOutRotateAnimation(rl_level3,0);
					isDispalyLevel3=!isDispalyLevel3;
					startOffset=200;
				}
				Utils.startOutRotateAnimation(rl_level2,startOffset);
			}else{
				Utils.startInRotateAnimation(rl_level2,0);
			}
			isDispalyLevel2 = !isDispalyLevel2;
			
			break;
		case R.id.ib_menu:
			Toast.makeText(getApplicationContext(), "ib_menu", 0).show();
			if(isDispalyLevel3){
				//隐藏
				Utils.startOutRotateAnimation(rl_level3,0);
			}else{
				//显示
				Utils.startInRotateAnimation(rl_level3,0);
			}
			isDispalyLevel3 =!isDispalyLevel3;
			
			break;

		default:
			break;
		}
	}
}
