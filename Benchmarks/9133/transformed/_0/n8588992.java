class n8588992 {
	public ActionForward perform(ActionMapping gHuAo4zL, ActionForm Eo7swfDn, HttpServletRequest OWcS9iSB,
			HttpServletResponse PbaEVzgV) throws IOException, ServletException {
		String x28gcKjx = null;
		HttpSession kRUemj2Z = OWcS9iSB.getSession();
		ReportingBean aIEv4G5D = null;
		NewConceptBean OaJ0L4Ap = null;
		String uqviJjCD = null;
		String GHVaBlta = null;
		MessageResources M8HmK26T = MessageResources
				.getMessageResources("com.apelon.apps.dts.treebrowser.resources.error_messages");
		LogonUtilities hlSwkty6 = new LogonUtilities();
		if (hlSwkty6.checkSession(kRUemj2Z, x28gcKjx, aIEv4G5D, M8HmK26T)) {
			aIEv4G5D = (ReportingBean) kRUemj2Z.getAttribute("reportingBean");
			if ((aIEv4G5D.getMessageHtml().indexOf("Classify")) == -1) {
				aIEv4G5D.setReportingHtml("");
			}
			OaJ0L4Ap = (NewConceptBean) kRUemj2Z.getAttribute("newConceptEntity");
			uqviJjCD = OWcS9iSB.getParameter("conceptName");
			GHVaBlta = OWcS9iSB.getParameter("primitive");
			if (GHVaBlta == null) {
				GHVaBlta = "false";
			}
			OaJ0L4Ap.setConceptName(uqviJjCD);
			OaJ0L4Ap.setPrimitive(GHVaBlta);
			String APr7QzjZ = OaJ0L4Ap.getConceptNamespace();
			if (APr7QzjZ == null) {
				aIEv4G5D.setReportingHtml(M8HmK26T.getMessage("classify_3"));
				kRUemj2Z.setAttribute("reportingBean", aIEv4G5D);
				x28gcKjx = "classify_fail";
				return (gHuAo4zL.findForward(x28gcKjx));
			}
			String[] eovCBcv5 = OWcS9iSB.getParameterValues("some_or_all");
			String[] Vztqt2Qu = OWcS9iSB.getParameterValues("role_group");
			Vector Qvk26Veh = OaJ0L4Ap.getRoles();
			RoleBean[] GcFkQehL = new RoleBean[Qvk26Veh.size()];
			Qvk26Veh.copyInto(GcFkQehL);
			if (eovCBcv5 != null && Vztqt2Qu != null && GcFkQehL != null) {
				if (GcFkQehL.length == eovCBcv5.length && GcFkQehL.length == Vztqt2Qu.length) {
					for (int eXSBgCJe = 0; eXSBgCJe < GcFkQehL.length; eXSBgCJe++) {
						GcFkQehL[eXSBgCJe].setSomeOrAll(eovCBcv5[eXSBgCJe]);
						GcFkQehL[eXSBgCJe].setRoleGroup(Vztqt2Qu[eXSBgCJe]);
					}
				}
			}
			kRUemj2Z.setAttribute("newConceptEntity", OaJ0L4Ap);
			NewConceptXMLDisplayBean HDAUwuVG = new NewConceptXMLDisplayBean();
			HDAUwuVG.setNewConceptXml(OaJ0L4Ap);
			String BlmpMA3m = BrowserUtilities.encodeUrl("conceptXml") + "="
					+ BrowserUtilities.encodeUrl(HDAUwuVG.getNewConceptXml()) + "&"
					+ BrowserUtilities.encodeUrl("nameSpace") + "=" + BrowserUtilities.encodeUrl(APr7QzjZ);
			XMLPropertyHandler DqGgOtlY = new XMLPropertyHandler("dtsbrowserclassify.xml");
			Properties HT9im7C4 = DqGgOtlY.getProps();
			String wcrcc0U3 = HT9im7C4.getProperty("url");
			URL IpVZchqh = new URL(wcrcc0U3);
			URLConnection YE5jQ3IM = IpVZchqh.openConnection();
			YE5jQ3IM.setDoOutput(true);
			OutputStreamWriter TggyNg6p = new OutputStreamWriter(YE5jQ3IM.getOutputStream());
			TggyNg6p.write(BlmpMA3m);
			TggyNg6p.flush();
			BufferedReader dnmRG790 = new BufferedReader(new InputStreamReader(YE5jQ3IM.getInputStream()));
			String s356D9Oz;
			StringBuffer N9xOncE7 = new StringBuffer();
			while ((s356D9Oz = dnmRG790.readLine()) != null) {
				N9xOncE7.append(s356D9Oz);
			}
			String VG5fPZwj = N9xOncE7.toString();
			TggyNg6p.close();
			dnmRG790.close();
			ClassifiedConceptBean xg1UXg3h = new ClassifiedConceptBean();
			ClassifyResultParser WKwpaQu6 = new ClassifyResultParser(VG5fPZwj);
			ResultBuilder wi4XGWKY = new ResultBuilder();
			wi4XGWKY.setConceptBean(xg1UXg3h);
			wi4XGWKY.setParser(WKwpaQu6);
			wi4XGWKY.setNamespace(APr7QzjZ);
			try {
				wi4XGWKY.buildResult();
				xg1UXg3h = wi4XGWKY.getConceptBean();
				ClassifiedConceptDisplayBean LhdGwxOv = new ClassifiedConceptDisplayBean();
				LhdGwxOv.setNewConceptHtml(xg1UXg3h);
				kRUemj2Z.setAttribute("classifyResult", xg1UXg3h);
				kRUemj2Z.setAttribute("classifyDisplayResult", LhdGwxOv);
				x28gcKjx = "success";
			} catch (Exception JzLzcPj3) {
				Categories.dataServer().error(StackTracePrinter.getStackTrace(JzLzcPj3));
				aIEv4G5D.setReportingHtml(M8HmK26T.getMessage("classify_1") + JzLzcPj3.getMessage());
				kRUemj2Z.setAttribute("reportingBean", aIEv4G5D);
				x28gcKjx = "classify_fail";
			}
		}
		return (gHuAo4zL.findForward(x28gcKjx));
	}

}