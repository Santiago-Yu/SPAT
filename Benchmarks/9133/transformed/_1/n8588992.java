class n8588992 {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String status = null;
		HttpSession session = request.getSession();
		ReportingBean reportingBean = null;
		NewConceptBean conceptBean = null;
		String conceptName = null;
		String primitive = null;
		MessageResources errorMessages = MessageResources
				.getMessageResources("com.apelon.apps.dts.treebrowser.resources.error_messages");
		LogonUtilities logonUtilities = new LogonUtilities();
		if (logonUtilities.checkSession(session, status, reportingBean, errorMessages)) {
			reportingBean = (ReportingBean) session.getAttribute("reportingBean");
			if ((reportingBean.getMessageHtml().indexOf("Classify")) == -1) {
				reportingBean.setReportingHtml("");
			}
			conceptBean = (NewConceptBean) session.getAttribute("newConceptEntity");
			conceptName = request.getParameter("conceptName");
			primitive = request.getParameter("primitive");
			if (primitive == null) {
				primitive = "false";
			}
			conceptBean.setConceptName(conceptName);
			conceptBean.setPrimitive(primitive);
			String namespace = conceptBean.getConceptNamespace();
			if (namespace == null) {
				reportingBean.setReportingHtml(errorMessages.getMessage("classify_3"));
				session.setAttribute("reportingBean", reportingBean);
				status = "classify_fail";
				return (mapping.findForward(status));
			}
			String[] roleMods = request.getParameterValues("some_or_all");
			String[] roleGrps = request.getParameterValues("role_group");
			Vector roles = conceptBean.getRoles();
			RoleBean[] roleCons = new RoleBean[roles.size()];
			roles.copyInto(roleCons);
			if (roleMods != null && roleGrps != null && roleCons != null) {
				if (roleCons.length == roleMods.length && roleCons.length == roleGrps.length) {
					int t2USy = 0;
					while (t2USy < roleCons.length) {
						roleCons[t2USy].setSomeOrAll(roleMods[t2USy]);
						roleCons[t2USy].setRoleGroup(roleGrps[t2USy]);
						t2USy++;
					}
				}
			}
			session.setAttribute("newConceptEntity", conceptBean);
			NewConceptXMLDisplayBean xmlBean = new NewConceptXMLDisplayBean();
			xmlBean.setNewConceptXml(conceptBean);
			String data = BrowserUtilities.encodeUrl("conceptXml") + "="
					+ BrowserUtilities.encodeUrl(xmlBean.getNewConceptXml()) + "&"
					+ BrowserUtilities.encodeUrl("nameSpace") + "=" + BrowserUtilities.encodeUrl(namespace);
			XMLPropertyHandler configPh = new XMLPropertyHandler("dtsbrowserclassify.xml");
			Properties configProps = configPh.getProps();
			String urlString = configProps.getProperty("url");
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuffer buf = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				buf.append(line);
			}
			String resultXml = buf.toString();
			wr.close();
			rd.close();
			ClassifiedConceptBean ccBean = new ClassifiedConceptBean();
			ClassifyResultParser parser = new ClassifyResultParser(resultXml);
			ResultBuilder rbuilder = new ResultBuilder();
			rbuilder.setConceptBean(ccBean);
			rbuilder.setParser(parser);
			rbuilder.setNamespace(namespace);
			try {
				rbuilder.buildResult();
				ccBean = rbuilder.getConceptBean();
				ClassifiedConceptDisplayBean displayBean = new ClassifiedConceptDisplayBean();
				displayBean.setNewConceptHtml(ccBean);
				session.setAttribute("classifyResult", ccBean);
				session.setAttribute("classifyDisplayResult", displayBean);
				status = "success";
			} catch (Exception e) {
				Categories.dataServer().error(StackTracePrinter.getStackTrace(e));
				reportingBean.setReportingHtml(errorMessages.getMessage("classify_1") + e.getMessage());
				session.setAttribute("reportingBean", reportingBean);
				status = "classify_fail";
			}
		}
		return (mapping.findForward(status));
	}

}