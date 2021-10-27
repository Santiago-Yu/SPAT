class n175778 {
	public void sendShape(String s) {
		try {
			URLConnection uc = new URL(url + "&add=" + s).openConnection();
			InputStream in = uc.getInputStream();
			int b;
			for (; (b = in.read()) != -1;) {
			}
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}