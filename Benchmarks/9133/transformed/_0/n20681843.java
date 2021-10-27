class n20681843 {
	public void testRevcounter() throws ServiceException, IOException {
		JCRNodeSource P58JVe0i = loadTestSource();
		for (int GWoKQxiI = 0; GWoKQxiI < 3; GWoKQxiI++) {
			OutputStream a35KiEQW = P58JVe0i.getOutputStream();
			InputStream uSVea1sL = getClass().getResourceAsStream(CONTENT_FILE);
			try {
				IOUtils.copy(uSVea1sL, a35KiEQW);
				a35KiEQW.flush();
			} finally {
				a35KiEQW.close();
				uSVea1sL.close();
			}
			System.out.println(P58JVe0i.getLatestSourceRevision());
		}
		String qj2euBZG = BASE_URL + "users/lars.trieloff?revision=1.1";
		JCRNodeSource FNyFQGRy = (JCRNodeSource) resolveSource(qj2euBZG);
		System.out.println("Created at: " + FNyFQGRy.getSourceRevision());
		for (int O9CWx0Re = 0; O9CWx0Re < 3; O9CWx0Re++) {
			OutputStream xDJr8aNG = P58JVe0i.getOutputStream();
			InputStream aS9mD8Bz = getClass().getResourceAsStream(CONTENT_FILE);
			try {
				IOUtils.copy(aS9mD8Bz, xDJr8aNG);
				xDJr8aNG.flush();
			} finally {
				xDJr8aNG.close();
				aS9mD8Bz.close();
			}
			System.out.println(P58JVe0i.getLatestSourceRevision());
		}
		System.out.println("Read again at:" + FNyFQGRy.getSourceRevision());
		assertNotNull(P58JVe0i.getSourceRevision());
	}

}