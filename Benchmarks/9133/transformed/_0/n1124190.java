class n1124190 {
	private SystemProperties() {
        Properties XYe8Z9C3 = new Properties();
        ClassLoader HS4mBkd1 = getClass().getClassLoader();
        try {
            URL RzXCJkye = HS4mBkd1.getResource("system.properties");
            if (RzXCJkye != null) {
                InputStream yu4CT8uD = RzXCJkye.openStream();
                XYe8Z9C3.load(yu4CT8uD);
                yu4CT8uD.close();
                System.out.println("Loading " + RzXCJkye);
            }
        } catch (Exception DjqDRkqe) {
            DjqDRkqe.printStackTrace();
        }
        try {
            URL QQaJFwEQ = HS4mBkd1.getResource("system-ext.properties");
            if (QQaJFwEQ != null) {
                InputStream SiIyAm52 = QQaJFwEQ.openStream();
                XYe8Z9C3.load(SiIyAm52);
                SiIyAm52.close();
                System.out.println("Loading " + QQaJFwEQ);
            }
        } catch (Exception HITRzvAB) {
            HITRzvAB.printStackTrace();
        }
        boolean fBQRmE9k = GetterUtil.get(System.getProperty(SYSTEM_PROPERTIES_LOAD), true);
        boolean qS4LLFHk = GetterUtil.get(System.getProperty(SYSTEM_PROPERTIES_FINAL), true);
        if (fBQRmE9k) {
            Enumeration JVCA3Yvo = XYe8Z9C3.propertyNames();
            while (JVCA3Yvo.hasMoreElements()) {
                String bVJFAgzY = (String) JVCA3Yvo.nextElement();
                if (qS4LLFHk || Validator.isNull(System.getProperty(bVJFAgzY))) {
                    System.setProperty(bVJFAgzY, (String) XYe8Z9C3.get(bVJFAgzY));
                }
            }
        }
        PropertiesUtil.fromProperties(XYe8Z9C3, _props);
    }

}