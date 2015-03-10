package com.leopaard.cn.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ScrollingTextView extends TextView {

	 public ScrollingTextView(Context context, AttributeSet attrs, int defStyle) {    
	        super(context, attrs, defStyle);    
	    }    
	     
	    public ScrollingTextView(Context context, AttributeSet attrs) {    
	        super(context, attrs);    
	    }    
	     
	    public ScrollingTextView(Context context) {    
	        super(context);    
	    }    
	      
	    @Override    
	    public boolean isFocused() {    
	        return true;    
	    }  
}
