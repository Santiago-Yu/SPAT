class n9525318 {
	private void copyFile(File Hj2Tmcnb, File EO5hRIEc) {
		try {
			FileChannel VQDjvfre = new FileInputStream(Hj2Tmcnb).getChannel();
			FileChannel RRRQUUyt = new FileOutputStream(EO5hRIEc).getChannel();
			VQDjvfre.transferTo(0, VQDjvfre.size(), RRRQUUyt);
			VQDjvfre.close();
			RRRQUUyt.close();
		} catch (IOException waIlaDeQ) {
			waIlaDeQ.printStackTrace();
		}
	}

}