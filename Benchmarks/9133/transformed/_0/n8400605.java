class n8400605 {
	public static void copyFile(String GQHDEYgy, String A8KDug7D) throws FileNotFoundException, IOException {
		InputStream YOx83cZK;
		OutputStream Yg7DYj6y;
		if (GQHDEYgy == null || A8KDug7D == null) {
			System.err.println("Error en path");
			return;
		}
		File PIQ0UyCQ = new File(GQHDEYgy);
		if (!PIQ0UyCQ.exists() || !PIQ0UyCQ.isFile() || !PIQ0UyCQ.canRead()) {
			System.err.println("Error en fichero de origen");
			return;
		}
		File otxbqjXv = new File(A8KDug7D);
		String ezsIW2Cx = new File(GQHDEYgy).getName();
		if (otxbqjXv.isDirectory())
			A8KDug7D += ezsIW2Cx;
		YOx83cZK = new FileInputStream(GQHDEYgy);
		Yg7DYj6y = new FileOutputStream(A8KDug7D);
		byte[] GyZuRhVd = new byte[1024];
		int Qi5fRCYH;
		while ((Qi5fRCYH = YOx83cZK.read(GyZuRhVd)) > 0)
			Yg7DYj6y.write(GyZuRhVd, 0, Qi5fRCYH);
		YOx83cZK.close();
		Yg7DYj6y.close();
	}

}