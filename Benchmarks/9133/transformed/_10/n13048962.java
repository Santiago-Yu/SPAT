class n13048962 {
	public final void saveAsCopy(String current_image, String destination) {
		BufferedOutputStream to = null;
		BufferedInputStream from = null;
		String source = temp_dir + key + current_image;
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
	}

}