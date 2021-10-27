class n22564546 {
	public void unzip(String resource) {
		File f = new File(resource);
		if (!f.exists())
			throw new RuntimeException("The specified resources does not exist (" + resource + ")");
		String parent = f.getParent().toString();
		try {
			FileInputStream fis = new FileInputStream(resource);
			BufferedOutputStream dest = null;
			ZipEntry entry;
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			while ((entry = zis.getNextEntry()) != null) {
				log.info("Extracting archive entry: " + entry);
				String entryPath = new StringBuilder(parent).append(System.getProperty("file.separator"))
						.append(entry.getName()).toString();
				int count;
				if (entry.isDirectory()) {
					log.info("Creating directory: " + entryPath);
					(new File(entryPath)).mkdir();
					continue;
				}
				FileOutputStream fos = new FileOutputStream(entryPath);
				byte data[] = new byte[BUFFER];
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1)
					dest.write(data, 0, count);
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}