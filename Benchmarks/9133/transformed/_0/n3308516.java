class n3308516 {
	public String[] doGeoQuery(String L9aHplxg) throws IOException {
		String cm1m0KpH = "http://maps.google.com/maps/geo?output=csv&keyABQIAAAAct2NN7QKbyiMr1rfhB6UGBQn1DChMmG6tCCZd3aXbcL03vlL5hSUZpyoaGCXRwjbRTSBi0L89DeYeg&q=";
		URL Ss8slGIA = new URL(cm1m0KpH + URLEncoder.encode(L9aHplxg, "UTF-8"));
		URLConnection Iyk3F7k8 = Ss8slGIA.openConnection();
		StringBuffer vyK1RitK = new StringBuffer();
		InputStream JLIFpBFo = (InputStream) Iyk3F7k8.getContent();
		int TaRFvO1T = -1;
		while ((TaRFvO1T = JLIFpBFo.read()) != -1) {
			vyK1RitK.append((char) TaRFvO1T);
		}
		log.info("Geo Query " + Ss8slGIA.toExternalForm() + " => " + vyK1RitK.toString());
		return vyK1RitK.toString().split(",");
	}

}