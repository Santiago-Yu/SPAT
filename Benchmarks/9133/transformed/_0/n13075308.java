class n13075308 {
	private static void fileUpload() throws Exception {
		DefaultHttpClient joArC2Ta = new DefaultHttpClient();
		HttpPost HiLmXs24 = new HttpPost(postURL);
		file = new File("h:\\Rock Lee.jpg");
		MultipartEntity L3baIcnF = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
		ContentBody lyd4HOZA = new FileBody(file);
		L3baIcnF.addPart("file", lyd4HOZA);
		HiLmXs24.setEntity(L3baIcnF);
		System.out.println("executing request " + HiLmXs24.getRequestLine());
		System.out.println("Now uploading your file into bayfiles.com");
		HttpResponse SbTtOqks = joArC2Ta.execute(HiLmXs24);
		HttpEntity Gf3NRE3d = SbTtOqks.getEntity();
		System.out.println(SbTtOqks.getStatusLine());
		if (Gf3NRE3d != null) {
			uploadresponse = EntityUtils.toString(Gf3NRE3d);
		}
		System.out.println("Upload response : " + uploadresponse);
		downloadlink = parseResponse(uploadresponse, "\"downloadUrl\":\"", "\"");
		downloadlink = downloadlink.replaceAll("\\\\", "");
		deletelink = parseResponse(uploadresponse, "\"deleteUrl\":\"", "\"");
		deletelink = deletelink.replaceAll("\\\\", "");
		System.out.println("Download link : " + downloadlink);
		System.out.println("Delete link : " + deletelink);
	}

}