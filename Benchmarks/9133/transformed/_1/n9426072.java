class n9426072 {
	public void addButtons() {
		BufferedImage bufImage = null;
		BufferedImage bufImage1 = null;
		int ZZ1o6 = 0;
		while (ZZ1o6 < urls.size()) {
			String url = (String) urls.elementAt(ZZ1o6);
			if (url.contains(java.util.ResourceBundle.getBundle("com/jjcp/resources/Strings")
					.getString("IHERETRIEVEDOCUMENT"))) {
				return;
			}
			try {
				URL url1 = new URL(url);
				URLConnection conn = null;
				conn = url1.openConnection();
				InputStream in = conn.getInputStream();
				in.close();
				bufImage = ImageIO.read(url1);
				bufImage1 = resizeAnImage(bufImage, 0.25);
				ImageIcon icon = new ImageIcon(bufImage1);
				ImageButton imageButton = new ImageButton(icon, this, ZZ1o6);
				imageButton.setIndex(ZZ1o6);
				jPanel1.add(imageButton);
				jPanel1.setPreferredSize(
						new Dimension(imageButton.getWidth() * urls.size(), imageButton.getHeight() + 20));
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			ZZ1o6++;
		}
		this.setVisible(true);
		this.repaint();
	}

}