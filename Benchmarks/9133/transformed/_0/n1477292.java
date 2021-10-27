class n1477292 {
	public void testCreate() throws Exception {
		File ptCGYP5K = File.createTempFile("DiskCacheItemTest", "tmp");
		ptCGYP5K.deleteOnExit();
		try {
			DiskCacheItem F8nUJe7M = new DiskCacheItem(ptCGYP5K);
			F8nUJe7M.setLastModified(200005L);
			F8nUJe7M.setTranslationCount(11);
			F8nUJe7M.setEncoding("GB2312");
			F8nUJe7M.setHeader(new ResponseHeaderImpl("Test2", new String[] { "Value3", "Value4" }));
			F8nUJe7M.setHeader(new ResponseHeaderImpl("Test1", new String[] { "Value1", "Value2" }));
			byte[] ggfEoMSu = new byte[] { -42, -48, -46, -30, 87, 101, 98, 46, 99, 111, 109, 32, -54, -57, -46, -69,
					-72, -10, -61, -26, -49, -14, -42, -48, -50, -60, -45, -61, -69, -89, -95, -94, -67, -23, -55, -36,
					-46, -30, -76, -13, -64, -5, -58, -13, -46, -75, -75, -60, -42, -48, -50, -60, -51, -8, -43, -66,
					-93, -84, -54, -57, -46, -69, -68, -36, -51, -88, -49, -14, -74, -85, -73, -67, -75, -60, -51, -8,
					-62, -25, -57, -59, -63, -70, -93, -84, -53, -4, -75, -60, -60, -65, -75, -60, -44, -38, -45, -38,
					-80, -17, -42, -6, -78, -69, -74, -49, -73, -94, -43, -71, -41, -77, -76, -13, -75, -60, -58, -13,
					-46, -75, -68, -28, -67, -8, -48, -48, -49, -32, -69, -91, -63, -86, -49, -75, -67, -45, -76, -91,
					-95, -93, -50, -46, -61, -57, -49, -32, -48, -59, -93, -84, -42, -48, -50, -60, -45, -61, -69, -89,
					-67, -85, -69, -31, -51, -88, -71, -3, -79, -66, -51, -8, -43, -66, -93, -84, -43, -46, -75, -67,
					-45, -48, -71, -40, -46, -47, -45, -21, -42, -48, -71, -6, -58, -13, -46, -75, -67, -88, -63, -94,
					-70, -49, -41, -9, -67, -69, -51, -7, -71, -40, -49, -75, -75, -60, -46, -30, -76, -13, -64, -5,
					-58, -13, -46, -75, -93, -84, -69, -14, -45, -48, -46, -30, -45, -21, -42, -48, -71, -6, 32, -58,
					-13, -46, -75, -67, -8, -48, -48, -70, -49, -41, -9, -67, -69, -51, -7, -75, -60, -46, -30, -76,
					-13, -64, -5, -58, -13, -46, -75, -75, -60, -45, -48, -45, -61, -48, -59, -49, -94, -41, -54, -63,
					-49, -95, -93 };
			{
				InputStream ic2TrsXY = new ByteArrayInputStream(ggfEoMSu);
				try {
					F8nUJe7M.setContentAsStream(ic2TrsXY);
				} finally {
					ic2TrsXY.close();
				}
			}
			assertEquals("GB2312", F8nUJe7M.getEncoding());
			assertEquals(200005L, F8nUJe7M.getLastModified());
			assertEquals(11, F8nUJe7M.getTranslationCount());
			assertFalse(F8nUJe7M.isCached());
			F8nUJe7M.updateAfterAllContentUpdated(null, null);
			{
				assertEquals(3, F8nUJe7M.getHeaders().size());
				int S8HnyZsc = 0;
				for (ResponseHeader TiQWwqR4 : F8nUJe7M.getHeaders()) {
					S8HnyZsc++;
					if (S8HnyZsc == 1) {
						assertEquals("Content-Length", TiQWwqR4.getName());
						assertEquals("[279]", Arrays.toString(TiQWwqR4.getValues()));
					} else if (S8HnyZsc == 2) {
						assertEquals("Test1", TiQWwqR4.getName());
						assertEquals("[Value1, Value2]", Arrays.toString(TiQWwqR4.getValues()));
					} else if (S8HnyZsc == 3) {
						assertEquals("Test2", TiQWwqR4.getName());
						assertEquals("[Value3, Value4]", Arrays.toString(TiQWwqR4.getValues()));
					}
				}
			}
			{
				FileInputStream hbVMp1IN = new FileInputStream(ptCGYP5K);
				StringWriter hOMGtkxt = new StringWriter();
				try {
					IOUtils.copy(hbVMp1IN, hOMGtkxt, "GB2312");
				} finally {
					IOUtils.closeQuietly(hbVMp1IN);
					IOUtils.closeQuietly(hOMGtkxt);
				}
				assertEquals(new String(ggfEoMSu, "GB2312"), hOMGtkxt.toString());
			}
			{
				FileInputStream tefhqxg0 = new FileInputStream(ptCGYP5K);
				ByteArrayOutputStream Ro8IV3hP = new ByteArrayOutputStream();
				try {
					IOUtils.copy(tefhqxg0, Ro8IV3hP);
				} finally {
					IOUtils.closeQuietly(tefhqxg0);
					IOUtils.closeQuietly(Ro8IV3hP);
				}
				assertTrue(Arrays.equals(ggfEoMSu, Ro8IV3hP.toByteArray()));
			}
		} finally {
			ptCGYP5K.delete();
		}
	}

}