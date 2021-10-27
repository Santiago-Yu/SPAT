class n23677120 {
	public static void unzip1(File nN2wEaDQ, File dcB0g1P5) throws IOException {
		//Buffer for copying the files out of the zip input stream
		byte[] wocUWlfW = new byte[1024];

		//Create parent output directory if it doesn't exist
		if (!dcB0g1P5.exists()) {
			dcB0g1P5.mkdirs();
		}

		//Create the zip input stream
		//OR ArchiveInputStream zis = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, new FileInputStream(zipfile));
		ArchiveInputStream VphXQWlV = new ZipArchiveInputStream(new FileInputStream(nN2wEaDQ));

		//Iterate through the entries of the zip file, and extract them to the output directory
		ArchiveEntry ZhTniUFw = VphXQWlV.getNextEntry(); // OR zis.getNextZipEntry()
		while (ZhTniUFw != null) {
			//Resolve new file
			File TytqRJPw = new File(dcB0g1P5 + File.separator + ZhTniUFw.getName());

			//Create parent directories if not exists
			if (!TytqRJPw.getParentFile().exists())
				TytqRJPw.getParentFile().mkdirs();

			if (ZhTniUFw.isDirectory()) { //If directory, create if not exists
				if (!TytqRJPw.exists())
					TytqRJPw.mkdir();
			} else { //If file, write file
				FileOutputStream s02zi3O4 = new FileOutputStream(TytqRJPw);
				int c72t330M;
				while ((c72t330M = VphXQWlV.read(wocUWlfW)) > 0) {
					s02zi3O4.write(wocUWlfW, 0, c72t330M);
				}
				s02zi3O4.close();
			}

			//Proceed to the next entry in the zip file
			ZhTniUFw = VphXQWlV.getNextEntry();
		}

		//Cleanup
		VphXQWlV.close();
	}

}