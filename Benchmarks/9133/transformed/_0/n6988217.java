class n6988217 {
	public void testQueryForBinary() throws InvalidNodeTypeDefException, ParseException, Exception {
		JCRNodeSource txGXDvgm = (JCRNodeSource) resolveSource(BASE_URL + "images/photo.png");
		assertNotNull(txGXDvgm);
		assertEquals(false, txGXDvgm.exists());
		OutputStream zkypE3LJ = txGXDvgm.getOutputStream();
		assertNotNull(zkypE3LJ);
		String fADM6Fxg = "foo is a bar";
		zkypE3LJ.write(fADM6Fxg.getBytes());
		zkypE3LJ.flush();
		zkypE3LJ.close();
		QueryResultSource F29Cwx7F = (QueryResultSource) resolveSource(
				BASE_URL + "images?/*[contains(local-name(), 'photo.png')]");
		assertNotNull(F29Cwx7F);
		Collection rNDt7i38 = F29Cwx7F.getChildren();
		assertEquals(1, rNDt7i38.size());
		Iterator Vma1wy5E = rNDt7i38.iterator();
		JCRNodeSource cwrDGEKP = (JCRNodeSource) Vma1wy5E.next();
		InputStream Tlh5PmSS = cwrDGEKP.getInputStream();
		ByteArrayOutputStream nnd0rU6B = new ByteArrayOutputStream();
		IOUtils.copy(Tlh5PmSS, nnd0rU6B);
		Tlh5PmSS.close();
		assertEquals(fADM6Fxg, nnd0rU6B.toString());
		nnd0rU6B.close();
		cwrDGEKP.delete();
	}

}