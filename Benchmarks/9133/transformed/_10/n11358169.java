class n11358169 {
	public void backupFile(File fromFile, File toFile) {
		FileOutputStream to = null;
		FileInputStream from = null;
		try {
			to = new FileOutputStream(toFile);
			from = new FileInputStream(fromFile);
			int bytesRead;
			byte[] buffer = new byte[4096];
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
		}
	}

}