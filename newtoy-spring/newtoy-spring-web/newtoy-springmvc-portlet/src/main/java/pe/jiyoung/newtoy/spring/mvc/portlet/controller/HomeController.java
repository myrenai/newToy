package pe.jiyoung.newtoy.spring.mvc.portlet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("VIEW")
public class HomeController {

    /**
     * Log instance.
     */
    private static final Log LOG = LogFactory.getLog(HomeController.class);

    protected static final String MESSAGES = "messages";
    final String STATICRESOURCESPATH = "resourcesPath";
    final String DYNAMICRESOURCESPATTERN = "dynamicResourcesPattern";


    /**
     * render home page
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RenderMapping
    public String goHome(final RenderRequest request, final RenderResponse response, ModelMap model) {
        model = this.bindInitialModel(model, response, request);
        return "home";
    }

    @ResourceMapping(value = "getJSON")
    public View getJSON(final ResourceRequest request, final ResourceResponse response) {
        final MappingJacksonJsonView view = new MappingJacksonJsonView();
        final Locale locale = request.getLocale();
        view.addStaticAttribute(MESSAGES, this.i18nService.getStrings(locale));
        view.addStaticAttribute("pref1", request.getPreferences().getValue("pref1", "pref1 not found !"));
        view.addStaticAttribute("uid", request.getAttribute("uid"));
        view.addStaticAttribute("portletMode", request.getPortletMode().toString());
        view.addStaticAttribute("windowState", request.getWindowState().toString());
        return view;
    }

    /**
     * Add ressourceURL to spring MVC model
     * @param model
     * @param response
     * @param request
     * @return completed spring MVC model
     */
    protected ModelMap bindInitialModel(final ModelMap model, final RenderResponse response, final RenderRequest request) {
        model.addAttribute(this.STATICRESOURCESPATH, response.encodeURL(request.getContextPath()));
        final ResourceURL resourceURL = response.createResourceURL();
        resourceURL.setResourceID("@@id@@");
        resourceURL.setParameter("p1", "__p1__");
        resourceURL.setParameter("p2", "__p2__");
        resourceURL.setParameter("p3", "__p3__");
        resourceURL.setParameter("p4", "__p4__");
        model.addAttribute(this.DYNAMICRESOURCESPATTERN, resourceURL);
        return model;
    }

    /**
     * @param name of stored object
     * @return the object stored in session
     */
    protected Object getFromSession(final String name) {
        return RequestContextHolder.getRequestAttributes().getAttribute(name, PortletSession.PORTLET_SCOPE);
    }

    /**
     * Store a object in session
     *
     * @param name of stored object
     * @param value of stored object
     */
    protected void setInSession(final String name, final Object value) {
        RequestContextHolder.getRequestAttributes().setAttribute(name, value, PortletSession.PORTLET_SCOPE);
    }

    @ResourceMapping(value = "getDate")
    public View toggleItemReadState(
            @RequestParam(required = true, value = "p1") final boolean isWithHour) {
        final MappingJacksonJsonView view = new MappingJacksonJsonView();
        final Date date = new Date();
        String ret;
        if (isWithHour) {
            ret = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
        }
        else {
            ret = new SimpleDateFormat("dd/MM/yyyy").format(date);
        }
        view.addStaticAttribute("date", ret);
        return view;
    }

}
