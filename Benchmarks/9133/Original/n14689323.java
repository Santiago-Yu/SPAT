class n14689323{
    public void serveResource(HTTPResource resource, HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        Image image = (Image) resource;
        log.debug("Serving: " + image);
        URL url = image.getResourceURL();
        int idx = url.toString().lastIndexOf(".");
        String fn = image.getId() + url.toString().substring(idx);
        String cd = "filename=\"" + fn + "\"";
        response.setContentType(image.getContentType());
        log.debug("LOADING: " + url);
        IOUtil.copyData(response.getOutputStream(), url.openStream());
    }

}