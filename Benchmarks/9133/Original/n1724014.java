class n1724014{
    public Component loadComponent(URI uri, URI origuri) throws ComponentException {
        if (usePrivMan) PrivilegeManager.enablePrivilege("UniversalConnect");
        ConzillaRDFModel model = factory.createModel(origuri, uri);
        RDFParser parser = new com.hp.hpl.jena.rdf.arp.StanfordImpl();
        java.net.URL url = null;
        try {
            url = uri.getJavaURL();
        } catch (java.net.MalformedURLException e) {
            throw new ComponentException("Invalid URL " + uri + " for component " + origuri + ":\n " + e.getMessage());
        }
        try {
            InputSource source = new InputSource(url.openStream());
            source.setSystemId(origuri.toString());
            parser.parse(source, new ModelConsumer(model));
            factory.getTotalModel().addModel(model);
        } catch (org.xml.sax.SAXException se) {
            se.getException().printStackTrace();
            throw new ComponentException("Format error loading URL " + url + " for component " + origuri + ":\n " + se.getMessage());
        } catch (java.io.IOException se) {
            throw new ComponentException("IO error loading URL " + url + " for component " + origuri + ":\n " + se.getMessage());
        } catch (org.w3c.rdf.model.ModelException se) {
            throw new ComponentException("Model error loading URL " + url + " for component " + origuri + ":\n " + se.getMessage());
        }
        return model;
    }

}