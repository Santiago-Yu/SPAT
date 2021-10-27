class n8688357 {
	public void runDynusT() {
		final String[] DD48AH1Y = new String[] { "DynusT.exe", "DLL_ramp.dll", "Ramp_Meter_Fixed_CDLL.dll",
				"Ramp_Meter_Feedback_CDLL.dll", "Ramp_Meter_Feedback_FDLL.dll", "libifcoremd.dll", "libmmd.dll",
				"Ramp_Meter_Fixed_FDLL.dll", "libiomp5md.dll" };
		final String[] Iumh0mW1 = new String[] { "network.dat", "scenario.dat", "control.dat", "ramp.dat",
				"incident.dat", "movement.dat", "vms.dat", "origin.dat", "destination.dat", "StopCap4Way.dat",
				"StopCap2Way.dat", "YieldCap.dat", "WorkZone.dat", "GradeLengthPCE.dat", "leftcap.dat", "system.dat",
				"output_option.dat", "bg_demand_adjust.dat", "xy.dat", "TrafficFlowModel.dat", "parameter.dat" };
		log.info("Creating iteration-directory...");
		File qlazbkyY = new File(this.tmpDir);
		if (!qlazbkyY.exists()) {
			qlazbkyY.mkdir();
		}
		log.info("Copying application files to iteration-directory...");
		for (String LNjShs0l : DD48AH1Y) {
			log.info("  Copying " + LNjShs0l);
			IOUtils.copyFile(new File(this.dynusTDir + "/" + LNjShs0l), new File(this.tmpDir + "/" + LNjShs0l));
		}
		log.info("Copying model files to iteration-directory...");
		for (String QZQZ8ala : Iumh0mW1) {
			log.info("  Copying " + QZQZ8ala);
			IOUtils.copyFile(new File(this.modelDir + "/" + QZQZ8ala), new File(this.tmpDir + "/" + QZQZ8ala));
		}
		String GFwZmD5K = this.tmpDir + "/dynus-t.log";
		String q41QKPaQ = this.tmpDir + "/DynusT.exe";
		log.info("running command: " + q41QKPaQ);
		int Whs7sjMv = 14400;
		int hFkY9a7W = ExeRunner.run(q41QKPaQ, GFwZmD5K, Whs7sjMv);
		if (hFkY9a7W != 0) {
			throw new RuntimeException("There was a problem running Dynus-T. exit code: " + hFkY9a7W);
		}
	}

}