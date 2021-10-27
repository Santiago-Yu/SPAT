class n17539094 {
	public XMLTreeView(JFrame frame, Web3DService web3DService) {
        frame.getContentPane().setLayout(new BorderLayout());
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(file);
        InputStream urlIn = null;
        saxTree = new SAXTreeBuilder(top);
        try {
            SAXParser saxParser = new SAXParser();
            saxParser.setContentHandler(saxTree);
            String request = web3DService.getServiceEndPoint() + "?" + "SERVICE=" + web3DService.getService() + "&" + "REQUEST=GetCapabilities&" + "ACCEPTFORMATS=text/xml&" + "ACCEPTVERSIONS=";
            for (int i = 0; i < web3DService.getAcceptVersions().length; i++) {
                if (i > 0) request += ",";
                request += web3DService.getAcceptVersions()[i];
            }
            System.out.println(request);
            URL url = new URL(request);
            URLConnection urlc = url.openConnection();
            urlc.setReadTimeout(Navigator.TIME_OUT);
            if (web3DService.getEncoding() != null) {
                urlc.setRequestProperty("Authorization", "Basic " + web3DService.getEncoding());
            }
            urlIn = urlc.getInputStream();
            saxParser.parse(new InputSource(urlIn));
        } catch (Exception ex) {
            top.add(new DefaultMutableTreeNode(ex.getMessage()));
        }
        try {
            urlIn.close();
        } catch (Exception e) {
        }
        JTree tree = new JTree(saxTree.getTree());
        JScrollPane scrollPane = new JScrollPane(tree);
        frame.getContentPane().add("Center", scrollPane);
        frame.setVisible(true);
    }

}