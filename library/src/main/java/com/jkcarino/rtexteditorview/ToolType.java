package com.jkcarino.rtexteditorview;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.jkcarino.rtexteditorview.ToolType.ALIGN_CENTER;
import static com.jkcarino.rtexteditorview.ToolType.ALIGN_JUSTIFY;
import static com.jkcarino.rtexteditorview.ToolType.ALIGN_LEFT;
import static com.jkcarino.rtexteditorview.ToolType.ALIGN_RIGHT;
import static com.jkcarino.rtexteditorview.ToolType.BOLD;
import static com.jkcarino.rtexteditorview.ToolType.CLEAR;
import static com.jkcarino.rtexteditorview.ToolType.CODE;
import static com.jkcarino.rtexteditorview.ToolType.EDIT_HTML;
import static com.jkcarino.rtexteditorview.ToolType.H1;
import static com.jkcarino.rtexteditorview.ToolType.H2;
import static com.jkcarino.rtexteditorview.ToolType.H3;
import static com.jkcarino.rtexteditorview.ToolType.H4;
import static com.jkcarino.rtexteditorview.ToolType.H5;
import static com.jkcarino.rtexteditorview.ToolType.H6;
import static com.jkcarino.rtexteditorview.ToolType.HORIZONTAL_RULE;
import static com.jkcarino.rtexteditorview.ToolType.INDENT;
import static com.jkcarino.rtexteditorview.ToolType.ITALIC;
import static com.jkcarino.rtexteditorview.ToolType.LINK;
import static com.jkcarino.rtexteditorview.ToolType.NONE;
import static com.jkcarino.rtexteditorview.ToolType.NORMAL;
import static com.jkcarino.rtexteditorview.ToolType.ORDERED_LIST;
import static com.jkcarino.rtexteditorview.ToolType.OUTDENT;
import static com.jkcarino.rtexteditorview.ToolType.QUOTE;
import static com.jkcarino.rtexteditorview.ToolType.REMOVE_FORMAT;
import static com.jkcarino.rtexteditorview.ToolType.STRIKETHROUGH;
import static com.jkcarino.rtexteditorview.ToolType.SUBSCRIPT;
import static com.jkcarino.rtexteditorview.ToolType.SUPERSCRIPT;
import static com.jkcarino.rtexteditorview.ToolType.TABLE;
import static com.jkcarino.rtexteditorview.ToolType.TEXT_BACK_COLOR;
import static com.jkcarino.rtexteditorview.ToolType.TEXT_FORE_COLOR;
import static com.jkcarino.rtexteditorview.ToolType.UNDERLINE;
import static com.jkcarino.rtexteditorview.ToolType.UNLINK;
import static com.jkcarino.rtexteditorview.ToolType.UNORDERED_LIST;

@IntDef({
        NONE, BOLD, ITALIC, UNDERLINE, STRIKETHROUGH, REMOVE_FORMAT, NORMAL, H1, H2, H3, H4, H5, H6,
        SUPERSCRIPT, SUBSCRIPT, TEXT_FORE_COLOR, TEXT_BACK_COLOR, CODE, UNORDERED_LIST,
        ORDERED_LIST, QUOTE, ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, HORIZONTAL_RULE,
        INDENT, OUTDENT, TABLE, LINK, UNLINK, CLEAR, EDIT_HTML
})
@Retention(RetentionPolicy.SOURCE)
public @interface ToolType {
    int NONE = 0;
    int BOLD = 1;
    int ITALIC = 2;
    int UNDERLINE = 3;
    int STRIKETHROUGH = 4;
    int REMOVE_FORMAT = 5;
    int NORMAL = 6;
    int H1 = 7;
    int H2 = 8;
    int H3 = 9;
    int H4 = 10;
    int H5 = 11;
    int H6 = 12;
    int SUPERSCRIPT = 13;
    int SUBSCRIPT = 14;
    int TEXT_FORE_COLOR = 15;
    int TEXT_BACK_COLOR = 16;
    int CODE = 17;
    int UNORDERED_LIST = 18;
    int ORDERED_LIST = 19;
    int QUOTE = 20;
    int ALIGN_LEFT = 21;
    int ALIGN_CENTER = 22;
    int ALIGN_RIGHT = 23;
    int ALIGN_JUSTIFY = 24;
    int HORIZONTAL_RULE = 25;
    int INDENT = 26;
    int OUTDENT = 27;
    int TABLE = 28;
    int LINK = 29;
    int UNLINK = 30;
    int CLEAR = 31;
    int EDIT_HTML = 32;
}
