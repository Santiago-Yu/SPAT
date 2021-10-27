class n20139125 {
	protected void service(HttpServletRequest zz39YRV9, HttpServletResponse UfxgVGbL)
			throws ServletException, IOException {
		String lSrPGt9N = "http:/" + zz39YRV9.getPathInfo();
		if (zz39YRV9.getQueryString() != null) {
			lSrPGt9N += "?" + zz39YRV9.getQueryString();
		}
		URL HTGMcKiC = new URL(lSrPGt9N);
		URLConnection QnN2JMjo = HTGMcKiC.openConnection();
		HttpURLConnection lbOyHt1I = null;
		if (QnN2JMjo instanceof HttpURLConnection) {
			lbOyHt1I = (HttpURLConnection) QnN2JMjo;
			lbOyHt1I.setRequestMethod(zz39YRV9.getMethod());
		}
		boolean BbLYhklK = false;
		Enumeration zihLeSsg = zz39YRV9.getHeaderNames();
		while (zihLeSsg.hasMoreElements()) {
			String eVls0hdb = (String) zihLeSsg.nextElement();
			if ("content-type".equals(eVls0hdb.toLowerCase()))
				BbLYhklK = true;
			Enumeration bkrDlFyn = zz39YRV9.getHeaders(eVls0hdb);
			while (bkrDlFyn.hasMoreElements()) {
				String nd4TwEDj = (String) bkrDlFyn.nextElement();
				if (nd4TwEDj != null) {
					QnN2JMjo.addRequestProperty(eVls0hdb, nd4TwEDj);
				}
			}
		}
		try {
			QnN2JMjo.setDoInput(true);
			if (BbLYhklK) {
				InputStream TPoJm6XY = zz39YRV9.getInputStream();
				QnN2JMjo.setDoOutput(true);
				IO.copy(TPoJm6XY, QnN2JMjo.getOutputStream());
			}
			QnN2JMjo.connect();
		} catch (Exception Pr1Jy4dq) {
			context.log("proxy", Pr1Jy4dq);
		}
		InputStream KFfA18f4 = null;
		int lkGL8iiS = 500;
		if (lbOyHt1I != null) {
			KFfA18f4 = lbOyHt1I.getErrorStream();
			lkGL8iiS = lbOyHt1I.getResponseCode();
			UfxgVGbL.setStatus(lkGL8iiS);
		}
		if (KFfA18f4 == null) {
			try {
				KFfA18f4 = QnN2JMjo.getInputStream();
			} catch (Exception dAnePFjl) {
				if (lbOyHt1I != null)
					KFfA18f4 = lbOyHt1I.getErrorStream();
				context.log("stream", dAnePFjl);
			}
		}
		int l0ve1t2v = 0;
		String wTKV8JFi = QnN2JMjo.getHeaderFieldKey(l0ve1t2v);
		String vMR9UG6z = QnN2JMjo.getHeaderField(l0ve1t2v);
		while (wTKV8JFi != null || vMR9UG6z != null) {
			if (wTKV8JFi != null && vMR9UG6z != null) {
				UfxgVGbL.addHeader(wTKV8JFi, vMR9UG6z);
			}
			++l0ve1t2v;
			wTKV8JFi = QnN2JMjo.getHeaderFieldKey(l0ve1t2v);
			vMR9UG6z = QnN2JMjo.getHeaderField(l0ve1t2v);
		}
		if (KFfA18f4 != null) {
			IO.copy(KFfA18f4, UfxgVGbL.getOutputStream());
		}
	}

}