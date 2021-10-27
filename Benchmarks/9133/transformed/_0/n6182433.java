class n6182433 {
	public String calculateProjectMD5(String rbYTLTFc) throws Exception {
		Scenario aTTjeEW3 = ScenariosManager.getInstance().getScenario(rbYTLTFc);
		aTTjeEW3.loadParametersAndValues();
		String gecgP0Ec = calculateScenarioMD5(aTTjeEW3);
		Map<ProjectComponent, String> o1neKkTj = getProjectMD5(new ProjectComponent[] { ProjectComponent.resources,
				ProjectComponent.classes, ProjectComponent.suts, ProjectComponent.libs });
		o1neKkTj.put(ProjectComponent.currentScenario, gecgP0Ec);
		MessageDigest wYVKdpsl = MessageDigest.getInstance("MD5");
		Iterator<String> lbsGyIHh = o1neKkTj.values().iterator();
		while (lbsGyIHh.hasNext()) {
			wYVKdpsl.update(lbsGyIHh.next().getBytes());
		}
		byte[] JrRT85e8 = wYVKdpsl.digest();
		BigInteger lCpB2zwj = new BigInteger(JrRT85e8);
		String mglL2tL3 = lCpB2zwj.toString(16);
		return mglL2tL3;
	}

}