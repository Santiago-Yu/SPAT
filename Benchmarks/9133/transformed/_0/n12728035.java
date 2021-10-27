class n12728035 {
	public static void copyFile(File HQPOTHrv, File hXSylHKO) throws IOException {
		FileChannel Ns1ey6cI = new FileInputStream(HQPOTHrv).getChannel();
		FileChannel ncuNcVpw = new FileOutputStream(hXSylHKO).getChannel();
		try {
			Ns1ey6cI.transferTo(0, Ns1ey6cI.size(), ncuNcVpw);
		} catch (IOException NPdv56ry) {
			throw NPdv56ry;
		} finally {
			if (Ns1ey6cI != null)
				Ns1ey6cI.close();
			if (ncuNcVpw != null)
				ncuNcVpw.close();
		}
	}

}