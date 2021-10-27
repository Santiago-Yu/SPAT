class n10392922 {
	public static void copyCompletely(InputStream nEAxZmiW, OutputStream BtryF7CG) throws IOException {
		if ((BtryF7CG instanceof FileOutputStream) && (nEAxZmiW instanceof FileInputStream)) {
			try {
				FileChannel jQ6DdTSN = ((FileOutputStream) BtryF7CG).getChannel();
				FileChannel WIMFHGX8 = ((FileInputStream) nEAxZmiW).getChannel();
				WIMFHGX8.transferTo(0, Integer.MAX_VALUE, jQ6DdTSN);
				WIMFHGX8.close();
				jQ6DdTSN.close();
				return;
			} catch (Exception wuyI5gtw) {
			}
		}
		byte[] q28PF2vS = new byte[8192];
		while (true) {
			int PtNrmTKa = nEAxZmiW.read(q28PF2vS);
			if (PtNrmTKa < 0)
				break;
			BtryF7CG.write(q28PF2vS, 0, PtNrmTKa);
		}
		try {
			nEAxZmiW.close();
		} catch (IOException I4yHbgEG) {
		}
		try {
			BtryF7CG.close();
		} catch (IOException ApOhXGwl) {
		}
	}

}