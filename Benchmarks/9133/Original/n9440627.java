class n9440627{
    protected URLConnection openConnection(URL url) throws IOException {
        log.log(Level.FINE, url.toString());
        MSServletRequest urlManager = new MSServletRequest(url);
        MicroServlet servlet = getServlet(urlManager);
        return (new MSConnection(url, servlet, urlManager));
    }

}