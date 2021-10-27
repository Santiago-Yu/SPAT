class n16845107 {
	public boolean copyFile(File destinationFolder, File fromFile) {
		String toFileName = destinationFolder.getAbsolutePath() + "/" + fromFile.getName();
		boolean result = false;
		FileInputStream from = null;
		File toFile = new File(toFileName);
		FileOutputStream to = null;
		try {
			to = new FileOutputStream(toFile);
			from = new FileInputStream(fromFile);
			int bytesRead;
			byte[] buffer = new byte[4096];
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (from != null) {
				try {
					from.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if (to != null) {
					try {
						to.close();
						result = true;
					} catch (IOException e3) {
						e3.printStackTrace();
					}
				}
			}
		}
		return result;
	}

}