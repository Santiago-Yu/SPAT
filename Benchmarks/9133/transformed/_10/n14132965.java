class n14132965 {
	public static void copia(File nombreFuente, File nombreDestino) throws IOException {
		FileOutputStream fos = new FileOutputStream(nombreDestino);
		FileInputStream fis = new FileInputStream(nombreFuente);
		FileChannel canalFuente = fis.getChannel();
		FileChannel canalDestino = fos.getChannel();
		canalFuente.transferTo(0, canalFuente.size(), canalDestino);
		fis.close();
		fos.close();
	}

}