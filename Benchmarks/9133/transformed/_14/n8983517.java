class n8983517 {
	public User getUser(String userlogin) {
		UserDAO userDAO = new UserDAO();
		User user = null;
		try {
			user = userDAO.load(userlogin);
			if (null == user) {
				URL url = Thread.currentThread().getContextClassLoader().getResource("users.cfg");
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
				String linea = br.readLine();
				while (linea != null) {
					StringTokenizer st = new StringTokenizer(linea, ":");
					if (3 == st.countTokens()) {
						String login = st.nextToken();
						String password = st.nextToken();
						String profile = st.nextToken();
						if (login.equals(userlogin)) {
							user = new User(login, password, profile);
							userDAO.save(user);
						}
					} else {
					}
					linea = br.readLine();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}