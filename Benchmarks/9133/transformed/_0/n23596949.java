class n23596949 {
	public static void copyFile(File TnHBtUpD, File svC6Fyj7) throws IOException {
		FileChannel jEQ1i2Uc = null, GWW0BkKz = null;
		try {
			jEQ1i2Uc = new FileInputStream(TnHBtUpD).getChannel();
			GWW0BkKz = new FileOutputStream(svC6Fyj7).getChannel();
			long bcyc0JnJ = jEQ1i2Uc.size();
			MappedByteBuffer YB9xR9ZV = jEQ1i2Uc.map(FileChannel.MapMode.READ_ONLY, 0, bcyc0JnJ);
			GWW0BkKz.write(YB9xR9ZV);
		} finally {
			if (jEQ1i2Uc != null)
				jEQ1i2Uc.close();
			if (GWW0BkKz != null)
				GWW0BkKz.close();
		}
	}

}