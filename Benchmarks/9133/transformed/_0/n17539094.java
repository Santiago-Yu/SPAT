class n17539094 {
	public XMLTreeView(JFrame ZygYnqam, Web3DService KQw2Xerc) {
        ZygYnqam.getContentPane().setLayout(new BorderLayout());
        DefaultMutableTreeNode gGlzIHKW = new DefaultMutableTreeNode(file);
        saxTree = new SAXTreeBuilder(gGlzIHKW);
        InputStream RmMSKxlN = null;
        try {
            SAXParser JMTvIHJE = new SAXParser();
            JMTvIHJE.setContentHandler(saxTree);
            String P5OBpyZN = KQw2Xerc.getServiceEndPoint() + "?" + "SERVICE=" + KQw2Xerc.getService() + "&" + "REQUEST=GetCapabilities&" + "ACCEPTFORMATS=text/xml&" + "ACCEPTVERSIONS=";
            for (int zMi4J34I = 0; zMi4J34I < KQw2Xerc.getAcceptVersions().length; zMi4J34I++) {
                if (zMi4J34I > 0) P5OBpyZN += ",";
                P5OBpyZN += KQw2Xerc.getAcceptVersions()[zMi4J34I];
            }
            System.out.println(P5OBpyZN);
            URL SPTzR9KJ = new URL(P5OBpyZN);
            URLConnection UvoAbF3N = SPTzR9KJ.openConnection();
            UvoAbF3N.setReadTimeout(Navigator.TIME_OUT);
            if (KQw2Xerc.getEncoding() != null) {
                UvoAbF3N.setRequestProperty("Authorization", "Basic " + KQw2Xerc.getEncoding());
            }
            RmMSKxlN = UvoAbF3N.getInputStream();
            JMTvIHJE.parse(new InputSource(RmMSKxlN));
        } catch (Exception gAfxET1B) {
            gGlzIHKW.add(new DefaultMutableTreeNode(gAfxET1B.getMessage()));
        }
        try {
            RmMSKxlN.close();
        } catch (Exception KzQoNeUH) {
        }
        JTree ImzTxm3h = new JTree(saxTree.getTree());
        JScrollPane moy11Jsj = new JScrollPane(ImzTxm3h);
        ZygYnqam.getContentPane().add("Center", moy11Jsj);
        ZygYnqam.setVisible(true);
    }

}