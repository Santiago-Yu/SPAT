class n1428038{
    public void initializeWebInfo() throws MalformedURLException, IOException, DOMException {
        Tidy tidy = new Tidy();
        URL url = new URL(YOUTUBE_URL + videoId);
        InputStream in = url.openConnection().getInputStream();
        Document doc = tidy.parseDOM(in, null);
        Element e = doc.getDocumentElement();
        String title = null;
        if (e != null && e.hasChildNodes()) {
            NodeList children = e.getElementsByTagName("title");
            if (children != null) {
                for (int i = 0; i < children.getLength(); i++) {
                    try {
                        Element childE = (Element) children.item(i);
                        if (childE.getTagName().equals("title")) {
                            NodeList titleChildren = childE.getChildNodes();
                            for (int n = 0; n < titleChildren.getLength(); n++) {
                                if (titleChildren.item(n).getNodeType() == childE.TEXT_NODE) {
                                    title = titleChildren.item(n).getNodeValue();
                                }
                            }
                        }
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }
                }
            }
        }
        if (title == null || title.equals("")) {
            throw new DOMException(DOMException.NOT_FOUND_ERR, "no title found");
        } else {
            setTitle(title);
        }
    }

}