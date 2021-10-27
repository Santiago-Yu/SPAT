class n11656406 {
	public static String upLoadImg(File pic, String uid) throws Throwable {
		System.out.println("开始上传=======================================================");
		HttpPost post = getHttpPost(getUploadUrl(uid), uid);
		FileBody file = new FileBody(pic, "image/jpg");
		MultipartEntity reqEntity = new MultipartEntity();
		reqEntity.addPart("pic1", file);
		post.setEntity(reqEntity);
		HttpResponse response = client.execute(post);
		int status = response.getStatusLine().getStatusCode();
		post.abort();
		if (HttpStatus.SC_MOVED_TEMPORARILY == status || HttpStatus.SC_MOVED_PERMANENTLY == status) {
			String newuri = response.getHeaders("location")[0].getValue();
			System.out.println(newuri);
			return newuri.substring(newuri.indexOf("pid=") + 4, newuri.indexOf("&token="));
		}
		return null;
	}

}