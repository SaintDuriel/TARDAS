package org.ChameleonArch;

import org.ChameleonArch.browsers.Browsers;
import org.ChameleonArch.driverManagers.ChromeDriverManager;
import org.ChameleonArch.driverManagers.EdgeDriverManager;
import org.ChameleonArch.driverManagers.FirefoxDriverManager;
import org.ChameleonArch.driverManagers.IE11DriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(Browsers type) {

        DriverManager driverManager;

        switch (type) {
        case CHROME:
            driverManager = new ChromeDriverManager();
            break;
        case FIREFOX:
            driverManager = new FirefoxDriverManager();
            break;
        case EDGE:
            driverManager = new EdgeDriverManager();
            break;
        case IE11:
            driverManager = new IE11DriverManager();
            break;
        default:
            driverManager = new ChromeDriverManager();
            break;
        }
        return driverManager;

    }
}
