package result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lily on 2016/4/11.
 */
public class AjaxResult implements Result{
    public void execute(ActionInvocation actionInvocation) throws Exception {
        HttpServletResponse response= ServletActionContext.getResponse();
        response.setCharacterEncoding("utf-8");
        String message= ActionContext.getContext().getValueStack().peek().toString();
        response.getWriter().print(message);
    }
}
