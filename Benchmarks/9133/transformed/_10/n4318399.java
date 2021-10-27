class n4318399 {
	private void unzipEntry(ZipFile zipfile, ZipEntry entry, File outputDir, BackUpInfoFileGroup fileGroup,
			LinkedList<String> restoreList) {
		LinkedList<BackUpInfoFile> fileList = fileGroup.getFileList();
		if (entry.isDirectory()) {
			createDir(new File(outputDir, entry.getName()));
			return;
		}
		for (int i = 0; i < fileList.size(); i++) {
			if (fileList.get(i).getId().equals(entry.getName())) {
				for (int j = 0; j < restoreList.size(); j++) {
					if ((fileList.get(i).getName() + "." + fileList.get(i).getType()).equals(restoreList.get(j))) {
						counter += 1;
						File outputFile = new File(outputDir,
								fileList.get(i).getName() + "." + fileList.get(i).getType());
						BufferedInputStream inputStream;
						if (!outputFile.getParentFile().exists()) {
							createDir(outputFile.getParentFile());
						}
						BufferedOutputStream outputStream;
						try {
							outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
							inputStream = new BufferedInputStream(zipfile.getInputStream(entry));
							IOUtils.copy(inputStream, outputStream);
							outputStream.close();
							inputStream.close();
						} catch (IOException ex) {
							throw new BackupException(ex.getMessage());
						}
					}
				}
			}
		}
	}

}