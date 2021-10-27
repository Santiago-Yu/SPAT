class n23677121 {
	public static void unzip2(File ExupjJat, File doWgjQTb) throws IOException {
		//Buffer for extracting files
		byte[] B3UHyzUJ = new byte[1024];

		//Zip file
		ZipFile JLMIL0Sn = new ZipFile(ExupjJat);

		//Get entries
		Enumeration<ZipArchiveEntry> Bb4mkeBl = JLMIL0Sn.getEntries();

		//Iterate through the entries
		while (Bb4mkeBl.hasMoreElements()) {
			//Get entry
			ZipArchiveEntry VyJsVRCi = Bb4mkeBl.nextElement();

			//Resolve entry file
			File HtfTb2iF = new File(doWgjQTb + File.separator + VyJsVRCi.getName());

			//Make parent directories
			HtfTb2iF.getParentFile().mkdirs();

			if (VyJsVRCi.isDirectory()) { //If directory, create it
				HtfTb2iF.mkdir();
			} else { //If file, extract it
				InputStream V0zveuca = JLMIL0Sn.getInputStream(VyJsVRCi);
				FileOutputStream emuBIbMl = new FileOutputStream(HtfTb2iF);
				int A0koC0Mk;
				while ((A0koC0Mk = V0zveuca.read(B3UHyzUJ)) > 0) {
					emuBIbMl.write(B3UHyzUJ, 0, A0koC0Mk);
				}
				emuBIbMl.close();
				V0zveuca.close();
			}
		}

		//Cleanup
		JLMIL0Sn.close();
	}

}