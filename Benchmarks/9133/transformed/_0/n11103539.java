class n11103539 {
	public void compressFile(String HNlQItPE) {
		String hDfBGE4w = HNlQItPE + ".zip";
		try {
			FileInputStream ywJ2tPa7 = new FileInputStream(HNlQItPE);
			GZIPOutputStream eN4QQs9z = new GZIPOutputStream(new FileOutputStream(hDfBGE4w));
			byte[] KMWxpUI3 = new byte[4096];
			int ngMwb2Tr;
			while ((ngMwb2Tr = ywJ2tPa7.read(KMWxpUI3)) != -1)
				eN4QQs9z.write(KMWxpUI3, 0, ngMwb2Tr);
			ywJ2tPa7.close();
			eN4QQs9z.close();
		} catch (Exception CIC6KcYH) {
			CIC6KcYH.printStackTrace();
		}
	}

}