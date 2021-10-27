class n9756057 {
	public void writeToFile(File BIjr3V9k) throws IOException, DocumentException {
		FileChannel rkAVePrs = new FileInputStream(pdf_file).getChannel();
		FileChannel HfKg3shy = new FileOutputStream(BIjr3V9k).getChannel();
		try {
			rkAVePrs.transferTo(0, rkAVePrs.size(), HfKg3shy);
		} catch (IOException PM4Fpevh) {
			throw PM4Fpevh;
		} finally {
			if (rkAVePrs != null)
				rkAVePrs.close();
			if (HfKg3shy != null)
				HfKg3shy.close();
		}
	}

}