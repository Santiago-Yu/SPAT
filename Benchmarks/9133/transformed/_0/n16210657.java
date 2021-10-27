class n16210657 {
	public SimpleParser(String AQlhJ5iB) throws Exception {
        this.path = AQlhJ5iB;
        InputStream Wc8277Nd = null;
        try {
            if (this.path.indexOf("http") == 0) {
                URL ZEMecd6i = new URL(this.path);
                Wc8277Nd = ZEMecd6i.openStream();
            } else if (this.path.indexOf("<?xml") == 0) {
                Wc8277Nd = new ByteArrayInputStream(AQlhJ5iB.getBytes(encoding));
            } else {
                File hJqurICu = new File(this.path);
                if (!hJqurICu.exists()) {
                    setError("File not found : " + this.path);
                } else {
                    Wc8277Nd = new FileInputStream(hJqurICu);
                }
            }
            if (Wc8277Nd != null) {
                DocumentBuilderFactory GPZeWVjS = DocumentBuilderFactory.newInstance();
                DocumentBuilder g02hJqPh = GPZeWVjS.newDocumentBuilder();
                doc = g02hJqPh.parse(Wc8277Nd);
                doc.getDocumentElement().normalize();
            }
        } catch (Exception de83CSIO) {
            Malgn.errorLog("{SimpleParser.constructor} Path:" + AQlhJ5iB + " " + de83CSIO.getMessage());
            setError("Parser Error : " + de83CSIO.getMessage());
        } finally {
            if (Wc8277Nd != null) Wc8277Nd.close();
        }
    }

}