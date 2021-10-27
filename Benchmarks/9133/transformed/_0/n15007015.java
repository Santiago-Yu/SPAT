class n15007015 {
	public static byte[] wrapBMP(Image YS9C2Nf9) throws IOException {
		if (YS9C2Nf9.getOriginalType() != Image.ORIGINAL_BMP)
			throw new IOException("Only BMP can be wrapped in WMF.");
		InputStream ctZjkj3m;
		byte nkTB4EQO[] = null;
		if (YS9C2Nf9.getOriginalData() == null) {
			ctZjkj3m = YS9C2Nf9.url().openStream();
			ByteArrayOutputStream erPzp3cM = new ByteArrayOutputStream();
			int AG83wsA5 = 0;
			while ((AG83wsA5 = ctZjkj3m.read()) != -1)
				erPzp3cM.write(AG83wsA5);
			ctZjkj3m.close();
			nkTB4EQO = erPzp3cM.toByteArray();
		} else
			nkTB4EQO = YS9C2Nf9.getOriginalData();
		int Xhiulrvp = (nkTB4EQO.length - 14 + 1) >>> 1;
		ByteArrayOutputStream FfRIdlK2 = new ByteArrayOutputStream();
		writeWord(FfRIdlK2, 1);
		writeWord(FfRIdlK2, 9);
		writeWord(FfRIdlK2, 0x0300);
		writeDWord(FfRIdlK2, 9 + 4 + 5 + 5 + (13 + Xhiulrvp) + 3);
		writeWord(FfRIdlK2, 1);
		writeDWord(FfRIdlK2, 14 + Xhiulrvp);
		writeWord(FfRIdlK2, 0);
		writeDWord(FfRIdlK2, 4);
		writeWord(FfRIdlK2, META_SETMAPMODE);
		writeWord(FfRIdlK2, 8);
		writeDWord(FfRIdlK2, 5);
		writeWord(FfRIdlK2, META_SETWINDOWORG);
		writeWord(FfRIdlK2, 0);
		writeWord(FfRIdlK2, 0);
		writeDWord(FfRIdlK2, 5);
		writeWord(FfRIdlK2, META_SETWINDOWEXT);
		writeWord(FfRIdlK2, (int) YS9C2Nf9.height());
		writeWord(FfRIdlK2, (int) YS9C2Nf9.width());
		writeDWord(FfRIdlK2, 13 + Xhiulrvp);
		writeWord(FfRIdlK2, META_DIBSTRETCHBLT);
		writeDWord(FfRIdlK2, 0x00cc0020);
		writeWord(FfRIdlK2, (int) YS9C2Nf9.height());
		writeWord(FfRIdlK2, (int) YS9C2Nf9.width());
		writeWord(FfRIdlK2, 0);
		writeWord(FfRIdlK2, 0);
		writeWord(FfRIdlK2, (int) YS9C2Nf9.height());
		writeWord(FfRIdlK2, (int) YS9C2Nf9.width());
		writeWord(FfRIdlK2, 0);
		writeWord(FfRIdlK2, 0);
		FfRIdlK2.write(nkTB4EQO, 14, nkTB4EQO.length - 14);
		if ((nkTB4EQO.length & 1) == 1)
			FfRIdlK2.write(0);
		writeDWord(FfRIdlK2, 3);
		writeWord(FfRIdlK2, 0);
		FfRIdlK2.close();
		return FfRIdlK2.toByteArray();
	}

}