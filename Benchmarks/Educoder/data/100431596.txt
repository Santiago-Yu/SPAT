    public Vector parse(String link) {
        addMessage("Parsing: " + link);
        links.removeAllElements();
        URLConnection conn = null;
        Reader rd = null;
        EditorKit kit = new HTMLEditorKit();
        Document doc = kit.createDefaultDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException err) {
            System.out.println("Malformed URL");
            return links;
        }
        try {
            conn = new URL(link).openConnection();
            rd = new InputStreamReader(conn.getInputStream());
        } catch (Exception err) {
            err.printStackTrace();
            return links;
        }
        try {
            kit.read(rd, doc, 0);
            ElementIterator it = new ElementIterator(doc);
            javax.swing.text.Element elem;
            while ((elem = it.next()) != null) {
                SimpleAttributeSet s = (SimpleAttributeSet) elem.getAttributes().getAttribute(HTML.Tag.A);
                if (s != null) {
                    if (s.toString().indexOf("script") >= 0) continue;
                    String lnk = "";
                    try {
                        lnk = s.getAttribute(HTML.Attribute.HREF).toString();
                    } catch (Exception err) {
                        continue;
                    }
                    int j = 0;
                    if ((j = lnk.indexOf('#')) >= 0) lnk = lnk.substring(0, j);
                    URL urlLink = new URL(url, lnk);
                    if (!url.getHost().equals(urlLink.getHost())) continue;
                    String str = urlLink.toString();
                    if (!str.startsWith("http")) continue;
                    if (str.endsWith(".pdf")) {
                        continue;
                    }
                    for (int i = 0; i < leaveSuffix.length; i++) {
                        if ((str.endsWith(leaveSuffix[i]))) continue;
                    }
                    boolean skip = false;
                    for (int i = 0; i < suffix.length; i++) {
                        if ((str.endsWith(suffix[i]))) skip = true;
                    }
                    if (!skip) {
                        try {
                            conn = urlLink.openConnection();
                        } catch (Exception err) {
                        }
                        String contentType = null;
                        if (contentType == null) contentType = conn.getContentType();
                        if (contentType.equals("application/pdf")) {
                            continue;
                        } else if (!contentType.equals("text/html")) {
                            continue;
                        }
                    }
                    if (!links.contains(urlLink.toString())) {
                        links.addElement(urlLink.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return links;
    }
