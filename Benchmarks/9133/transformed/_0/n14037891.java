class n14037891 {
	private void transformFile(File W4AknQc6, File wZLvsXoJ, Cipher CBgQiP1O, boolean kFpv9y4Y, String zrJYmwsT)
			throws IOException {
		FileInputStream ZgYXAQZj = new FileInputStream(W4AknQc6);
		InputStream HxQW26Z0;
		if (zrJYmwsT != null) {
			HxQW26Z0 = new ProgressMonitorInputStream(null, zrJYmwsT, ZgYXAQZj);
		} else {
			HxQW26Z0 = ZgYXAQZj;
		}
		FilterInputStream quhkSZNR = new BufferedInputStream(HxQW26Z0);
		FilterOutputStream cRphGJEe = new BufferedOutputStream(new FileOutputStream(wZLvsXoJ));
		FilterInputStream Mtsz0Ioy;
		FilterOutputStream x6ImObbs;
		if (kFpv9y4Y) {
			Mtsz0Ioy = quhkSZNR;
			x6ImObbs = new GZIPOutputStream(new CipherOutputStream(cRphGJEe, CBgQiP1O));
		} else {
			Mtsz0Ioy = new GZIPInputStream(new CipherInputStream(quhkSZNR, CBgQiP1O));
			x6ImObbs = cRphGJEe;
		}
		byte[] miv7peCC = new byte[CBgQiP1O.getBlockSize() * blocksInBuffer];
		int nNbDrTfX = Mtsz0Ioy.read(miv7peCC);
		while (nNbDrTfX != -1) {
			x6ImObbs.write(miv7peCC, 0, nNbDrTfX);
			nNbDrTfX = Mtsz0Ioy.read(miv7peCC);
		}
		if (kFpv9y4Y) {
			GZIPOutputStream cMW4Xd3h = (GZIPOutputStream) x6ImObbs;
			cMW4Xd3h.finish();
		}
		x6ImObbs.close();
		Mtsz0Ioy.close();
	}

}