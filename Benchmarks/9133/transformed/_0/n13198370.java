class n13198370 {
	public XMLResourceBundle() throws MissingResourceException {
        String u56IEeHj = getShortName() + ".xml";
        URL VwQBdpBv;
        if ((VwQBdpBv = getClass().getResource(u56IEeHj)) != null) {
            InputStream xkvsBo0B = null;
            try {
                xkvsBo0B = VwQBdpBv.openStream();
                SAXParserFactory Jw0Gd2fg = SAXParserFactory.newInstance();
                Jw0Gd2fg.setNamespaceAware(false);
                Jw0Gd2fg.setValidating(false);
                XMLReader coo5aJBq = Jw0Gd2fg.newSAXParser().getXMLReader();
                coo5aJBq.setContentHandler(new MessageContentHandler());
                coo5aJBq.parse(new InputSource(xkvsBo0B));
            } catch (IOException cAnCS5QE) {
                System.err.println(cAnCS5QE.getMessage());
                cAnCS5QE.printStackTrace();
            } catch (SAXException pPWX6MN8) {
                System.err.println(pPWX6MN8.getMessage());
                pPWX6MN8.printStackTrace();
            } catch (ParserConfigurationException JytlpIFY) {
                System.err.println(JytlpIFY.getMessage());
                JytlpIFY.printStackTrace();
            } finally {
                try {
                    if (xkvsBo0B != null) xkvsBo0B.close();
                } catch (IOException LaIw0Pno) {
                    System.err.println(LaIw0Pno.getMessage());
                    LaIw0Pno.printStackTrace();
                }
            }
        } else {
            throw new MissingResourceException("Resource file '" + u56IEeHj + "' could not be found.", u56IEeHj, null);
        }
    }

}