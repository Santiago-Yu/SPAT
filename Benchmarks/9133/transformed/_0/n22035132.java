class n22035132 {
	protected void processRequest(HttpServletRequest mZzvRtNX, HttpServletResponse Aj4SBiez)
			throws ServletException, IOException {
		ServletConfig vDNxrniR = getServletConfig();
		ServletContext FrThFnfn = vDNxrniR.getServletContext();
		try {
			String spDmXkzG = FrThFnfn.getInitParameter("driver");
			Class.forName(spDmXkzG);
			String CyjGqBae = FrThFnfn.getInitParameter("db");
			String sXs95cuB = FrThFnfn.getInitParameter("username");
			String Cxbz3jes = "";
			connection = DriverManager.getConnection(CyjGqBae, sXs95cuB, Cxbz3jes);
		} catch (ClassNotFoundException A2uBvqPv) {
			System.out.println("Database driver not found.");
		} catch (SQLException o9cnzErK) {
			System.out.println("Error opening the db connection: " + o9cnzErK.getMessage());
		}
		String PwF9Uiel = "";
		String cONEOORe;
		String Of5l8eJ3 = "";
		HttpSession wUuUJWh1 = mZzvRtNX.getSession();
		wUuUJWh1.setMaxInactiveInterval(300);
		if (mZzvRtNX.getParameter("action") != null) {
			PwF9Uiel = mZzvRtNX.getParameter("action");
		} else {
			cONEOORe = "Unknown action!";
			mZzvRtNX.setAttribute("notice", cONEOORe);
			RequestDispatcher i7MeyfjU = getServletContext().getRequestDispatcher("/admin/index.jsp");
			i7MeyfjU.forward(mZzvRtNX, Aj4SBiez);
			return;
		}
		if (PwF9Uiel.equals("edit_events")) {
			String wxDK8Fbq;
			String uzAcKuyo = "";
			int jarC95Ph;
			int fZ0nFyT8;
			Event IzBfN9nS;
			if (mZzvRtNX.getParameter("month") != null) {
				jarC95Ph = Integer.parseInt(mZzvRtNX.getParameter("month"));
				String kV0yEcjQ = mZzvRtNX.getParameter("year_num");
				fZ0nFyT8 = Integer.parseInt(kV0yEcjQ);
				int fX1TCo1C = jarC95Ph - 1;
				IzBfN9nS = new Event(fZ0nFyT8, fX1TCo1C, 1);
				uzAcKuyo = IzBfN9nS.getMonthName();
				fZ0nFyT8 = IzBfN9nS.getYearNumber();
				if (jarC95Ph < 10) {
					wxDK8Fbq = "SELECT * FROM event WHERE date LIKE '" + fZ0nFyT8 + "-0" + jarC95Ph + "-%'";
				} else {
					wxDK8Fbq = "SELECT * FROM event WHERE date LIKE '" + fZ0nFyT8 + "-" + jarC95Ph + "-%'";
				}
			} else {
				IzBfN9nS = new Event();
				uzAcKuyo = IzBfN9nS.getMonthName();
				jarC95Ph = IzBfN9nS.getMonthNumber() + 1;
				fZ0nFyT8 = IzBfN9nS.getYearNumber();
				wxDK8Fbq = "SELECT * FROM event WHERE date LIKE '" + fZ0nFyT8 + "-%" + jarC95Ph + "-%'";
			}
			try {
				dbStatement = connection.createStatement();
				dbResultSet = dbStatement.executeQuery(wxDK8Fbq);
				mZzvRtNX.setAttribute("resultset", dbResultSet);
				mZzvRtNX.setAttribute("year", Integer.toString(fZ0nFyT8));
				mZzvRtNX.setAttribute("month", Integer.toString(jarC95Ph));
				mZzvRtNX.setAttribute("month_name", uzAcKuyo);
				RequestDispatcher LgQMv4d3 = getServletContext().getRequestDispatcher("/admin/edit_events.jsp");
				LgQMv4d3.forward(mZzvRtNX, Aj4SBiez);
				return;
			} catch (SQLException H8mrETVu) {
				cONEOORe = "Error retrieving events from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher zxOT4I82 = getServletContext().getRequestDispatcher("/admin/index.jsp");
				zxOT4I82.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("edit_event")) {
			int n80qnwu2 = Integer.parseInt(mZzvRtNX.getParameter("id"));
			Event U4haR7aU = new Event();
			U4haR7aU = U4haR7aU.getEvent(n80qnwu2);
			if (U4haR7aU != null) {
				mZzvRtNX.setAttribute("event", U4haR7aU);
				mZzvRtNX.setAttribute("id", Integer.toString(n80qnwu2));
				RequestDispatcher dI0rLwWx = getServletContext().getRequestDispatcher("/admin/add_event.jsp");
				dI0rLwWx.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error retrieving event from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher uGQw06gb = getServletContext().getRequestDispatcher("/admin/index.jsp");
				uGQw06gb.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("save_event")) {
			String r2WYd0NN = mZzvRtNX.getParameter("title");
			String RvHqy5SV = mZzvRtNX.getParameter("description");
			String o6GGgcX9 = mZzvRtNX.getParameter("month");
			String PYwfyJBk = mZzvRtNX.getParameter("day");
			String x7OmYukz = mZzvRtNX.getParameter("year");
			String WnkByJdt = "";
			String CCrSpPRQ = "";
			if (mZzvRtNX.getParameter("all_day") == null) {
				String kDEhDVL2 = mZzvRtNX.getParameter("start_hour");
				String PKki2qPQ = mZzvRtNX.getParameter("start_minutes");
				String u6Y3c54A = mZzvRtNX.getParameter("start_ampm");
				String uN8ZjMgB = mZzvRtNX.getParameter("end_hour");
				String XxqOPsYW = mZzvRtNX.getParameter("end_minutes");
				String biezK7yv = mZzvRtNX.getParameter("end_ampm");
				if (Integer.parseInt(kDEhDVL2) < 10) {
					kDEhDVL2 = "0" + kDEhDVL2;
				}
				if (Integer.parseInt(uN8ZjMgB) < 10) {
					uN8ZjMgB = "0" + uN8ZjMgB;
				}
				WnkByJdt = kDEhDVL2 + ":" + PKki2qPQ + " " + u6Y3c54A;
				CCrSpPRQ = uN8ZjMgB + ":" + XxqOPsYW + " " + biezK7yv;
			}
			Event yMyCzXbp = null;
			if (!WnkByJdt.equals("") && !CCrSpPRQ.equals("")) {
				yMyCzXbp = new Event(r2WYd0NN, RvHqy5SV, o6GGgcX9, PYwfyJBk, x7OmYukz, WnkByJdt, CCrSpPRQ);
			} else {
				yMyCzXbp = new Event(r2WYd0NN, RvHqy5SV, o6GGgcX9, PYwfyJBk, x7OmYukz);
			}
			if (yMyCzXbp.saveEvent()) {
				cONEOORe = "Calendar event saved!";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher SskNFwpN = getServletContext().getRequestDispatcher("/admin/index.jsp");
				SskNFwpN.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error saving calendar event.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				mZzvRtNX.setAttribute("event", yMyCzXbp);
				RequestDispatcher O9kFSTd4 = getServletContext().getRequestDispatcher("/admin/add_event.jsp");
				O9kFSTd4.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("update_event")) {
			String AoFrxp85 = mZzvRtNX.getParameter("title");
			String LUElli0C = mZzvRtNX.getParameter("description");
			String odPf4lFE = mZzvRtNX.getParameter("month");
			String ToKTbVCJ = mZzvRtNX.getParameter("day");
			String bi7npx7z = mZzvRtNX.getParameter("year");
			String lyPSy4DH = "";
			String f3r5t67U = "";
			int kGT3Zf7z = Integer.parseInt(mZzvRtNX.getParameter("id"));
			if (mZzvRtNX.getParameter("all_day") == null) {
				String cxubQAhU = mZzvRtNX.getParameter("start_hour");
				String QnMmYgi7 = mZzvRtNX.getParameter("start_minutes");
				String JwWc3vVP = mZzvRtNX.getParameter("start_ampm");
				String PMN1yseW = mZzvRtNX.getParameter("end_hour");
				String uAF4T2dO = mZzvRtNX.getParameter("end_minutes");
				String gC6nYJKj = mZzvRtNX.getParameter("end_ampm");
				if (Integer.parseInt(cxubQAhU) < 10) {
					cxubQAhU = "0" + cxubQAhU;
				}
				if (Integer.parseInt(PMN1yseW) < 10) {
					PMN1yseW = "0" + PMN1yseW;
				}
				lyPSy4DH = cxubQAhU + ":" + QnMmYgi7 + " " + JwWc3vVP;
				f3r5t67U = PMN1yseW + ":" + uAF4T2dO + " " + gC6nYJKj;
			}
			Event q0naG1tJ = null;
			if (!lyPSy4DH.equals("") && !f3r5t67U.equals("")) {
				q0naG1tJ = new Event(AoFrxp85, LUElli0C, odPf4lFE, ToKTbVCJ, bi7npx7z, lyPSy4DH, f3r5t67U);
			} else {
				q0naG1tJ = new Event(AoFrxp85, LUElli0C, odPf4lFE, ToKTbVCJ, bi7npx7z);
			}
			if (q0naG1tJ.updateEvent(kGT3Zf7z)) {
				cONEOORe = "Calendar event updated!";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher u9SKHaT3 = getServletContext().getRequestDispatcher("/admin/index.jsp");
				u9SKHaT3.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error updating calendar event.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				mZzvRtNX.setAttribute("event", q0naG1tJ);
				RequestDispatcher KjrSNHcj = getServletContext().getRequestDispatcher("/admin/add_event.jsp");
				KjrSNHcj.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("delete_event")) {
			int zAiKIjEB = Integer.parseInt(mZzvRtNX.getParameter("id"));
			Event vv7ZyVma = new Event();
			if (vv7ZyVma.deleteEvent(zAiKIjEB)) {
				cONEOORe = "Calendar event successfully deleted.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher zcFI9EjW = getServletContext().getRequestDispatcher("/admin?action=edit_events");
				zcFI9EjW.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error deleting event from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher GpMHGZAL = getServletContext().getRequestDispatcher("/admin?action=edit_events");
				GpMHGZAL.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("edit_members")) {
			String MDVALvY0 = "SELECT * FROM person ORDER BY lname";
			if (mZzvRtNX.getParameter("member_type") != null) {
				String LHdnfuuo = mZzvRtNX.getParameter("member_type");
				if (LHdnfuuo.equals("all")) {
					MDVALvY0 = "SELECT * FROM person ORDER BY lname";
				} else {
					MDVALvY0 = "SELECT * FROM person where member_type LIKE '" + LHdnfuuo + "' ORDER BY lname";
				}
				mZzvRtNX.setAttribute("member_type", LHdnfuuo);
			}
			try {
				dbStatement = connection.createStatement();
				dbResultSet = dbStatement.executeQuery(MDVALvY0);
				mZzvRtNX.setAttribute("resultset", dbResultSet);
				RequestDispatcher f8corZgK = getServletContext().getRequestDispatcher("/admin/edit_members.jsp");
				f8corZgK.forward(mZzvRtNX, Aj4SBiez);
				return;
			} catch (SQLException qoBAadcU) {
				cONEOORe = "Error retrieving members from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher nOzowdEy = getServletContext().getRequestDispatcher("/admin/index.jsp");
				nOzowdEy.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("edit_person")) {
			int JVCz7CYf = Integer.parseInt(mZzvRtNX.getParameter("id"));
			String G9feLVNQ = mZzvRtNX.getParameter("member_type");
			Person bWSVmE8V = new Person();
			bWSVmE8V = bWSVmE8V.getPerson(JVCz7CYf);
			if (G9feLVNQ.equals("student")) {
				Student vUoFio0O = bWSVmE8V.getStudent();
				mZzvRtNX.setAttribute("student", vUoFio0O);
				RequestDispatcher v7qiDkHW = getServletContext().getRequestDispatcher("/admin/edit_student.jsp");
				v7qiDkHW.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else if (G9feLVNQ.equals("alumni")) {
				Alumni Rm0iqLpU = bWSVmE8V.getAlumni();
				mZzvRtNX.setAttribute("alumni", Rm0iqLpU);
				RequestDispatcher CbH15aP2 = getServletContext().getRequestDispatcher("/admin/edit_alumni.jsp");
				CbH15aP2.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else if (G9feLVNQ.equals("hospital")) {
				Hospital O3NwWaJU = bWSVmE8V.getHospital(JVCz7CYf);
				mZzvRtNX.setAttribute("hospital", O3NwWaJU);
				RequestDispatcher nz4YpeXT = getServletContext().getRequestDispatcher("/admin/edit_hospital.jsp");
				nz4YpeXT.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("update_alumni")) {
			int ICY93ZX5 = Integer.parseInt(mZzvRtNX.getParameter("person_id"));
			Person aIomxQQi = new Person();
			aIomxQQi = aIomxQQi.getPerson(ICY93ZX5);
			Alumni slCHztLi = aIomxQQi.getAlumni();
			String oQPmUoNI = mZzvRtNX.getParameter("fname");
			String Se0bWnXc = mZzvRtNX.getParameter("lname");
			String uF3RvkLv = mZzvRtNX.getParameter("address1");
			String eua7Yir2 = mZzvRtNX.getParameter("address2");
			String mCxGnmrx = mZzvRtNX.getParameter("city");
			String uMQL6Xyf = mZzvRtNX.getParameter("state");
			String MYxN5Yzw = mZzvRtNX.getParameter("zip");
			String kBUAD1qc = mZzvRtNX.getParameter("email");
			String iGHd6U1j = mZzvRtNX.getParameter("company_name");
			String SgEYYO8m = mZzvRtNX.getParameter("position");
			int uX4B8ETU = 0;
			if (mZzvRtNX.getParameter("mentor") != null) {
				uX4B8ETU = 1;
			}
			String oCdvYMnB = mZzvRtNX.getParameter("graduation_year") + "-" + mZzvRtNX.getParameter("graduation_month")
					+ "-01";
			String S8MUDsSo = "";
			if (mZzvRtNX.getParameter("password") != null) {
				S8MUDsSo = mZzvRtNX.getParameter("password");
				MessageDigest gNK9PdTc = null;
				try {
					gNK9PdTc = MessageDigest.getInstance("MD5");
					gNK9PdTc.update(S8MUDsSo.getBytes("UTF-8"));
				} catch (Exception ZQfQXuhL) {
					cONEOORe = "Could not encrypt your password.  Please try again.";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					RequestDispatcher rZMMfgnB = getServletContext().getRequestDispatcher("/admin?action=edit_members");
					rZMMfgnB.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
				S8MUDsSo = (new BASE64Encoder()).encode(gNK9PdTc.digest());
			} else {
				S8MUDsSo = slCHztLi.getPassword();
			}
			int jx9q3nLs = 0;
			if (mZzvRtNX.getParameter("is_admin") != null) {
				jx9q3nLs = 1;
			}
			Alumni Y8eRQyvO = new Alumni(oQPmUoNI, Se0bWnXc, uF3RvkLv, eua7Yir2, mCxGnmrx, uMQL6Xyf, MYxN5Yzw, kBUAD1qc,
					S8MUDsSo, jx9q3nLs, iGHd6U1j, SgEYYO8m, oCdvYMnB, uX4B8ETU);
			if (!Y8eRQyvO.getEmail().equals(slCHztLi.getEmail())) {
				if (Y8eRQyvO.checkEmailIsRegistered()) {
					cONEOORe = "That email address is already registered!";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					mZzvRtNX.setAttribute("alumni", Y8eRQyvO);
					RequestDispatcher Zn2Zmkx1 = getServletContext().getRequestDispatcher("/admin?action=edit_members");
					Zn2Zmkx1.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
			}
			if (!Y8eRQyvO.updateAlumni(ICY93ZX5)) {
				wUuUJWh1.setAttribute("alumni", Y8eRQyvO);
				cONEOORe = "There was an error saving your information.  Please try again.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher jEVY5mBu = getServletContext().getRequestDispatcher("/admin?action=edit_members");
				jEVY5mBu.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
			cONEOORe = "Member information successfully updated.";
			mZzvRtNX.setAttribute("notice", cONEOORe);
			RequestDispatcher GSIIgOyE = getServletContext().getRequestDispatcher("/admin?action=edit_members");
			GSIIgOyE.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("update_hospital")) {
			int PD2WBaSy = Integer.parseInt(mZzvRtNX.getParameter("person_id"));
			Person CWBtT3uV = new Person();
			CWBtT3uV = CWBtT3uV.getPerson(PD2WBaSy);
			Hospital EkUupra1 = CWBtT3uV.getHospital(PD2WBaSy);
			String hHBgGxyf = mZzvRtNX.getParameter("fname");
			String dCbILvkL = mZzvRtNX.getParameter("lname");
			String Cc036NYR = mZzvRtNX.getParameter("address1");
			String ZC6Ze7RS = mZzvRtNX.getParameter("address2");
			String vdr3Go3L = mZzvRtNX.getParameter("city");
			String BCY2Ezyh = mZzvRtNX.getParameter("state");
			String ov5Lui2f = mZzvRtNX.getParameter("zip");
			String IFRupZOQ = mZzvRtNX.getParameter("email");
			String paqdlp9L = mZzvRtNX.getParameter("name");
			String wo8g3ycU = mZzvRtNX.getParameter("phone");
			String oT3T8dTs = mZzvRtNX.getParameter("url");
			String gEInnWnk = "";
			if (EkUupra1.getPassword() != null) {
				if (mZzvRtNX.getParameter("password") != null && !mZzvRtNX.getParameter("password").equals("")) {
					gEInnWnk = mZzvRtNX.getParameter("password");
					MessageDigest WVL9ztFB = null;
					try {
						WVL9ztFB = MessageDigest.getInstance("MD5");
						WVL9ztFB.update(gEInnWnk.getBytes("UTF-8"));
					} catch (Exception hCvH6tjo) {
						cONEOORe = "Could not encrypt your password.  Please try again.";
						mZzvRtNX.setAttribute("notice", cONEOORe);
						RequestDispatcher FuPvsZAn = getServletContext()
								.getRequestDispatcher("/admin?action=edit_members");
						FuPvsZAn.forward(mZzvRtNX, Aj4SBiez);
						return;
					}
					gEInnWnk = (new BASE64Encoder()).encode(WVL9ztFB.digest());
				} else {
					gEInnWnk = EkUupra1.getPassword();
				}
			}
			int sYtVAuXx = 0;
			if (mZzvRtNX.getParameter("is_admin") != null) {
				sYtVAuXx = 1;
			}
			Hospital ZVxoamLK = new Hospital(hHBgGxyf, dCbILvkL, Cc036NYR, ZC6Ze7RS, vdr3Go3L, BCY2Ezyh, ov5Lui2f,
					IFRupZOQ, gEInnWnk, sYtVAuXx, paqdlp9L, wo8g3ycU, oT3T8dTs);
			if (!ZVxoamLK.getEmail().equals(EkUupra1.getEmail())) {
				if (ZVxoamLK.checkEmailIsRegistered()) {
					cONEOORe = "That email address is already registered!";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					mZzvRtNX.setAttribute("hospital", ZVxoamLK);
					RequestDispatcher pGtO67nV = getServletContext().getRequestDispatcher("/admin?action=edit_members");
					pGtO67nV.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
			}
			if (!ZVxoamLK.updateHospital(PD2WBaSy)) {
				wUuUJWh1.setAttribute("hospital", ZVxoamLK);
				cONEOORe = "There was an error saving your information.  Please try again.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher OMLiN7Y0 = getServletContext().getRequestDispatcher("/admin?action=edit_members");
				OMLiN7Y0.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
			cONEOORe = "Information successfully updated.";
			mZzvRtNX.setAttribute("notice", cONEOORe);
			RequestDispatcher emnTkW1M = getServletContext().getRequestDispatcher("/admin?action=edit_members");
			emnTkW1M.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("update_student")) {
			int C3Q7rgDz = Integer.parseInt(mZzvRtNX.getParameter("person_id"));
			Person uFNNCTnw = new Person();
			uFNNCTnw = uFNNCTnw.getPerson(C3Q7rgDz);
			Student lMGsI5w4 = uFNNCTnw.getStudent();
			String I1SySu3w = mZzvRtNX.getParameter("fname");
			String bCESWBq8 = mZzvRtNX.getParameter("lname");
			String nLHGGg8z = mZzvRtNX.getParameter("address1");
			String ZeudkvEj = mZzvRtNX.getParameter("address2");
			String vHoEZup8 = mZzvRtNX.getParameter("city");
			String JT2XDhII = mZzvRtNX.getParameter("state");
			String abgqpGDM = mZzvRtNX.getParameter("zip");
			String ntUWysHw = mZzvRtNX.getParameter("email");
			String HsXr1q1q = mZzvRtNX.getParameter("start_year") + "-" + mZzvRtNX.getParameter("start_month") + "-01";
			String NtYiuvn0 = "";
			if (!mZzvRtNX.getParameter("grad_year").equals("") && !mZzvRtNX.getParameter("grad_month").equals("")) {
				NtYiuvn0 = mZzvRtNX.getParameter("grad_year") + "-" + mZzvRtNX.getParameter("grad_month") + "-01";
			}
			String L0LVsDT8 = "";
			if (mZzvRtNX.getParameter("password") != null && !mZzvRtNX.getParameter("password").equals("")) {
				L0LVsDT8 = mZzvRtNX.getParameter("password");
				MessageDigest pOGh9LOM = null;
				try {
					pOGh9LOM = MessageDigest.getInstance("MD5");
					pOGh9LOM.update(L0LVsDT8.getBytes("UTF-8"));
				} catch (Exception PcbLzByI) {
					cONEOORe = "Could not encrypt your password.  Please try again.";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					RequestDispatcher mSPGPUMt = getServletContext().getRequestDispatcher("/admin?action=edit_members");
					mSPGPUMt.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
				L0LVsDT8 = (new BASE64Encoder()).encode(pOGh9LOM.digest());
			} else {
				L0LVsDT8 = lMGsI5w4.getPassword();
			}
			int vVWfs5a0 = 0;
			if (mZzvRtNX.getParameter("is_admin") != null) {
				vVWfs5a0 = 1;
			}
			Student lYR4TSCK = new Student(I1SySu3w, bCESWBq8, nLHGGg8z, ZeudkvEj, vHoEZup8, JT2XDhII, abgqpGDM,
					ntUWysHw, L0LVsDT8, vVWfs5a0, HsXr1q1q, NtYiuvn0);
			if (!lYR4TSCK.getEmail().equals(lMGsI5w4.getEmail())) {
				if (lYR4TSCK.checkEmailIsRegistered()) {
					cONEOORe = "That email address is already registered!";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					mZzvRtNX.setAttribute("student", lYR4TSCK);
					RequestDispatcher E0243pib = getServletContext().getRequestDispatcher("/admin?action=edit_members");
					E0243pib.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
			}
			if (!lYR4TSCK.updateStudent(C3Q7rgDz)) {
				cONEOORe = "There was an error saving your information.  Please try again.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher G4iS7E6e = getServletContext().getRequestDispatcher("/admin?action=edit_members");
				G4iS7E6e.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
			cONEOORe = "Information successfully updated.";
			mZzvRtNX.setAttribute("notice", cONEOORe);
			RequestDispatcher jp519w6H = getServletContext().getRequestDispatcher("/admin?action=edit_members");
			jp519w6H.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("delete_person")) {
			int qZOo5ssI = Integer.parseInt(mZzvRtNX.getParameter("id"));
			String OGbApkok = mZzvRtNX.getParameter("member_type");
			Person hmUX4un8 = new Person();
			hmUX4un8 = hmUX4un8.getPerson(qZOo5ssI);
			if (hmUX4un8.deletePerson(OGbApkok)) {
				cONEOORe = hmUX4un8.getFname() + ' ' + hmUX4un8.getLname() + " successfully deleted from database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				hmUX4un8 = null;
				RequestDispatcher OdHE11cq = getServletContext()
						.getRequestDispatcher("/admin?action=edit_members&member_type=all");
				OdHE11cq.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("manage_pages")) {
			String guoLAFJ9 = "SELECT * FROM pages WHERE parent_id=0 OR parent_id IN (SELECT id FROM pages WHERE title LIKE 'root')";
			if (mZzvRtNX.getParameter("id") != null) {
				int hxWKCYax = Integer.parseInt(mZzvRtNX.getParameter("id"));
				guoLAFJ9 = "SELECT * FROM pages WHERE parent_id=" + hxWKCYax;
			}
			try {
				dbStatement = connection.createStatement();
				dbResultSet = dbStatement.executeQuery(guoLAFJ9);
				mZzvRtNX.setAttribute("resultset", dbResultSet);
				RequestDispatcher VXQ34Tnf = getServletContext().getRequestDispatcher("/admin/edit_pages.jsp");
				VXQ34Tnf.forward(mZzvRtNX, Aj4SBiez);
				return;
			} catch (SQLException BRas3Q0V) {
				cONEOORe = "Error retrieving content pages from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher O5pNcenQ = getServletContext().getRequestDispatcher("/admin/index.jsp");
				O5pNcenQ.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("add_page")) {
			String r2fqttsl = "SELECT id, title FROM pages WHERE parent_id=0 OR parent_id IN (SELECT id FROM pages WHERE title LIKE 'root')";
			try {
				dbStatement = connection.createStatement();
				dbResultSet = dbStatement.executeQuery(r2fqttsl);
				mZzvRtNX.setAttribute("resultset", dbResultSet);
				RequestDispatcher ePgolWUX = getServletContext().getRequestDispatcher("/admin/add_page.jsp");
				ePgolWUX.forward(mZzvRtNX, Aj4SBiez);
				return;
			} catch (SQLException DSKor3B8) {
				cONEOORe = "Error retrieving content pages from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher CI2l8mYK = getServletContext().getRequestDispatcher("/admin/index.jsp");
				CI2l8mYK.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("save_page")) {
			String fIoWcI5j = mZzvRtNX.getParameter("title");
			String isNWFX0W = mZzvRtNX.getParameter("content");
			Page W39tNGec = null;
			if (mZzvRtNX.getParameter("parent_id") != null) {
				int oTyHMjJa = Integer.parseInt(mZzvRtNX.getParameter("parent_id"));
				W39tNGec = new Page(fIoWcI5j, isNWFX0W, oTyHMjJa);
			} else {
				W39tNGec = new Page(fIoWcI5j, isNWFX0W, 0);
			}
			if (W39tNGec.savePage()) {
				cONEOORe = "Content page saved!";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher XqAQpClB = getServletContext().getRequestDispatcher("/admin/index.jsp");
				XqAQpClB.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "There was an error saving the page.";
				mZzvRtNX.setAttribute("page", W39tNGec);
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher ggb1Jeh0 = getServletContext().getRequestDispatcher("/admin/add_page.jsp");
				ggb1Jeh0.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("edit_page")) {
			String tqEP1Smu = "SELECT * FROM pages WHERE parent_id=0";
			int odev0PXw = Integer.parseInt(mZzvRtNX.getParameter("id"));
			Page vGw0Nq0Y = new Page();
			vGw0Nq0Y = vGw0Nq0Y.getPage(odev0PXw);
			try {
				dbStatement = connection.createStatement();
				dbResultSet = dbStatement.executeQuery(tqEP1Smu);
				mZzvRtNX.setAttribute("resultset", dbResultSet);
			} catch (SQLException nd4BqsIt) {
				cONEOORe = "Error retrieving content pages from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher suOb5RDM = getServletContext().getRequestDispatcher("/admin/index.jsp");
				suOb5RDM.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
			if (vGw0Nq0Y != null) {
				mZzvRtNX.setAttribute("page", vGw0Nq0Y);
				mZzvRtNX.setAttribute("id", Integer.toString(odev0PXw));
				RequestDispatcher mSg4VaAu = getServletContext().getRequestDispatcher("/admin/add_page.jsp");
				mSg4VaAu.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error retrieving content page from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher Ig7dDDnj = getServletContext().getRequestDispatcher("/admin/index.jsp");
				Ig7dDDnj.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("update_page")) {
			int hcLWdb0x = Integer.parseInt(mZzvRtNX.getParameter("id"));
			String SjApUU3D = mZzvRtNX.getParameter("title");
			String zWLykvQO = mZzvRtNX.getParameter("content");
			int F2vttqvN = 0;
			if (mZzvRtNX.getParameter("parent_id") != null) {
				F2vttqvN = Integer.parseInt(mZzvRtNX.getParameter("parent_id"));
			}
			Page BV96Cy6M = new Page(SjApUU3D, zWLykvQO, F2vttqvN);
			if (BV96Cy6M.updatePage(hcLWdb0x)) {
				cONEOORe = "Content page was updated successfully.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher jKy8yp8E = getServletContext().getRequestDispatcher("/admin/index.jsp");
				jKy8yp8E.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error updating the content page.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				mZzvRtNX.setAttribute("page", BV96Cy6M);
				RequestDispatcher M7yt1wpj = getServletContext().getRequestDispatcher("/admin/add_page.jsp");
				M7yt1wpj.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("delete_page")) {
			int fhNR4qWd = Integer.parseInt(mZzvRtNX.getParameter("id"));
			Page n7cCSOQ2 = new Page();
			if (n7cCSOQ2.deletePage(fhNR4qWd)) {
				cONEOORe = "Content page (and sub pages) deleted successfully.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher qwNUo3xK = getServletContext().getRequestDispatcher("/admin/index.jsp");
				qwNUo3xK.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error deleting the content page(s).";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher LTpZqdWp = getServletContext().getRequestDispatcher("/admin/index.jsp");
				LTpZqdWp.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("list_residencies")) {
			Residency dx0rRYLs = new Residency();
			dbResultSet = dx0rRYLs.getResidencies();
			mZzvRtNX.setAttribute("result", dbResultSet);
			RequestDispatcher LUe4zZ3B = getServletContext().getRequestDispatcher("/admin/list_residencies.jsp");
			LUe4zZ3B.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("delete_residency")) {
			int kwUXJ1V5 = Integer.parseInt(mZzvRtNX.getParameter("id"));
			Residency X6SdFC4w = new Residency();
			if (X6SdFC4w.deleteResidency(kwUXJ1V5)) {
				cONEOORe = "Residency has been successfully deleted.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher j3HFeb1H = getServletContext().getRequestDispatcher("/admin?action=list_residencies");
				j3HFeb1H.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error deleting the residency.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher dk3v2qYy = getServletContext().getRequestDispatcher("/index.jsp");
				dk3v2qYy.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("edit_residency")) {
			int RJxRql95 = Integer.parseInt(mZzvRtNX.getParameter("id"));
			Residency DkPd470I = new Residency();
			dbResultSet = DkPd470I.getResidency(RJxRql95);
			if (dbResultSet != null) {
				try {
					int qPDUZ2KN = dbResultSet.getInt("hospital_id");
					String BVrqW9Sw = DkPd470I.getHospitalName(qPDUZ2KN);
					mZzvRtNX.setAttribute("hName", BVrqW9Sw);
					dbResultSet.beforeFirst();
				} catch (SQLException oPcvLA1P) {
					Of5l8eJ3 = "There was an error retreiving the residency.";
					wUuUJWh1.setAttribute("error", Of5l8eJ3);
					RequestDispatcher fBXhXbjA = getServletContext().getRequestDispatcher("/error.jsp");
					fBXhXbjA.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
				mZzvRtNX.setAttribute("result", dbResultSet);
				RequestDispatcher TJLlLwQj = getServletContext().getRequestDispatcher("/admin/edit_residency.jsp");
				TJLlLwQj.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "There was an error in locating the residency you selected.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher nOOiGyhE = getServletContext().getRequestDispatcher("/index.jsp");
				nOOiGyhE.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("new_residency")) {
			Residency WbEXKOq6 = new Residency();
			dbResultSet = WbEXKOq6.getHospitals();
			mZzvRtNX.setAttribute("result", dbResultSet);
			RequestDispatcher Htgfs6hu = getServletContext().getRequestDispatcher("/admin/add_residency.jsp");
			Htgfs6hu.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("add_residency")) {
			Person TBi2q1Qt = (Person) wUuUJWh1.getAttribute("person");
			if (TBi2q1Qt.isAdmin()) {
				String gKDVTVx6 = mZzvRtNX.getParameter("hName");
				String QJCqK0Xv = mZzvRtNX.getParameter("title");
				String lv0z4nZt = mZzvRtNX.getParameter("description");
				String T4iRAMm0 = mZzvRtNX.getParameter("startDateMonth");
				String m0MUov2W = mZzvRtNX.getParameter("startDateDay");
				String nVDAAPL4 = mZzvRtNX.getParameter("startDateYear");
				String w8wmbLJY = nVDAAPL4 + T4iRAMm0 + m0MUov2W;
				String nBjXKWGi = mZzvRtNX.getParameter("endDateMonth");
				String U8YCzBte = mZzvRtNX.getParameter("endDateDay");
				String fBL2gRCz = mZzvRtNX.getParameter("endDateYear");
				String uxfE6Cfd = fBL2gRCz + nBjXKWGi + U8YCzBte;
				String c83UUqeW = mZzvRtNX.getParameter("deadlineDateMonth");
				String ChbLgOcd = mZzvRtNX.getParameter("deadlineDateDay");
				String TLP4ef2l = mZzvRtNX.getParameter("deadlineDateYear");
				String vdirIZf2 = TLP4ef2l + c83UUqeW + ChbLgOcd;
				int m0nKloAw = Integer.parseInt(mZzvRtNX.getParameter("hId"));
				Residency DLmFxRBr = new Residency(QJCqK0Xv, w8wmbLJY, uxfE6Cfd, vdirIZf2, lv0z4nZt, m0nKloAw);
				if (DLmFxRBr.saveResidency()) {
					cONEOORe = "Residency has been successfully saved.";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					RequestDispatcher NZEiV2Af = getServletContext()
							.getRequestDispatcher("/admin?action=list_residencies");
					NZEiV2Af.forward(mZzvRtNX, Aj4SBiez);
					return;
				} else {
					cONEOORe = "Error saving the residency.";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					RequestDispatcher snxivdDO = getServletContext().getRequestDispatcher("/index.jsp");
					snxivdDO.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
			}
			RequestDispatcher G9ajTqw5 = getServletContext().getRequestDispatcher("/index.jsp");
			G9ajTqw5.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("update_residency")) {
			Person N3j61THw = (Person) wUuUJWh1.getAttribute("person");
			int eoGYUsuM = Integer.parseInt(mZzvRtNX.getParameter("job_id"));
			if (N3j61THw.isAdmin()) {
				String NyOL5UNi = mZzvRtNX.getParameter("hName");
				String oeUQMPOm = mZzvRtNX.getParameter("title");
				String Wu0Ci7L8 = mZzvRtNX.getParameter("description");
				String RwwJKDT0 = mZzvRtNX.getParameter("startDateMonth");
				String PzYAs47V = mZzvRtNX.getParameter("startDateDay");
				String pGzV5xBr = mZzvRtNX.getParameter("startDateYear");
				String eL0jI9Y8 = pGzV5xBr + RwwJKDT0 + PzYAs47V;
				String BFZ4T5d9 = mZzvRtNX.getParameter("endDateMonth");
				String uzQtHY1q = mZzvRtNX.getParameter("endDateDay");
				String OrJGMr8v = mZzvRtNX.getParameter("endDateYear");
				String RKIoYTob = OrJGMr8v + BFZ4T5d9 + uzQtHY1q;
				String v406xf93 = mZzvRtNX.getParameter("deadlineDateMonth");
				String Len9nf20 = mZzvRtNX.getParameter("deadlineDateDay");
				String iaFClbyn = mZzvRtNX.getParameter("deadlineDateYear");
				String tBcSOeHU = iaFClbyn + v406xf93 + Len9nf20;
				int kPPfut0Z = Integer.parseInt(mZzvRtNX.getParameter("hId"));
				Residency DIpXj7q9 = new Residency(eoGYUsuM, oeUQMPOm, eL0jI9Y8, RKIoYTob, tBcSOeHU, Wu0Ci7L8);
				if (DIpXj7q9.updateResidency(eoGYUsuM)) {
					cONEOORe = "Residency has been successfully saved.";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					RequestDispatcher NrFoI4uW = getServletContext()
							.getRequestDispatcher("/admin?action=list_residencies");
					NrFoI4uW.forward(mZzvRtNX, Aj4SBiez);
					return;
				} else {
					cONEOORe = "Error saving the residency.";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					RequestDispatcher NZeSo0o8 = getServletContext().getRequestDispatcher("/index.jsp");
					NZeSo0o8.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
			}
			RequestDispatcher hAgag4Qz = getServletContext().getRequestDispatcher("/index.jsp");
			hAgag4Qz.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("add_hospital")) {
			Person bKYMQ6zU = (Person) wUuUJWh1.getAttribute("person");
			if (bKYMQ6zU.isAdmin()) {
				String AY3Kgo4I = mZzvRtNX.getParameter("name");
				String ROje9KvQ = mZzvRtNX.getParameter("url");
				String C6N54YiR = mZzvRtNX.getParameter("address1");
				String lSrLloFZ = mZzvRtNX.getParameter("address2");
				String WD80ffZq = mZzvRtNX.getParameter("city");
				String zBam1amY = mZzvRtNX.getParameter("state");
				String n333nz0Y = mZzvRtNX.getParameter("zip");
				String AIf5cOKY = mZzvRtNX.getParameter("phone");
				String iOqiqeJm = mZzvRtNX.getParameter("name");
				Hospital Ks1zrtFs = new Hospital(iOqiqeJm, C6N54YiR, lSrLloFZ, WD80ffZq, zBam1amY, n333nz0Y, AY3Kgo4I,
						AIf5cOKY, ROje9KvQ);
				if (!Ks1zrtFs.saveHospitalAdmin()) {
					cONEOORe = "There was an error saving your information.  Please try again.";
					mZzvRtNX.setAttribute("notice", cONEOORe);
					RequestDispatcher u7GQf1yK = getServletContext().getRequestDispatcher("/admin/index.jsp");
					u7GQf1yK.forward(mZzvRtNX, Aj4SBiez);
					return;
				}
				RequestDispatcher TYi9ZBly = getServletContext().getRequestDispatcher("/admin?action=new_residency");
				TYi9ZBly.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Unknown request.  Please try again.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher r5evibGx = getServletContext().getRequestDispatcher("/admin/index.jsp");
				r5evibGx.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("Get Admin News List")) {
			News MedBfyJp = new News();
			if (MedBfyJp.getNewsList() != null) {
				dbResultSet = MedBfyJp.getNewsList();
				mZzvRtNX.setAttribute("result", dbResultSet);
				RequestDispatcher ql5bVYoU = getServletContext().getRequestDispatcher("/admin/list.jsp");
				ql5bVYoU.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Could not get news list.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher s1FsGG8G = getServletContext().getRequestDispatcher("admin/index.jsp");
				s1FsGG8G.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("Get News List")) {
			News d5TLkMAj = new News();
			if (d5TLkMAj.getNewsList() != null) {
				dbResultSet = d5TLkMAj.getNewsList();
				mZzvRtNX.setAttribute("result", dbResultSet);
				RequestDispatcher A7ON3peJ = getServletContext().getRequestDispatcher("/admin/news_list.jsp");
				A7ON3peJ.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Could not get news list.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher kHGyo7n6 = getServletContext().getRequestDispatcher("/gsu_fhce/index.jsp");
				kHGyo7n6.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("detail")) {
			String xtoXTLJ8 = mZzvRtNX.getParameter("id");
			News nJfCfi0p = new News();
			if (nJfCfi0p.getNewsDetail(xtoXTLJ8) != null) {
				dbResultSet = nJfCfi0p.getNewsDetail(xtoXTLJ8);
				mZzvRtNX.setAttribute("result", dbResultSet);
				RequestDispatcher sadgVQEh = getServletContext().getRequestDispatcher("/admin/news_detail.jsp");
				sadgVQEh.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Could not get news detail.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher L1DONX57 = getServletContext().getRequestDispatcher("/admin/index.jsp");
				L1DONX57.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("delete")) {
			int gS7dEYoI = 0;
			gS7dEYoI = Integer.parseInt(mZzvRtNX.getParameter("id"));
			News Jdi7rDBr = new News();
			if (Jdi7rDBr.deleteNews(gS7dEYoI)) {
				cONEOORe = "News successfully deleted.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher xB1a9ESW = getServletContext()
						.getRequestDispatcher("/admin?action=Get Admin News List");
				xB1a9ESW.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error deleting the news.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher xkrmmyaI = getServletContext()
						.getRequestDispatcher("/admin?action=Get Admin News List");
				xkrmmyaI.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("edit")) {
			int OZn87756 = Integer.parseInt(mZzvRtNX.getParameter("id"));
			News WowAcT3X = new News();
			WowAcT3X = WowAcT3X.getNews(OZn87756);
			if (WowAcT3X != null) {
				mZzvRtNX.setAttribute("news", WowAcT3X);
				mZzvRtNX.setAttribute("id", Integer.toString(OZn87756));
				RequestDispatcher K1gKCHTw = getServletContext().getRequestDispatcher("/admin/news_update.jsp");
				K1gKCHTw.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error retrieving news from the database.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher jyiYThyj = getServletContext().getRequestDispatcher("/admin/index.jsp");
				jyiYThyj.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("Update News")) {
			String Vyzss9tL = mZzvRtNX.getParameter("title");
			String zElupUoQ = (mZzvRtNX.getParameter("year")) + (mZzvRtNX.getParameter("month"))
					+ (mZzvRtNX.getParameter("day"));
			String VspFNJW9 = mZzvRtNX.getParameter("content");
			int jhe81utk = Integer.parseInt(mZzvRtNX.getParameter("newsid"));
			News RtbrdeBw = new News(Vyzss9tL, zElupUoQ, VspFNJW9);
			if (RtbrdeBw.updateNews(jhe81utk)) {
				cONEOORe = "News successfully updated.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher AfL3PWvZ = getServletContext()
						.getRequestDispatcher("/admin?action=Get Admin News List");
				AfL3PWvZ.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Could not update news.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher ndgV9PiL = getServletContext()
						.getRequestDispatcher("/admin?action=Get Admin News List");
				ndgV9PiL.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("Add News")) {
			String hzAnOovy = "";
			String Ngfq29oM = mZzvRtNX.getParameter("title");
			String y0oUJT5o = mZzvRtNX.getParameter("year") + "-" + mZzvRtNX.getParameter("month") + "-"
					+ mZzvRtNX.getParameter("day");
			String beMTvp4h = mZzvRtNX.getParameter("content");
			News nhSOAYmw = new News(Ngfq29oM, y0oUJT5o, beMTvp4h);
			if (nhSOAYmw.addNews()) {
				cONEOORe = "News successfully added.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher dxGICY5H = getServletContext()
						.getRequestDispatcher("/admin?action=Get Admin News List");
				dxGICY5H.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Could not add news.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher p9b9tvdP = getServletContext().getRequestDispatcher("admin/index.jsp");
				p9b9tvdP.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("manage_mship")) {
			Mentor z1LjH7MS = new Mentor();
			dbResultSet = z1LjH7MS.getMentorships();
			if (dbResultSet != null) {
				mZzvRtNX.setAttribute("result", dbResultSet);
			} else {
				cONEOORe = "There are no current mentorships.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
			}
			RequestDispatcher gBlMaZKw = getServletContext().getRequestDispatcher("/admin/list_mentorships.jsp");
			gBlMaZKw.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("delete_mship")) {
			int vetFlMtU = Integer.parseInt(mZzvRtNX.getParameter("id"));
			Mentor V6uzOMhj = new Mentor();
			if (V6uzOMhj.delMentorship(vetFlMtU)) {
				cONEOORe = "Mentorship successfully deleted.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher OrmTq5nc = getServletContext().getRequestDispatcher("/admin?action=manage_mship");
				OrmTq5nc.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "Error deleting the mentorship.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher sHSwRxDp = getServletContext().getRequestDispatcher("/admin?action=manage_mship");
				sHSwRxDp.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		} else if (PwF9Uiel.equals("new_mship")) {
			Mentor MCrb7cFI = new Mentor();
			ResultSet tTd88V6E = null;
			ResultSet fqoZEZk7 = null;
			tTd88V6E = MCrb7cFI.getAlumnis();
			fqoZEZk7 = MCrb7cFI.getStudents();
			mZzvRtNX.setAttribute("alumni_result", tTd88V6E);
			mZzvRtNX.setAttribute("student_result", fqoZEZk7);
			RequestDispatcher lLmNtCrU = getServletContext().getRequestDispatcher("/admin/create_mship.jsp");
			lLmNtCrU.forward(mZzvRtNX, Aj4SBiez);
			return;
		} else if (PwF9Uiel.equals("create_mship")) {
			int pH1N89hF = Integer.parseInt(mZzvRtNX.getParameter("student_id"));
			int R4JVhFKk = Integer.parseInt(mZzvRtNX.getParameter("alumni_id"));
			Mentor CeKpzVLx = new Mentor();
			if (CeKpzVLx.addMentorship(pH1N89hF, R4JVhFKk)) {
				cONEOORe = "Mentorship successfully created.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher vWUxHf1c = getServletContext().getRequestDispatcher("/admin?action=manage_mship");
				vWUxHf1c.forward(mZzvRtNX, Aj4SBiez);
				return;
			} else {
				cONEOORe = "There was an error creating the mentorship.";
				mZzvRtNX.setAttribute("notice", cONEOORe);
				RequestDispatcher EhQSIv1X = getServletContext().getRequestDispatcher("/admin/create_mship.jsp");
				EhQSIv1X.forward(mZzvRtNX, Aj4SBiez);
				return;
			}
		}
	}

}