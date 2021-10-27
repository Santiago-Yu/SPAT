class n13048961 {
	private final void saveCopy(String source, String destination) {
		BufferedOutputStream to = null;
		BufferedInputStream from = null;
		try {
			to = new BufferedOutputStream(new FileOutputStream(destination));
			from = new BufferedInputStream(new FileInputStream(source));
			int bytes_read;
			byte[] buffer = new byte[65535];
			while ((bytes_read = from.read(buffer)) != -1)
				to.write(buffer, 0, bytes_read);
		} catch (Exception e) {
			LogWriter.writeLog("Exception " + e + " copying file");
		}
		try {
			to.close();
			from.close();
		} catch (Exception e) {
			LogWriter.writeLog("Exception " + e + " closing files");
		}
		from = null;
		to = null;
	}

}