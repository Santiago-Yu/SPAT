class n22600512 {
	public void readFully(String z1mW1gP4) throws Exception {
		URL eLblnbdB = new URL(z1mW1gP4);
		URLConnection xhiquOuf = eLblnbdB.openConnection();
		InputStream wi0KmTuk = xhiquOuf.getInputStream();
		byte[] iNEZsonP = new byte[10240];
		int lM0Xvkkr = wi0KmTuk.read(iNEZsonP);
		while (lM0Xvkkr > 0) {
			size += lM0Xvkkr;
			lM0Xvkkr = wi0KmTuk.read(iNEZsonP);
		}
		wi0KmTuk.close();
	}

}