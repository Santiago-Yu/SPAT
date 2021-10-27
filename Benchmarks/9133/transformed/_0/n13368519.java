class n13368519 {
	public void sendTemplate(String Z6A7lIsz, TemplateValues Z6IQiiZ3) throws IOException {
		Checker.checkEmpty(Z6A7lIsz, "filename");
		Checker.checkNull(Z6IQiiZ3, "values");
		URL eibvTrkN = _getFile(Z6A7lIsz);
		boolean aLjYgwbC = Context.getRootContext().getRunMode() == RUN_MODE.DEV ? true : false;
		Template Ni4oSrzn = new Template(eibvTrkN.openStream(), aLjYgwbC);
		try {
			Ni4oSrzn.write(getWriter(), Z6IQiiZ3);
		} catch (ErrorListException dr3wwfeg) {
			Context.getRootContext().getLogger().error(dr3wwfeg);
		}
	}

}