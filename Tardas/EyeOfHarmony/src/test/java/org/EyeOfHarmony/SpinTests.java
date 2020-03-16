package org.EyeOfHarmony;


import org.ChameleonArch.browsers.Browsers;
import org.EyeOfHarmony.Seed.BlackHole.TestType;
import org.EyeOfHarmony.Seed.Spin;
import org.testng.annotations.Test;

public class SpinTests {

    @Test
    public void testGetHostOperatingSystemEnum() { 
        Spin sp = Spin.builder().setLocal().setBrowser(Browsers.CHROME).setTestEnvironment("PROD").setTestType(TestType.BROWSER).build();
        System.out.println(sp.toString());
    }
}
