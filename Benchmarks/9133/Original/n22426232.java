class n22426232{
    public Element rootFromURL(URL url) throws org.jdom.JDOMException, java.io.IOException {
        Element e;
        try {
            InputStream stream = new BufferedInputStream(url.openConnection().getInputStream());
            return getRootViaURI(verify, stream);
        } catch (org.jdom.input.JDOMParseException e4) {
            throw e4;
        } catch (org.jdom.JDOMException e1) {
            if (!openWarn1) reportError1(url.toString(), e1);
            openWarn1 = true;
            try {
                InputStream stream = new BufferedInputStream(url.openConnection().getInputStream());
                e = getRootViaURL(verify, stream);
                log.info("getRootViaURL succeeded as 2nd try");
                return e;
            } catch (org.jdom.JDOMException e2) {
                if (!openWarn2) reportError2(url.toString(), e2);
                openWarn2 = true;
                InputStream stream = new BufferedInputStream(url.openConnection().getInputStream());
                e = getRootViaRelative(verify, stream);
                log.info("GetRootViaRelative succeeded as 3rd try");
                new Exception().printStackTrace();
                return e;
            }
        }
    }

}