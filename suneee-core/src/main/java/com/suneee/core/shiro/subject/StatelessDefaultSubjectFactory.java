/**  
 * File Name:StatelessDefaultSubjectFactory.java  
 * Package Name:com.suneee.core.shiro.subject  
 * Description: (That's the purpose of the file)
 * Date:2014年12月5日上午11:06:52  
 * Copyright (c) 2014, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
  
package com.suneee.core.shiro.subject;  

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;

/**  
 * ClassName:StatelessDefaultSubjectFactory <br/>  
 * Description:That's the purpose of the class
 * Date:     2014年12月5日 上午11:06:52 <br/>  
 * @author   joe  
 * @version  V1.0  
 * @see        
 */
public class StatelessDefaultSubjectFactory extends DefaultWebSubjectFactory
{
	
	@Override
	public Subject createSubject(SubjectContext context)
	{
	    context.setSessionCreationEnabled(false);
	    return super.createSubject(context);
	}

}
  
