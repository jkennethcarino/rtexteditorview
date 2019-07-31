package com.jkcarino.rtexteditorview;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.inputmethod.EditorInfoCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RTextEditorView extends WebView {

    private static final String ASSETS_EDITOR_HTML = "file:///android_asset/editor.html";

    private boolean isReady;

    private boolean isIncognitoModeEnabled;
    private String content;
    private OnTextChangeListener onTextChangeListener;

    public interface OnTextChangeListener {
        void onTextChanged(String content);
    }

    public RTextEditorView(Context context) {
        super(context);
    }

    public RTextEditorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RTextEditorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void init() {
        WebSettings settings = getSettings();
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        setWebChromeClient(new WebChromeClient());
        setWebViewClient(new RTextEditorWebViewClient());
        addJavascriptInterface(this, "RTextEditorView");
        loadUrl(ASSETS_EDITOR_HTML);
    }

    @Override
    public void destroy() {
        exec("javascript:destroy();");

        ViewGroup parent = (ViewGroup) getParent();
        if (parent != null) {
            parent.removeView(this);
        }
        super.destroy();
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        InputConnection inputConnection = super.onCreateInputConnection(outAttrs);
        if (isIncognitoModeEnabled) {
            outAttrs.imeOptions = outAttrs.imeOptions
                    | EditorInfoCompat.IME_FLAG_NO_PERSONALIZED_LEARNING;
        }
        return inputConnection;
    }

    public void setIncognitoModeEnabled(boolean enabled) {
        this.isIncognitoModeEnabled = enabled;
    }

    public void setOnTextChangeListener(@Nullable OnTextChangeListener listener) {
        this.onTextChangeListener = listener;
    }

    @JavascriptInterface
    public void onEditorContentChanged(String content) {
        if (onTextChangeListener != null) {
            onTextChangeListener.onTextChanged(content);
        }
        this.content = content;
    }

    @JavascriptInterface
    public void updateCurrentStyle(String style) {
        // TODO: Update buttons state
    }

    public void enable() {
        exec("javascript:enable();");
    }

    public void disable() {
        exec("javascript:disable();");
    }

    public void undo() {
        exec("javascript:undo();");
    }

    public void redo() {
        exec("javascript:redo();");
    }

    public void clear() {
        exec("javascript:clear();");
    }

    public void focus() {
        exec("javascript:setFocus();");
    }

    public void setHtml(@NonNull String html) {
        exec("javascript:setHtml('" + html + "');");
    }

    public String getHtml() {
        return content;
    }

    public void setBold() {
        exec("javascript:setBold();");
    }

    public void setItalic() {
        exec("javascript:setItalic();");
    }

    public void setUnderline() {
        exec("javascript:setUnderline();");
    }

    public void setStrikeThrough() {
        exec("javascript:setStrikeThrough();");
    }

    public void removeFormat() {
        exec("javascript:removeFormat();");
    }

    public void setFontSize(int sizeInPx) {
        exec("javascript:setFontSize(" + sizeInPx + ");");
    }

//    public void setFontName(String name) {
//        exec("javascript:setFontName(" + name + ");");
//    }

    public void setNormal() {
        exec("javascript:setNormal();");
    }

    public void setHeading(@IntRange(from=1,to=6) int value) {
        exec("javascript:setHeading('" + value + "');");
    }

    public void setLineHeight(int heightInPx) {
        exec("javascript:setLineHeight(" + heightInPx + ");");
    }

    public void setSuperscript() {
        exec("javascript:setSuperscript();");
    }

    public void setSubscript() {
        exec("javascript:setSubscript()");
    }

    public void setTextColor(@ColorInt int color) {
        setTextColor(String.format("#%06X", (0xFFFFFF & color)));
    }

    public void setTextColor(@NonNull String hexColor) {
        exec("javascript:setTextForeColor('" + hexColor + "');");
    }

    public void setTextBackgroundColor(@ColorInt int color) {
        setTextBackgroundColor(String.format("#%06X", (0xFFFFFF & color)));
    }

    public void setTextBackgroundColor(@NonNull String hexColor) {
        exec("javascript:setTextBackColor('" + hexColor + "');");
    }

    public void setBlockCode() {
        exec("javascript:setBlockCode();");
    }

    public void setUnorderedList() {
        exec("javascript:insertUnorderedList();");
    }

    public void setOrderedList() {
        exec("javascript:insertOrderedList();");
    }

    public void setBlockQuote() {
        exec("javascript:setBlockQuote();");
    }

    public void setAlignLeft() {
        exec("javascript:setAlignLeft();");
    }

    public void setAlignCenter() {
        exec("javascript:setAlignCenter();");
    }

    public void setAlignRight() {
        exec("javascript:setAlignRight();");
    }

    public void setAlignJustify() {
        exec("javascript:setAlignJustify();");
    }

    public void insertHorizontalRule() {
        exec("javascript:insertHorizontalRule();");
    }

    public void setIndent() {
        exec("javascript:indent();");
    }

    public void setOutdent() {
        exec("javascript:outdent();");
    }

    public void insertTable(int colCount, int rowCount) {
        exec("javascript:insertTable('" + colCount + "x" + rowCount + "');");
    }

    public void insertLink(@Nullable String title, @NonNull String url) {
        exec("javascript:insertLink('" + title + "','" + url + "');");
    }

    public void setUnlink() {
        exec("javascript:unlink();");
    }

    public void insertText(@NonNull String text) {
        exec("javascript:insertText('" + text + "');");
    }

    public void editHtml() {
        exec("javascript:editHtml();");
    }

    public void insertOrSurround(String before, String after) {
        exec("javascript:insertOrSurround('" + before + "','" + after + "');");
    }

    public void insertHTML(String htmlText) {
        exec("javascript:insertHTML('" + htmlText + "');");
    }

    public void insertImage(String src,@Nullable String alt, int width, int height) {
        StringBuilder builder = new StringBuilder("<img src=\"");
        builder.append(src).append("\" ");
        if (alt != null) builder.append("alt=\"").append(alt).append("\" ");
        if(width != 0) builder.append("width=\"").append(width).append("\" ");
        if(height != 0) builder.append("height=\"").append(height).append("\" ");
        builder.append(">");
        insertHTML(builder.toString());
    }

    public void insertYoutube(String url) {
        final String beforeId = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/";
        final String afterId = "\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>&nbsp;<br>&nbsp;<br>&nbsp;<br>";
        String id = getValueFromUrlString("v=", url);
        if(id == null || id.equals("")) {
//            if (Pattern.matches(".*youtu\\.be/\\w+", url)) {
//                Pattern pattern = Pattern.compile("youtu\\.be/\\w*");
//                Matcher matcher = pattern.matcher(url);
//                int start = matcher.start();
//                int end = matcher.end();
//                id = url.substring(start, end).replace("youtu.be/", "");
//            } else {
//                return;
//            }
            id = getValueFromUrlString("be/", url);
            if(id == null || id.equals("")) return;
        }
        insertHTML(beforeId + id + afterId);
    }

    private static String getValueFromUrlString (String fieldName, String url) {
        Pattern pattern = Pattern.compile(fieldName + "\\w*");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            return url.substring(start, end).replace(fieldName , "");
        }
        return null;
    }

    public void setFormat(@ToolType int type) {
        switch (type) {
            case ToolType.BOLD:
                setBold();
                break;
            case ToolType.ITALIC:
                setItalic();
                break;
            case ToolType.UNDERLINE:
                setUnderline();
                break;
            case ToolType.STRIKETHROUGH:
                setStrikeThrough();
                break;
            case ToolType.REMOVE_FORMAT:
                removeFormat();
                break;
            case ToolType.NORMAL:
                setNormal();
                break;
            case ToolType.H1:
                setHeading(1);
                break;
            case ToolType.H2:
                setHeading(2);
                break;
            case ToolType.H3:
                setHeading(3);
                break;
            case ToolType.H4:
                setHeading(4);
                break;
            case ToolType.H5:
                setHeading(5);
                break;
            case ToolType.H6:
                setHeading(6);
                break;
            case ToolType.SUPERSCRIPT:
                setSuperscript();
                break;
            case ToolType.SUBSCRIPT:
                setSubscript();
                break;
            case ToolType.CODE:
                setBlockCode();
                break;
            case ToolType.UNORDERED_LIST:
                setUnorderedList();
                break;
            case ToolType.ORDERED_LIST:
                setOrderedList();
                break;
            case ToolType.QUOTE:
                setBlockQuote();
                break;
            case ToolType.ALIGN_LEFT:
                setAlignLeft();
                break;
            case ToolType.ALIGN_CENTER:
                setAlignCenter();
                break;
            case ToolType.ALIGN_RIGHT:
                setAlignRight();
                break;
            case ToolType.ALIGN_JUSTIFY:
                setAlignJustify();
                break;
            case ToolType.HORIZONTAL_RULE:
                insertHorizontalRule();
                break;
            case ToolType.INDENT:
                setIndent();
                break;
            case ToolType.OUTDENT:
                setOutdent();
                break;
            case ToolType.UNLINK:
                setUnlink();
                break;
            case ToolType.CLEAR:
                clear();
                break;
            case ToolType.EDIT_HTML:
                editHtml();
                break;
            case ToolType.NONE:
            case ToolType.LINK:
            case ToolType.TABLE:
            case ToolType.TEXT_BACK_COLOR:
            case ToolType.TEXT_FORE_COLOR:
                break;
        }
    }

    protected void exec(@NonNull final String trigger) {
        if (isReady) {
            load(trigger);
        } else {
            postDelayed(new Runnable() {
                @Override public void run() {
                    exec(trigger);
                }
            }, 100);
        }
    }

    private void load(@NonNull String trigger) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            evaluateJavascript(trigger, null);
        } else {
            loadUrl(trigger);
        }
    }

    private class RTextEditorWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            isReady = url.equalsIgnoreCase(ASSETS_EDITOR_HTML);
            super.onPageFinished(view, url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}
