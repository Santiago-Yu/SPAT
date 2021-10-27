class n5365678{
    public void buildDocument(Files page) {
        String uri = constructFileUrlString(page, true);
        URL url;
        try {
            url = new URL(uri);
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            Reader reader = new InputStreamReader(in, "UTF8");
            xsltInputSource = new InputSourceImpl(reader, uri);
            xsltInputSource.setEncoding("utf-8");
            UserAgentContext ucontext = new CobraConfig.LocalUserAgentContext();
            HtmlRendererContext rendererContext = new CobraConfig.LocalHtmlRendererContext(htmlPanel, ucontext);
            DocumentBuilderImpl builder = new DocumentBuilderImpl(rendererContext.getUserAgentContext(), rendererContext);
            xsltDocument = builder.parse(xsltInputSource);
            htmlPanel.setDocument(xsltDocument, rendererContext);
            documentHolder = xsltDocument.toString();
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}