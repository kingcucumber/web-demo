package com.demo.jsp;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ViewIPTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		
		
		return Tag.EVAL_BODY_INCLUDE;
	}
	

}
