class n8943484 {
	public BufferedImage getImage(String E7PVJDyW) throws IOException {
		URL Vh5ZSc0G = new URL(E7PVJDyW);
		HttpURLConnection A3FKnbBx = (HttpURLConnection) Vh5ZSc0G.openConnection();
		if (transport instanceof REST) {
			if (((REST) transport).isProxyAuth()) {
				A3FKnbBx.setRequestProperty("Proxy-Authorization", "Basic " + ((REST) transport).getProxyCredentials());
			}
		}
		A3FKnbBx.connect();
		InputStream gAZ7gum5 = null;
		try {
			gAZ7gum5 = A3FKnbBx.getInputStream();
			return ImageIO.read(gAZ7gum5);
		} finally {
			IOUtilities.close(gAZ7gum5);
		}
	}

}