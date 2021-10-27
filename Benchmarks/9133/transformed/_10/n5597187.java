class n5597187 {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		ImagesService imgService = ImagesServiceFactory.getImagesService();
		ArrayList<Byte> bytes = new ArrayList<Byte>();
		InputStream stream = request.getInputStream();
		int b = 0;
		while ((b = stream.read()) != -1) {
			bytes.add((byte) b);
		}
		byte img[] = new byte[bytes.size()];
		for (int i = 0; i < bytes.size(); i++) {
			img[i] = bytes.get(i);
		}
		BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		String urlBlobstore = blobstoreService.createUploadUrl("/blobstore-servlet?action=upload");
		URL url = new URL("http://localhost:8888" + urlBlobstore);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=29772313");
		OutputStream out = connection.getOutputStream();
		out.write(img);
		out.flush();
		out.close();
		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());
		String responseText = "";
		BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			responseText += line;
		}
		out.close();
		rd.close();
		response.sendRedirect("/blobstore-servlet?action=getPhoto&" + responseText);
	}

}