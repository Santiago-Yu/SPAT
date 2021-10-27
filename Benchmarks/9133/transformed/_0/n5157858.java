class n5157858 {
	private void simulate() throws Exception {
		BufferedWriter nN7oMbQQ = null;
		nN7oMbQQ = new BufferedWriter(new FileWriter(outFile));
		nN7oMbQQ.write("#Thread\tReputation\tAction\n");
		nN7oMbQQ.flush();
		System.out.println("Simulate...");
		File YIEvYqsZ = new File(trsDemoSimulationfile);
		ObtainUserReputation VIqBwUbO = new ObtainUserReputation();
		ObtainUserReputationResponse HBvpsyRV;
		RateUser qCBSnSs9;
		RateUserResponse VRPp6by3;
		FileInputStream n9mVTwYn = new FileInputStream(YIEvYqsZ);
		BufferedReader ZwG6MphO = new BufferedReader(new InputStreamReader(n9mVTwYn));
		String Uxf1AIaZ = ZwG6MphO.readLine();
		while (Uxf1AIaZ != null) {
			qCBSnSs9 = generateRateUserRequest(Uxf1AIaZ);
			try {
				VRPp6by3 = trsPort.rateUser(qCBSnSs9);
				System.out.println("----------------R A T I N G-------------------");
				System.out.println("VBE: " + qCBSnSs9.getVbeId());
				System.out.println("VO: " + qCBSnSs9.getVoId());
				System.out.println("USER: " + qCBSnSs9.getUserId());
				System.out.println("SERVICE: " + qCBSnSs9.getServiceId());
				System.out.println("ACTION: " + qCBSnSs9.getActionId());
				System.out.println("OUTCOME: " + VRPp6by3.isOutcome());
				System.out.println("----------------------------------------------");
				assertEquals("The outcome field of the rateUser should be true: MESSAGE=" + VRPp6by3.getMessage(), true,
						VRPp6by3.isOutcome());
			} catch (RemoteException M3XEeDGq) {
				fail(M3XEeDGq.getMessage());
			}
			VIqBwUbO.setIoi(null);
			VIqBwUbO.setServiceId(null);
			VIqBwUbO.setUserId(qCBSnSs9.getUserId());
			VIqBwUbO.setVbeId(qCBSnSs9.getVbeId());
			VIqBwUbO.setVoId(null);
			try {
				HBvpsyRV = trsPort.obtainUserReputation(VIqBwUbO);
				System.out.println("-----------R E P U T A T I O N----------------");
				System.out.println("VBE: " + VIqBwUbO.getVbeId());
				System.out.println("VO: " + VIqBwUbO.getVoId());
				System.out.println("USER: " + VIqBwUbO.getUserId());
				System.out.println("SERVICE: " + VIqBwUbO.getServiceId());
				System.out.println("IOI: " + VIqBwUbO.getIoi());
				System.out.println("REPUTATION: " + HBvpsyRV.getReputation());
				System.out.println("----------------------------------------------");
				assertEquals("The outcome field of the obtainUserReputation should be true: MESSAGE="
						+ HBvpsyRV.getMessage(), true, HBvpsyRV.isOutcome());
				assertEquals(0.0, HBvpsyRV.getReputation(), 1.0);
			} catch (RemoteException vWVzrIK4) {
				fail(vWVzrIK4.getMessage());
			}
			VIqBwUbO.setIoi(null);
			VIqBwUbO.setServiceId(null);
			VIqBwUbO.setUserId(qCBSnSs9.getUserId());
			VIqBwUbO.setVbeId(qCBSnSs9.getVbeId());
			VIqBwUbO.setVoId(qCBSnSs9.getVoId());
			try {
				HBvpsyRV = trsPort.obtainUserReputation(VIqBwUbO);
				System.out.println("-----------R E P U T A T I O N----------------");
				System.out.println("VBE: " + VIqBwUbO.getVbeId());
				System.out.println("VO: " + VIqBwUbO.getVoId());
				System.out.println("USER: " + VIqBwUbO.getUserId());
				System.out.println("SERVICE: " + VIqBwUbO.getServiceId());
				System.out.println("IOI: " + VIqBwUbO.getIoi());
				System.out.println("REPUTATION: " + HBvpsyRV.getReputation());
				System.out.println("----------------------------------------------");
				assertEquals("The outcome field of the obtainUserReputation should be true: MESSAGE="
						+ HBvpsyRV.getMessage(), true, HBvpsyRV.isOutcome());
				assertEquals(0.0, HBvpsyRV.getReputation(), 1.0);
			} catch (RemoteException BOGMNVc1) {
				fail(BOGMNVc1.getMessage());
			}
			Uxf1AIaZ = ZwG6MphO.readLine();
		}
		n9mVTwYn.close();
		ZwG6MphO.close();
		nN7oMbQQ.flush();
		nN7oMbQQ.close();
	}

}