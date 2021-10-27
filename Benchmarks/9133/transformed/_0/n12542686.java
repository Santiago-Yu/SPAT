class n12542686 {
	public static Object deployNewService(String rgHczjwv, String QwkKuQ5U, String seZxN22M, String RI2vC5c6,
			String AL8WzUkh, String G5M3UPED, String KKn58pK3, Logger FcFHGrAA)
			throws RemoteException, MalformedURLException, StartServiceException, NotBoundException,
			IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException, SessionException {
		try {
			SCNodeInterface H6dVj0SU = (SCNodeInterface) Naming.lookup(rgHczjwv);
			String w99qHvBi = H6dVj0SU.login(QwkKuQ5U, seZxN22M);
			ByteArrayOutputStream xXIVW76a = new ByteArrayOutputStream();
			IOUtils.copy(new FileInputStream(AL8WzUkh), xXIVW76a);
			ServiceAdapterIfc SSSxqLJs = H6dVj0SU.deploy(w99qHvBi, RI2vC5c6, xXIVW76a.toByteArray(), AL8WzUkh, G5M3UPED,
					KKn58pK3);
			if (SSSxqLJs != null) {
				return new ExternalDomain(H6dVj0SU, SSSxqLJs, SSSxqLJs.getUri(), FcFHGrAA)
						.getProxy(Thread.currentThread().getContextClassLoader());
			}
		} catch (Exception PCr0ubzK) {
			FcFHGrAA.warn("Could not send deploy command: " + PCr0ubzK.getMessage(), PCr0ubzK);
		}
		return null;
	}

}