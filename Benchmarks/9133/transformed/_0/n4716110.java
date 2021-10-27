class n4716110 {
	public static void copyFile(File etWECw1T, File Qup2EkEL) throws Exception {
		FileChannel Zs1t4tbM = new FileInputStream(etWECw1T).getChannel();
		FileChannel ovCloOQ8 = new FileOutputStream(Qup2EkEL).getChannel();
		Zs1t4tbM.transferTo(0, Zs1t4tbM.size(), ovCloOQ8);
		Zs1t4tbM.close();
		ovCloOQ8.close();
	}

}