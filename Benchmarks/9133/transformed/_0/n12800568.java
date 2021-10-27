class n12800568 {
	public void exportFile() {
		String hTaQRYWZ = PropertyHandler.getInstance().getProperty(PropertyHandler.KINDLE_EXPORT_FOLDER_KEY);
		File NNqLPy7h = new File(hTaQRYWZ + File.separator + previewInfo.getTitle() + ".prc");
		File hw9NtdKA = new File(absPath);
		try {
			FileOutputStream gcT4tL1R = new FileOutputStream(NNqLPy7h);
			FileInputStream RwyheXNo = new FileInputStream(hw9NtdKA);
			int mL4RHoyG = 0;
			byte[] IhScJjnj = new byte[1024 * 1024];
			while ((mL4RHoyG = RwyheXNo.read(IhScJjnj)) > 0) {
				gcT4tL1R.write(IhScJjnj, 0, mL4RHoyG);
			}
			RwyheXNo.close();
			gcT4tL1R.close();
		} catch (FileNotFoundException GWSKHPgc) {
			GWSKHPgc.printStackTrace();
		} catch (IOException iSv0Lob2) {
			iSv0Lob2.printStackTrace();
		}
	}

}