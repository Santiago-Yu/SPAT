class n15696896 {
	private File getDvdDataFileFromWeb() throws IOException {
		System.out.println("Downloading " + dvdCsvFileUrl);
		URL url = new URL(dvdCsvFileUrl);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		OutputStream out = new FileOutputStream(dvdCsvZipFileName);
		writeFromTo(in, out);
		System.out.println("Extracting " + dvdCsvFileName + " from " + dvdCsvZipFileName);
		File dvdZipFile = new File(dvdCsvZipFileName);
		ZipFile zipFile = new ZipFile(dvdZipFile);
		File dvdCsvFile = new File(dvdCsvFileName);
		FileOutputStream os = new FileOutputStream(dvdCsvFile);
		ZipEntry zipEntry = zipFile.getEntry(dvdCsvFileName);
		InputStream is = zipFile.getInputStream(zipEntry);
		writeFromTo(is, os);
		System.out.println("Deleting zip file");
		dvdZipFile.delete();
		System.out.println("Dvd csv file download complete");
		return dvdCsvFile;
	}

}