class n10058360 {
	void startzm() {
		URL DkD37XyR;
		InputStream jt1GMAeb;
		byte k8k0fc9E[];
		boolean OtW0Nrw4;
		k8k0fc9E = null;
		try {
			System.err.println(zcodefile);
			DkD37XyR = new URL(zcodefile);
			jt1GMAeb = DkD37XyR.openStream();
			k8k0fc9E = suckstream(jt1GMAeb);
		} catch (MalformedURLException uWEtEmZh) {
			try {
				jt1GMAeb = new FileInputStream(zcodefile);
				k8k0fc9E = suckstream(jt1GMAeb);
			} catch (IOException SdpjJIW6) {
				add("North", new Label("Malformed URL"));
				failed = true;
			}
		} catch (IOException M42DeXg2) {
			add("North", new Label("I/O Error"));
		}
		if (k8k0fc9E != null) {
			switch (k8k0fc9E[0]) {
			case 3:
				zm = new ZMachine3(screen, status_line, k8k0fc9E);
				break;
			case 5:
				remove(status_line);
				zm = new ZMachine5(screen, k8k0fc9E);
				break;
			case 8:
				remove(status_line);
				zm = new ZMachine8(screen, k8k0fc9E);
				break;
			default:
				add("North", new Label("Not a valid V3,V5, or V8 story file"));
			}
			if (zm != null)
				zm.start();
		}
		OtW0Nrw4 = false;
		if (k8k0fc9E != null) {
			while (!OtW0Nrw4) {
				try {
					zm.join();
					OtW0Nrw4 = true;
				} catch (InterruptedException ws9xkmzx) {
				}
			}
		}
		System.exit(0);
	}

}