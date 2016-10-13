package sk.mimacom.openslava.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import demo.whois.api.SiteInfoDTO;
import demo.whois.api.WhoisService;

import java.net.URI;
import java.net.URISyntaxException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=Openslava",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=Openslava portlet",
        "javax.portlet.init-param.template-path=/jsp/",
        "javax.portlet.init-param.view-template=/jsp/view.jsp",
        "javax.portlet.resource-bundle=content.Language"
    },
    service = Portlet.class
)
public class OpenslavaPortlet extends MVCPortlet {

  @Reference
  WhoisService service;
  
  @ProcessAction(name = "whoisLookup")
  public void getWhoisData(ActionRequest request, ActionResponse response){
    
    String url = ParamUtil.getString(request, "url");
    
    if(url != null){
      try {
        SiteInfoDTO siteInfo = service.getSiteInfo(new URI(null,url,null,null));
        request.setAttribute("siteInfo", siteInfo);
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    }
  }
  
}