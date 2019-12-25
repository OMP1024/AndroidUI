package com.example.androidui.activity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

import com.example.androidui.R;

import butterknife.BindView;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity {

    @BindView(R.id.view)
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_animation;
    }

    @OnClick({
            R.id.rotate,
            R.id.scale,
            R.id.set,
            R.id.translate,
            R.id.alpha,
            R.id.valueAnimation,
            R.id.objectAnimation,
            R.id.AnimatorSet,
            R.id.PropertyAnimator,
            R.id.animtorXML})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rotate:
                this.view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_rotate));
                break;
            case R.id.scale:
                this.view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale));
                break;
            case R.id.set:
                this.view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_set));
                break;
            case R.id.translate:
                this.view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_translate));
                break;
            case R.id.alpha:
                this.view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_alpha));
                break;
            case R.id.valueAnimation:
                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 0.5f, 1.0f, 0.5f, 0.0f);
                valueAnimator.setDuration(2000);
                valueAnimator.addUpdateListener(valueAnimator1 -> AnimationActivity.this.view.setAlpha((Float) valueAnimator1.getAnimatedValue()));
                valueAnimator.setInterpolator(new DecelerateInterpolator());
                valueAnimator.start();
                break;
            case R.id.objectAnimation:
                ObjectAnimator.ofFloat(
                        AnimationActivity.this.view,
                        "alpha",
                        1.0f, 0.5f, 1.0f)
                        .setDuration(4000)
                        .start();
                break;
            case R.id.AnimatorSet: {
                ObjectAnimator animator = ObjectAnimator.ofFloat(AnimationActivity.this.view,"translationX",0.0f,200.0f,0f);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(AnimationActivity.this.view,"scaleX",1.0f,2.0f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(AnimationActivity.this.view,"rotationX",0.0f,90.0f,0.0f);
                AnimatorSet set = new AnimatorSet();
                set.setDuration(1000);
                set.play(animator).with(animator1).after(animator2);
                set.start();
            }
            break;
            case R.id.PropertyAnimator: {
                PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.5f);
                PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofFloat("rotationX", .0f, 90.0f, 1.5f);
                PropertyValuesHolder valuesHolder2 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.3f, 1.f);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(AnimationActivity.this.view, valuesHolder, valuesHolder1, valuesHolder2);
                objectAnimator.setDuration(2000).start();
            }
            break;
            case R.id.animtorXML: {
                AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(
                        AnimationActivity.this,
                        R.animator.property_animtor);
                animatorSet.setTarget(AnimationActivity.this.view);
                animatorSet.start();
            }
            break;

        }
    }
}
