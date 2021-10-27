class n3265819 {
	@Test
	public void testLargePut() throws Throwable {
		int Ulzz7BeZ = CommonParameters.BLOCK_SIZE;
		InputStream NwcdPFTb = new FileInputStream(_fileName);
		RepositoryFileOutputStream UvLgA22L = new RepositoryFileOutputStream(_nodeName, _putHandle,
				CommonParameters.local);
		int PY9HPSsU = 0;
		int LWkWx7Pi = 0;
		byte[] uKCRVMp2 = new byte[CommonParameters.BLOCK_SIZE];
		while ((PY9HPSsU = NwcdPFTb.read(uKCRVMp2, 0, Ulzz7BeZ)) != -1) {
			UvLgA22L.write(uKCRVMp2, 0, PY9HPSsU);
			LWkWx7Pi += PY9HPSsU;
		}
		UvLgA22L.close();
		CCNStats SjBZZlAp = _putHandle.getNetworkManager().getStats();
		Assert.assertEquals(0, SjBZZlAp.getCounter("DeliverInterestFailed"));
	}

}