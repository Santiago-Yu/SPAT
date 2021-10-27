class n15831694 {
	public static void copyFile(File D30EPzcE, File oVic16VF) throws IOException {
		FileChannel IlBhYZY5 = new FileInputStream(D30EPzcE).getChannel();
		FileChannel ZTsg5EJ2 = new FileOutputStream(oVic16VF).getChannel();
		try {
			IlBhYZY5.transferTo(0, IlBhYZY5.size(), ZTsg5EJ2);
		} catch (IOException Q34xMgaW) {
			throw Q34xMgaW;
		} finally {
			if (IlBhYZY5 != null)
				IlBhYZY5.close();
			if (ZTsg5EJ2 != null)
				ZTsg5EJ2.close();
		}
	}

}