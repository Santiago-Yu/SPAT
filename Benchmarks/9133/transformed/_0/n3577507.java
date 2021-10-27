class n3577507 {
	public static void copyFile(File yLJpJuzj, File gm9CWMYk) throws IOException {
		FileChannel ZmZxXYnv = new FileInputStream(yLJpJuzj).getChannel();
		FileChannel E4SShDNu = new FileOutputStream(gm9CWMYk).getChannel();
		try {
			ZmZxXYnv.transferTo(0, ZmZxXYnv.size(), E4SShDNu);
		} finally {
			if (ZmZxXYnv != null)
				ZmZxXYnv.close();
			if (E4SShDNu != null)
				E4SShDNu.close();
		}
	}

}