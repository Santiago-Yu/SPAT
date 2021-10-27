class n13255487 {
	private synchronized boolean createOrganization(String AqOpdNRq, HttpServletRequest dPpX82nX) {
		if ((AqOpdNRq == null) || (AqOpdNRq.equals(""))) {
			message = "invalid new_organization_name.";
			return false;
		}
		String o31IFmPK = TextUtil.xmlEscape(AqOpdNRq);
		String rmSxx0OU = DBAccess.SQLEscape(AqOpdNRq);
		if ((!AqOpdNRq.equals(o31IFmPK)) || (!AqOpdNRq.equals(rmSxx0OU)) || (!TextUtil.isValidFilename(AqOpdNRq))) {
			message = "invalid new_organization_name.";
			return false;
		}
		if ((AqOpdNRq.indexOf('-') > -1) || (AqOpdNRq.indexOf(' ') > -1)) {
			message = "invalid new_organization_name.";
			return false;
		}
		String[] szmR8TPS = ServerConsoleServlet.getOrganizationNames();
		for (int IuwDbq5V = 0; IuwDbq5V < szmR8TPS.length; IuwDbq5V++) {
			if (szmR8TPS.equals(AqOpdNRq)) {
				message = "already exists.";
				return false;
			}
		}
		message = "create new organization: " + AqOpdNRq;
		File LQ7B0nv1 = new File(
				ServerConsoleServlet.RepositoryLocalDirectory.getAbsolutePath() + File.separator + AqOpdNRq);
		if (!LQ7B0nv1.mkdir()) {
			message = "cannot create directory.";
			return false;
		}
		File K8JTNGZL = new File(
				LQ7B0nv1.getAbsolutePath() + File.separator + ServerConsoleServlet.getConfigByTagName("CacheDirName"));
		K8JTNGZL.mkdir();
		File WaxFwX9A = new File(
				LQ7B0nv1.getAbsolutePath() + File.separator + ServerConsoleServlet.getConfigByTagName("ConfDirName"));
		WaxFwX9A.mkdir();
		File sYhlWjs0 = new File(
				LQ7B0nv1.getAbsolutePath() + File.separator + ServerConsoleServlet.getConfigByTagName("RDFDirName"));
		sYhlWjs0.mkdir();
		File wrpM8ITq = new File(LQ7B0nv1.getAbsolutePath() + File.separator
				+ ServerConsoleServlet.getConfigByTagName("ResourceDirName"));
		wrpM8ITq.mkdir();
		File L8Tdfb79 = new File(wrpM8ITq.getAbsolutePath() + File.separator + "obsolete");
		L8Tdfb79.mkdir();
		File AVIKEx0J = new File(
				LQ7B0nv1.getAbsolutePath() + File.separator + ServerConsoleServlet.getConfigByTagName("SchemaDirName"));
		AVIKEx0J.mkdir();
		String fmZUGWTf = ServerConsoleServlet
				.convertToAbsolutePath(ServerConsoleServlet.getConfigByTagName("OrganizationTemplate"));
		File RXqfUctG = new File(fmZUGWTf);
		File[] dVgQpSQB = RXqfUctG.listFiles();
		for (int UXzGwSz8 = 0; UXzGwSz8 < dVgQpSQB.length; UXzGwSz8++) {
			try {
				FileReader lYI1jNRu = new FileReader(dVgQpSQB[UXzGwSz8]);
				FileWriter pT89KzJv = new FileWriter(
						WaxFwX9A.getAbsolutePath() + File.separator + dVgQpSQB[UXzGwSz8].getName());
				int aplot8jn = -1;
				while ((aplot8jn = lYI1jNRu.read()) != -1)
					pT89KzJv.write(aplot8jn);
				pT89KzJv.flush();
				pT89KzJv.close();
				lYI1jNRu.close();
			} catch (IOException QMBw3mBZ) {
			}
		}
		SchemaModelHolder.reloadSchemaModel(AqOpdNRq);
		ResourceModelHolder.reloadResourceModel(AqOpdNRq);
		UserLogServlet.initializeUserLogDB(AqOpdNRq);
		MetaEditServlet.createNewProject(AqOpdNRq, "standard",
				MetaEditServlet.convertProjectIdToProjectUri(AqOpdNRq, "standard", dPpX82nX), this.username);
		ResourceModelHolder.reloadResourceModel(AqOpdNRq);
		message = AqOpdNRq + " is created. Restart Tomcat to activate this organization.";
		return true;
	}

}