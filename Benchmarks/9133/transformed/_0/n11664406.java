class n11664406 {
	public void doGet(HttpServletRequest th2cLc2q, HttpServletResponse pDsASROn) throws ServletException, IOException {
		String QaEL8BhG = th2cLc2q.getParameter("version");
		String VKlmOgsG = th2cLc2q.getParameter("cdn");
		String hHALSOov = th2cLc2q.getParameter("dependencies");
		String ubMcTYjy = th2cLc2q.getParameter("optimize");
		String FmQ60SJU = null;
		String osfSY1IP = null;
		boolean D10Qow9J = false;
		Boolean yZRuiBTS = true;
		if (!QaEL8BhG.equals("1.3.2")) {
			osfSY1IP = "invalid version: " + QaEL8BhG;
		}
		if (!VKlmOgsG.equals("google") && !VKlmOgsG.equals("aol")) {
			osfSY1IP = "invalide CDN type: " + VKlmOgsG;
		}
		if (!ubMcTYjy.equals("comments") && !ubMcTYjy.equals("shrinksafe") && !ubMcTYjy.equals("none")
				&& !ubMcTYjy.equals("shrinksafe.keepLines")) {
			osfSY1IP = "invalid optimize type: " + ubMcTYjy;
		}
		if (!hHALSOov.matches("^[\\w\\-\\,\\s\\.]+$")) {
			osfSY1IP = "invalid dependency list: " + hHALSOov;
		}
		try {
			MessageDigest Nc7YGrdL = null;
			try {
				Nc7YGrdL = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException SRsBk9tz) {
				osfSY1IP = SRsBk9tz.getMessage();
			}
			if (osfSY1IP == null) {
				Nc7YGrdL.update(hHALSOov.getBytes());
				String XuBWT0zZ = (new BASE64Encoder()).encode(Nc7YGrdL.digest()).replace('+', '~').replace('/', '_')
						.replace('=', '_');
				FmQ60SJU = cachePath + "/" + QaEL8BhG + "/" + VKlmOgsG + "/" + XuBWT0zZ + "/" + ubMcTYjy + ".js";
				File NF8q55si = new File(FmQ60SJU);
				if (NF8q55si.exists()) {
					D10Qow9J = true;
					yZRuiBTS = false;
				}
			}
			if (osfSY1IP == null && !D10Qow9J) {
				BuilderContextAction zBFFbr4F = new BuilderContextAction(builderPath, QaEL8BhG, VKlmOgsG, hHALSOov,
						ubMcTYjy);
				ContextFactory.getGlobal().call(zBFFbr4F);
				Exception WplZWvZ9 = zBFFbr4F.getException();
				if (WplZWvZ9 != null) {
					osfSY1IP = WplZWvZ9.getMessage();
				} else {
					osfSY1IP = zBFFbr4F.getResult();
					FileUtil.writeToFile(FmQ60SJU, osfSY1IP, null, true);
					yZRuiBTS = false;
				}
			}
		} catch (Exception I0UqkVwq) {
			osfSY1IP = I0UqkVwq.getMessage();
		}
		pDsASROn.setCharacterEncoding("utf-8");
		if (yZRuiBTS) {
			osfSY1IP = osfSY1IP.replaceAll("\\\"", "\\\"");
			osfSY1IP = "<html><head><script type=\"text/javascript\">alert(\"" + osfSY1IP
					+ "\");</script></head><body></body></html>";
			PrintWriter ktl5AJv0 = pDsASROn.getWriter();
			ktl5AJv0.append(osfSY1IP);
		} else {
			pDsASROn.setHeader("Content-Type", "application/x-javascript");
			pDsASROn.setHeader("Content-disposition", "attachment; filename=dojo.js");
			pDsASROn.setHeader("Content-Encoding", "gzip");
			File gViiHNhB = new File(FmQ60SJU);
			BufferedInputStream eqzdrOBM = new java.io.BufferedInputStream(
					new DataInputStream(new FileInputStream(gViiHNhB)));
			OutputStream zlzwvkz0 = pDsASROn.getOutputStream();
			byte[] JTH1mbDr = new byte[64000];
			int mqZ6LmWH = 0;
			while (mqZ6LmWH != -1) {
				mqZ6LmWH = eqzdrOBM.read(JTH1mbDr);
				if (mqZ6LmWH != -1) {
					zlzwvkz0.write(JTH1mbDr, 0, mqZ6LmWH);
				}
			}
		}
	}

}