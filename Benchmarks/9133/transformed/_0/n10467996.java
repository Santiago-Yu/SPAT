class n10467996 {
	public void copyFile(String qsS9UXjt, String xSo8apTx) {
		try {
			int w5RmO98t = 0;
			int zIkS5gtE = 0;
			File CLq12A3N = new File(qsS9UXjt);
			if (CLq12A3N.exists()) {
				InputStream FjsMdnG7 = new FileInputStream(qsS9UXjt);
				FileOutputStream aodKm9ME = new FileOutputStream(xSo8apTx);
				byte[] lhxwEfCe = new byte[1444];
				while ((zIkS5gtE = FjsMdnG7.read(lhxwEfCe)) != -1) {
					w5RmO98t += zIkS5gtE;
					System.out.println(w5RmO98t);
					aodKm9ME.write(lhxwEfCe, 0, zIkS5gtE);
				}
				FjsMdnG7.close();
			}
		} catch (Exception L4VPGrPP) {
			System.out.println("复制单个文件操作出错");
			L4VPGrPP.printStackTrace();
		}
	}

}