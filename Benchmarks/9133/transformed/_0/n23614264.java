class n23614264 {
	private static void copyFile(File JYDD4iKw, File hhKpiEHA) throws IOException {
		System.out.println(JYDD4iKw.getAbsolutePath());
		System.out.println(hhKpiEHA.getAbsolutePath());
		FileChannel NtLzrHvl = new FileInputStream(JYDD4iKw).getChannel();
		try {
			FileChannel Ccq6Ugtn = new FileOutputStream(hhKpiEHA).getChannel();
			try {
				Ccq6Ugtn.transferFrom(NtLzrHvl, 0, NtLzrHvl.size());
			} finally {
				if (Ccq6Ugtn != null) {
					Ccq6Ugtn.close();
				}
			}
		} finally {
			NtLzrHvl.close();
		}
	}

}