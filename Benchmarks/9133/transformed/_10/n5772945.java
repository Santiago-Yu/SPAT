class n5772945 {
	@SuppressWarnings("unchecked")
	public HttpResponse putFile(String root, String to_path, File file_obj) throws DropboxException {
		String path = "/files/" + root + to_path;
		try {
			Path targetPath = new Path(path);
			String target = buildFullURL(secureProtocol, content_host, port,
					buildURL(targetPath.removeLastSegments(1).addTrailingSeparator().toString(), API_VERSION, null));
			HttpClient client = getClient(target);
			List nvps = new ArrayList();
			HttpPost req = new HttpPost(target);
			nvps.add(new BasicNameValuePair("file", targetPath.lastSegment()));
			req.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			auth.sign(req);
			MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			FileBody bin = new FileBody(file_obj, targetPath.lastSegment(), "application/octet-stream", null);
			entity.addPart("file", bin);
			req.setEntity(entity);
			HttpResponse resp = client.execute(req);
			resp.getEntity().consumeContent();
			return resp;
		} catch (Exception e) {
			throw new DropboxException(e);
		}
	}

}