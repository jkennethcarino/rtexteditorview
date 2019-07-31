var enable = function() {
    $('#summernote').summernote('enable');
};

var disable = function() {
    $('#summernote').summernote('disable');
};

var destroy = function() {
    $('#summernote').summernote('destroy');
};

var undo = function() {
    $('#summernote').summernote('undo');
};

var redo = function() {
    $('#summernote').summernote('redo');
};

var clear = function() {
    $('#summernote').summernote('reset');
};

var setFocus = function(){
    $('#summernote').summernote('focus');
};

var setHtml = function(html) {
    $('#summernote').summernote('code', html);
};

var setBold = function() {
    $('#summernote').summernote('bold');
};

var setItalic = function() {
    $('#summernote').summernote('italic');
};

var setUnderline = function() {
    $('#summernote').summernote('underline');
};

var setStrikeThrough = function() {
    $('#summernote').summernote('strikethrough');
};

var removeFormat = function() {
    $('#summernote').summernote('removeFormat');
};

var setFontSize = function(size) {
    $('#summernote').summernote('fontSize', size);
};

//var setFontName = function(name){
//    $('#summernote').summernote('fontName', name);
//};

var setNormal = function() {
    $('#summernote').summernote('formatPara');
};

var setHeading = function(heading) {
    $('#summernote').summernote('formatH' + heading);
};

var setLineHeight = function(height) {
    $('#summernote').summernote('lineHeight', height);
}

var setSuperscript = function() {
    $('#summernote').summernote('superscript');
};

var setSubscript = function() {
    $('#summernote').summernote('subscript');
};

var setTextForeColor = function(hexColor) {
    if (!hexColor.startsWith('#')) {
        hexColor = '#' + hexColor;
    }
    $('#summernote').summernote('foreColor', hexColor);
};

var setTextBackColor = function(hexColor) {
    if (!hexColor.startsWith('#')) {
        hexColor = '#' + hexColor;
    }
    $('#summernote').summernote('backColor', hexColor);
};

var setBlockCode = function() {
    $('#summernote').summernote('formatBlock', 'pre');
};

var insertUnorderedList = function() {
    $('#summernote').summernote('insertUnorderedList');
};

var insertOrderedList = function() {
    $('#summernote').summernote('insertOrderedList');
};

var setBlockQuote = function() {
    $('#summernote').summernote('formatBlock', 'blockquote');
};

var setAlignLeft = function() {
    $('#summernote').summernote('justifyLeft');
};

var setAlignCenter = function() {
    $('#summernote').summernote('justifyCenter');
};

var setAlignRight = function() {
    $('#summernote').summernote('justifyRight');
};

var setAlignJustify = function() {
    $('#summernote').summernote('justifyFull');
};

var insertHorizontalRule = function() {
    $('#summernote').summernote('insertHorizontalRule');
};

var indent = function() {
    $('#summernote').summernote('indent');
};

var outdent = function() {
    $('#summernote').summernote('outdent');
};

var insertTable = function(dimen) {
    $('#summernote').summernote('insertTable', dimen);
};

var insertLink = function(linkTitle, linkUrl) {
    $('#summernote').summernote('createLink', {
        text: linkTitle,
        url: linkUrl,
        isNewWindow: false
    });
};

var unlink = function() {
    $('#summernote').summernote('unlink');
};

var insertText = function(text) {
    $('#summernote').summernote('insertText', text);
};

var editHtml = function() {
    $('#summernote').summernote('codeview.toggle');
};

var insertOrSurround = function(before, after) {
        var div = document.createElement("span");
        div.innerHTML = before + getSelectionHtml() + after;
        $('#summernote').summernote('insertNode', div);
};

function getSelectionHtml() {
    var html = "";
    if (typeof window.getSelection != "undefined") {
        var sel = window.getSelection();
        if (sel.rangeCount) {
            var container = document.createElement("div");
            for (var i = 0, len = sel.rangeCount; i < len; ++i) {
                container.appendChild(sel.getRangeAt(i).cloneContents());
            }
            html = container.innerHTML;
        }
    } else if (typeof document.selection != "undefined") {
        if (document.selection.type == "Text") {
            html = document.selection.createRange().htmlText;
        }
    }
    return html;
}

var insertHTML = function(html){
    var div = document.createElement('div');
    div.innerHTML = html;
    var node = div.firstChild;
    $('#summernote').summernote('insertNode', node);
};

//    var range, divBef, divAft, nodeBef, nodeAft, emptyNode;
//
//            divBef = document.createElement("div");
//            divBef.innerHTML = before;
//            nodeBef = divBef.firstChild;
//
//            divAft = document.createElement("div");
//            divAft.innerHTML = after;
//            nodeAft = divAft.firstChild;
//
//            range = window.getSelection().getRangeAt(0);
//
//            range.insertNode(nodeBef);
//            range.collapse(false);
//
//            range.insertNode(nodeAft);
//            range.collapse(false);
//
//            range = window.getSelection().getRangeAt(0);
//            range.collapse(true);
//
//            $('#summernote').summernote('insertText', '');


//        var rangeText = window.getSelection().toString();
//        $('#summernote').summernote('insertText', before + rangeText + after);


//        var rangeText = window.getSelection().getRangeAt(0);
//        rangeText.deleteContents();
//        rangeText.insertNode(node);
//        rangeText.collapse(true);
//        rangeText.insertNode(node);

//var insertOrSurround2 = function(before, after) {
//    var sel, range, node, nodee;
//    if (window.getSelection) {
//        sel = window.getSelection();
//        if (sel.getRangeAt && sel.rangeCount) {
//
//            // Range.createContextualFragment() would be useful here but was
//            // until recently non-standard and not supported in all browsers
//            // (IE9, for one)
//            var el = document.createElement("div");
//            el.innerHTML = before;
//            var frag = document.createDocumentFragment(), node, lastNode;
//            while ((node = el.firstChild)) {
//                lastNode = frag.appendChild(node);
//            }
//
//            var ell = document.createElement("div");
//            ell.innerHTML = after;
//            var frage = document.createDocumentFragment(), nodee, lastNodee;
//            while ((nodee = ell.firstChild)) {
//                lastNodee = frage.appendChild(nodee);
//            }
//
//            range = window.getSelection().getRangeAt(0);
//            range.insertNode(frag);
//            range.collapse(false);
//
//            range.insertNode(frage);
//            range.collapse(false);
//            $('#summernote').summernote('insertText', '');
//        }
//    } else if (document.selection && document.selection.createRange) {
//        range = document.selection.createRange();
//        range.pasteHTML(before);
//        range.collapse(false);
//        range.pasteHTML(after);
//        range.collapse(false);
//        $('#summernote').summernote('insertText', '');
//    }
//};