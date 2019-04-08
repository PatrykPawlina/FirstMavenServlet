package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Start of the application: " + new Date());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("End of the application: " + new Date());
    }
}
