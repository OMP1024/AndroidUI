package com.example.androidui.info;

public final class ItemInfo {
    private String title;
    private Type type;

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ItemInfo(String title, Type type) {
        this.title = title;
        this.type = type;
    }

    public enum Type {
        TEXT_VIEW,
        PROGRESS_BAR,
        RECYCLERVIEW,
        ACTIVITY,
        FRAGMENT,
        VIEW,
        VIEWPAGE,
        TABLAYOUT,
        BOTTOMSHEET,
        DIALOGFRAGMENT,
        WEBVIEW,
        VIDEOVIEW,
        LifeCycle,
        ViewAnimation,
        WebView,
        Intent_FIlter,
        PackageName,
        KitKat,
        Broadcast,
        DrawLayout,
        FILE,
        INCLUDEMERGEVIEWSTUB;
    }
}
