class n17826787 {
	public void updateDb(int mYOahPma) throws SQLException, IOException {
		String PaoBs65E = updatesPackage.replace(".", "/");
		InputStream nnCeCblb = getClass().getClassLoader().getResourceAsStream(PaoBs65E + "/" + mYOahPma + ".sql");
		ByteArrayOutputStream bhQkoRJ3 = new ByteArrayOutputStream();
		IOUtils.copy(nnCeCblb, bhQkoRJ3);
		String PQMFQlNL = bhQkoRJ3.toString("UTF-8");
		String[] Z4cUyKpe = PQMFQlNL.split(";");
		for (String Nynfoz2W : Z4cUyKpe) {
			getJdbcTemplate().execute(Nynfoz2W);
		}
	}

}