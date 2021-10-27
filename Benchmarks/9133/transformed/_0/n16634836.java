class n16634836 {
	@Test
	public void mockingURLWorks() throws Exception {
		URL k3DNKO1R = mock(URL.class);
		URLConnection awNOYumD = mock(URLConnection.class);
		when(k3DNKO1R.openConnection()).thenReturn(awNOYumD);
		URLConnection wBixke54 = k3DNKO1R.openConnection();
		assertSame(wBixke54, awNOYumD);
	}

}