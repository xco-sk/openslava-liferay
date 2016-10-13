package sk.mimacom.openslava.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Openslava",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Openslava portlet",
		"javax.portlet.init-param.template-path=/jsp/",
		"javax.portlet.init-param.view-template=/jsp/view.jsp"
	},
	service = Portlet.class
)
public class OpenslavaPortlet extends MVCPortlet {

}