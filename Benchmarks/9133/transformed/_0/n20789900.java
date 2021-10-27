class n20789900 {
	public void render(HttpServletRequest TvUQebmK, HttpServletResponse Ck5Ygsru, File KAcYwJNt,
			final Throwable uDU1gKqr, final String a5wQJ51B, final String Emdv9KoU) throws Exception {
		if (a5wQJ51B != null) {
			Ck5Ygsru.setContentType(a5wQJ51B);
		}
		if (Emdv9KoU != null) {
			Ck5Ygsru.setCharacterEncoding(Emdv9KoU);
		}
		if (KAcYwJNt.length() > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Cannot send file greater than 2GB");
		}
		Ck5Ygsru.setContentLength((int) KAcYwJNt.length());
		IOUtils.copy(new FileInputStream(KAcYwJNt), Ck5Ygsru.getOutputStream());
	}

}