class n9954926 {
	private void simulate() throws Exception {
		BufferedWriter B8Qrc6Zs = null;
		B8Qrc6Zs = new BufferedWriter(new FileWriter(outFile));
		B8Qrc6Zs.write("#Thread\tReputation\tAction\n");
		B8Qrc6Zs.flush();
		System.out.println("Simulate...");
		File C5riEMh4 = new File(trsDemoSimulationfile);
		ObtainUserReputation FZwuNNrb = new ObtainUserReputation();
		ObtainUserReputationResponse AzLS0HB6;
		RateUser bHO2zOaC;
		RateUserResponse v0nqapME;
		FileInputStream i71N71th = new FileInputStream(C5riEMh4);
		BufferedReader jHzIqkF8 = new BufferedReader(new InputStreamReader(i71N71th));
		String W7SuY8vi = jHzIqkF8.readLine();
		while (W7SuY8vi != null) {
			bHO2zOaC = generateRateUserRequest(W7SuY8vi);
			try {
				v0nqapME = trsPort.rateUser(bHO2zOaC);
				System.out.println("----------------R A T I N G-------------------");
				System.out.println("VBE: " + bHO2zOaC.getVbeId());
				System.out.println("VO: " + bHO2zOaC.getVoId());
				System.out.println("USER: " + bHO2zOaC.getUserId());
				System.out.println("SERVICE: " + bHO2zOaC.getServiceId());
				System.out.println("ACTION: " + bHO2zOaC.getActionId());
				System.out.println("OUTCOME: " + v0nqapME.isOutcome());
				System.out.println("----------------------------------------------");
				assertEquals("The outcome field of the rateUser should be true: MESSAGE=" + v0nqapME.getMessage(), true,
						v0nqapME.isOutcome());
			} catch (RemoteException Q8empyZX) {
				fail(Q8empyZX.getMessage());
			}
			FZwuNNrb.setIoi(null);
			FZwuNNrb.setServiceId(null);
			FZwuNNrb.setUserId(bHO2zOaC.getUserId());
			FZwuNNrb.setVbeId(bHO2zOaC.getVbeId());
			FZwuNNrb.setVoId(null);
			try {
				AzLS0HB6 = trsPort.obtainUserReputation(FZwuNNrb);
				System.out.println("-----------R E P U T A T I O N----------------");
				System.out.println("VBE: " + FZwuNNrb.getVbeId());
				System.out.println("VO: " + FZwuNNrb.getVoId());
				System.out.println("USER: " + FZwuNNrb.getUserId());
				System.out.println("SERVICE: " + FZwuNNrb.getServiceId());
				System.out.println("IOI: " + FZwuNNrb.getIoi());
				System.out.println("REPUTATION: " + AzLS0HB6.getReputation());
				System.out.println("----------------------------------------------");
				assertEquals("The outcome field of the obtainUserReputation should be true: MESSAGE="
						+ AzLS0HB6.getMessage(), true, AzLS0HB6.isOutcome());
				assertEquals(0.0, AzLS0HB6.getReputation(), 1.0);
			} catch (RemoteException fyd9DUvJ) {
				fail(fyd9DUvJ.getMessage());
			}
			FZwuNNrb.setIoi(null);
			FZwuNNrb.setServiceId(null);
			FZwuNNrb.setUserId(bHO2zOaC.getUserId());
			FZwuNNrb.setVbeId(bHO2zOaC.getVbeId());
			FZwuNNrb.setVoId(bHO2zOaC.getVoId());
			try {
				AzLS0HB6 = trsPort.obtainUserReputation(FZwuNNrb);
				System.out.println("-----------R E P U T A T I O N----------------");
				System.out.println("VBE: " + FZwuNNrb.getVbeId());
				System.out.println("VO: " + FZwuNNrb.getVoId());
				System.out.println("USER: " + FZwuNNrb.getUserId());
				System.out.println("SERVICE: " + FZwuNNrb.getServiceId());
				System.out.println("IOI: " + FZwuNNrb.getIoi());
				System.out.println("REPUTATION: " + AzLS0HB6.getReputation());
				System.out.println("----------------------------------------------");
				assertEquals("The outcome field of the obtainUserReputation should be true: MESSAGE="
						+ AzLS0HB6.getMessage(), true, AzLS0HB6.isOutcome());
				assertEquals(0.0, AzLS0HB6.getReputation(), 1.0);
			} catch (RemoteException fKlZCFPq) {
				fail(fKlZCFPq.getMessage());
			}
			W7SuY8vi = jHzIqkF8.readLine();
		}
		i71N71th.close();
		jHzIqkF8.close();
		B8Qrc6Zs.flush();
		B8Qrc6Zs.close();
	}

}