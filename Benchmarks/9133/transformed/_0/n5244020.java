class n5244020 {
	public static AddUserResponse napiUserAdd(String TTtEAYsn, String D021fmqt, String OZJJiz7t)
			throws TimeoutException, InterruptedException, IOException {
		if (TTtEAYsn.matches("^[a-zA-Z0-9]{2,20}$") == false) {
			return AddUserResponse.NAPI_ADD_USER_BAD_LOGIN;
		}
		if (D021fmqt.equals("")) {
			return AddUserResponse.NAPI_ADD_USER_BAD_PASS;
		}
		if (OZJJiz7t.matches("^[a-zA-Z0-9\\-\\_]{1,30}@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$") == false) {
			return AddUserResponse.NAPI_ADD_USER_BAD_EMAIL;
		}
		URLConnection rAAK7b3c = null;
		ClientHttpRequest HMJqK8xs = null;
		InputStreamReader Ymj2dQ2U = null;
		URL O4o3IwMM = new URL("http://www.napiprojekt.pl/users_add.php");
		rAAK7b3c = O4o3IwMM.openConnection(Global.getProxy());
		HMJqK8xs = new ClientHttpRequest(rAAK7b3c);
		HMJqK8xs.setParameter("login", TTtEAYsn);
		HMJqK8xs.setParameter("haslo", D021fmqt);
		HMJqK8xs.setParameter("mail", OZJJiz7t);
		HMJqK8xs.setParameter("z_programu", "true");
		Ymj2dQ2U = new InputStreamReader(HMJqK8xs.post(), "Cp1250");
		BufferedReader NDlFp2sT = new BufferedReader(Ymj2dQ2U);
		String bTDTJapt = NDlFp2sT.readLine();
		if (bTDTJapt.indexOf("login ju? istnieje") != -1) {
			return AddUserResponse.NAPI_ADD_USER_LOGIN_EXISTS;
		}
		if (bTDTJapt.indexOf("na podany e-mail") != -1) {
			return AddUserResponse.NAPI_ADD_USER_EMAIL_EXISTS;
		}
		if (bTDTJapt.indexOf("NPc0") == 0) {
			return AddUserResponse.NAPI_ADD_USER_OK;
		}
		return AddUserResponse.NAPI_ADD_USER_BAD_UNKNOWN;
	}

}