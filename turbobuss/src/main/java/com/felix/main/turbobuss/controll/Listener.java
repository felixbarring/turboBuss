package com.felix.main.turbobuss.controll;

import com.felix.main.turbobuss.model.Model;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author felix
 */
@WebListener()
public class Listener implements ServletContextListener, HttpSessionListener {

    private static final Logger LOG = Logger.getLogger(Listener.class.getName());

    // I.e. application starts
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.log(Level.INFO, "*** Loading Backend");
        sce.getServletContext().setAttribute(Keys.BACKEND.toString(), Model.getInstance());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOG.log(Level.INFO, "*** Session Created {0}", se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
