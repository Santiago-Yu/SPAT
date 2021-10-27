class n16210657{
    public SimpleParser(String filepath) throws Exception {
        this.path = filepath;
        InputStream is = null;
        try {
            if (this.path.indexOf("http") == 0) {
                URL url = new URL(this.path);
                is = url.openStream();
            } else if (this.path.indexOf("<?xml") == 0) {
                is = new ByteArrayInputStream(filepath.getBytes(encoding));
            } else {
                File f = new File(this.path);
                if (!f.exists()) {
                    setError("File not found : " + this.path);
                } else {
                    is = new FileInputStream(f);
                }
            }
            if (is != null) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(is);
                doc.getDocumentElement().normalize();
            }
        } catch (Exception ex) {
            Malgn.errorLog("{SimpleParser.constructor} Path:" + filepath + " " + ex.getMessage());
            setError("Parser Error : " + ex.getMessage());
        } finally {
            if (is != null) is.close();
        }
    }

}