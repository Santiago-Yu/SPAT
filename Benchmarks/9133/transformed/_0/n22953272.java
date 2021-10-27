class n22953272 {
	public static final boolean copyFileNio(File s6v0I8DK, File gpAcfTsA) throws IOException {
		FileChannel em5o5K33 = null, R6PFfL9o = null;
		try {
			em5o5K33 = new FileInputStream(s6v0I8DK).getChannel();
			R6PFfL9o = new FileOutputStream(gpAcfTsA).getChannel();
			{
				int nSAQdYFb = (64 * 1024 * 1024) / 4;
				long ukOa1auI = em5o5K33.size();
				long MuAqgn3y = 0;
				while (MuAqgn3y < ukOa1auI) {
					MuAqgn3y += em5o5K33.transferTo(MuAqgn3y, nSAQdYFb, R6PFfL9o);
				}
			}
			em5o5K33.close();
			em5o5K33 = null;
			R6PFfL9o.close();
			R6PFfL9o = null;
			return true;
		} finally {
			try {
				if (em5o5K33 != null)
					em5o5K33.close();
			} catch (IOException pQ3lSoJ4) {
				Debug.debug(pQ3lSoJ4);
			}
			try {
				if (R6PFfL9o != null)
					R6PFfL9o.close();
			} catch (IOException U1yq90aU) {
				Debug.debug(U1yq90aU);
			}
		}
	}

}