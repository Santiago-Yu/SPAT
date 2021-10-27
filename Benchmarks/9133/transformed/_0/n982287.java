class n982287 {
	private void writeFile(FileInputStream Ha1ib0D8, FileOutputStream RyOXOZk1) throws IOException {
		byte[] gxu6DgIe = new byte[2048];
		int MgL6npu6;
		while ((MgL6npu6 = Ha1ib0D8.read(gxu6DgIe)) > 0 && !stopped)
			RyOXOZk1.write(gxu6DgIe, 0, MgL6npu6);
		Ha1ib0D8.close();
	}

}