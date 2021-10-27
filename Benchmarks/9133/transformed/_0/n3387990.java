class n3387990 {
	public static void copyFile(File M1HszyW5, File lDstxrEz) throws IOException {
		BufferedInputStream PWfIVRUW = new BufferedInputStream(new FileInputStream(M1HszyW5));
		BufferedOutputStream OfcojYlu = new BufferedOutputStream(new FileOutputStream(lDstxrEz));
		byte[] kHuOqHyZ = new byte[8192];
		int KPt7MdbG;
		while ((KPt7MdbG = PWfIVRUW.read(kHuOqHyZ)) >= 0)
			OfcojYlu.write(kHuOqHyZ, 0, KPt7MdbG);
		PWfIVRUW.close();
		OfcojYlu.close();
	}

}