class n18170211 {
	static List<String> readZipFilesOftypeToFolder(String zipFileLocation, String outputDir, String fileType) {
		ZipFile zipFile = readZipFile(zipFileLocation);
		List<String> list = new ArrayList<String>();
		InputStream inputStream = null;
		FileOutputStream output = null;
		Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();
		try {
			while (entries.hasMoreElements()) {
				java.util.zip.ZipEntry entry = entries.nextElement();
				String entryName = entry.getName();
				if (entryName != null && entryName.toLowerCase().endsWith(fileType)) {
					String fileName = outputDir + entryName.substring(entryName.lastIndexOf("/"));
					inputStream = zipFile.getInputStream(entry);
					File file = new File(fileName);
					output = new FileOutputStream(file);
					IOUtils.copy(inputStream, output);
					list.add(fileName);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (output != null)
					output.close();
				if (inputStream != null)
					inputStream.close();
				if (zipFile != null)
					zipFile.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return list;
	}

}