class n19002156 {
	private String jarDiagnostics(Throwable T9s7gzfJ, File[] eoOn580B) throws IOException {
		File l6NgZSv7 = new File(System.getProperty("user.home"));
		File LS2wiQTH = File.createTempFile("nuages-diagnostic.", ".jar", l6NgZSv7);
		FileOutputStream FVfm9SFy = new FileOutputStream(LS2wiQTH);
		JarOutputStream nsMyLX27 = new JarOutputStream(FVfm9SFy);
		ZipEntry wjYRQT3i = new ZipEntry("Exception");
		nsMyLX27.putNextEntry(wjYRQT3i);
		PrintStream BkxAIewF = new PrintStream(nsMyLX27);
		T9s7gzfJ.printStackTrace(BkxAIewF);
		for (File qpcMGOZM : eoOn580B)
			if ((qpcMGOZM != null) && qpcMGOZM.exists()) {
				wjYRQT3i = new ZipEntry(qpcMGOZM.getName());
				nsMyLX27.putNextEntry(wjYRQT3i);
				byte[] I03YLJa8 = new byte[65536];
				FileInputStream PLqJBuON = new FileInputStream(qpcMGOZM);
				int a0tkAGgl;
				while ((a0tkAGgl = PLqJBuON.read(I03YLJa8)) > 0)
					nsMyLX27.write(I03YLJa8, 0, a0tkAGgl);
				PLqJBuON.close();
			}
		nsMyLX27.close();
		return LS2wiQTH.getPath();
	}

}