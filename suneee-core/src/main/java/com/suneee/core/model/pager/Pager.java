/**  
 * File Name:Pager.java  
 * Package Name:com.suneee.core.model.pager  
 * Description: (That's the purpose of the file)
 * Date:2014年11月21日下午3:43:44  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
 */

package com.suneee.core.model.pager;

import java.io.Serializable;

import com.suneee.core.common.constant.Global;

/**
 * ClassName:Pager <br/>
 * Description:That's the purpose of the class Date: 2014年11月21日 下午3:43:44 <br/>
 * 
 * @author joe
 * @version V1.0
 * @see
 */
public final class Pager implements Serializable {

	/**
	 * serialVersionUID:That's the purpose of the variable.
	 */
	private static final long serialVersionUID = 6051933424406636470L;
	
	private final static int SIZE = 20;
	private final static int START = 0;
	private final static int END  = 20;
	private final static int CURRENT_NO = 1;

	// page size
	private int size = SIZE;

	// total rows
	private int total;

	// start row
	private int start = START;

	// end row
	private int end = END;

	// current page
	private int currentNo = CURRENT_NO;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if(size != Global.I_0){
			this.size = size;
		}
		init();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getCurrentNo() {
		return currentNo;
	}

	public void setCurrentNo(int currentNo) {
		if(currentNo != Global.I_0){
			this.currentNo = currentNo;
		}
		init();
	}
	
	/**
	 * @Title: init 
	 * @Description: 如果请求参数中含有 当前页参数  和 每页的数量参数 则重新计算 end  start 参数。
	 * @throws
	 */
	private void init(){
		this.end   = this.currentNo * this.size;
		this.start  = this.end - this.size ;
	}
	
}
