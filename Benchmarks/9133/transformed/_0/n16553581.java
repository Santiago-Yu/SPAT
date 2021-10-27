class n16553581 {
	public Item findById(String qraQ927z) throws UnsupportedEncodingException, IOException {
		String dUHHQm9X = (String) RuntimeAccess.getInstance().getSession().getAttribute("SESSION_ID");
		DefaultHttpClient jjjJMSTR = new DefaultHttpClient();
		FindItemByIdRequest FK1E5XSw = new FindItemByIdRequest();
		FK1E5XSw.setItemID(qraQ927z);
		FK1E5XSw.setSessionId(dUHHQm9X);
		XStream pGkz6vpl = new XStream();
		pGkz6vpl.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		pGkz6vpl.alias("FindItemByIdRequest", FindItemByIdRequest.class);
		XStream KVUJ8FOv = new XStream();
		KVUJ8FOv.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		KVUJ8FOv.alias("FindItemByIdResponse", FindItemByIdResponse.class);
		String zFMhDQ9u = URLEncoder.encode(KVUJ8FOv.toXML(FK1E5XSw), "UTF-8");
		HttpGet TbDXd5LU = new HttpGet(MewitProperties.getMewitUrl() + "/resources/findItemById?REQUEST=" + zFMhDQ9u);
		HttpResponse MODi4t8a = jjjJMSTR.execute(TbDXd5LU);
		HttpEntity IeC8LwO6 = MODi4t8a.getEntity();
		if (IeC8LwO6 != null) {
			String CvBerbCA = URLDecoder.decode(EntityUtils.toString(IeC8LwO6), "UTF-8");
			FindItemByIdResponse Hyu1Qm3t = (FindItemByIdResponse) KVUJ8FOv.fromXML(CvBerbCA);
			return Hyu1Qm3t.getItem();
		}
		return null;
	}

}