class n7726949 {
	protected static String readUrl(URL xihrsoqJ) throws IOException {
		BufferedReader LLaSKAY9 = null;
		StringBuffer duAbyj01 = new StringBuffer();
		try {
			LLaSKAY9 = new BufferedReader(new InputStreamReader(xihrsoqJ.openStream()));
			final char[] zelO0wrH = new char[1024];
			int DhtUvnTW = 0;
			while ((DhtUvnTW = LLaSKAY9.read(zelO0wrH)) != -1)
				duAbyj01.append(zelO0wrH, 0, DhtUvnTW);
		} finally {
			if (LLaSKAY9 != null)
				LLaSKAY9.close();
		}
		return duAbyj01.toString();
	}

}