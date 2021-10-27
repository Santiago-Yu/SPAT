class n18790182 {
	public void testAddingEntries() throws Exception {
		DiskCache u9jyfEpW = new DiskCache();
		{
			u9jyfEpW.setRoot(rootFolder.getAbsolutePath());
			u9jyfEpW.setHtmlExtension("htm");
			u9jyfEpW.setPropertiesExtension("txt");
			assertEquals("htm", u9jyfEpW.getHtmlExtension());
			assertEquals("txt", u9jyfEpW.getPropertiesExtension());
			assertEquals(rootFolder.getAbsolutePath(), u9jyfEpW.getRoot());
		}
		String JoEkEZ9n = "cat1/key1";
		String XNHtGV7u = "cat1/key2";
		try {
			try {
				{
					u9jyfEpW.removeCacheEntry(JoEkEZ9n, null);
					CacheItem nn97VGdy = u9jyfEpW.getOrCreateCacheEntry(JoEkEZ9n);
					assertNull(nn97VGdy.getEncoding());
					assertEquals(-1L, nn97VGdy.getLastModified());
					assertEquals(-1, nn97VGdy.getTranslationCount());
					assertFalse(nn97VGdy.isCached());
					assertNull(nn97VGdy.getHeaders());
					nn97VGdy.setLastModified(300005L);
					nn97VGdy.setTranslationCount(10);
					nn97VGdy.setEncoding("ISO-8859-7");
					nn97VGdy.setHeader(new ResponseHeaderImpl("Test2", new String[] { "Value3", "Value4" }));
					nn97VGdy.setHeader(new ResponseHeaderImpl("Test1", new String[] { "Value1", "Value2" }));
					byte[] ZIJrohYv = new byte[] { -57, -20, -27, -15, -34, -13, -23, -31, 32, -48, -17, -21, -23, -12,
							-23, -22, -34, 32, -59, -10, -25, -20, -27, -15, -33, -28, -31, 32, -60, -23, -31, -19, -35,
							-20, -27, -12, -31, -23, 32, -22, -31, -24, -25, -20, -27, -15, -23, -19, -36, 32, -60, -39,
							-47, -59, -63, -51, 32, -13, -12, -17, 32, -28, -33, -22, -12, -11, -17, 32, -13, -11, -29,
							-22, -17, -23, -19, -7, -19, -23, -2, -19, 32, -12, -25, -14, 32, -56, -27, -13, -13, -31,
							-21, -17, -19, -33, -22, -25, -14 };
					String IiUSXi6J = new String(ZIJrohYv, "ISO-8859-7");
					{
						InputStream bqibHdpZ = new ByteArrayInputStream(ZIJrohYv);
						try {
							nn97VGdy.setContentAsStream(bqibHdpZ);
						} finally {
							bqibHdpZ.close();
						}
					}
					assertEquals("ISO-8859-7", nn97VGdy.getEncoding());
					assertEquals(300005L, nn97VGdy.getLastModified());
					assertEquals(10, nn97VGdy.getTranslationCount());
					assertFalse(nn97VGdy.isCached());
					nn97VGdy.updateAfterAllContentUpdated(null, null);
					{
						assertEquals(3, nn97VGdy.getHeaders().size());
						int A0oUwNYK = 0;
						for (ResponseHeader AJKDauaH : nn97VGdy.getHeaders()) {
							A0oUwNYK++;
							if (A0oUwNYK == 1) {
								assertEquals("Content-Length", AJKDauaH.getName());
								assertEquals("[97]", Arrays.toString(AJKDauaH.getValues()));
							} else if (A0oUwNYK == 2) {
								assertEquals("Test1", AJKDauaH.getName());
								assertEquals("[Value1, Value2]", Arrays.toString(AJKDauaH.getValues()));
							} else if (A0oUwNYK == 3) {
								assertEquals("Test2", AJKDauaH.getName());
								assertEquals("[Value3, Value4]", Arrays.toString(AJKDauaH.getValues()));
							}
						}
					}
					u9jyfEpW.storeInCache(JoEkEZ9n, nn97VGdy);
					assertEquals("ISO-8859-7", nn97VGdy.getEncoding());
					assertEquals(300005L, nn97VGdy.getLastModified());
					assertEquals(10, nn97VGdy.getTranslationCount());
					assertTrue(nn97VGdy.isCached());
					{
						InputStream WAZuHc1y = nn97VGdy.getContentAsStream();
						StringWriter lgoZTtUT = new StringWriter();
						IOUtils.copy(WAZuHc1y, lgoZTtUT, "ISO-8859-7");
						IOUtils.closeQuietly(WAZuHc1y);
						IOUtils.closeQuietly(lgoZTtUT);
						assertEquals(IiUSXi6J, lgoZTtUT.toString());
					}
				}
				{
					u9jyfEpW.removeCacheEntry(XNHtGV7u, null);
					CacheItem sshRWVfW = u9jyfEpW.getOrCreateCacheEntry(XNHtGV7u);
					assertNull(sshRWVfW.getEncoding());
					assertEquals(-1L, sshRWVfW.getLastModified());
					assertEquals(-1, sshRWVfW.getTranslationCount());
					assertFalse(sshRWVfW.isCached());
					assertNull(sshRWVfW.getHeaders());
					sshRWVfW.setLastModified(350000L);
					sshRWVfW.setTranslationCount(11);
					sshRWVfW.setEncoding("ISO-8859-1");
					sshRWVfW.setHeader(new ResponseHeaderImpl("Test3", new String[] { "Value3", "Value4" }));
					sshRWVfW.setHeader(new ResponseHeaderImpl("Test4", new String[] { "Value1" }));
					String xwcWP3J2 = "Hello this is another example";
					{
						InputStream ha4e0GDM = new ByteArrayInputStream(xwcWP3J2.getBytes("ISO-8859-1"));
						try {
							sshRWVfW.setContentAsStream(ha4e0GDM);
						} finally {
							ha4e0GDM.close();
						}
					}
					assertEquals("ISO-8859-1", sshRWVfW.getEncoding());
					assertEquals(350000L, sshRWVfW.getLastModified());
					assertEquals(11, sshRWVfW.getTranslationCount());
					assertFalse(sshRWVfW.isCached());
					sshRWVfW.updateAfterAllContentUpdated(null, null);
					{
						assertEquals(3, sshRWVfW.getHeaders().size());
						int vq9z0Zm9 = 0;
						for (ResponseHeader NY0hrzjA : sshRWVfW.getHeaders()) {
							vq9z0Zm9++;
							if (vq9z0Zm9 == 1) {
								assertEquals("Content-Length", NY0hrzjA.getName());
								assertEquals("[29]", Arrays.toString(NY0hrzjA.getValues()));
							} else if (vq9z0Zm9 == 2) {
								assertEquals("Test3", NY0hrzjA.getName());
								assertEquals("[Value3, Value4]", Arrays.toString(NY0hrzjA.getValues()));
							} else if (vq9z0Zm9 == 3) {
								assertEquals("Test4", NY0hrzjA.getName());
								assertEquals("[Value1]", Arrays.toString(NY0hrzjA.getValues()));
							}
						}
					}
					u9jyfEpW.storeInCache(XNHtGV7u, sshRWVfW);
					assertEquals("ISO-8859-1", sshRWVfW.getEncoding());
					assertEquals(350000L, sshRWVfW.getLastModified());
					assertEquals(11, sshRWVfW.getTranslationCount());
					assertTrue(sshRWVfW.isCached());
					{
						InputStream hsRigewU = sshRWVfW.getContentAsStream();
						StringWriter zKEPMdMN = new StringWriter();
						IOUtils.copy(hsRigewU, zKEPMdMN, "ISO-8859-1");
						IOUtils.closeQuietly(hsRigewU);
						IOUtils.closeQuietly(zKEPMdMN);
						assertEquals(xwcWP3J2, zKEPMdMN.toString());
					}
				}
				{
					CacheItem hqBRVp8u = u9jyfEpW.getOrCreateCacheEntry(JoEkEZ9n);
					assertEquals("ISO-8859-7", hqBRVp8u.getEncoding());
					assertEquals(300005L, hqBRVp8u.getLastModified());
					assertEquals(10, hqBRVp8u.getTranslationCount());
					assertTrue(hqBRVp8u.isCached());
					{
						assertEquals(3, hqBRVp8u.getHeaders().size());
						int uC4iyK15 = 0;
						for (ResponseHeader HDzMYyfm : hqBRVp8u.getHeaders()) {
							uC4iyK15++;
							if (uC4iyK15 == 1) {
								assertEquals("Content-Length", HDzMYyfm.getName());
								assertEquals("[97]", Arrays.toString(HDzMYyfm.getValues()));
							} else if (uC4iyK15 == 2) {
								assertEquals("Test1", HDzMYyfm.getName());
								assertEquals("[Value1, Value2]", Arrays.toString(HDzMYyfm.getValues()));
							} else if (uC4iyK15 == 3) {
								assertEquals("Test2", HDzMYyfm.getName());
								assertEquals("[Value3, Value4]", Arrays.toString(HDzMYyfm.getValues()));
							}
						}
					}
					byte[] Y5WOKON2 = new byte[] { -57, -20, -27, -15, -34, -13, -23, -31, 32, -48, -17, -21, -23, -12,
							-23, -22, -34, 32, -59, -10, -25, -20, -27, -15, -33, -28, -31, 32, -60, -23, -31, -19, -35,
							-20, -27, -12, -31, -23, 32, -22, -31, -24, -25, -20, -27, -15, -23, -19, -36, 32, -60, -39,
							-47, -59, -63, -51, 32, -13, -12, -17, 32, -28, -33, -22, -12, -11, -17, 32, -13, -11, -29,
							-22, -17, -23, -19, -7, -19, -23, -2, -19, 32, -12, -25, -14, 32, -56, -27, -13, -13, -31,
							-21, -17, -19, -33, -22, -25, -14 };
					String RUseIG9f = new String(Y5WOKON2, "ISO-8859-7");
					{
						InputStream A3NY4DiO = hqBRVp8u.getContentAsStream();
						StringWriter ljyF5wah = new StringWriter();
						IOUtils.copy(A3NY4DiO, ljyF5wah, "ISO-8859-7");
						IOUtils.closeQuietly(A3NY4DiO);
						IOUtils.closeQuietly(ljyF5wah);
						assertEquals(RUseIG9f, ljyF5wah.toString());
					}
				}
				{
					u9jyfEpW.removeCacheEntry(JoEkEZ9n, null);
					CacheItem IJQK0V4R = u9jyfEpW.getOrCreateCacheEntry(JoEkEZ9n);
					assertNull(IJQK0V4R.getEncoding());
					assertEquals(-1L, IJQK0V4R.getLastModified());
					assertEquals(-1, IJQK0V4R.getTranslationCount());
					assertFalse(IJQK0V4R.isCached());
					assertNull(IJQK0V4R.getHeaders());
				}
			} finally {
				u9jyfEpW.removeCacheEntry(JoEkEZ9n, null);
			}
		} finally {
			u9jyfEpW.removeCacheEntry(XNHtGV7u, null);
		}
	}

}