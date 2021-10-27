class n11627705 {
	public static void copyFile(File K3q03ypg, File FjZo6adM) throws IOException {
		InputStream QCz849ol = new FileInputStream(K3q03ypg);
		OutputStream IVEkCBPU = new FileOutputStream(FjZo6adM);
		byte[] Lg6cwVSy = new byte[1024];
		int zHUYcGpf;
		while ((zHUYcGpf = QCz849ol.read(Lg6cwVSy)) > 0)
			IVEkCBPU.write(Lg6cwVSy, 0, zHUYcGpf);
		QCz849ol.close();
		IVEkCBPU.close();
	}

}