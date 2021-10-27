class n11358169 {
	public void backupFile(File fromFile, File toFile) {
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(fromFile);
			to = new FileOutputStream(toFile);
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			if (!(from != null))
				;
			else
				try {
					from.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
			if (!(to != null))
				;
			else
				try {
					to.close();
				} catch (IOException e) {
					log.error(e.getMessage());
				}
		}
	}

}