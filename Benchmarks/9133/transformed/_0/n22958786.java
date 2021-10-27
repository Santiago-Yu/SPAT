class n22958786 {
	public JGroundStationBrowser(Frame m0CeWKQK) {
        this.parent = m0CeWKQK;
        initComponents();
        topTreeNode = new DefaultMutableTreeNode("Ground Stations");
        treeModel = new DefaultTreeModel(topTreeNode);
        groundStationTree.setModel(treeModel);
        String RsY3zwsZ = null;
        DefaultMutableTreeNode t4IDyRtw = null;
        try {
            BufferedReader JOh55tPq = null;
            if (new File(groundStationDB).exists()) {
                File VyFS8wXr = new File(groundStationDB);
                FileReader n9fcaRYD = new FileReader(VyFS8wXr);
                JOh55tPq = new BufferedReader(n9fcaRYD);
            } else {
                URL cZ96eRi7 = new URL("http://www.gano.name/shawn/JSatTrak/" + groundStationDB);
                URLConnection UuGWSxmL = cZ96eRi7.openConnection();
                InputStreamReader Z6oflGEV = new InputStreamReader(UuGWSxmL.getInputStream());
                JOh55tPq = new BufferedReader(Z6oflGEV);
            }
            String rhgrficx = null;
            int ROk7QizQ = 0;
            while ((rhgrficx = JOh55tPq.readLine()) != null) {
                String[] voOFCROz = rhgrficx.split(",");
                if (voOFCROz.length == 5) {
                    String bUmqapGr = voOFCROz[0];
                    String O7UTDtzA = voOFCROz[1];
                    double YCszxrGr = Double.parseDouble(voOFCROz[2]);
                    double eIRwSyhS = Double.parseDouble(voOFCROz[3]);
                    double V5i6Whan = Double.parseDouble(voOFCROz[4]);
                    gsHash.put(O7UTDtzA, new double[] { YCszxrGr, eIRwSyhS, V5i6Whan });
                    if (!bUmqapGr.equalsIgnoreCase(RsY3zwsZ)) {
                        t4IDyRtw = new DefaultMutableTreeNode(bUmqapGr);
                        topTreeNode.add(t4IDyRtw);
                        RsY3zwsZ = bUmqapGr;
                    }
                    t4IDyRtw.add(new DefaultMutableTreeNode(O7UTDtzA));
                    ROk7QizQ++;
                }
            }
            JOh55tPq.close();
            if (new File(groundStationCustomDB).exists()) {
                File nFSXNmta = new File(groundStationCustomDB);
                FileReader OL7KJz3O = new FileReader(nFSXNmta);
                JOh55tPq = new BufferedReader(OL7KJz3O);
                customSecondaryNode = new DefaultMutableTreeNode("Custom");
                topTreeNode.add(customSecondaryNode);
                while ((rhgrficx = JOh55tPq.readLine()) != null) {
                    String[] kitgOgDq = rhgrficx.split(",");
                    if (kitgOgDq.length == 5) {
                        String c5As6gnv = kitgOgDq[0];
                        String cFplyIHC = kitgOgDq[1];
                        double FbtJT51m = Double.parseDouble(kitgOgDq[2]);
                        double ev0G1rIN = Double.parseDouble(kitgOgDq[3]);
                        double BLKnZJcD = Double.parseDouble(kitgOgDq[4]);
                        gsHash.put(cFplyIHC, new double[] { FbtJT51m, ev0G1rIN, BLKnZJcD });
                        customSecondaryNode.add(new DefaultMutableTreeNode(cFplyIHC));
                        ROk7QizQ++;
                    }
                }
                JOh55tPq.close();
            } else {
                customSecondaryNode = new DefaultMutableTreeNode("Custom");
                topTreeNode.add(customSecondaryNode);
            }
            statusTextField.setText("Total Ground Stations loaded: " + ROk7QizQ);
            groundStationTree.expandRow(0);
        } catch (Exception Js6sP7z9) {
            System.out.println("ERROR IN GROUND STATION READING POSSIBLE FILE FORMAT OR MISSING FILES:");
            Js6sP7z9.printStackTrace();
            JOptionPane.showMessageDialog(m0CeWKQK, "Error Loading Ground Station Data. Check data.\n" + Js6sP7z9.toString(), "Data LOADING ERROR", JOptionPane.ERROR_MESSAGE);
        }
        groundStationTree.setTransferHandler(new TreeGroundStationTransferHandler(gsHash));
        groundStationTree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
    }

}