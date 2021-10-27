class n8132219 {
	public static void copyFile(String I5wpf3PL, String mQTYBVFf) {
		File qJy04QNc = new File(I5wpf3PL);
		File OhUqNJMm = new File(mQTYBVFf);
		try {
			FileChannel Ae6nSaZH = new FileInputStream(qJy04QNc).getChannel();
			FileChannel Qfx669nS = new FileOutputStream(OhUqNJMm).getChannel();
			try {
				Ae6nSaZH.transferTo(0, Ae6nSaZH.size(), Qfx669nS);
			} finally {
				if (Ae6nSaZH != null)
					Ae6nSaZH.close();
				if (Qfx669nS != null)
					Qfx669nS.close();
			}
		} catch (IOException UmuojuWi) {
			throw new RuntimeException(UmuojuWi);
		}
	}

}