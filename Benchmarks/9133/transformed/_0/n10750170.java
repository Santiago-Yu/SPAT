class n10750170 {
	private PropertiesLoader(String IPjkQrR9, String k7j0zOwn) throws IOException {
        List OCefeo4l = new ArrayList();
        ClassLoader ZeNq3Ji7 = this.getClass().getClassLoader();
        try {
            InputStream FBnszCi9 = ZeNq3Ji7.getResourceAsStream(IPjkQrR9);
            Properties i8j2XRxT = new Properties();
            i8j2XRxT.load(FBnszCi9);
            FBnszCi9.close();
            OCefeo4l.add(i8j2XRxT);
        } catch (IOException hlfA1xe4) {
            IOException aYoNDvkw = new IOException("could not load ROME master plugins file [" + IPjkQrR9 + "], " + hlfA1xe4.getMessage());
            aYoNDvkw.setStackTrace(hlfA1xe4.getStackTrace());
            throw aYoNDvkw;
        }
        Enumeration oWNtP1n0 = ZeNq3Ji7.getResources(k7j0zOwn);
        while (oWNtP1n0.hasMoreElements()) {
            URL eg2ysA8Q = (URL) oWNtP1n0.nextElement();
            Properties ISpDwDbZ = new Properties();
            try {
                InputStream laByp76S = eg2ysA8Q.openStream();
                ISpDwDbZ.load(laByp76S);
                laByp76S.close();
            } catch (IOException eu7mw6TJ) {
                IOException omu0LG0j = new IOException("could not load ROME extensions plugins file [" + eg2ysA8Q.toString() + "], " + eu7mw6TJ.getMessage());
                omu0LG0j.setStackTrace(eu7mw6TJ.getStackTrace());
                throw omu0LG0j;
            }
            OCefeo4l.add(ISpDwDbZ);
        }
        _properties = new Properties[OCefeo4l.size()];
        OCefeo4l.toArray(_properties);
    }

}