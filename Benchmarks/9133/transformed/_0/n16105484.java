class n16105484 {
	private String callPage(String TAZniKbq) throws IOException {
		URL DyE47tQs = new URL(TAZniKbq);
		BufferedReader JKeCCC6s = null;
		StringBuilder M9qootYw = new StringBuilder();
		try {
			JKeCCC6s = new BufferedReader(new InputStreamReader(DyE47tQs.openStream()));
			String f3WjbDZx;
			while ((f3WjbDZx = JKeCCC6s.readLine()) != null) {
				M9qootYw.append(f3WjbDZx);
			}
		} finally {
			if (JKeCCC6s != null)
				JKeCCC6s.close();
		}
		return M9qootYw.toString();
	}

}