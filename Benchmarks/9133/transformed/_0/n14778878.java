class n14778878 {
	public void copyFile(String o2d2ap5g, String qRIsK4Dz) {
		try {
			int QppyL5Al = 0;
			int KuR7lJ4b = 0;
			File jC1DBsns = new File(o2d2ap5g);
			if (jC1DBsns.exists()) {
				InputStream YlxUaiZn = new FileInputStream(o2d2ap5g);
				FileOutputStream kzrEQml4 = new FileOutputStream(qRIsK4Dz);
				byte[] DFrLUweL = new byte[1444];
				while ((KuR7lJ4b = YlxUaiZn.read(DFrLUweL)) != -1) {
					QppyL5Al += KuR7lJ4b;
					System.out.println(QppyL5Al);
					kzrEQml4.write(DFrLUweL, 0, KuR7lJ4b);
				}
				YlxUaiZn.close();
			}
		} catch (Exception AsiyUt4L) {
			message = ("??????????????????");
		}
	}

}