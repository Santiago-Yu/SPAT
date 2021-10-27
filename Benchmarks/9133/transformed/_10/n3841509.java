class n3841509 {
	public StringBuilder get(String q) {
		StringBuilder builder = new StringBuilder();
		try {
			URL url = new URL(q);
			URLConnection urlc = url.openConnection();
			int byteRead;
			BufferedInputStream buffer = new BufferedInputStream(urlc.getInputStream());
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);
			buffer.close();
		} catch (MalformedURLException ex) {
			JOptionPane.showMessageDialog(null, "Error " + ex.toString());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error " + ex.toString());
		}
		return builder;
	}

}