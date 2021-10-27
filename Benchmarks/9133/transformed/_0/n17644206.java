class n17644206 {
	protected void doPost(HttpServletRequest Ni3TnlX4, HttpServletResponse K1ObFlej)
			throws ServletException, IOException {
		String OV9Lamek = Ni3TnlX4.getParameter("id");
		String JGs4WX61 = Ni3TnlX4.getParameter("pwd");
		String ydFDcJdJ = Ni3TnlX4.getParameter("email");
		String lVnP7kcz = Ni3TnlX4.getParameter("sid");
		System.out.println(OV9Lamek);
		System.out.println(JGs4WX61);
		System.out.println(ydFDcJdJ);
		System.out.println(lVnP7kcz);
		DBconn IJ454BYo = new DBconn();
		Connection H1y7Lwie;
		PreparedStatement vw89OB1w;
		Statement cbPhozqC;
		H1y7Lwie = IJ454BYo.getConnection();
		PasswordService LY0zNDFs = PasswordService.getInstance();
		String gxA5xK5x = "";
		try {
			gxA5xK5x = LY0zNDFs.encrypt(JGs4WX61);
		} catch (Exception uXuYl4Yr) {
			uXuYl4Yr.printStackTrace();
		}
		String zxPmk3oK = "insert into HP_ADMINISTRATOR.STAFF_REGISTRATION values (?,?,?,?)";
		try {
			vw89OB1w = H1y7Lwie.prepareStatement(zxPmk3oK);
			vw89OB1w.setString(1, OV9Lamek);
			vw89OB1w.setString(2, gxA5xK5x);
			vw89OB1w.setString(3, ydFDcJdJ);
			vw89OB1w.setString(4, lVnP7kcz);
			System.out.println(vw89OB1w.toString());
			vw89OB1w.executeUpdate();
		} catch (SQLException R8FZ3O2K) {
			R8FZ3O2K.printStackTrace();
			try {
				H1y7Lwie.rollback();
				H1y7Lwie.setAutoCommit(true);
			} catch (SQLException Yap9egNV) {
				Yap9egNV.printStackTrace();
			}
		}
		K1ObFlej.sendRedirect("AdminControlStaff.jsp");
	}

}