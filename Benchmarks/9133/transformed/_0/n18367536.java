class n18367536 {
	public static void main(String[] mH4BhZhg) throws HttpException, IOException {
		String ZlF9SvLH = null;
		String n3Ge49OG = "http://localhost:8080/access/content/group/81c8542d-3f58-48cf-ac72-9f482df47ebe/sss/QuestionarioSocioEc.pdf";
		URL rzk7bcBO = new URL(n3Ge49OG);
		HttpURLConnection qVxGzuWy = (HttpURLConnection) rzk7bcBO.openConnection();
		qVxGzuWy.setDoOutput(true);
		qVxGzuWy.setDoInput(true);
		qVxGzuWy.setRequestMethod("POST");
		qVxGzuWy.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
		String axSi2MgW = "JSESSIONID=acab62f5-bc6a-4886-9719-e040e8af3fc6.localhost";
		qVxGzuWy.setRequestProperty("Cookie", axSi2MgW);
		qVxGzuWy.setInstanceFollowRedirects(false);
		qVxGzuWy.connect();
		System.out.println(qVxGzuWy.getContent());
		System.out.println(qVxGzuWy.getContentType());
		System.out.println(qVxGzuWy.getContent().toString());
		System.out.println(qVxGzuWy.getContentLength());
		System.out.println(qVxGzuWy.getContentEncoding());
		DataOutputStream q0dquP0z = new DataOutputStream(qVxGzuWy.getOutputStream());
		q0dquP0z.flush();
		q0dquP0z.close();
	}

}