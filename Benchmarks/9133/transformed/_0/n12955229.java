class n12955229 {
	public static void copyFile(File rGPyb1Yn, File PVBsLDVm, boolean hPtchKGT)
			throws IOException, DirNotFoundException, FileNotFoundException, FileExistsAlreadyException {
		File ykBrrfWc = new File(PVBsLDVm.getParent());
		if (!ykBrrfWc.exists()) {
			throw new DirNotFoundException(ykBrrfWc.getAbsolutePath());
		}
		if (!rGPyb1Yn.exists()) {
			throw new FileNotFoundException(rGPyb1Yn.getAbsolutePath());
		}
		if (!hPtchKGT && PVBsLDVm.exists()) {
			throw new FileExistsAlreadyException(PVBsLDVm.getAbsolutePath());
		}
		FileInputStream wSPaBREl = new FileInputStream(rGPyb1Yn);
		FileOutputStream YQy5hJ8j = new FileOutputStream(PVBsLDVm);
		byte[] VREe01F7 = new byte[8 * 1024];
		int SV7L1o68 = 0;
		do {
			YQy5hJ8j.write(VREe01F7, 0, SV7L1o68);
			SV7L1o68 = wSPaBREl.read(VREe01F7, 0, VREe01F7.length);
		} while (SV7L1o68 != -1);
		wSPaBREl.close();
		YQy5hJ8j.close();
	}

}