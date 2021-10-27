class n21742963 {
	public static void main(String[] PTTGFfV9) throws Exception {
		if (PTTGFfV9.length != 2) {
			System.out.println("usage: PutFromFile [properties file] [file with pmpxml]");
			throw new IllegalArgumentException("Wrong number of arguments");
		}
		Reader y96Dt1eG = new FileReader(PTTGFfV9[1]);
		char[] rIDyESi5 = new char[1024];
		StringBuffer hzhNidvZ = new StringBuffer();
		int c3M6N2Ag;
		while ((c3M6N2Ag = y96Dt1eG.read(rIDyESi5)) > 0) {
			hzhNidvZ.append(rIDyESi5, 0, c3M6N2Ag);
		}
		String LA7iK3mr = hzhNidvZ.toString();
		System.out.println(LA7iK3mr);
		String M8IFmEXX = PTTGFfV9[0];
		String EqpfzcGJ = "verb=PutRecord&xml=" + URLEncoder.encode(LA7iK3mr, "UTF-8");
		URL reFz4iz4 = new URL(M8IFmEXX);
		URLConnection TgxH9DLS = reFz4iz4.openConnection();
		TgxH9DLS.setDoOutput(true);
		OutputStreamWriter eIraEVlp = new OutputStreamWriter(TgxH9DLS.getOutputStream());
		eIraEVlp.write(EqpfzcGJ);
		eIraEVlp.flush();
		BufferedReader FMKTfa2t = new BufferedReader(new InputStreamReader(TgxH9DLS.getInputStream()));
		String HAbKLwBV;
		while ((HAbKLwBV = FMKTfa2t.readLine()) != null) {
			System.out.println(HAbKLwBV);
		}
		eIraEVlp.close();
		FMKTfa2t.close();
	}

}