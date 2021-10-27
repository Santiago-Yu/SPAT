class n7380658 {
	public static void copyFile(File Ytta9fZ7, File qUWK9urq) throws IOException {
		FileChannel r47rV9aj = new FileInputStream(Ytta9fZ7).getChannel();
		FileChannel yjQJABHz = new FileOutputStream(qUWK9urq).getChannel();
		try {
			r47rV9aj.transferTo(0, r47rV9aj.size(), yjQJABHz);
		} catch (IOException YHPTYeDN) {
			throw YHPTYeDN;
		} finally {
			if (r47rV9aj != null) {
				r47rV9aj.close();
			}
			if (yjQJABHz != null) {
				yjQJABHz.close();
			}
		}
	}

}