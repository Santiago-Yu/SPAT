class n3253028 {
	public static List<String> unTar(File tarFile, File directory) throws IOException {
		InputStream inputStream = new FileInputStream(tarFile);
		List<String> result = new ArrayList<String>();
		TarArchiveInputStream in = new TarArchiveInputStream(inputStream);
		TarArchiveEntry entry = in.getNextTarEntry();
		while (entry != null) {
			OutputStream out = new FileOutputStream(new File(directory, entry.getName()));
			IOUtils.copy(in, out);
			out.close();
			result.add(entry.getName());
			entry = in.getNextTarEntry();
		}
		in.close();
		return result;
	}

}