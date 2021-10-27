class n10062074 {
	private long generateUnixInstallShell(File JIWxZo2M, String rCuBeVdP, File LwIgz89W) throws IOException {
		FileOutputStream hkijA6ar = new FileOutputStream(JIWxZo2M);
		InputStream RxqFB7MH = getClass().getResourceAsStream("/" + rCuBeVdP);
		InputStreamReader YXzw6zuk = new InputStreamReader(RxqFB7MH);
		LineNumberReader qBuENT01 = new LineNumberReader(YXzw6zuk);
		String mzft3l3m = "";
		String MIVRNwwo = "000000000000";
		NumberFormat lZq7Z6n6 = NumberFormat.getInstance(Locale.US);
		lZq7Z6n6.setGroupingUsed(false);
		lZq7Z6n6.setMinimumIntegerDigits(MIVRNwwo.length());
		int dw55tyaQ = 0;
		long Sbt3o3Ls = 0;
		System.out.println(VAGlobals.i18n("VAArchiver_GenerateInstallShell"));
		String spjdxRWi = qBuENT01.readLine();
		while ((spjdxRWi != null) && (!spjdxRWi.startsWith("# InstallClassStart"))) {
			mzft3l3m += spjdxRWi + "\n";
			spjdxRWi = qBuENT01.readLine();
		}
		mzft3l3m += "InstallClassStart=" + MIVRNwwo + "\n";
		dw55tyaQ = mzft3l3m.length() - 1 - 1 - MIVRNwwo.length();
		spjdxRWi = qBuENT01.readLine();
		while ((spjdxRWi != null) && (!spjdxRWi.startsWith("# InstallClassSize"))) {
			mzft3l3m += spjdxRWi + "\n";
			spjdxRWi = qBuENT01.readLine();
		}
		mzft3l3m += new String("InstallClassSize=" + LwIgz89W.length() + "\n");
		spjdxRWi = qBuENT01.readLine();
		while ((spjdxRWi != null) && (!spjdxRWi.startsWith("# InstallClassName"))) {
			mzft3l3m += spjdxRWi + "\n";
			spjdxRWi = qBuENT01.readLine();
		}
		mzft3l3m += new String("InstallClassName=" + instClassName_ + "\n");
		spjdxRWi = qBuENT01.readLine();
		while ((spjdxRWi != null) && (!spjdxRWi.startsWith("# Install class"))) {
			mzft3l3m += spjdxRWi + "\n";
			spjdxRWi = qBuENT01.readLine();
		}
		if (spjdxRWi != null)
			mzft3l3m += spjdxRWi + "\n";
		hkijA6ar.write(mzft3l3m.substring(0, dw55tyaQ + 1).getBytes());
		hkijA6ar.write(lZq7Z6n6.format(mzft3l3m.length()).getBytes());
		hkijA6ar.write(mzft3l3m.substring(dw55tyaQ + 1 + MIVRNwwo.length()).getBytes());
		Sbt3o3Ls = mzft3l3m.length();
		mzft3l3m = null;
		FileInputStream Aca59j9L = new FileInputStream(LwIgz89W);
		byte[] JW5xwZAD = new byte[2048];
		int oBWirOpM = Aca59j9L.read(JW5xwZAD);
		while (oBWirOpM > 0) {
			hkijA6ar.write(JW5xwZAD, 0, oBWirOpM);
			oBWirOpM = Aca59j9L.read(JW5xwZAD);
		}
		Aca59j9L.close();
		qBuENT01.close();
		hkijA6ar.close();
		return Sbt3o3Ls;
	}

}