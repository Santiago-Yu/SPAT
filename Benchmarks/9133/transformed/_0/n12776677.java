class n12776677 {
	private void checkLogin(String IUzxGSIq, String ex3AJbsi) throws JspTagException {
		String fHsOI0pB;
		try {
			MessageDigest rCSPExTK = MessageDigest.getInstance("MD5");
			rCSPExTK.update(ex3AJbsi.getBytes());
			byte WtpFBe82[] = rCSPExTK.digest();
			StringBuffer Pk1rB3Qb = new StringBuffer();
			for (int ysbiZj91 = 0; ysbiZj91 < WtpFBe82.length; ysbiZj91++) {
				Pk1rB3Qb.append(hexDigit(WtpFBe82[ysbiZj91]));
			}
			fHsOI0pB = Pk1rB3Qb.toString();
			rCSPExTK.reset();
			InitialContext l6I31SEw = new InitialContext();
			java.lang.Object lCKrMpoa = l6I31SEw.lookup("java:comp/env/ejb/Value");
			ValueHome FZTPMmgx = (ValueHome) PortableRemoteObject.narrow(lCKrMpoa, ValueHome.class);
			Value jk2SNBYG = FZTPMmgx.findByPasswordCheck(IUzxGSIq, fHsOI0pB);
			pageContext.setAttribute("validLogin", new Boolean(true));
			HttpSession nfov4GRc = pageContext.getSession();
			nfov4GRc.setAttribute("jspShop.userID", jk2SNBYG.getObjectID());
		} catch (NoSuchAlgorithmException OEGs3DnA) {
			System.err.println(
					"jspShop: Could not get instance of MD5 algorithm. Please fix this!" + OEGs3DnA.getMessage());
			OEGs3DnA.printStackTrace();
			throw new JspTagException("Error crypting password!: " + OEGs3DnA.getMessage());
		} catch (ObjectNotFoundException OzvtEqNI) {
			pageContext.setAttribute("validLogin", new Boolean(false));
		} catch (NamingException tWb6op2C) {
			System.err.println("jspShop: Could not initialise context in LoginTag");
			tWb6op2C.printStackTrace();
		} catch (RemoteException MQGsa9Jj) {
			System.err.println("jspShop: Could not connect to container in LoginTag");
		} catch (FinderException C6TbUQrB) {
			System.err.println("jspShop: Error using finderQuery in LoginTag");
		}
	}

}