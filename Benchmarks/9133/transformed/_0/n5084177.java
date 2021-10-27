class n5084177 {
	protected void processRequest(HttpServletRequest VGtOcr3r, HttpServletResponse oKNXZoZY)
			throws ServletException, IOException {
		ServletConfig Kl6AwwHy = getServletConfig();
		ServletContext iU5d8axD = Kl6AwwHy.getServletContext();
		try {
			String kYvL67hq = iU5d8axD.getInitParameter("driver");
			Class.forName(kYvL67hq);
			String z5A2Yx9v = iU5d8axD.getInitParameter("db");
			String tDgXqzpB = iU5d8axD.getInitParameter("username");
			String a4ctmc3X = "";
			connection = DriverManager.getConnection(z5A2Yx9v, tDgXqzpB, a4ctmc3X);
		} catch (ClassNotFoundException YGWTxrM4) {
			System.out.println("Database driver not found.");
		} catch (SQLException L2Rpuiwt) {
			System.out.println("Error opening the db connection: " + L2Rpuiwt.getMessage());
		}
		String f3chYmnH = "";
		HttpSession wLmUd7QW = VGtOcr3r.getSession();
		wLmUd7QW.setMaxInactiveInterval(300);
		if (VGtOcr3r.getParameter("action") != null) {
			f3chYmnH = VGtOcr3r.getParameter("action");
		} else {
			RequestDispatcher Tl4MHVJe = getServletContext().getRequestDispatcher("/login.jsp");
			Tl4MHVJe.forward(VGtOcr3r, oKNXZoZY);
			return;
		}
		if (f3chYmnH.equals("login")) {
			String fJN2tCtg = VGtOcr3r.getParameter("username");
			String sLoC6T2F = VGtOcr3r.getParameter("password");
			MessageDigest yTL4irl1 = null;
			try {
				yTL4irl1 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException szya7ALy) {
				error = "There was an error encrypting password.";
				wLmUd7QW.setAttribute("error", error);
				RequestDispatcher iuVrx9QL = getServletContext().getRequestDispatcher("/error.jsp");
				iuVrx9QL.forward(VGtOcr3r, oKNXZoZY);
				return;
			}
			try {
				yTL4irl1.update(sLoC6T2F.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException spdRwWbY) {
				error = "There was an error encrypting password.";
				wLmUd7QW.setAttribute("error", error);
				RequestDispatcher h9F8pPnP = getServletContext().getRequestDispatcher("/error.jsp");
				h9F8pPnP.forward(VGtOcr3r, oKNXZoZY);
				return;
			}
			String YfJ8uqeK = (new BASE64Encoder()).encode(yTL4irl1.digest());
			try {
				String yUiP0Yep = "SELECT * FROM person WHERE email LIKE '" + fJN2tCtg + "' AND password='" + YfJ8uqeK
						+ "'";
				dbStatement = connection.createStatement();
				dbResultSet = dbStatement.executeQuery(yUiP0Yep);
				if (dbResultSet.next()) {
					Person YokJPvk0 = new Person(dbResultSet.getString("fname"), dbResultSet.getString("lname"),
							dbResultSet.getString("address1"), dbResultSet.getString("address2"),
							dbResultSet.getString("city"), dbResultSet.getString("state"), dbResultSet.getString("zip"),
							dbResultSet.getString("email"), dbResultSet.getString("password"),
							dbResultSet.getInt("is_admin"));
					String Mo7xjTJW = dbResultSet.getString("member_type");
					String x2YvUaWW = Integer.toString(dbResultSet.getInt("id"));
					wLmUd7QW.setAttribute("person", YokJPvk0);
					wLmUd7QW.setAttribute("member_type", Mo7xjTJW);
					wLmUd7QW.setAttribute("person_id", x2YvUaWW);
				} else {
					notice = "Your username and/or password is incorrect.";
					VGtOcr3r.setAttribute("notice", notice);
					RequestDispatcher J8LZdXd2 = getServletContext().getRequestDispatcher("/index.jsp");
					J8LZdXd2.forward(VGtOcr3r, oKNXZoZY);
					return;
				}
			} catch (SQLException gamlwUSC) {
				error = "There was an error trying to login. (SQL Statement)";
				wLmUd7QW.setAttribute("error", error);
				RequestDispatcher nBq1bpFK = getServletContext().getRequestDispatcher("/error.jsp");
				nBq1bpFK.forward(VGtOcr3r, oKNXZoZY);
				return;
			}
			RequestDispatcher ZqhrWANd = getServletContext().getRequestDispatcher("/index.jsp");
			ZqhrWANd.forward(VGtOcr3r, oKNXZoZY);
			return;
		} else {
			notice = "Unable to log you in.  Please try again.";
			VGtOcr3r.setAttribute("notice", notice);
			RequestDispatcher nXHvxbqH = getServletContext().getRequestDispatcher("/login.jsp");
			nXHvxbqH.forward(VGtOcr3r, oKNXZoZY);
			return;
		}
	}

}