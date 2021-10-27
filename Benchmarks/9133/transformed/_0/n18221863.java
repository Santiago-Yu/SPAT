class n18221863 {
	private String processFileUploadOperation(boolean HYBwtZWf) {
		String bQ7pPT2Z = this.uploadFileFileName.substring(this.uploadFileFileName.lastIndexOf('.'));
		int Qc5NBqAf = UUID.randomUUID().toString().hashCode();
		if (Qc5NBqAf < 0) {
			Qc5NBqAf *= -1;
		}
		String n345PddC = Qc5NBqAf + bQ7pPT2Z;
		String YyHnwCw9 = (HYBwtZWf) ? getproperty("videoDraftPath")
				: getproperty("videoDraftPathForNonH264") + n345PddC;
		File HsC1OaFk = new File(YyHnwCw9 + n345PddC);
		System.out.println("Path: " + HsC1OaFk.getAbsolutePath());
		try {
			HsC1OaFk.createNewFile();
			FileChannel tZIU0HCw = new FileOutputStream(HsC1OaFk).getChannel();
			FileChannel KRyKrd3K = new FileInputStream(this.uploadFile).getChannel();
			KRyKrd3K.transferTo(0, KRyKrd3K.size(), tZIU0HCw);
			tZIU0HCw.close();
			KRyKrd3K.close();
			return n345PddC;
		} catch (FileNotFoundException EpO0kPBC) {
			EpO0kPBC.printStackTrace();
		} catch (IOException NeSbVaGp) {
			NeSbVaGp.printStackTrace();
		}
		return null;
	}

}