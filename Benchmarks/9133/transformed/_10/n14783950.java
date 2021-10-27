class n14783950 {
	public static void compressWithZip(Vector fileList, String zipFileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(zipFileName);
		if (fileList == null || fileList.size() == 0)
			return;
		Iterator iter = fileList.iterator();
		ZipOutputStream zos = new ZipOutputStream(fos);
		while (iter.hasNext()) {
			String fileName = (String) iter.next();
			String shortName = "unknown";
			int ind = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));
			if (ind < fileName.length() - 1)
				shortName = fileName.substring(ind + 1);
			zos.putNextEntry(new ZipEntry(shortName));
			byte[] buf = new byte[10000];
			FileInputStream fis = new FileInputStream(fileName);
			int bytesRead;
			while ((bytesRead = fis.read(buf)) > 0)
				zos.write(buf, 0, bytesRead);
			fis.close();
			zos.closeEntry();
		}
		zos.close();
	}

}