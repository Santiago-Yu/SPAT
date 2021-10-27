class n22958786 {
	public JGroundStationBrowser(Frame parent) {
        this.parent = parent;
        initComponents();
        topTreeNode = new DefaultMutableTreeNode("Ground Stations");
        treeModel = new DefaultTreeModel(topTreeNode);
        groundStationTree.setModel(treeModel);
        String currentSecondaryNodeName = null;
        DefaultMutableTreeNode currentSecondaryNode = null;
        try {
            BufferedReader gsReader = null;
            if (new File(groundStationDB).exists()) {
                File gsFile = new File(groundStationDB);
                FileReader gsFileReader = new FileReader(gsFile);
                gsReader = new BufferedReader(gsFileReader);
            } else {
                URL url = new URL("http://www.gano.name/shawn/JSatTrak/" + groundStationDB);
                URLConnection c = url.openConnection();
                InputStreamReader isr = new InputStreamReader(c.getInputStream());
                gsReader = new BufferedReader(isr);
            }
            String nextLine = null;
            int gsCount = 0;
            while ((nextLine = gsReader.readLine()) != null) {
                String[] elements = nextLine.split(",");
                if (elements.length == 5) {
                    String network = elements[0];
                    String stationName = elements[1];
                    double stationLat = Double.parseDouble(elements[2]);
                    double stationLon = Double.parseDouble(elements[3]);
                    double stationAlt = Double.parseDouble(elements[4]);
                    gsHash.put(stationName, new double[] { stationLat, stationLon, stationAlt });
                    if (!network.equalsIgnoreCase(currentSecondaryNodeName)) {
                        currentSecondaryNode = new DefaultMutableTreeNode(network);
                        topTreeNode.add(currentSecondaryNode);
                        currentSecondaryNodeName = network;
                    }
                    currentSecondaryNode.add(new DefaultMutableTreeNode(stationName));
                    gsCount += 1;
                }
            }
            gsReader.close();
            if (new File(groundStationCustomDB).exists()) {
                File gsFile = new File(groundStationCustomDB);
                FileReader gsFileReader = new FileReader(gsFile);
                gsReader = new BufferedReader(gsFileReader);
                customSecondaryNode = new DefaultMutableTreeNode("Custom");
                topTreeNode.add(customSecondaryNode);
                while ((nextLine = gsReader.readLine()) != null) {
                    String[] elements = nextLine.split(",");
                    if (elements.length == 5) {
                        String network = elements[0];
                        String stationName = elements[1];
                        double stationLat = Double.parseDouble(elements[2]);
                        double stationLon = Double.parseDouble(elements[3]);
                        double stationAlt = Double.parseDouble(elements[4]);
                        gsHash.put(stationName, new double[] { stationLat, stationLon, stationAlt });
                        customSecondaryNode.add(new DefaultMutableTreeNode(stationName));
                        gsCount += 1;
                    }
                }
                gsReader.close();
            } else {
                customSecondaryNode = new DefaultMutableTreeNode("Custom");
                topTreeNode.add(customSecondaryNode);
            }
            statusTextField.setText("Total Ground Stations loaded: " + gsCount);
            groundStationTree.expandRow(0);
        } catch (Exception e) {
            System.out.println("ERROR IN GROUND STATION READING POSSIBLE FILE FORMAT OR MISSING FILES:");
            e.printStackTrace();
            JOptionPane.showMessageDialog(parent, "Error Loading Ground Station Data. Check data.\n" + e.toString(), "Data LOADING ERROR", JOptionPane.ERROR_MESSAGE);
        }
        groundStationTree.setTransferHandler(new TreeGroundStationTransferHandler(gsHash));
        groundStationTree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    }

}