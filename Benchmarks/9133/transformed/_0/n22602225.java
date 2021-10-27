class n22602225 {
	private static void writeBinaryFile(String mbBhZUk1, String YedDh0Ka) throws IOException {
		File lSiC30tR = new File(YedDh0Ka);
		AgentFilesystem.forceDir(lSiC30tR.getParent());
		FileOutputStream HmJXKI0F = new FileOutputStream(new File(YedDh0Ka));
		FileInputStream joRdpACe = new FileInputStream(mbBhZUk1);
		byte[] dFjgu3tG = new byte[4096];
		int YDwDhLoo = 0;
		while ((YDwDhLoo = joRdpACe.read(dFjgu3tG)) > -1)
			HmJXKI0F.write(dFjgu3tG, 0, YDwDhLoo);
		joRdpACe.close();
		HmJXKI0F.close();
	}

}