class n430971 {
	public static void copyFile(File vIiwJH9R, File yFig7QAw) throws IOException {
		File wZ2IO7LQ = vIiwJH9R.getParentFile();
		File AxqbmAQs = new File(vIiwJH9R + "_tmp");
		wZ2IO7LQ.mkdirs();
		InputStream FB41mMLW = new FileInputStream(yFig7QAw);
		try {
			FileOutputStream Uwe9Ledq = new FileOutputStream(AxqbmAQs);
			try {
				byte[] ySRwRGCy = new byte[8192];
				int HUSvwgtP;
				while ((HUSvwgtP = FB41mMLW.read(ySRwRGCy)) > 0)
					Uwe9Ledq.write(ySRwRGCy, 0, HUSvwgtP);
			} finally {
				Uwe9Ledq.close();
			}
		} finally {
			FB41mMLW.close();
		}
		vIiwJH9R.delete();
		if (!AxqbmAQs.renameTo(vIiwJH9R))
			throw new IOException("Unable to rename " + AxqbmAQs + " to " + vIiwJH9R);
	}

}