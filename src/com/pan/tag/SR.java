package com.pan.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import com.pan.tools.InterManager;

public class SR extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String word;

	@Override
	public int doStartTag() throws JspException {
		String interWord = InterManager.getPageResource(word);
		JspWriter out = pageContext.getOut();
		try {
			out.print(interWord);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Tag.SKIP_BODY;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
