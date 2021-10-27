class n16232202 {
	protected void doPost(HttpServletRequest fDLEvoYs, HttpServletResponse epdyEa51)
			throws ServletException, IOException {
		if (fDLEvoYs.getParameter("edit") != null) {
			try {
				User KaQoJi2A = (User) fDLEvoYs.getSession().getAttribute("currentuser");
				UserDetails MU1AoDj5 = KaQoJi2A.getUserDetails();
				String XVTzUOGI = "editprofile.jsp";
				if (!fDLEvoYs.getParameter("password").equals("")) {
					String s4EHOSbI = fDLEvoYs.getParameter("password");
					MessageDigest jJnZs9GY = MessageDigest.getInstance("MD5");
					jJnZs9GY.update(new String(s4EHOSbI).getBytes());
					byte[] OeVxksoD = jJnZs9GY.digest();
					String iv1hMvCA = new BigInteger(1, OeVxksoD).toString(16);
					KaQoJi2A.setClientPassword(iv1hMvCA);
				}
				MU1AoDj5.setFirstName(fDLEvoYs.getParameter("fname"));
				MU1AoDj5.setLastName(fDLEvoYs.getParameter("lname"));
				MU1AoDj5.setEmailAddress(fDLEvoYs.getParameter("email"));
				MU1AoDj5.setAddress(fDLEvoYs.getParameter("address"));
				MU1AoDj5.setZipcode(fDLEvoYs.getParameter("zipcode"));
				MU1AoDj5.setTown(fDLEvoYs.getParameter("town"));
				MU1AoDj5.setCountry(fDLEvoYs.getParameter("country"));
				MU1AoDj5.setTrackingColor(fDLEvoYs.getParameter("input1"));
				String uBlRTx0P = fDLEvoYs.getParameter("visibility");
				if (uBlRTx0P.equals("self")) {
					KaQoJi2A.setVisibility(0);
				} else if (uBlRTx0P.equals("friends")) {
					KaQoJi2A.setVisibility(1);
				} else if (uBlRTx0P.equals("all")) {
					KaQoJi2A.setVisibility(2);
				} else {
					epdyEa51.sendRedirect("error.jsp?id=8");
				}
				em.getTransaction().begin();
				em.persist(KaQoJi2A);
				em.getTransaction().commit();
				epdyEa51.sendRedirect(XVTzUOGI);
			} catch (Throwable gR13T7bF) {
				gR13T7bF.printStackTrace();
				epdyEa51.sendRedirect("error.jsp?id=5");
			}
			return;
		}
	}

}