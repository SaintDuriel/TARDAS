package org.ChameleonArch.browsers;

public enum Browsers {
    CHROME, FIREFOX, IE11, EDGE, SAFARI, OPERA;

    public static Browsers getBrowser(String browser) {
        return Browsers.valueOf(browser.toUpperCase());
    }
}
