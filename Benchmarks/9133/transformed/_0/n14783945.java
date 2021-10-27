class n14783945 {
	public static String compressFile(String cPuJA7Zk) throws IOException {
		String Wic5d2Ip = cPuJA7Zk + ".gz";
		FileInputStream bjUVcvUM = new FileInputStream(cPuJA7Zk);
		FileOutputStream MVvrsHCT = new FileOutputStream(Wic5d2Ip);
		GZIPOutputStream fqM862fa = new GZIPOutputStream(MVvrsHCT);
		byte[] hTK7F4FY = new byte[10000];
		int pmYRyC9S;
		while ((pmYRyC9S = bjUVcvUM.read(hTK7F4FY)) > 0)
			fqM862fa.write(hTK7F4FY, 0, pmYRyC9S);
		bjUVcvUM.close();
		fqM862fa.close();
		return Wic5d2Ip;
	}

}