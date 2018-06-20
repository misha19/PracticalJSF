package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class  login01 {

    public String login(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request =(HttpServletRequest) context
                .getExternalContext().getRequest();

        try {
            request.login(_userName,_password);
        }catch (ServletException e){
            context.addMessage(null,new FacesMessage("Login failed."));
            return "/loginError";
        }
        return "/persons";
    }
}
