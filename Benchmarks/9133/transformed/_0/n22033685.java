class n22033685 {
	protected void processRequest(HttpServletRequest hlkPFTuN, HttpServletResponse kSLwjKyi)
			throws ServletException, IOException {
		HttpSession ssGvMXDd = hlkPFTuN.getSession();
		ssGvMXDd.setMaxInactiveInterval(300);
		String yMNWg09b;
		String yyVwU6z4;
		String J4z4mau9;
		String qbUUE9pQ;
		if ((String) ssGvMXDd.getAttribute("member_type") != null) {
			yMNWg09b = (String) ssGvMXDd.getAttribute("member_type");
		} else {
			qbUUE9pQ = "You must login first!";
			hlkPFTuN.setAttribute("notice", qbUUE9pQ);
			RequestDispatcher lMQLIW4k = getServletContext().getRequestDispatcher("/index.jsp");
			lMQLIW4k.forward(hlkPFTuN, kSLwjKyi);
			return;
		}
		if (hlkPFTuN.getParameter("action") != null) {
			J4z4mau9 = (String) hlkPFTuN.getParameter("action");
		} else {
			if (yMNWg09b.equals("student")) {
				if (ssGvMXDd.getAttribute("person") != null) {
					Person X01qfzQ3 = (Person) ssGvMXDd.getAttribute("person");
					Student arbpo29j = X01qfzQ3.getStudent();
					hlkPFTuN.setAttribute("student", arbpo29j);
					RequestDispatcher gLffAVyA = getServletContext().getRequestDispatcher("/member/student.jsp");
					gLffAVyA.forward(hlkPFTuN, kSLwjKyi);
					return;
				} else {
					qbUUE9pQ = "You are not logged in!";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					RequestDispatcher m8Xr5uh3 = getServletContext().getRequestDispatcher("/index.jsp");
					m8Xr5uh3.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
			} else if (yMNWg09b.equals("alumni")) {
				if (ssGvMXDd.getAttribute("person") != null) {
					Person xsqvyAZH = (Person) ssGvMXDd.getAttribute("person");
					Alumni YU5g49Ht = xsqvyAZH.getAlumni();
					hlkPFTuN.setAttribute("alumni", YU5g49Ht);
					RequestDispatcher rl6X0X4D = getServletContext().getRequestDispatcher("/member/alumni.jsp");
					rl6X0X4D.forward(hlkPFTuN, kSLwjKyi);
					return;
				} else {
					qbUUE9pQ = "You are not logged in!";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					RequestDispatcher DS7lZf06 = getServletContext().getRequestDispatcher("/index.jsp");
					DS7lZf06.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
			} else if (yMNWg09b.equals("hospital")) {
				if (ssGvMXDd.getAttribute("person") != null) {
					Person ki7y0UwP = (Person) ssGvMXDd.getAttribute("person");
					Hospital ocYS76e1 = ki7y0UwP.getHospital();
					hlkPFTuN.setAttribute("hospital", ocYS76e1);
					RequestDispatcher ZoLXFx3y = getServletContext().getRequestDispatcher("/member/hospital.jsp");
					ZoLXFx3y.forward(hlkPFTuN, kSLwjKyi);
					return;
				} else {
					qbUUE9pQ = "You are not logged in!";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					RequestDispatcher gAYKfa7I = getServletContext().getRequestDispatcher("/index.jsp");
					gAYKfa7I.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
			} else {
				qbUUE9pQ = "I don't understand your request.  Please try again.";
				hlkPFTuN.setAttribute("notice", qbUUE9pQ);
				RequestDispatcher YIWkA34k = getServletContext().getRequestDispatcher("/index.jsp");
				YIWkA34k.forward(hlkPFTuN, kSLwjKyi);
				return;
			}
		}
		if (J4z4mau9.equals("save_student")) {
			Person nr5H8F07 = (Person) ssGvMXDd.getAttribute("person");
			Student FKJIR0WU = nr5H8F07.getStudent();
			int irxljegy = Integer.parseInt((String) ssGvMXDd.getAttribute("person_id"));
			String oXqONLlx = hlkPFTuN.getParameter("fname");
			String hlNs6zyL = hlkPFTuN.getParameter("lname");
			String xZGg2IZR = hlkPFTuN.getParameter("address1");
			String xPQE1c88 = hlkPFTuN.getParameter("address2");
			String ih2vSPy0 = hlkPFTuN.getParameter("city");
			String NrfMC8pa = hlkPFTuN.getParameter("state");
			String vZ7BwN3R = hlkPFTuN.getParameter("zip");
			String N0pgN8ys = hlkPFTuN.getParameter("email");
			String K5T2uJmt = hlkPFTuN.getParameter("start_year") + "-" + hlkPFTuN.getParameter("start_month") + "-01";
			String PXTnjwyY = "";
			if (!hlkPFTuN.getParameter("grad_year").equals("") && !hlkPFTuN.getParameter("grad_month").equals("")) {
				PXTnjwyY = hlkPFTuN.getParameter("grad_year") + "-" + hlkPFTuN.getParameter("grad_month") + "-01";
			}
			String QATXBZIc = "";
			if (hlkPFTuN.getParameter("password") != null && !hlkPFTuN.getParameter("password").equals("")) {
				QATXBZIc = hlkPFTuN.getParameter("password");
				MessageDigest UoxMXwP9 = null;
				try {
					UoxMXwP9 = MessageDigest.getInstance("MD5");
					UoxMXwP9.update(QATXBZIc.getBytes("UTF-8"));
				} catch (Exception kVeiYNHU) {
					qbUUE9pQ = "Could not encrypt your password.  Please try again.";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					RequestDispatcher l1GGznWi = getServletContext().getRequestDispatcher("/member/student.jsp");
					l1GGznWi.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
				QATXBZIc = (new BASE64Encoder()).encode(UoxMXwP9.digest());
			} else {
				QATXBZIc = FKJIR0WU.getPassword();
			}
			int FqFFnATp = 0;
			if (hlkPFTuN.getParameter("is_admin") != null) {
				FqFFnATp = 1;
			}
			Student rlX4089V = new Student(oXqONLlx, hlNs6zyL, xZGg2IZR, xPQE1c88, ih2vSPy0, NrfMC8pa, vZ7BwN3R,
					N0pgN8ys, QATXBZIc, FqFFnATp, K5T2uJmt, PXTnjwyY);
			if (!rlX4089V.getEmail().equals(FKJIR0WU.getEmail())) {
				if (rlX4089V.checkEmailIsRegistered()) {
					qbUUE9pQ = "That email address is already registered!";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					hlkPFTuN.setAttribute("student", rlX4089V);
					RequestDispatcher dxhJnTBH = getServletContext().getRequestDispatcher("/member/student.jsp");
					dxhJnTBH.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
			}
			if (!rlX4089V.updateStudent(irxljegy)) {
				qbUUE9pQ = "There was an error saving your information.  Please try again.";
				hlkPFTuN.setAttribute("notice", qbUUE9pQ);
				RequestDispatcher nVAAQ20q = getServletContext().getRequestDispatcher("/member/student.jsp");
				nVAAQ20q.forward(hlkPFTuN, kSLwjKyi);
				return;
			}
			Person ejLvB06u = rlX4089V.getPerson(irxljegy);
			ssGvMXDd.setAttribute("person", ejLvB06u);
			qbUUE9pQ = "Information successfully updated.";
			hlkPFTuN.setAttribute("notice", qbUUE9pQ);
			RequestDispatcher mgyOyG9G = getServletContext().getRequestDispatcher("/index.jsp");
			mgyOyG9G.forward(hlkPFTuN, kSLwjKyi);
			return;
		} else if (J4z4mau9.equals("save_alumni")) {
			Person nVIUE6He = (Person) ssGvMXDd.getAttribute("person");
			Alumni Nabyt546 = nVIUE6He.getAlumni();
			int KXLeJvme = Integer.parseInt((String) ssGvMXDd.getAttribute("person_id"));
			String Zek18Ic0 = hlkPFTuN.getParameter("fname");
			String ygJMZX3L = hlkPFTuN.getParameter("lname");
			String CceYkHW0 = hlkPFTuN.getParameter("address1");
			String VnEhuGn0 = hlkPFTuN.getParameter("address2");
			String uAxzq6ed = hlkPFTuN.getParameter("city");
			String OcRIruyq = hlkPFTuN.getParameter("state");
			String O9oJ0ovt = hlkPFTuN.getParameter("zip");
			String PQexXAiT = hlkPFTuN.getParameter("email");
			String keFJ57nH = hlkPFTuN.getParameter("company_name");
			String yMEK2pVI = hlkPFTuN.getParameter("position");
			int hqWrmj9A = 0;
			if (hlkPFTuN.getParameter("mentor") != null) {
				hqWrmj9A = 1;
			}
			String PUJtYEow = hlkPFTuN.getParameter("graduation_year") + "-" + hlkPFTuN.getParameter("graduation_month")
					+ "-01";
			String JiyZ4ouS = "";
			if (hlkPFTuN.getParameter("password") != null) {
				JiyZ4ouS = hlkPFTuN.getParameter("password");
				MessageDigest P4fFb9d7 = null;
				try {
					P4fFb9d7 = MessageDigest.getInstance("MD5");
					P4fFb9d7.update(JiyZ4ouS.getBytes("UTF-8"));
				} catch (Exception aceEU3Q8) {
					qbUUE9pQ = "Could not encrypt your password.  Please try again.";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					RequestDispatcher pHSbaKFz = getServletContext().getRequestDispatcher("/member/alumni.jsp");
					pHSbaKFz.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
				JiyZ4ouS = (new BASE64Encoder()).encode(P4fFb9d7.digest());
			} else {
				JiyZ4ouS = Nabyt546.getPassword();
			}
			int MD83pvne = 0;
			if (hlkPFTuN.getParameter("is_admin") != null) {
				MD83pvne = 1;
			}
			Alumni SPygkZL2 = new Alumni(Zek18Ic0, ygJMZX3L, CceYkHW0, VnEhuGn0, uAxzq6ed, OcRIruyq, O9oJ0ovt, PQexXAiT,
					JiyZ4ouS, MD83pvne, keFJ57nH, yMEK2pVI, PUJtYEow, hqWrmj9A);
			if (!SPygkZL2.getEmail().equals(Nabyt546.getEmail())) {
				if (SPygkZL2.checkEmailIsRegistered()) {
					qbUUE9pQ = "That email address is already registered!";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					hlkPFTuN.setAttribute("alumni", SPygkZL2);
					RequestDispatcher raxxBM79 = getServletContext().getRequestDispatcher("/member/alumni.jsp");
					raxxBM79.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
			}
			if (!SPygkZL2.updateAlumni(KXLeJvme)) {
				ssGvMXDd.setAttribute("alumni", SPygkZL2);
				qbUUE9pQ = "There was an error saving your information.  Please try again.";
				hlkPFTuN.setAttribute("notice", qbUUE9pQ);
				RequestDispatcher RMcBcNYs = getServletContext().getRequestDispatcher("/member/alumni.jsp");
				RMcBcNYs.forward(hlkPFTuN, kSLwjKyi);
				return;
			}
			Person e3ldoIA6 = SPygkZL2.getPerson(KXLeJvme);
			ssGvMXDd.setAttribute("person", e3ldoIA6);
			qbUUE9pQ = "Information successfully updated.";
			hlkPFTuN.setAttribute("notice", qbUUE9pQ);
			RequestDispatcher KcA0QQcl = getServletContext().getRequestDispatcher("/index.jsp");
			KcA0QQcl.forward(hlkPFTuN, kSLwjKyi);
			return;
		} else if (J4z4mau9.equals("save_hospital")) {
			Person UU9kbsD5 = (Person) ssGvMXDd.getAttribute("person");
			Hospital lWPhrEzw = UU9kbsD5.getHospital();
			int qCn8BQGh = Integer.parseInt((String) ssGvMXDd.getAttribute("person_id"));
			String YICPaicv = hlkPFTuN.getParameter("fname");
			String yja9H2M3 = hlkPFTuN.getParameter("lname");
			String KAOgWRaf = hlkPFTuN.getParameter("address1");
			String QPPYbFML = hlkPFTuN.getParameter("address2");
			String lF6VqQBM = hlkPFTuN.getParameter("city");
			String XEKnHbCf = hlkPFTuN.getParameter("state");
			String rICxBmsI = hlkPFTuN.getParameter("zip");
			String Gx5YPwJP = hlkPFTuN.getParameter("email");
			String gvYsSW5m = hlkPFTuN.getParameter("name");
			String Ws13daAg = hlkPFTuN.getParameter("phone");
			String yTM2F5ap = hlkPFTuN.getParameter("url");
			String mjVMmiO6 = "";
			if (hlkPFTuN.getParameter("password") != null && !hlkPFTuN.getParameter("password").equals("")) {
				mjVMmiO6 = hlkPFTuN.getParameter("password");
				MessageDigest zCpQTPyK = null;
				try {
					zCpQTPyK = MessageDigest.getInstance("MD5");
					zCpQTPyK.update(mjVMmiO6.getBytes("UTF-8"));
				} catch (Exception XYIdYvy9) {
					qbUUE9pQ = "Could not encrypt your password.  Please try again.";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					RequestDispatcher GiclREX2 = getServletContext().getRequestDispatcher("/member/hospital.jsp");
					GiclREX2.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
				mjVMmiO6 = (new BASE64Encoder()).encode(zCpQTPyK.digest());
			} else {
				mjVMmiO6 = lWPhrEzw.getPassword();
			}
			int YXawAVkd = 0;
			if (hlkPFTuN.getParameter("is_admin") != null) {
				YXawAVkd = 1;
			}
			Hospital TF3p1NeP = new Hospital(YICPaicv, yja9H2M3, KAOgWRaf, QPPYbFML, lF6VqQBM, XEKnHbCf, rICxBmsI,
					Gx5YPwJP, mjVMmiO6, YXawAVkd, gvYsSW5m, Ws13daAg, yTM2F5ap);
			if (!TF3p1NeP.getEmail().equals(lWPhrEzw.getEmail())) {
				if (TF3p1NeP.checkEmailIsRegistered()) {
					qbUUE9pQ = "That email address is already registered!";
					hlkPFTuN.setAttribute("notice", qbUUE9pQ);
					hlkPFTuN.setAttribute("hospital", TF3p1NeP);
					RequestDispatcher O7Enhe7r = getServletContext().getRequestDispatcher("/member/hospital.jsp");
					O7Enhe7r.forward(hlkPFTuN, kSLwjKyi);
					return;
				}
			}
			if (!TF3p1NeP.updateHospital(qCn8BQGh)) {
				ssGvMXDd.setAttribute("hospital", TF3p1NeP);
				qbUUE9pQ = "There was an error saving your information.  Please try again.";
				hlkPFTuN.setAttribute("notice", qbUUE9pQ);
				RequestDispatcher Oy68mbeI = getServletContext().getRequestDispatcher("/member/hospital.jsp");
				Oy68mbeI.forward(hlkPFTuN, kSLwjKyi);
				return;
			}
			Person HjxZY2of = TF3p1NeP.getPerson(qCn8BQGh);
			ssGvMXDd.setAttribute("person", HjxZY2of);
			qbUUE9pQ = "Information successfully updated.";
			hlkPFTuN.setAttribute("notice", qbUUE9pQ);
			RequestDispatcher pGeKAO7n = getServletContext().getRequestDispatcher("/index.jsp");
			pGeKAO7n.forward(hlkPFTuN, kSLwjKyi);
			return;
		} else {
			qbUUE9pQ = "There was an error with your request.  Please try again.";
			hlkPFTuN.setAttribute("notice", qbUUE9pQ);
			RequestDispatcher N77t7JhE = getServletContext().getRequestDispatcher("/member/hospital.jsp");
			N77t7JhE.forward(hlkPFTuN, kSLwjKyi);
			return;
		}
	}

}