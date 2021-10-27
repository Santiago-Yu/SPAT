class n22080746 {
	@Test
	public void testCarResource() throws Exception {
		DefaultHttpClient Fp1vU01J = new DefaultHttpClient();
		System.out.println("**** CarResource Via @MatrixParam ***");
		HttpGet fup2zM2j = new HttpGet("http://localhost:9095/cars/matrix/mercedes/e55;color=black/2006");
		HttpResponse G1mZ3d2g = Fp1vU01J.execute(fup2zM2j);
		Assert.assertEquals(200, G1mZ3d2g.getStatusLine().getStatusCode());
		BufferedReader JFxrsD1A = new BufferedReader(new InputStreamReader(G1mZ3d2g.getEntity().getContent()));
		String AQ3zz2Pj = JFxrsD1A.readLine();
		while (AQ3zz2Pj != null) {
			System.out.println(AQ3zz2Pj);
			AQ3zz2Pj = JFxrsD1A.readLine();
		}
		System.out.println("**** CarResource Via PathSegment ***");
		fup2zM2j = new HttpGet("http://localhost:9095/cars/segment/mercedes/e55;color=black/2006");
		G1mZ3d2g = Fp1vU01J.execute(fup2zM2j);
		Assert.assertEquals(200, G1mZ3d2g.getStatusLine().getStatusCode());
		JFxrsD1A = new BufferedReader(new InputStreamReader(G1mZ3d2g.getEntity().getContent()));
		AQ3zz2Pj = JFxrsD1A.readLine();
		while (AQ3zz2Pj != null) {
			System.out.println(AQ3zz2Pj);
			AQ3zz2Pj = JFxrsD1A.readLine();
		}
		System.out.println("**** CarResource Via PathSegments ***");
		fup2zM2j = new HttpGet("http://localhost:9095/cars/segments/mercedes/e55/amg/year/2006");
		G1mZ3d2g = Fp1vU01J.execute(fup2zM2j);
		Assert.assertEquals(200, G1mZ3d2g.getStatusLine().getStatusCode());
		JFxrsD1A = new BufferedReader(new InputStreamReader(G1mZ3d2g.getEntity().getContent()));
		AQ3zz2Pj = JFxrsD1A.readLine();
		while (AQ3zz2Pj != null) {
			System.out.println(AQ3zz2Pj);
			AQ3zz2Pj = JFxrsD1A.readLine();
		}
		System.out.println("**** CarResource Via PathSegment ***");
		fup2zM2j = new HttpGet("http://localhost:9095/cars/uriinfo/mercedes/e55;color=black/2006");
		G1mZ3d2g = Fp1vU01J.execute(fup2zM2j);
		Assert.assertEquals(200, G1mZ3d2g.getStatusLine().getStatusCode());
		JFxrsD1A = new BufferedReader(new InputStreamReader(G1mZ3d2g.getEntity().getContent()));
		AQ3zz2Pj = JFxrsD1A.readLine();
		while (AQ3zz2Pj != null) {
			System.out.println(AQ3zz2Pj);
			AQ3zz2Pj = JFxrsD1A.readLine();
		}
		System.out.println();
		System.out.println();
	}

}