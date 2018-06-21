package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class logout {

    public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context
                .getExternalContext().getRequest();
        try{
            request.logout();
        }catch (ServletException e){
            context.addMessage(null,new FacesMessage("Lgout failed."));
        }
    }
}
