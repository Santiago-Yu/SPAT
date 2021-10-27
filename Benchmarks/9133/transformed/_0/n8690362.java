class n8690362 {
	public static void fileUpload() throws IOException {
		HttpClient u2K07Frn = new DefaultHttpClient();
		u2K07Frn.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		HttpPost NwLN3utZ = new HttpPost(postURL);
		File Nb5RyBiE = new File("d:/hai.html");
		System.out.println(ukeycookie);
		NwLN3utZ.setHeader("Cookie", ukeycookie + ";" + skeycookie + ";" + usercookie);
		MultipartEntity gbYZqCQC = new MultipartEntity();
		ContentBody BslK6ltu = new FileBody(Nb5RyBiE);
		gbYZqCQC.addPart("", BslK6ltu);
		NwLN3utZ.setEntity(gbYZqCQC);
		System.out.println("Now uploading your file into mediafire...........................");
		HttpResponse MawgqY0h = u2K07Frn.execute(NwLN3utZ);
		HttpEntity gQyZMN7W = MawgqY0h.getEntity();
		System.out.println(MawgqY0h.getStatusLine());
		if (gQyZMN7W != null) {
			System.out.println("Getting upload response key value..........");
			uploadresponsekey = EntityUtils.toString(gQyZMN7W);
			getUploadResponseKey();
			System.out.println("upload resoponse key " + uploadresponsekey);
		}
	}

}