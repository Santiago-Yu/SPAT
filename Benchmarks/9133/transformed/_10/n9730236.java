class n9730236 {
	public static void copy(String fromFileName, String toFileName) throws IOException {
		File toFile = new File(toFileName);
		File fromFile = new File(fromFileName);
		FileOutputStream to = null;
		FileInputStream from = null;
		try {
			to = new FileOutputStream(toFile);
			from = new FileInputStream(fromFile);
			int bytesRead;
			byte[] buffer = new byte[4096];
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} finally {
			from.close();
			to.close();
		}
	}

}