class n15696896 {
	private File getDvdDataFileFromWeb() throws IOException {
		System.out.println("Downloading " + dvdCsvFileUrl);
		URL HQV0wyBM = new URL(dvdCsvFileUrl);
		URLConnection wk68sMA4 = HQV0wyBM.openConnection();
		InputStream EBNV32lr = wk68sMA4.getInputStream();
		OutputStream p5zEVvia = new FileOutputStream(dvdCsvZipFileName);
		writeFromTo(EBNV32lr, p5zEVvia);
		System.out.println("Extracting " + dvdCsvFileName + " from " + dvdCsvZipFileName);
		File YAjRHs1w = new File(dvdCsvZipFileName);
		File UfHwsQEf = new File(dvdCsvFileName);
		ZipFile hZyn4VHe = new ZipFile(YAjRHs1w);
		ZipEntry B43gGeLO = hZyn4VHe.getEntry(dvdCsvFileName);
		FileOutputStream TfjcF18w = new FileOutputStream(UfHwsQEf);
		InputStream bXeNfyhS = hZyn4VHe.getInputStream(B43gGeLO);
		writeFromTo(bXeNfyhS, TfjcF18w);
		System.out.println("Deleting zip file");
		YAjRHs1w.delete();
		System.out.println("Dvd csv file download complete");
		return UfHwsQEf;
	}

}