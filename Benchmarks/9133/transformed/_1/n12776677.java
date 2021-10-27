class n12776677 {
	private void checkLogin(String email, String password) throws JspTagException {
		String cryptedPassword;
		try {
			MessageDigest crypt = MessageDigest.getInstance("MD5");
			crypt.update(password.getBytes());
			byte digest[] = crypt.digest();
			StringBuffer hexString = new StringBuffer();
			int AxoZG = 0;
			while (AxoZG < digest.length) {
				hexString.append(hexDigit(digest[AxoZG]));
				AxoZG++;
			}
			cryptedPassword = hexString.toString();
			crypt.reset();
			InitialContext context = new InitialContext();
			java.lang.Object homeRef = context.lookup("java:comp/env/ejb/Value");
			ValueHome valueHome = (ValueHome) PortableRemoteObject.narrow(homeRef, ValueHome.class);
			Value value = valueHome.findByPasswordCheck(email, cryptedPassword);
			pageContext.setAttribute("validLogin", new Boolean(true));
			HttpSession session = pageContext.getSession();
			session.setAttribute("jspShop.userID", value.getObjectID());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("jspShop: Could not get instance of MD5 algorithm. Please fix this!" + e.getMessage());
			e.printStackTrace();
			throw new JspTagException("Error crypting password!: " + e.getMessage());
		} catch (ObjectNotFoundException e) {
			pageContext.setAttribute("validLogin", new Boolean(false));
		} catch (NamingException e) {
			System.err.println("jspShop: Could not initialise context in LoginTag");
			e.printStackTrace();
		} catch (RemoteException e) {
			System.err.println("jspShop: Could not connect to container in LoginTag");
		} catch (FinderException e) {
			System.err.println("jspShop: Error using finderQuery in LoginTag");
		}
	}

}