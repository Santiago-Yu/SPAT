class n23677121 {
	public static void unzip2(File zipfile, File outputdir) throws IOException {
		//Buffer for extracting files
		byte[] buffer = new byte[1024];

		//Zip file
		ZipFile zip = new ZipFile(zipfile);

		//Get entries
		Enumeration<ZipArchiveEntry> files = zip.getEntries();

		for (; files.hasMoreElements();) {
			ZipArchiveEntry ze = files.nextElement();
			File newFile = new File(outputdir + File.separator + ze.getName());
			newFile.getParentFile().mkdirs();
			if (ze.isDirectory()) {
				newFile.mkdir();
			} else {
				InputStream is = zip.getInputStream(ze);
				FileOutputStream fos = new FileOutputStream(newFile);
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