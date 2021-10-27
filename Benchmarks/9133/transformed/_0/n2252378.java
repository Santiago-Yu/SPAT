class n2252378 {
	private static void copyFile(File GAs4SBNf, File tWYAsfOH) throws IOException {
		FileChannel OmhibQIW = new FileInputStream(GAs4SBNf).getChannel();
		FileChannel P7iXNrt3 = new FileOutputStream(tWYAsfOH).getChannel();
		try {
			OmhibQIW.transferTo(0, OmhibQIW.size(), P7iXNrt3);
		} catch (IOException h25p0tE6) {
			throw h25p0tE6;
		} finally {
			if (OmhibQIW != null)
				OmhibQIW.close();
			if (P7iXNrt3 != null)
				P7iXNrt3.close();
		}
	}

}