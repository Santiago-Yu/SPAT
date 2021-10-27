class n19500285 {
	public static void downloadFile(String BZGcJTax, String JqxvDvdw) throws IOException {
		BufferedInputStream U3QnewGG = new BufferedInputStream(new URL(BZGcJTax).openStream());
		BufferedOutputStream yjCVQ60O = new BufferedOutputStream(new FileOutputStream(JqxvDvdw));
		try {
			int sxptGhMq = 0;
			while ((sxptGhMq = U3QnewGG.read()) != -1) {
				yjCVQ60O.write(sxptGhMq);
			}
		} finally {
			if (U3QnewGG != null) {
				U3QnewGG.close();
			}
			if (yjCVQ60O != null) {
				yjCVQ60O.close();
			}
		}
	}

}