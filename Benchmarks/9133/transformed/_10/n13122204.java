class n13122204 {
	public static void unzipModel(String filename, String tempdir) throws EDITSException {
		try {
			FileInputStream fis = new FileInputStream(filename);
			BufferedOutputStream dest = null;
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			int BUFFER = 2048;
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				byte data[] = new byte[BUFFER];
				int count;
				FileOutputStream fos = new FileOutputStream(tempdir + entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1)
					dest.write(data, 0, count);
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			throw new EDITSException("Can not expand model in \"" + tempdir + "\" because:\n" + e.getMessage());
		}
	}

}