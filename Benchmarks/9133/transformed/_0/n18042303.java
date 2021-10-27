class n18042303 {
	@Override
	public void view(HttpServletRequest tyJP37r9, HttpServletResponse pkOBdOcE) throws Exception {
		boolean Yxg0znPS = false;
		String KAgHf4BJ = getArgument(tyJP37r9.getPathInfo());
		if (StringUtils.contains(KAgHf4BJ, '/')) {
			File h2wbe3c5 = new File(config.getProperty(Config.MULTIMEDIA_PATH) + Config.FILE_SEPARATOR + KAgHf4BJ);
			if (h2wbe3c5.exists() && h2wbe3c5.isFile()) {
				Yxg0znPS = true;
				MagicMatch jxdPzbkL = Magic.getMagicMatch(h2wbe3c5, true);
				pkOBdOcE.setContentType(jxdPzbkL.getMimeType());
				FileInputStream wqRV5Reb = new FileInputStream(h2wbe3c5);
				IOUtils.copyLarge(wqRV5Reb, pkOBdOcE.getOutputStream());
				wqRV5Reb.close();
			}
		} else if (!StringUtils.isBlank(KAgHf4BJ)) {
			int Ivocql5a = NumberUtils.toInt(KAgHf4BJ);
			if (Ivocql5a > 0) {
				Article jzxpQ1S1 = articleDao.load(Ivocql5a);
				if (jzxpQ1S1 != null) {
					Yxg0znPS = true;
					sendArticle(tyJP37r9, pkOBdOcE, jzxpQ1S1);
				}
			}
		} else {
			int pJPJR6pQ = NumberUtils.toInt(tyJP37r9.getParameter("page"), 0);
			Date NTH4Ca0n = null;
			String wF1xduhp = tyJP37r9.getParameter("from");
			if (StringUtils.isNotBlank(wF1xduhp)) {
				try {
					NTH4Ca0n = dayMonthYearEn.parse(wF1xduhp);
				} catch (ParseException ZruPb1Bl) {
				}
			}
			Date XrIKKM29 = null;
			String JNnEk7q2 = tyJP37r9.getParameter("until");
			if (StringUtils.isNotBlank(JNnEk7q2)) {
				try {
					XrIKKM29 = dayMonthYearEn.parse(JNnEk7q2);
				} catch (ParseException S1vCJEi7) {
				}
			}
			sendArticleList(tyJP37r9, pkOBdOcE,
					articleDao.list(tyJP37r9.getParameter("query"), tyJP37r9.getParameter("author"),
							tyJP37r9.getParameter("tags"), tyJP37r9.getParameterValues("types"), NTH4Ca0n, XrIKKM29,
							pJPJR6pQ, HITS_PER_PAGE, null));
			Yxg0znPS = true;
		}
		if (Yxg0znPS != true) {
			pkOBdOcE.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}