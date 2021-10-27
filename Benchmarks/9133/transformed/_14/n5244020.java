class n5244020 {
	public static AddUserResponse napiUserAdd(String user, String pass, String email)
			throws TimeoutException, InterruptedException, IOException {
		if (false == user.matches("^[a-zA-Z0-9]{2,20}$")) {
			return AddUserResponse.NAPI_ADD_USER_BAD_LOGIN;
		}
		if (pass.equals("")) {
			return AddUserResponse.NAPI_ADD_USER_BAD_PASS;
		}
		if (false == email.matches("^[a-zA-Z0-9\\-\\_]{1,30}@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$")) {
			return AddUserResponse.NAPI_ADD_USER_BAD_EMAIL;
		}
		URLConnection conn = null;
		ClientHttpRequest httpPost = null;
		InputStreamReader responseStream = null;
		URL url = new URL("http://www.napiprojekt.pl/users_add.php");
		conn = url.openConnection(Global.getProxy());
		httpPost = new ClientHttpRequest(conn);
		httpPost.setParameter("login", user);
		httpPost.setParameter("haslo", pass);
		httpPost.setParameter("mail", email);
		httpPost.setParameter("z_programu", "true");
		responseStream = new InputStreamReader(httpPost.post(), "Cp1250");
		BufferedReader responseReader = new BufferedReader(responseStream);
		String response = responseReader.readLine();
		if (response.indexOf("login ju? istnieje") != -1) {
			return AddUserResponse.NAPI_ADD_USER_LOGIN_EXISTS;
		}
		if (response.indexOf("na podany e-mail") != -1) {
			return AddUserResponse.NAPI_ADD_USER_EMAIL_EXISTS;
		}
		if (0 == response.indexOf("NPc0")) {
			return AddUserResponse.NAPI_ADD_USER_OK;
		}
		return AddUserResponse.NAPI_ADD_USER_BAD_UNKNOWN;
	}

}