class n13309014 {
	public String[] getElements() throws IOException {
		Vector arhnyuhu = new Vector();
		PushbackInputStream HAhfQJHy = null;
		try {
			URLConnection zkWGXeCT = dtdURL.openConnection();
			HAhfQJHy = new PushbackInputStream(new BufferedInputStream(zkWGXeCT.getInputStream()));
			while (scanForLTBang(HAhfQJHy)) {
				String D7xAZ9PY = getString(HAhfQJHy);
				if (D7xAZ9PY.equals("ELEMENT")) {
					skipWhiteSpace(HAhfQJHy);
					String UVArHzOq = getString(HAhfQJHy);
					arhnyuhu.addElement(UVArHzOq);
				}
			}
			HAhfQJHy.close();
			String[] LQsHfNSZ = new String[arhnyuhu.size()];
			arhnyuhu.copyInto(LQsHfNSZ);
			return LQsHfNSZ;
		} catch (Exception eZaEc4y9) {
			if (HAhfQJHy != null) {
				try {
					HAhfQJHy.close();
				} catch (Exception NDT6Q8M8) {
				}
			}
			throw new IOException("Error reading DTD: " + eZaEc4y9.toString());
		}
	}

}