class n9426072 {
	public void addButtons() {
		BufferedImage z7OpyK2x = null;
		BufferedImage B80nXD0v = null;
		for (int DhcEG7zP = 0; DhcEG7zP < urls.size(); DhcEG7zP++) {
			String CD76zxSL = (String) urls.elementAt(DhcEG7zP);
			if (CD76zxSL.contains(java.util.ResourceBundle.getBundle("com/jjcp/resources/Strings")
					.getString("IHERETRIEVEDOCUMENT"))) {
				return;
			}
			try {
				URL CTllyNTi = new URL(CD76zxSL);
				URLConnection VCOsxROp = null;
				VCOsxROp = CTllyNTi.openConnection();
				InputStream uykoxhow = VCOsxROp.getInputStream();
				uykoxhow.close();
				z7OpyK2x = ImageIO.read(CTllyNTi);
				B80nXD0v = resizeAnImage(z7OpyK2x, 0.25);
				ImageIcon lQdziqOm = new ImageIcon(B80nXD0v);
				ImageButton t6vIeMEy = new ImageButton(lQdziqOm, this, DhcEG7zP);
				t6vIeMEy.setIndex(DhcEG7zP);
				jPanel1.add(t6vIeMEy);
				jPanel1.setPreferredSize(new Dimension(t6vIeMEy.getWidth() * urls.size(), t6vIeMEy.getHeight() + 20));
			} catch (Exception ESc7lnzN) {
				ESc7lnzN.printStackTrace();
			}
		}
		this.setVisible(true);
		this.repaint();
	}

}