package com.example.androidui.activity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.example.androidui.R;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.container)
    ViewGroup container;
    private WebView webView;
    private static final String TAG = "webview";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 用代码的方式替代XML，防止Activity引用被滥用，导致的内存泄漏，能解决90+%的内存泄漏
        webView = new WebView(this.getApplicationContext());
        container.addView(webView);

        webView.loadUrl("www.baidu.com");
        webView.setWebViewClient(new WebViewClient() {

            // 拦截页面加载，返回true，表示宿主App拦截并处理该url，否则返回false由当前webview处理
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Log.i(TAG, "shouldOverrideUrlLoading: ");
                return super.shouldOverrideUrlLoading(view, request);
            }

            /**
             * 调用非UI线程拦截资源请求并返回数据，返回null时，将继续加载资源
             */
            @Nullable
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return super.shouldInterceptRequest(view, request);
            }

            /**
             * 开始加载
             */
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i(TAG, "onPageStarted: ");
            }

            /**
             * 完成加载
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG, "onPageFinished: ");
            }

            /**
             * 将要加载资源
             */
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                Log.i(TAG, "onLoadResource: ");
            }

            /**
             * 加载资源错误，连接不到服务器
             */
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Log.i(TAG, "onReceivedError: ");
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {

            /**
             * <video/> 控件在未播放是，会展示一张为海报图，HTML中通过它的poster属性指定，如果未指定，则通过此方法提供默认海报图
             */
            @Nullable
            @Override
            public Bitmap getDefaultVideoPoster() {
                return super.getDefaultVideoPoster();
            }

            /**
             * 当视频正在缓冲时，此方法返回一个占位图（入旋转的菊花）
             */
            @Nullable
            @Override
            public View getVideoLoadingProgressView() {
                return super.getVideoLoadingProgressView();
            }

            /**
             * 接受页面的加载进度
             */
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.i(TAG, "onProgressChanged: " + webView.getProgress());
            }

            /**
             * 通知应用当前页面进入全屏模式，应用必须显示一个包含网页内容的自定义View
             */
            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
            }

            /**
             * 通知应用当前页面退出全屏模式，此时应用必须隐藏之前显示的自定义View
             */
            @Override
            public void onHideCustomView() {
                super.onHideCustomView();
            }

            /**
             * 显示一个alert对话框
             */
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });

        WebSettings settings = webView.getSettings();
        // 设置缓存
        settings.setAppCacheEnabled(true);
        // 设置缓存路径
        settings.setAppCachePath(this.getCacheDir().getAbsolutePath());
        // 没网，离线加载缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 设置 http https 混合加载模式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        // 页面自适应
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);

        // 禁止缩放
        settings.setSupportZoom(false);

        // 设置图片自动加载
        settings.setLoadsImagesAutomatically(true);

        // 禁止长按赋值
        webView.setOnLongClickListener(view -> true);
        // 隐藏滚动条
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null){
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.loadDataWithBaseURL(null,"","text/html","utf-8",null);
            webView.clearHistory();
            ((ViewGroup)webView.getParent()).removeView(webView);
            webView = null;
        }
    }
}
