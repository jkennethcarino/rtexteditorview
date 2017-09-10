RTextEditorView
======
[![JitPack][jitpackbadge-svg]][jitpackbadge] [![License: MIT][mitbadge-svg]][mitbadge]

A simple WYSIWYG Editor for Android, based on [Summernote][summernote].

Screenshots
------

<img src="/art/Screenshot_01.png" width="33%" /> <img src="/art/Screenshot_02.png" width="33%" /> <img src="/art/Screenshot_03.png" width="33%" />

Features
------

- [ ] Font Name
- [x] Font Size
- [x] Line Spacing
- [x] Bold
- [x] Italic
- [x] Underline
- [x] Strikethrough
- [x] Paragraph
- [x] Heading 1-6
- [x] Superscript
- [x] Subscript
- [x] Text Foreground Color
- [x] Text Background Color
- [x] Unordered List
- [x] Ordered List
- [x] Blockquote
- [x] Block Code
- [x] Left Align
- [x] Center Align
- [x] Right Align
- [x] Justify Align
- [x] Horizontal Rule
- [x] Indent
- [x] Outdent
- [x] Clear Formatting
- [x] Edit HTML
- [ ] Insert Image
- [x] Insert Table
- [x] Insert Link
- [x] Remove Link
- [x] Get/Set HTML
- [x] Undo/Redo changes

Download
------

Download the [latest AAR](https://github.com/jkennethcarino/RTextEditorView/releases) or grab via Gradle:

**Step 1.** Add the JitPack repository to your build file

Add it in your root `build.gradle` at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```groovy
dependencies {
    compile 'com.github.jkennethcarino:RTextEditorView:0.1.0'
}
```

RTextEditorView requires at minimum Android 4.0.3 (API Level 15).

Usage
------

XML Usage:

```xml
<!-- Set up our main editor -->
<com.jkcarino.rtexteditorview.RTextEditorView
    android:id="@+id/editor_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_above="@+id/toolbar_line"
    android:layout_alignParentTop="true" />

<!-- Set up the toolbar -->
<com.jkcarino.rtexteditorview.RTextEditorToolbar
    android:id="@+id/editor_toolbar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <com.jkcarino.rtexteditorview.RTextEditorButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="?android:attr/selectableItemBackground"
        android:padding="@dimen/toolbar_item_padding"
        app:srcCompat="@drawable/ic_format_bold"
        app:toolType="bold" />

    <com.jkcarino.rtexteditorview.RTextEditorButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="?android:attr/selectableItemBackground"
        android:padding="@dimen/toolbar_item_padding"
        app:srcCompat="@drawable/ic_format_italic"
        app:toolType="italic" />
</com.jkcarino.rtexteditorview.RTextEditorToolbar>
```

Java usage:

```java
RTextEditorView editor = (RTextEditorView) findViewById(R.id.editor_view);

RTextEditorToolbar editorToolbar = (RTextEditorToolbar) findViewById(R.id.editor_toolbar);
// Set the RTextEditorView to our toolbar
editorToolbar.setEditorView(editor);
```

And you're good to go!

Or you can implement your own toolbar, or just use a simple `Button`:

```java
Button boldButton = (Button) findViewById(R.id.format_bold);
boldButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        editor.setBold(); // or editor.setFormat(ToolType.BOLD);
    }
});
```

To see it in action, check out the sample app in `sample/`.

Credits
------

* [RichEditor](https://github.com/wasabeef/richeditor-android/)
* [MRichEditor](https://github.com/Even201314/MRichEditor/)
* [Google][google-materialicons] and [Austin Andrews][austin-andrews] for the Material Design Icons that I used in the sample app.

License
------

```
MIT License

Copyright (c) 2017 Jhon Kenneth Cariño

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

[jitpackbadge-svg]: https://jitpack.io/v/jkennethcarino/RTextEditorView.svg
[jitpackbadge]: https://jitpack.io/#jkennethcarino/RTextEditorView
[mitbadge-svg]: https://img.shields.io/badge/License-MIT-blue.svg
[mitbadge]: https://github.com/jkennethcarino/RTextEditorView/blob/master/LICENSE
[summernote]: https://github.com/summernote/summernote/
[google-materialicons]: https://material.io/icons/
[austin-andrews]: https://twitter.com/Templarian
