class n8917665 {
	public static void copyAll(URL DRjGUlnH, StringBuilder ulvrRj1k) {
		Reader B1sL9BiQ = null;
		try {
			B1sL9BiQ = new InputStreamReader(new BufferedInputStream(DRjGUlnH.openStream()));
			copyAll(B1sL9BiQ, ulvrRj1k);
		} catch (IOException ggIxE8sM) {
			throw new RuntimeException(ggIxE8sM);
		} finally {
			close(B1sL9BiQ);
		}
	}

}