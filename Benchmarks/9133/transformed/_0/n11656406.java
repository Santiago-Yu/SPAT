class n11656406 {
	public static String upLoadImg(File YrsMFVJm, String DIqCDi1W) throws Throwable {
		System.out.println("开始上传=======================================================");
		HttpPost tYiZl3I7 = getHttpPost(getUploadUrl(DIqCDi1W), DIqCDi1W);
		FileBody EoMkQ8K9 = new FileBody(YrsMFVJm, "image/jpg");
		MultipartEntity wmCCj7DH = new MultipartEntity();
		wmCCj7DH.addPart("pic1", EoMkQ8K9);
		tYiZl3I7.setEntity(wmCCj7DH);
		HttpResponse M5bKTLI2 = client.execute(tYiZl3I7);
		int XswlVDLS = M5bKTLI2.getStatusLine().getStatusCode();
		tYiZl3I7.abort();
		if (XswlVDLS == HttpStatus.SC_MOVED_TEMPORARILY || XswlVDLS == HttpStatus.SC_MOVED_PERMANENTLY) {
			String pzXDv5au = M5bKTLI2.getHeaders("location")[0].getValue();
			System.out.println(pzXDv5au);
			return pzXDv5au.substring(pzXDv5au.indexOf("pid=") + 4, pzXDv5au.indexOf("&token="));
		}
		return null;
	}

}