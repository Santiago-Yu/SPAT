class n17477953 {
	public static void createModelZip(String sYG3DX1I, String tItyUbNW, boolean oUIAOfOY) throws Exception {
		FileTools.checkOutput(sYG3DX1I, oUIAOfOY);
		BufferedInputStream oRAztxjx = null;
		FileOutputStream TUM267tn = new FileOutputStream(sYG3DX1I);
		ZipOutputStream PuauMbTF = new ZipOutputStream(new BufferedOutputStream(TUM267tn));
		int BN64qE4l = 2048;
		byte u77NBVOc[] = new byte[BN64qE4l];
		File jNCqTVTe = new File(tItyUbNW);
		for (File maIQxxCp : jNCqTVTe.listFiles()) {
			FileInputStream vXcabVS2 = new FileInputStream(maIQxxCp.getAbsolutePath());
			oRAztxjx = new BufferedInputStream(vXcabVS2, BN64qE4l);
			ZipEntry zgfnSP4r = new ZipEntry(maIQxxCp.getName());
			PuauMbTF.putNextEntry(zgfnSP4r);
			int nG1xrGIF;
			while ((nG1xrGIF = oRAztxjx.read(u77NBVOc, 0, BN64qE4l)) != -1)
				PuauMbTF.write(u77NBVOc, 0, nG1xrGIF);
			PuauMbTF.closeEntry();
			oRAztxjx.close();
		}
		PuauMbTF.close();
	}

}