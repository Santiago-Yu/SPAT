class n17644206 {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String sid = request.getParameter("sid");
		System.out.println(uid);
		System.out.println(pwd);
		System.out.println(email);
		System.out.println(sid);
		Connection conn;
		DBconn dbc = new DBconn();
		Statement st;
		PreparedStatement pst;
		conn = dbc.getConnection();
		String hash = "";
		PasswordService ps = PasswordService.getInstance();
		String sql = "insert into HP_ADMINISTRATOR.STAFF_REGISTRATION values (?,?,?,?)";
		try {
			hash = ps.encrypt(pwd);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, uid);
			pst.setString(2, hash);
			pst.setString(3, email);
			pst.setString(4, sid);
			System.out.println(pst.toString());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		response.sendRedirect("AdminControlStaff.jsp");
	}

}