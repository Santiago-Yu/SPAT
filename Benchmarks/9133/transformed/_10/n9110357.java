class n9110357 {
	public ArrayList<Jane16Results> callExternalService(ServiceType type, HashMap<String, String> params)
			throws Exception {
		URL url = initURL(type, params);
		XMLParser parser = initParser(type);
		ArrayList<Jane16Results> results = new ArrayList<Jane16Results>();
		InputStream in = url.openStream();
		ArrayList<Byte> arrByte = new ArrayList<Byte>();
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			for (int i = 0; i < len; i++) {
				arrByte.add(buf[i]);
			}
		}
		in.close();
		int i = 0;
		byte[] data = new byte[arrByte.size()];
		for (Byte b : arrByte) {
			data[i++] = b;
		}
		results = parser.parse(data);
		return results;
	}

}