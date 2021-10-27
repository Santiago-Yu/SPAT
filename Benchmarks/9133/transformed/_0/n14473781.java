class n14473781 {
	@Override
	protected String doInBackground(Void... H7RN5Hdy) {
		HttpClient oXUchKXR = new DefaultHttpClient();
		HttpContext Pa2vPT4G = new BasicHttpContext();
		HttpPost Dhg7YTF9 = new HttpPost(urlFormated);
		try {
			MultipartEntity kkf8r1CO = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
			for (int xdzv9oMk = 0; xdzv9oMk < POSTparamList.size(); xdzv9oMk++) {
				if (POSTparamList.get(xdzv9oMk).getName().equalsIgnoreCase("image")) {
					kkf8r1CO.addPart(POSTparamList.get(xdzv9oMk).getName(),
							new FileBody(new File(POSTparamList.get(xdzv9oMk).getValue())));
				} else {
					kkf8r1CO.addPart(POSTparamList.get(xdzv9oMk).getName(),
							new StringBody(POSTparamList.get(xdzv9oMk).getValue()));
				}
			}
			Dhg7YTF9.setEntity(kkf8r1CO);
			HttpResponse bB7PGoeV = oXUchKXR.execute(Dhg7YTF9, Pa2vPT4G);
			return processAnswer(bB7PGoeV);
		} catch (IOException wdf2ZsP3) {
			wdf2ZsP3.printStackTrace();
		}
		return null;
	}

}