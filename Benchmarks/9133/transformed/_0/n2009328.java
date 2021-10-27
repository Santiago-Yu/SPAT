class n2009328 {
	private String storeProxy(String faU9uAYV, String ca1qqFcL) throws IOException {
		File QCScw4dT = new File(faU9uAYV);
		String lgF0o95m = slcsFactory.getStoreDirectory() + File.separator + ca1qqFcL + File.separator + PROXYFILENAME;
		File psHNWdhn = new File(lgF0o95m);
		FileReader cEglFKQz = new FileReader(QCScw4dT);
		FileWriter gPs0IUpz = new FileWriter(psHNWdhn);
		int corfzAb2;
		while ((corfzAb2 = cEglFKQz.read()) != -1)
			gPs0IUpz.write(corfzAb2);
		cEglFKQz.close();
		gPs0IUpz.close();
		Process nx0JHpIK = Runtime.getRuntime().exec("/bin/chmod 600 " + lgF0o95m);
		try {
			nx0JHpIK.waitFor();
		} catch (InterruptedException VarHA3z4) {
			VarHA3z4.printStackTrace();
		}
		return lgF0o95m;
	}

}