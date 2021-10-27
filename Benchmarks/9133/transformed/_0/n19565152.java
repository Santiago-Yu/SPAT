class n19565152 {
	private void appendArchive(File ZFhZhqmO) throws IOException {
		FileOutputStream l6vrGqd4 = new FileOutputStream(ZFhZhqmO.getName(), true);
		FileInputStream frV0qI3P = new FileInputStream("install.jar");
		byte[] igTYefdy = new byte[2048];
		int sDxFF38I = frV0qI3P.read(igTYefdy);
		while (sDxFF38I > 0) {
			l6vrGqd4.write(igTYefdy, 0, sDxFF38I);
			sDxFF38I = frV0qI3P.read(igTYefdy);
		}
		frV0qI3P.close();
		l6vrGqd4.close();
	}

}