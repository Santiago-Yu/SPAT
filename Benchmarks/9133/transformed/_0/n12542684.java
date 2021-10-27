class n12542684 {
	public ServiceAdapterIfc deploy(String GZBxP3qI, String ssUrxLrq, byte px5jebS3[], String uz3NXTe7, String aQKK4UCH,
			String Wfl3G3kT) throws RemoteException, MalformedURLException, StartServiceException, SessionException {
		try {
			File rcWHpM2o = new File(uz3NXTe7);
			uz3NXTe7 = rcWHpM2o.getName();
			String VIYbnoAN = uz3NXTe7;
			rcWHpM2o = new File(VIYbnoAN);
			int u6V7yJ0U = 0;
			while (rcWHpM2o.exists()) {
				VIYbnoAN = uz3NXTe7 + u6V7yJ0U++;
				rcWHpM2o = new File(VIYbnoAN);
			}
			FileOutputStream e7lOgQ9U = new FileOutputStream(VIYbnoAN);
			IOUtils.copy(new ByteArrayInputStream(px5jebS3), e7lOgQ9U);
			SCClassLoader uybj4bbR = new SCClassLoader(new URL[] { new URL("file://" + rcWHpM2o.getAbsolutePath()) },
					getMasterNode().getSCClassLoaderCounter());
			return startService(GZBxP3qI, ssUrxLrq, aQKK4UCH, Wfl3G3kT, uybj4bbR);
		} catch (SessionException HzLaW8EU) {
			throw HzLaW8EU;
		} catch (Exception SX8rAkgq) {
			throw new StartServiceException("Could not deploy service: " + SX8rAkgq.getMessage(), SX8rAkgq);
		}
	}

}