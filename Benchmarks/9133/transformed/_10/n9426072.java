class n9426072 {
	public void addButtons() {
		BufferedImage bufImage1 = null;
		BufferedImage bufImage = null;
		for (int i = 0; i < urls.size(); i++) {
			String url = (String) urls.elementAt(i);
			if (url.contains(java.util.ResourceBundle.getBundle("com/jjcp/resources/Strings")
					.getString("IHERETRIEVEDOCUMENT"))) {
				return;
			}
			try {
				URLConnection conn = null;
				URL url1 = new URL(url);
				conn = url1.openConnection();
				InputStream in = conn.getInputStream();
				in.close();
				bufImage = ImageIO.read(url1);
				bufImage1 = resizeAnImage(bufImage, 0.25);
				ImageIcon icon = new ImageIcon(bufImage1);
				ImageButton imageButton = new ImageButton(icon, this, i);
				imageButton.setIndex(i);
				jPanel1.add(imageButton);
				jPanel1.setPreferredSize(
						new Dimension(imageButton.getWidth() * urls.size(), imageButton.getHeight() + 20));
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		this.setVisible(true);
		this.repaint();
	}

}