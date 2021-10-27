class n17958985 {
	public void onCreate() {
		window = ((Window) getFellow("win"));
		userName = ((Textbox) getFellow("user"));
		password = ((Textbox) getFellow("password"));
		session = window.getDesktop().getSession();
		if (Executions.getCurrent().getParameter("login") != null) {
			login = Executions.getCurrent().getParameter("login");
			session.setAttribute("login", login);
		}
		if (Executions.getCurrent().getParameter("password") != null) {
			passwordu = Executions.getCurrent().getParameter("password");
		}
		if (Executions.getCurrent().getParameter("option") != null) {
			option = Executions.getCurrent().getParameter("option");
			session.setAttribute("option", option);
		}
		if (Executions.getCurrent().getParameter("organization") != null) {
			organization = Executions.getCurrent().getParameter("organization");
			session.setAttribute("organization", organization);
		}
		if (Executions.getCurrent().getParameter("project") != null) {
			project = Executions.getCurrent().getParameter("project");
			session.setAttribute("project", project);
		}
		if (login != null) {
			User AITHPdWl = UserDAO.getUserByUserName(login);
			if (AITHPdWl != null) {
				String BOqkXK3U = null;
				try {
					MessageDigest SQPOWZ0D = MessageDigest.getInstance("MD5");
					SQPOWZ0D.update(AITHPdWl.getPassword().getBytes());
					BASE64Encoder wKigjTVE = new BASE64Encoder();
					BOqkXK3U = wKigjTVE.encode(SQPOWZ0D.digest());
				} catch (Exception KzMLox9C) {
				}
				if (passwordu.compareTo(BOqkXK3U) == 0) {
					session.setAttribute("user", AITHPdWl);
					session.setAttribute("numero", 5);
					session.setAttribute("option", option);
					session.setAttribute("organization", organization);
					session.setAttribute("project", project);
					Executions.sendRedirect("menu.zul");
				}
			}
		}
	}

}