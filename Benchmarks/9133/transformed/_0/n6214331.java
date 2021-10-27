class n6214331 {
	public static void copyFile(File JirP3I9P, File ed5IdxZx) {
		try {
			FileInputStream ZiN8lj0f = new FileInputStream(JirP3I9P);
			FileOutputStream kRG1dEvZ = new FileOutputStream(ed5IdxZx);
			int htMz1TJc;
			while ((htMz1TJc = ZiN8lj0f.read()) != -1)
				kRG1dEvZ.write(htMz1TJc);
			ZiN8lj0f.close();
			kRG1dEvZ.close();
		} catch (IOException wQlCeGaa) {
			System.err.println(wQlCeGaa);
		}
	}

}