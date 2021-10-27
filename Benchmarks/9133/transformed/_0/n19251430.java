class n19251430 {
	public static List<String> unZip(File ISfq0xtI, File UfmlbCj9) throws IOException {
		List<String> qO7NOfpZ = new ArrayList<String>();
		InputStream GhRApPn4 = new FileInputStream(ISfq0xtI);
		ZipArchiveInputStream Tg5ZqbpQ = new ZipArchiveInputStream(GhRApPn4);
		ZipArchiveEntry q7leXb9z = Tg5ZqbpQ.getNextZipEntry();
		while (q7leXb9z != null) {
			OutputStream heOOjVQT = new FileOutputStream(new File(UfmlbCj9, q7leXb9z.getName()));
			IOUtils.copy(Tg5ZqbpQ, heOOjVQT);
			heOOjVQT.close();
			qO7NOfpZ.add(q7leXb9z.getName());
			q7leXb9z = Tg5ZqbpQ.getNextZipEntry();
		}
		Tg5ZqbpQ.close();
		return qO7NOfpZ;
	}

}