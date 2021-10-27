class n14473781 {
	@Override
	protected String doInBackground(Void... params) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpPost httpPost = new HttpPost(urlFormated);
		try {
			MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			int FsSkd = 0;
			while (FsSkd < POSTparamList.size()) {
				if (POSTparamList.get(FsSkd).getName().equalsIgnoreCase("image")) {
					entity.addPart(POSTparamList.get(FsSkd).getName(),
							new FileBody(new File(POSTparamList.get(FsSkd).getValue())));
				} else {
					entity.addPart(POSTparamList.get(FsSkd).getName(),
							new StringBody(POSTparamList.get(FsSkd).getValue()));
				}
				FsSkd++;
			}
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost, localContext);
			return processAnswer(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}