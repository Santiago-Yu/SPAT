class n1725721 {
	public static int writeFile(URL OTFfnAvV, File wa0MyhVo) {
		InputStream h8sVi92h;
		try {
			h8sVi92h = OTFfnAvV.openStream();
		} catch (IOException dhCpLrVY) {
			dhCpLrVY.printStackTrace();
			return 0;
		}
		FileOutputStream GPQOnyD2;
		try {
			GPQOnyD2 = new FileOutputStream(wa0MyhVo);
		} catch (FileNotFoundException VAMZcZGE) {
			VAMZcZGE.printStackTrace();
			return 0;
		}
		return writeFile(h8sVi92h, GPQOnyD2);
	}

}