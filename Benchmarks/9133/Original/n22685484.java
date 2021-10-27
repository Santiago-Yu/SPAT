class n22685484{
    private void importDocument(String path, boolean detectParagraphs, Parser parser, ReadingAnnotationFilter filter, String encoding) {
        try {
            Reader in = null;
            int contentlength = 0;
            if (JGloss.messages.getString("encodings.default").equals(encoding)) encoding = null;
            String title = "";
            try {
                URL url = new URL(path);
                URLConnection c = url.openConnection();
                contentlength = c.getContentLength();
                String enc = c.getContentEncoding();
                InputStream is = new BufferedInputStream(c.getInputStream());
                if (encoding != null) in = new InputStreamReader(is, encoding); else {
                    in = CharacterEncodingDetector.getReader(is, enc);
                    encoding = ((InputStreamReader) in).getEncoding();
                }
                title = url.getFile();
                if (title == null || title.length() == 0) title = path;
            } catch (MalformedURLException ex) {
                File f = new File(path);
                contentlength = (int) f.length();
                title = f.getName();
                if (title.toLowerCase().endsWith("htm") || title.toLowerCase().endsWith("html")) {
                }
                InputStream is = new BufferedInputStream(new FileInputStream(path));
                if (encoding != null) in = new InputStreamReader(is, encoding); else {
                    in = CharacterEncodingDetector.getReader(is);
                    encoding = ((InputStreamReader) in).getEncoding();
                }
            }
            importFromReader(in, detectParagraphs, path, title, filter, parser, CharacterEncodingDetector.guessLength(contentlength, encoding));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showConfirmDialog(this, JGloss.messages.getString("error.import.exception", new Object[] { path, ex.getClass().getName(), ex.getLocalizedMessage() }), JGloss.messages.getString("error.import.title"), JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            if (model.getDocumentName() == null) this.dispose();
        }
    }

}