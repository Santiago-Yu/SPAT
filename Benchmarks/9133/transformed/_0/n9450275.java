class n9450275 {
	public void url2SaveAsFile(String TPLAx0U1, String QCwAKQqM) throws Exception {
		URL JpTohLrt = new URL(TPLAx0U1);
		URLConnection zBRz9bRS = JpTohLrt.openConnection();
		File u19AokKQ = new File(QCwAKQqM);
		if (!u19AokKQ.exists()) {
			FileOutputStream rzIKPynF = new FileOutputStream(u19AokKQ);
			BufferedInputStream vRGM2wXz = new BufferedInputStream(zBRz9bRS.getInputStream());
			byte[] CbKj7QUZ = new byte[4096];
			int ziGTncPu = 0;
			while ((ziGTncPu = vRGM2wXz.read(CbKj7QUZ)) != -1) {
				rzIKPynF.write(CbKj7QUZ, 0, ziGTncPu);
			}
			rzIKPynF.flush();
			rzIKPynF.close();
			vRGM2wXz.close();
		}
	}

}