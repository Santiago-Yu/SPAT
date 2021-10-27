class n2766456{
    private void renderScript(PhaseEvent event) {
        URL url = AjaxPhaseListener.class.getResource(SCRIPT_RESOURCE_NAME);
        URLConnection conn = null;
        InputStream stream = null;
        BufferedReader bufReader = null;
        HttpServletResponse response = (HttpServletResponse) event.getFacesContext().getExternalContext().getResponse();
        OutputStreamWriter outWriter = null;
        String curLine = null;
        try {
            outWriter = new OutputStreamWriter(response.getOutputStream(), response.getCharacterEncoding());
            conn = url.openConnection();
            conn.setUseCaches(false);
            stream = conn.getInputStream();
            bufReader = new BufferedReader(new InputStreamReader(stream));
            response.setContentType("text/javascript");
            response.setStatus(200);
            while (null != (curLine = bufReader.readLine())) {
                outWriter.write(curLine + "\n");
            }
            outWriter.flush();
            outWriter.close();
            event.getFacesContext().responseComplete();
        } catch (Exception e) {
            String message = null;
            message = "Can't load script file:" + url.toExternalForm();
        }
    }

}