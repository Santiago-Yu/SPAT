    public static String fromHtml(URL url, String defaultEncoding, boolean overrideEncoding) throws IOException, BadDocumentException {
        URLConnection conn = url.openConnection();
        String contentType = conn.getContentType();
        String encoding = conn.getContentEncoding();
        if (encoding == null) {
            int i = contentType.indexOf("charset");
            if (i >= 0) {
                String s = contentType.substring(i);
                i = s.indexOf('=');
                if (i >= 0) {
                    s = contentType.substring(i + 1).trim();
                    encoding = s.replace("\'", "").replace("\"", "").trim();
                    if (encoding.equals("")) {
                        encoding = defaultEncoding;
                    }
                }
            } else {
                encoding = defaultEncoding;
            }
        }
        String expected = "text/html";
        if (contentType == null) {
            DefaultXMLNoteErrorHandler.warning(null, 90190, "Returned content type for url.openConnection() is null");
            contentType = expected;
        }
        int index = contentType.indexOf(';');
        if (index >= 0) {
            contentType = contentType.substring(0, index).trim();
        }
        if (!contentType.equals(expected)) {
            String msg = translator.translate("The content type of url '%s' is not '%s', it is '%s'");
            throw new BadDocumentException(String.format(msg, url.toString(), expected, contentType));
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
        return fromHtml(in, encoding);
    }
