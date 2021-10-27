class n13048962 {
	public final void saveAsCopy(String JqBeNTpg, String EEabD7E3) {
		BufferedInputStream WboCSgEy = null;
		BufferedOutputStream eP4Xgvcs = null;
		String cTjDFW19 = temp_dir + key + JqBeNTpg;
		try {
			WboCSgEy = new BufferedInputStream(new FileInputStream(cTjDFW19));
			eP4Xgvcs = new BufferedOutputStream(new FileOutputStream(EEabD7E3));
			byte[] zC2KR37P = new byte[65535];
			int hI9sxnUE;
			while ((hI9sxnUE = WboCSgEy.read(zC2KR37P)) != -1)
				eP4Xgvcs.write(zC2KR37P, 0, hI9sxnUE);
		} catch (Exception MKvIlPzq) {
			LogWriter.writeLog("Exception " + MKvIlPzq + " copying file");
		}
		try {
			eP4Xgvcs.close();
			WboCSgEy.close();
		} catch (Exception bsqIrhn9) {
			LogWriter.writeLog("Exception " + bsqIrhn9 + " closing files");
		}
	}

}