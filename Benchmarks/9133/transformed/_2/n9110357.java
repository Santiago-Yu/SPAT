class n9110357 {
	public ArrayList<Jane16Results> callExternalService(ServiceType type, HashMap<String, String> params)
			throws Exception {
		URL url = initURL(type, params);
		XMLParser parser = initParser(type);
		InputStream in = url.openStream();
		ArrayList<Jane16Results> results = new ArrayList<Jane16Results>();
		byte[] buf = new byte[1024];
		ArrayList<Byte> arrByte = new ArrayList<Byte>();
		int len;
		for (; (len = in.read(buf)) > 0;) {
			for (int i = 0; i < len; i++) {
				arrByte.add(buf[i]);
			}
		}
		in.close();
		byte[] data = new byte[arrByte.size()];
		int i = 0;
		for (Byte b : arrByte) {
			data[i++] = b;
		}
		results = parser.parse(data);
		return results;
	}

}