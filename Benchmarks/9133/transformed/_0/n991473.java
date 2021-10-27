class n991473 {
	private void doUpdate(final boolean Ha4zILit) {
		if (!validServerUrl) {
			return;
		}
		boolean aBqCTiGS = true;
		List Crzea2dO = new ArrayList();
		try {
			BufferedReader IVjm6fcU = new BufferedReader(new InputStreamReader(url.openStream()));
			String OiHvJ4AY = null;
			while ((OiHvJ4AY = IVjm6fcU.readLine()) != null) {
				Matcher vMTWejRK = ROW_PARSER_PATTERN.matcher(OiHvJ4AY);
				if (vMTWejRK.matches() && checkAllProjects) {
					String yNtVyuOe = vMTWejRK.group(GROUP_PROJECT);
					String qLWSiZwh = vMTWejRK.group(GROUP_STATUS);
					if (qLWSiZwh.equals(MessageUtils.getString("ccOutput.status.failed"))) {
						aBqCTiGS = false;
						Crzea2dO.add(yNtVyuOe);
					}
				}
			}
		} catch (IOException Pb4kBxsd) {
			serverReachable = false;
			if (Ha4zILit) {
				monitor.notifyServerUnreachable(
						MessageUtils.getString("error.readError", new String[] { url.toString() }));
			}
			return;
		}
		if (Ha4zILit && buildClean && !aBqCTiGS) {
			monitor.notifyBuildFailure(MessageUtils.getString("message.buildFailed", new Object[] { Crzea2dO.get(0) }));
		}
		if (Ha4zILit && !buildClean && aBqCTiGS) {
			monitor.notifyBuildFixed(MessageUtils.getString("message.allBuildsClean"));
		}
		buildClean = aBqCTiGS;
		monitor.setStatus(buildClean);
		serverReachable = true;
	}

}