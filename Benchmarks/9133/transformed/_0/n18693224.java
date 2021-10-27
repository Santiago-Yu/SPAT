class n18693224 {
	public void runDynusT(final boolean UYxn0XCg) {
		final String[] K8JJlNvz = new String[] { "DynusT.exe", "DLL_ramp.dll", "Ramp_Meter_Fixed_CDLL.dll",
				"Ramp_Meter_Feedback_CDLL.dll", "Ramp_Meter_Feedback_FDLL.dll", "libifcoremd.dll", "libmmd.dll",
				"Ramp_Meter_Fixed_FDLL.dll", "libiomp5md.dll" };
		final String[] YZ0sYkM5 = new String[] { "network.dat", "scenario.dat", "control.dat", "ramp.dat",
				"incident.dat", "movement.dat", "vms.dat", "origin.dat", "destination.dat", "StopCap4Way.dat",
				"StopCap2Way.dat", "YieldCap.dat", "WorkZone.dat", "GradeLengthPCE.dat", "leftcap.dat", "system.dat",
				"output_option.dat", "bg_demand_adjust.dat", "xy.dat", "TrafficFlowModel.dat", "parameter.dat" };
		log.info("Creating iteration-directory...");
		File oFoWteY1 = new File(this.tmpDir);
		if (!oFoWteY1.exists()) {
			oFoWteY1.mkdir();
		}
		log.info("Copying application files to iteration-directory...");
		for (String cqdMWltL : K8JJlNvz) {
			log.info("  Copying " + cqdMWltL);
			IOUtils.copyFile(new File(this.dynusTDir + "/" + cqdMWltL), new File(this.tmpDir + "/" + cqdMWltL));
		}
		log.info("Copying model files to iteration-directory...");
		for (String xtSzGkVs : YZ0sYkM5) {
			log.info("  Copying " + xtSzGkVs);
			IOUtils.copyFile(new File(this.modelDir + "/" + xtSzGkVs), new File(this.tmpDir + "/" + xtSzGkVs));
		}
		for (File Anpuy5zW : new File(this.modelDir).listFiles()) {
			if (Anpuy5zW.getName().toLowerCase(Locale.ROOT).endsWith(".dws")) {
				log.info("  Copying " + Anpuy5zW.getName());
				IOUtils.copyFile(Anpuy5zW, new File(this.tmpDir + "/" + Anpuy5zW.getName()));
			}
		}
		String nCPiDI1w = this.tmpDir + "/dynus-t.log";
		String qtwOZWqo = this.tmpDir + "/DynusT.exe";
		log.info("running command: " + qtwOZWqo + " in directory " + this.tmpDir);
		int cGPl1ewZ = 7200;
		int sFi5Xs5u = ExeRunner.run(qtwOZWqo, nCPiDI1w, cGPl1ewZ, this.tmpDir);
		if (sFi5Xs5u != 0) {
			throw new RuntimeException("There was a problem running Dynus-T. exit code: " + sFi5Xs5u);
		}
		if (UYxn0XCg) {
			for (String bKLVxPkM : K8JJlNvz) {
				log.info("  Deleting " + bKLVxPkM);
				new File(this.tmpDir + "/" + bKLVxPkM).delete();
			}
		}
	}

}