class n21004812{
    @Override
    public void run(ProcedureRunner runner) throws Exception {
        if (url == null) {
            throw BuiltinExceptionFactory.createAttributeMissing(this, "url");
        }
        if (inputPath == null) {
            throw BuiltinExceptionFactory.createAttributeMissing(this, "inputPath");
        }
        CompositeMap context = runner.getContext();
        Object inputObject = context.getObject(inputPath);
        if (inputObject == null) throw BuiltinExceptionFactory.createDataFromXPathIsNull(this, inputPath);
        if (!(inputObject instanceof CompositeMap)) throw BuiltinExceptionFactory.createInstanceTypeWrongException(inputPath, CompositeMap.class, inputObject.getClass());
        URI uri = new URI(url);
        URL url = uri.toURL();
        PrintWriter out = null;
        BufferedReader br = null;
        CompositeMap soapBody = createSOAPBody();
        soapBody.addChild((CompositeMap) inputObject);
        String content = XMLOutputter.defaultInstance().toXML(soapBody.getRoot(), true);
        LoggingContext.getLogger(context, this.getClass().getCanonicalName()).config("request:\r\n" + content);
        HttpURLConnection httpUrlConnection = null;
        try {
            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setRequestProperty("SOAPAction", "urn:anonOutInOp");
            httpUrlConnection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            httpUrlConnection.connect();
            OutputStream os = httpUrlConnection.getOutputStream();
            out = new PrintWriter(os);
            out.println("<?xml version='1.0' encoding='UTF-8'?>");
            out.println(new String(content.getBytes("UTF-8")));
            out.flush();
            out.close();
            String soapResponse = null;
            CompositeMap soap = null;
            CompositeLoader cl = new CompositeLoader();
            if (HttpURLConnection.HTTP_OK == httpUrlConnection.getResponseCode()) {
                soap = cl.loadFromStream(httpUrlConnection.getInputStream());
                soapResponse = soap.toXML();
                LoggingContext.getLogger(context, this.getClass().getCanonicalName()).config("correct response:" + soapResponse);
            } else {
                soap = cl.loadFromStream(httpUrlConnection.getErrorStream());
                soapResponse = soap.toXML();
                LoggingContext.getLogger(context, this.getClass().getCanonicalName()).config("error response:" + soapResponse);
                if (raiseExceptionOnError) {
                    throw new ConfigurationFileException(WS_INVOKER_ERROR_CODE, new Object[] { url, soapResponse }, this);
                }
            }
            httpUrlConnection.disconnect();
            CompositeMap result = (CompositeMap) soap.getChild(SOAPServiceInterpreter.BODY.getLocalName()).getChilds().get(0);
            if (returnPath != null) runner.getContext().putObject(returnPath, result, true);
        } catch (Exception e) {
            LoggingContext.getLogger(context, this.getClass().getCanonicalName()).log(Level.SEVERE, "", e);
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                out.close();
            }
            if (br != null) {
                br.close();
            }
            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
        }
    }

}