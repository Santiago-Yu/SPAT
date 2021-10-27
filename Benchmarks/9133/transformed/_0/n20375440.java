class n20375440 {
	public static void copyFile(File ELOibUxL, File NXc4RHhI) throws IOException {
		InputStream kddBeECQ = new FileInputStream(ELOibUxL);
		OutputStream MLaaDE1Q = new FileOutputStream(NXc4RHhI);
		byte Cej9G580[] = new byte[1024];
		int YFcyhcPG = 1;
		while (YFcyhcPG > 0) {
			YFcyhcPG = kddBeECQ.read(Cej9G580);
			if (YFcyhcPG > 0) {
				MLaaDE1Q.write(Cej9G580, 0, YFcyhcPG);
			}
		}
		kddBeECQ.close();
		MLaaDE1Q.close();
	}

}