class n18845763 {
	public static void copyFile(String HP5vx66r, String tfxhVHjF, String ZDpUDy4g, String XsuEVECx, File saaD02CM)
			throws Exception {
		org.apache.commons.httpclient.HttpClient BBK1puk5 = WebDavUtility.initClient("files-cert.rxhub.net", ZDpUDy4g,
				XsuEVECx);
		HttpMethod VDg5n477 = new GetMethod(tfxhVHjF);
		BBK1puk5.executeMethod(VDg5n477);
		BufferedOutputStream w1BMXoa1 = new BufferedOutputStream(new FileOutputStream(saaD02CM));
		IOUtils.copyLarge(VDg5n477.getResponseBodyAsStream(), w1BMXoa1);
	}

}