class n7209394 {
	public static void copyFile(File YyWxUhG4, File u7kAp5Du) throws IOException {
		FileChannel OcNGDrA7 = new FileInputStream(YyWxUhG4).getChannel();
		FileChannel K39IizQv = new FileOutputStream(u7kAp5Du).getChannel();
		try {
			int dcgrwqvr = (64 * 1024 * 1024) - (32 * 1024);
			long KThHkYMx = OcNGDrA7.size();
			long Ba5EDLBC = 0;
			while (Ba5EDLBC < KThHkYMx) {
				Ba5EDLBC += OcNGDrA7.transferTo(Ba5EDLBC, dcgrwqvr, K39IizQv);
			}
		} catch (IOException Nkcz4UQy) {
			throw Nkcz4UQy;
		} finally {
			if (OcNGDrA7 != null)
				OcNGDrA7.close();
			if (K39IizQv != null)
				K39IizQv.close();
		}
	}

}