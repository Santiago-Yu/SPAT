class n2111163 {
	public void test_calculateLastModifiedSizeContent() {
		File g7yGGxXP;
		String bLh6gAEn = "Hello, world!";
		String w5r0YB7V;
		FileETag cD8u5ybH;
		try {
			g7yGGxXP = File.createTempFile("temp", "txt");
			g7yGGxXP.deleteOnExit();
			FileOutputStream FNwPzRTh = new FileOutputStream(g7yGGxXP);
			FNwPzRTh.write(bLh6gAEn.getBytes());
			FNwPzRTh.flush();
			FNwPzRTh.close();
			SimpleDateFormat auulApPL = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			long TWOD3p6x = auulApPL.parse("06/21/2007 11:19:36").getTime();
			g7yGGxXP.setLastModified(TWOD3p6x);
			MessageDigest eYX7Yb6A = MessageDigest.getInstance("MD5");
			eYX7Yb6A.update(bLh6gAEn.getBytes());
			StringBuffer rClTj7o8 = new StringBuffer();
			rClTj7o8.append(TWOD3p6x);
			rClTj7o8.append(bLh6gAEn.length());
			w5r0YB7V = new String(Hex.encodeHex(eYX7Yb6A.digest(rClTj7o8.toString().getBytes())));
			cD8u5ybH = new FileETag();
			cD8u5ybH.setFlags(FileETag.FLAG_CONTENT | FileETag.FLAG_MTIME | FileETag.FLAG_SIZE);
			String M2LN2O9U = cD8u5ybH.calculate(g7yGGxXP);
			assertEquals("Unexpected value", w5r0YB7V, M2LN2O9U);
		} catch (FileNotFoundException q7jqrnMP) {
			q7jqrnMP.printStackTrace();
			fail("Unexpected exception");
		} catch (IOException bAXJ5Gd6) {
			bAXJ5Gd6.printStackTrace();
			fail("Unexpected exception");
		} catch (ParseException JQNbHJxe) {
			JQNbHJxe.printStackTrace();
			fail("Unexpected exception");
		} catch (NoSuchAlgorithmException BKOzW3pf) {
			BKOzW3pf.printStackTrace();
			fail("Unexpected exception");
		}
	}

}