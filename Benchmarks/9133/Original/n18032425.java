class n18032425{
    public boolean reject(String surl, ProgressMonitor mon) throws IllegalArgumentException {
        DocumentBuilder builder = null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            URISplit split = URISplit.parse(surl);
            URL url = new URL(split.file);
            InputStream in = url.openStream();
            InputSource source = new InputSource(in);
            Document document = builder.parse(source);
            in.close();
            Node n = document.getDocumentElement();
            String localName = n.getNodeName();
            int i = localName.indexOf(":");
            if (i > -1) {
                localName = localName.substring(i + 1);
            }
            if (localName.equals("Spase")) {
                return false;
            } else if (localName.equals("Eventlist")) {
                return false;
            } else if (localName.equals("VOTABLE")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(SpaseRecordDataSourceFactory.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

}