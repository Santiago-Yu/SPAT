class n3788864 {
	public static void logout(String DUMIgq5T) throws NetworkException {
		HttpClient H0KrXCUK = HttpUtil.newInstance();
		HttpGet K72GASPo = new HttpGet(HttpUtil.KAIXIN_LOGOUT_URL + HttpUtil.KAIXIN_PARAM_VERIFY + DUMIgq5T);
		HttpUtil.setHeader(K72GASPo);
		try {
			HttpResponse QdEyIOX9 = H0KrXCUK.execute(K72GASPo);
			if (QdEyIOX9 != null && QdEyIOX9.getEntity() != null) {
				HTTPUtil.consume(QdEyIOX9.getEntity());
			}
		} catch (Exception pDVBWraf) {
			pDVBWraf.printStackTrace();
			throw new NetworkException(pDVBWraf);
		}
	}

}