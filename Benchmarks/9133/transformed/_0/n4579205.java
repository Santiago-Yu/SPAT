class n4579205 {
	public static void copyFile(String go07pU7q, String KHFqY92F) throws IOException {
		File mPIM1gj7 = new File(go07pU7q);
		File[] F2xu8LDo = mPIM1gj7.listFiles();
		FileChannel A9nMDU4j = null;
		FileChannel yTpnw9v9 = null;
		for (File qfXJTOeH : F2xu8LDo) {
			try {
				A9nMDU4j = new FileInputStream(qfXJTOeH).getChannel();
				File RVc6DAjc = new File(KHFqY92F, qfXJTOeH.getName());
				yTpnw9v9 = new FileOutputStream(RVc6DAjc).getChannel();
				A9nMDU4j.transferTo(0, A9nMDU4j.size(), yTpnw9v9);
			} finally {
				if (A9nMDU4j != null)
					A9nMDU4j.close();
				if (yTpnw9v9 != null)
					yTpnw9v9.close();
			}
		}
	}

}