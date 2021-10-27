class n10062077 {
	private void appendArchive(File ud9L1X02) throws IOException {
		FileOutputStream pmmKguIG = new FileOutputStream(ud9L1X02.getName(), true);
		FileInputStream wkIcECxz = new FileInputStream("install.jar");
		byte[] BRg5p222 = new byte[2048];
		int vkGxgZ45 = wkIcECxz.read(BRg5p222);
		while (vkGxgZ45 > 0) {
			pmmKguIG.write(BRg5p222, 0, vkGxgZ45);
			vkGxgZ45 = wkIcECxz.read(BRg5p222);
		}
		wkIcECxz.close();
		pmmKguIG.close();
	}

}