class n19100233 {
	protected void doPost(HttpServletRequest Kf7arqHg, HttpServletResponse rzOkS61j)
			throws ServletException, IOException {
		rzOkS61j.setContentType("text/plain");
		PrintWriter Bx7XobAo = rzOkS61j.getWriter();
		String SXh9T0hJ = Kf7arqHg.getParameter("reqno");
		int FF1IRfdy = Integer.parseInt(SXh9T0hJ);
		Connection OIZUQ4dq = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			OIZUQ4dq = DriverManager.getConnection("jdbc:derby:/DerbyDB/AssetDB");
			OIZUQ4dq.setAutoCommit(false);
			String d2wMngBF = Kf7arqHg.getRemoteAddr();
			Statement d04Jvof3 = OIZUQ4dq.createStatement();
			String jaDagdZd = "UPDATE REQUEST_DETAILS SET viewed = '1', checked_by = '" + d2wMngBF
					+ "' WHERE QUERY = ?";
			PreparedStatement aEbLUba0 = OIZUQ4dq.prepareStatement(jaDagdZd);
			aEbLUba0.setInt(1, FF1IRfdy);
			aEbLUba0.executeUpdate();
			OIZUQ4dq.commit();
			String rMiOC4kr = "/queryRemoved.jsp";
			RequestDispatcher oqwJYZ7S = getServletContext().getRequestDispatcher(rMiOC4kr);
			oqwJYZ7S.forward(Kf7arqHg, rzOkS61j);
		} catch (Exception nx5ugrDU) {
			try {
				OIZUQ4dq.rollback();
			} catch (SQLException RPy9TRWK) {
			}
			Bx7XobAo.println("Failed");
		} finally {
			try {
				if (OIZUQ4dq != null)
					OIZUQ4dq.close();
			} catch (SQLException fdFS8TDM) {
			}
		}
	}

}