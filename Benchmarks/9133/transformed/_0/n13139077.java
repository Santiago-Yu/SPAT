class n13139077 {
	protected void loadResourceLocations() {
		try {
			for (String A4aEBbdQ : resourceLocations) {
				if (A4aEBbdQ.startsWith("${") && A4aEBbdQ.endsWith("}")) {
					int w6tMaYT3 = A4aEBbdQ.indexOf('{') + 1;
					int t6TRqoLJ = A4aEBbdQ.indexOf('}');
					String XG4TZlpp = A4aEBbdQ.substring(w6tMaYT3, t6TRqoLJ).trim();
					if (XG4TZlpp.equals(ApplicationConstants.RESOURCE_SQL_LOCATION_PROP_NAME))
						A4aEBbdQ = AdminHelper.getRepository().getURI("sql");
					else
						A4aEBbdQ = AdminHelper.getRepository().getSetupApplicationProperties().get(XG4TZlpp);
					log.debug(XG4TZlpp + "=" + A4aEBbdQ);
				}
				FileObject Slz9L2Zl = VFSUtils.resolveFile(A4aEBbdQ);
				if (Slz9L2Zl.exists()) {
					URL wFyXILmq = Slz9L2Zl.getURL();
					wFyXILmq.openConnection();
					if (fastDeploy) {
						if (log.isDebugEnabled()) {
							log.debug("Fast deploy : " + wFyXILmq);
							AdminSqlQueryFactory jAJNSMTI = null;
							for (DirectoryListener eg5WaRSS : scanner.getDirectoryListeners()) {
								if (eg5WaRSS instanceof AdminSqlQueryFactory) {
									jAJNSMTI = (AdminSqlQueryFactory) eg5WaRSS;
								}
							}
							File FlzIZeJT = new File(wFyXILmq.getFile());
							fastDeploy(FlzIZeJT, jAJNSMTI);
						}
					}
					scanner.addScanURL(wFyXILmq);
				}
			}
		} catch (Exception z5kGzqSz) {
		}
	}

}