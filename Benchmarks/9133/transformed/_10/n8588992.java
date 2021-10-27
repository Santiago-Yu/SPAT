class n8588992 {
	public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String status = null;
		NewConceptBean conceptBean = null;
		ReportingBean reportingBean = null;
		String conceptName = null;
		MessageResources errorMessages = MessageResources
				.getMessageResources("com.apelon.apps.dts.treebrowser.resources.error_messages");
		String primitive = null;
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
					for (int i = 0; i < roleCons.length; i++) {
						roleCons[i].setSomeOrAll(roleMods[i]);
						roleCons[i].setRoleGroup(roleGrps[i]);
					}
				}
			}
			session.setAttribute("newConceptEntity", conceptBean);
			NewConceptXMLDisplayBean xmlBean = new NewConceptXMLDisplayBean();
			xmlBean.setNewConceptXml(conceptBean);
			XMLPropertyHandler configPh = new XMLPropertyHandler("dtsbrowserclassify.xml");
			String data = BrowserUtilities.encodeUrl("conceptXml") + "="
					+ BrowserUtilities.encodeUrl(xmlBean.getNewConceptXml()) + "&"
					+ BrowserUtilities.encodeUrl("nameSpace") + "=" + BrowserUtilities.encodeUrl(namespace);
			Properties configProps = configPh.getProps();
			String urlString = configProps.getProperty("url");
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			String line;
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer buf = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				buf.append(line);
			}
			String resultXml = buf.toString();
			wr.close();
			rd.close();
			ClassifyResultParser parser = new ClassifyResultParser(resultXml);
			ClassifiedConceptBean ccBean = new ClassifiedConceptBean();
			ResultBuilder rbuilder = new ResultBuilder();
			rbuilder.setConceptBean(ccBean);
			rbuilder.setParser(parser);
			rbuilder.setNamespace(namespace);
			try {
				rbuilder.buildResult();
				ClassifiedConceptDisplayBean displayBean = new ClassifiedConceptDisplayBean();
				ccBean = rbuilder.getConceptBean();
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