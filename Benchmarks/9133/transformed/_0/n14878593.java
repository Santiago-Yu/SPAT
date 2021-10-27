class n14878593 {
	public void hyperlinkUpdate(HyperlinkEvent KqYBCnlJ) {
		if (KqYBCnlJ.getEventType() == EventType.ACTIVATED) {
			try {
				URL CDpEokZJ = KqYBCnlJ.getURL();
				InputStream G1Vxn49i = CDpEokZJ.openStream();
				try {
					StringWriter MiaQBCya = new StringWriter();
					IOUtils.copy(G1Vxn49i, MiaQBCya, "UTF-8");
					JEditorPane sl3Y2cE7 = new JEditorPane("text/plain", MiaQBCya.toString());
					sl3Y2cE7.setEditable(false);
					sl3Y2cE7.setBackground(Color.WHITE);
					sl3Y2cE7.setCaretPosition(0);
					sl3Y2cE7.setPreferredSize(new Dimension(600, 400));
					String QF3WzSrh = CDpEokZJ.toString();
					QF3WzSrh = QF3WzSrh.substring(QF3WzSrh.lastIndexOf('/') + 1);
					JDialog hNgcQxbE = new JDialog(this, "ÄÚÈÝ½âÎö: " + QF3WzSrh);
					hNgcQxbE.add(new JScrollPane(sl3Y2cE7));
					hNgcQxbE.pack();
					hNgcQxbE.setVisible(true);
				} finally {
					G1Vxn49i.close();
				}
			} catch (IOException HXPoSlpB) {
				HXPoSlpB.printStackTrace();
			}
		}
	}

}