class n23677121 {
	public static void unzip2(File zipfile, File outputdir) throws IOException {
		ZipFile zip = new ZipFile(zipfile);

		byte[] buffer = new byte[1024];

		//Get entries
		Enumeration<ZipArchiveEntry> files = zip.getEntries();

		//Iterate through the entries
		while (files.hasMoreElements()) {
			//Get entry
			ZipArchiveEntry ze = files.nextElement();

			//Resolve entry file
			File newFile = new File(outputdir + File.separator + ze.getName());

			//Make parent directories
			newFile.getParentFile().mkdirs();

			if (ze.isDirectory()) { //If directory, create it
				newFile.mkdir();
			} else { //If file, extract it
				FileOutputStream fos = new FileOutputStream(newFile);
				InputStream is = zip.getInputStream(ze);
				int len;
				while ((len = is.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				is.close();
			}
		}

		//Cleanup
		zip.close();
	}

}