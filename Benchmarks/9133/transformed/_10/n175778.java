class n175778 {
	public void sendShape(String s) {
		try {
			URLConnection uc = new URL(url + "&add=" + s).openConnection();
			int b;
			InputStream in = uc.getInputStream();
			while ((b = in.read()) != -1) {
			}
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}