class n23677120 {
	public static void unzip1(File zipfile, File outputdir) throws IOException {
		if (!outputdir.exists()) {
			outputdir.mkdirs();
		}

		byte[] buffer = new byte[1024];

		//Create the zip input stream
		//OR ArchiveInputStream zis = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, new FileInputStream(zipfile));
		ArchiveInputStream zis = new ZipArchiveInputStream(new FileInputStream(zipfile));

		//Iterate through the entries of the zip file, and extract them to the output directory
		ArchiveEntry ae = zis.getNextEntry(); // OR zis.getNextZipEntry()
		while (ae != null) {
			//Resolve new file
			File newFile = new File(outputdir + File.separator + ae.getName());

			//Create parent directories if not exists
			if (!newFile.getParentFile().exists())
				newFile.getParentFile().mkdirs();

			if (ae.isDirectory()) { //If directory, create if not exists
				if (!newFile.exists())
					newFile.mkdir();
			} else { //If file, write file
				int len;
				FileOutputStream fos = new FileOutputStream(newFile);
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
			}

			//Proceed to the next entry in the zip file
			ae = zis.getNextEntry();
		}

		//Cleanup
		zis.close();
	}

}