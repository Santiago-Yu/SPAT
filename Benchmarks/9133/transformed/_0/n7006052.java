class n7006052 {
	public static void copyFileTo(String fur24OqB, String owB90xEf) throws FileNotFoundException, IOException {
		File MlLtwGvB = new File(owB90xEf);
		InputStream yv1dxxcT = new FileInputStream(new File(fur24OqB));
		OutputStream TF1Os1kA = new FileOutputStream(MlLtwGvB);
		byte wCupGX3v[] = new byte[1024];
		int Efaef8zn;
		while ((Efaef8zn = yv1dxxcT.read(wCupGX3v)) > 0)
			TF1Os1kA.write(wCupGX3v, 0, Efaef8zn);
		yv1dxxcT.close();
		TF1Os1kA.close();
	}

}