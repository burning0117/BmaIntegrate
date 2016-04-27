package filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import domain.AdminUser;
import org.apache.struts2.ServletActionContext;

/**
 * Created by lily on 2016/4/25.
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        AdminUser adminUser= (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existAdminUser");
        if (adminUser!=null){
            return actionInvocation.invoke();
        }else {
            ActionSupport support= (ActionSupport) actionInvocation.getAction();
            support.addActionError("您还没有登录！没有访问权限");
            return ActionSupport.LOGIN;
        }
    }
}
