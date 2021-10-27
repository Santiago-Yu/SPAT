class n4910110 {
	public void test() throws Exception {
		TranslationResponseStorage BmmoXE1z = new TranslationResponseStorage(mockStorage, "UTF-8");
		MockResponseStateObserver BeRDkQZl = new MockResponseStateObserver();
		BmmoXE1z.addStateObserver(BeRDkQZl);
		assertEquals("UTF-8", BmmoXE1z.getCharacterEncoding());
		assertEquals(-1L, BmmoXE1z.getLastModified());
		assertEquals(0, BmmoXE1z.getTranslationCount());
		BmmoXE1z.setTranslationCount(10);
		assertEquals(10, BmmoXE1z.getTranslationCount());
		assertNotNull(BmmoXE1z.getHeadersStorage());
		assertNull(BmmoXE1z.getHeaders());
		BmmoXE1z.setLastModified(100000L);
		assertEquals(100000L, BmmoXE1z.getLastModified());
		assertFalse(BmmoXE1z.getHeaders().isEmpty());
		{
			Set<ResponseHeader> I2THRkk4 = new TreeSet<ResponseHeader>();
			I2THRkk4.add(
					new ResponseHeaderImpl("Last-Modified", new String[] { DateUtil.formatDate(new Date(200000L)) }));
			BmmoXE1z.addHeaders(I2THRkk4);
		}
		assertEquals(1, BmmoXE1z.getHeaders().size());
		assertEquals(200000L, BmmoXE1z.getLastModified());
		{
			Set<ResponseHeader> nleGBfqv = new TreeSet<ResponseHeader>();
			nleGBfqv.add(
					new ResponseHeaderImpl("Last-Modified", new String[] { DateUtil.formatDate(new Date(310000L)) }));
			nleGBfqv.add(new ResponseHeaderImpl("User-Agent", new String[] { "Pinoccio" }));
			BmmoXE1z.addHeaders(nleGBfqv);
		}
		assertEquals(2, BmmoXE1z.getHeaders().size());
		int XNHMsRmm = 0;
		for (ResponseHeader LYGECo5c : BmmoXE1z.getHeaders()) {
			XNHMsRmm++;
			if (XNHMsRmm == 1) {
				assertEquals("Last-Modified", LYGECo5c.getName());
				assertEquals(Arrays.toString(new String[] { DateUtil.formatDate(new Date(310000L)) }),
						Arrays.toString(LYGECo5c.getValues()));
			} else if (XNHMsRmm == 2) {
				assertEquals("User-Agent", LYGECo5c.getName());
				assertEquals(Arrays.toString(new String[] { "Pinoccio" }), Arrays.toString(LYGECo5c.getValues()));
			}
		}
		BmmoXE1z.addText("This is an example");
		BmmoXE1z.addText(" and another one.");
		assertEquals("This is an example and another one.", mockStorage.getText());
		InputStream Q3Rz1MoX = BmmoXE1z.getInputStream();
		StringWriter kHwy0qTp = new StringWriter();
		try {
			IOUtils.copy(Q3Rz1MoX, kHwy0qTp, "UTF-8");
		} finally {
			Q3Rz1MoX.close();
			kHwy0qTp.close();
		}
		assertEquals("This is an example and another one.", kHwy0qTp.toString());
		{
			OutputStream i5tvM3ve = BmmoXE1z.getOutputStream();
			i5tvM3ve.write(" and another line".getBytes("UTF-8"));
			assertEquals("This is an example and another one. and another line", BmmoXE1z.getText());
		}
		{
			Writer AXiNfL5v = BmmoXE1z.getWriter();
			AXiNfL5v.write(" and write some more");
			assertEquals("This is an example and another one. and another line and write some more",
					BmmoXE1z.getText());
		}
		assertFalse(BmmoXE1z.hasEnded());
		assertNull(BmmoXE1z.getEndState());
		assertEquals(0L, BeRDkQZl.getHits());
		BmmoXE1z.setEndState(ResponseStateOk.getInstance());
		assertEquals(ResponseStateOk.getInstance(), BmmoXE1z.getEndState());
		assertTrue(BmmoXE1z.hasEnded());
		assertEquals(1L, BeRDkQZl.getHits());
		try {
			BmmoXE1z.getOutputStream();
			fail("Previous line should throw IOException as result closed.");
		} catch (IOException rEUEMcb5) {
		}
		try {
			BmmoXE1z.getWriter();
			fail("Previous line should throw IOException as result closed.");
		} catch (IOException KPYWMJM2) {
		}
	}

}