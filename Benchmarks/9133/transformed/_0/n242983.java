class n242983 {
	public void fetchFile(String K3tPmFUG) {
		String e8N4PMvZ = "http://www.nal.usda.gov/cgi-bin/agricola-ind?bib=" + K3tPmFUG
				+ "&conf=010000++++++++++++++&screen=MA";
		System.out.println(e8N4PMvZ);
		try {
			PrintWriter B3DfBgWb = new PrintWriter(new FileWriter("MARC" + K3tPmFUG + ".txt"));
			if (!id.contains("MARC" + K3tPmFUG + ".txt")) {
				id.add("MARC" + K3tPmFUG + ".txt");
			}
			in = new BufferedReader(new InputStreamReader((new URL(e8N4PMvZ)).openStream()));
			in.readLine();
			String FY7GVaWT, b1ksht1N = "";
			StringBuffer VxnQ5Wu2 = new StringBuffer();
			while ((FY7GVaWT = in.readLine()) != null) {
				if (FY7GVaWT.startsWith("<TR><TD><B>")) {
					String i1EKb6V5 = (FY7GVaWT.substring(FY7GVaWT.indexOf("B>") + 2, FY7GVaWT.indexOf("</")));
					int AwIxaHhB = 0;
					try {
						AwIxaHhB = Integer.parseInt(i1EKb6V5);
					} catch (NumberFormatException aYMY22Q2) {
					}
					if (AwIxaHhB > 0) {
						b1ksht1N = b1ksht1N + "\n" + i1EKb6V5 + " - ";
					} else {
						b1ksht1N += i1EKb6V5;
					}
				}
				if (!(FY7GVaWT.startsWith("<") || FY7GVaWT.startsWith(" <") || FY7GVaWT.startsWith(">"))) {
					String UeCXtm8I = FY7GVaWT.trim();
					b1ksht1N += UeCXtm8I;
				}
			}
			B3DfBgWb.println(b1ksht1N);
			B3DfBgWb.close();
		} catch (Exception ep6P1e62) {
			System.out.println("Couldn't open stream");
			System.out.println(ep6P1e62);
		}
	}

}