class n11199367 {
	private void copy(FileInfo msROiZsh, FileInfo lq77KY3f) {
		try {
			FileReader eOUDMnT8 = new FileReader(msROiZsh.file);
			FileWriter apgD8ZPb = new FileWriter(lq77KY3f.file);
			int KxfcQfcw;
			while ((KxfcQfcw = eOUDMnT8.read()) != -1)
				apgD8ZPb.write(KxfcQfcw);
			eOUDMnT8.close();
			apgD8ZPb.close();
			lq77KY3f.file.setLastModified(msROiZsh.lastModified);
		} catch (IOException BQ5ScAOW) {
		}
	}

}