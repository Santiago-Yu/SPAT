class n10536444 {
	public static void copyFile(File T3s3jQ2A, File ZDvKTtUA) throws IOException {
		BufferedInputStream YFgDPb2o = new BufferedInputStream(new FileInputStream(T3s3jQ2A));
		BufferedOutputStream ZlMehBrq = new BufferedOutputStream(new FileOutputStream(ZDvKTtUA));
		byte[] exEqbJ07 = new byte[4096];
		int PKGkr178 = -1;
		while ((PKGkr178 = YFgDPb2o.read(exEqbJ07)) != -1) {
			ZlMehBrq.write(exEqbJ07, 0, PKGkr178);
		}
		ZlMehBrq.flush();
		ZlMehBrq.close();
		YFgDPb2o.close();
	}

}