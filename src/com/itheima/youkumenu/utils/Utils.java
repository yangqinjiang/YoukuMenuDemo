package com.itheima.youkumenu.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;

public class Utils {
	private static boolean isStartingOut=false;
	private static boolean isStartingIn=false;
	/**
	 * ִ�г�ȥ�Ķ���
	 * 
	 * @param view
	 */
	public static void startOutRotateAnimation(ViewGroup view,long startOffset) {// ViewGroup���㴦����Ԫ��

		//
		int childCount = view.getChildCount();
		View childView;
		// �����ӿؼ�Ϊ������
		for (int i = 0; i < childCount; i++) {
			childView = view.getChildAt(i);
			childView.setEnabled(false);
		}
		RotateAnimation anim = new RotateAnimation(0f, -180f,
				Animation.RELATIVE_TO_SELF, 0.5f, // �ο���
				Animation.RELATIVE_TO_SELF, 1.0f);
		anim.setDuration(500);
		anim.setStartOffset(startOffset);
		anim.setFillAfter(true);
		anim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				isStartingOut=true;
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				isStartingOut=false;
			}
		});
		//
		view.setAnimation(anim);
	}
	/**
	 * �ж��Ƿ�����ִ�г�ȥ�Ķ���
	 * @return
	 */
	public static boolean isStartingOut(){
		return isStartingOut;
	}
	/**
	 * �ж��Ƿ�����ִ�н����Ķ���
	 * @return
	 */
	public static boolean isStartingin(){
		return isStartingIn;
	}
	/**
	 * ִ�г�ȥ�Ķ���
	 * 
	 * @param view
	 * @param startOffset 
	 */
	public static void startInRotateAnimation(ViewGroup view,long startOffset) {// ViewGroup���㴦����Ԫ��

		//
		int childCount = view.getChildCount();
		View childView;
		// �����ӿؼ�Ϊ������
		for (int i = 0; i < childCount; i++) {
			childView = view.getChildAt(i);
			childView.setEnabled(true);
		}
		RotateAnimation anim = new RotateAnimation(
				-180f, 0f,
				Animation.RELATIVE_TO_SELF, 0.5f, // �ο���
				Animation.RELATIVE_TO_SELF, 1.0f);
		anim.setDuration(500);
		anim.setStartOffset(startOffset);
		anim.setFillAfter(true);
		anim.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				isStartingIn=true;
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				isStartingIn=false;
			}
		});
		//
		view.setAnimation(anim);
	}
}
