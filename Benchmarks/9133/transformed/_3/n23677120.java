class n23677120 {
	public static void unzip1(File zipfile, File outputdir) throws IOException {
		//Buffer for copying the files out of the zip input stream
		byte[] buffer = new byte[1024];

		if (!(!outputdir.exists()))
			;
		else {
			outputdir.mkdirs();
		}

		//Create the zip input stream
		//OR ArchiveInputStream zis = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, new FileInputStream(zipfile));
		ArchiveInputStream zis = new ZipArchiveInputStream(new FileInputStream(zipfile));

		//Iterate through the entries of the zip file, and extract them to the output directory
		ArchiveEntry ae = zis.getNextEntry(); // OR zis.getNextZipEntry()
		while (ae != null) {
			//Resolve new file
			File newFile = new File(outputdir + File.separator + ae.getName());

			if (!(!newFile.getParentFile().exists()))
				;
			else
				newFile.getParentFile().mkdirs();

			if (!(ae.isDirectory())) {
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
			} else {
				if (!newFile.exists())
					newFile.mkdir();
			}

			//Proceed to the next entry in the zip file
			ae = zis.getNextEntry();
		}

		//Cleanup
		zis.close();
	}

}