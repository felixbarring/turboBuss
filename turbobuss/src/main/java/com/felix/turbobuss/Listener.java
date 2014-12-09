package com.felix.turbobuss;

import com.felix.turbobuss.simpleBackend.Backend;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application life cycle listener.
 *
 * @author hajo
 */
@WebListener()
public class Listener implements ServletContextListener, HttpSessionListener {

    private static final Logger LOG = Logger.getLogger(Listener.class.getName());

    // I.e. application starts
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.log(Level.INFO, "******* Putting Shop in application scope");
        sce.getServletContext().setAttribute(Keys.BACKEND.toString(), Backend.getInstance());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Nothing
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOG.log(Level.INFO, "******* Session Created {0}", se.getSession());
        se.getSession().setAttribute(Keys.PAGE_SIZE.toString(), 4); // Hardcoded
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Nothing
    }
}
