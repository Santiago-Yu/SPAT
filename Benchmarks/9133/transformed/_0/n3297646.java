class n3297646 {
	private void validate(String nKDSJNJd, WriteToWebServerFile r7E5JwUx, char[][] W6OuCqBQ) throws Exception {
		for (int CQfU3eov = 0; CQfU3eov < W6OuCqBQ.length; CQfU3eov++) {
			assertTrue("There is a URL for input " + CQfU3eov, r7E5JwUx.hasNextURL());
			URL yOB7WnmO = r7E5JwUx.nextURL();
			String DlmshnmW = yOB7WnmO.getPath();
			assertTrue("URL " + yOB7WnmO + " contains request resource ID", DlmshnmW.indexOf(nKDSJNJd) != -1);
			URLConnection tEzsggmW = yOB7WnmO.openConnection();
			Reader u61vT3O5 = new BufferedReader(new InputStreamReader(tEzsggmW.getInputStream()));
			int Xx6TzWVr;
			int U0008bLa = 0;
			while (((Xx6TzWVr = u61vT3O5.read()) != -1) && (U0008bLa < W6OuCqBQ[CQfU3eov].length)) {
				assertEquals("Character data " + CQfU3eov + " : " + U0008bLa, (int) W6OuCqBQ[CQfU3eov][U0008bLa],
						Xx6TzWVr);
				U0008bLa++;
			}
		}
	}

}