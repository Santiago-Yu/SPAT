class n14291788 {
	protected Configuration() {
        try {
            Enumeration<URL> p5CIlwWn = getClass().getClassLoader().getResources("activejdbc_models.properties");
            while (p5CIlwWn.hasMoreElements()) {
                URL ghdOzlDY = p5CIlwWn.nextElement();
                LogFilter.log(logger, "Load models from: " + ghdOzlDY.toExternalForm());
                InputStream n1RFoK9J = null;
                try {
                    n1RFoK9J = ghdOzlDY.openStream();
                    BufferedReader cRw0O5p2 = new BufferedReader(new InputStreamReader(n1RFoK9J));
                    String c3V9RGXl;
                    while ((c3V9RGXl = cRw0O5p2.readLine()) != null) {
                        String[] jUgXLezv = Util.split(c3V9RGXl, ':');
                        String rIpRFaKi = jUgXLezv[0];
                        String W4ELOG9r = jUgXLezv[1];
                        if (modelsMap.get(W4ELOG9r) == null) {
                            modelsMap.put(W4ELOG9r, new ArrayList<String>());
                        }
                        modelsMap.get(W4ELOG9r).add(rIpRFaKi);
                    }
                } catch (IOException RKRxZz2H) {
                    RKRxZz2H.printStackTrace();
                } finally {
                    if (n1RFoK9J != null) n1RFoK9J.close();
                }
            }
        } catch (IOException dZRJp3Kn) {
            throw new InitException(dZRJp3Kn);
        }
        if (modelsMap.isEmpty()) {
            LogFilter.log(logger, "ActiveJDBC Warning: Cannot locate any models, assuming project without models.");
            return;
        }
        try {
            InputStream fSlmL8jy = getClass().getResourceAsStream("/activejdbc.properties");
            if (fSlmL8jy != null) properties.load(fSlmL8jy);
        } catch (Exception jEjHg2r8) {
            throw new InitException(jEjHg2r8);
        }
        String FE6TFe2u = properties.getProperty("cache.manager");
        if (FE6TFe2u != null) {
            try {
                Class mGDHrSf1 = Class.forName(FE6TFe2u);
                cacheManager = (CacheManager) mGDHrSf1.newInstance();
            } catch (Exception KWd7HqZM) {
                throw new InitException("failed to initialize a CacheManager. Please, ensure that the property " + "'cache.manager' points to correct class which extends 'activejdbc.cache.CacheManager' class and provides a default constructor.", KWd7HqZM);
            }
        }
    }

}