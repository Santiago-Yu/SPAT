class n15971794 {
	private boolean getWave(String LnCYwP3m, String bF2Za23S) {
		try {
			File VmxQpnOL = new File(f.getParent() + "/" + f.getName() + "pron");
			VmxQpnOL.mkdir();
			URL s3lEK6Tl = new URL(LnCYwP3m);
			BufferedReader LsyJyrvc = new BufferedReader(new InputStreamReader(s3lEK6Tl.openStream()));
			File Wg9kcQUp = new File(f.getParent() + "/" + f.getName() + "pron/" + bF2Za23S + ".wav");
			if (!Wg9kcQUp.exists()) {
				FileOutputStream ku1G2u4E = new FileOutputStream(
						f.getParent() + "/" + f.getName() + "pron/" + bF2Za23S + ".wav");
				BufferedWriter fqxZbchX = new BufferedWriter(new OutputStreamWriter(ku1G2u4E));
				char[] EZjAlAXl = new char[1024];
				int yOFukuIH = LsyJyrvc.read(EZjAlAXl, 0, 1024);
				while (yOFukuIH > 0) {
					fqxZbchX.write(EZjAlAXl, 0, yOFukuIH);
					yOFukuIH = LsyJyrvc.read(EZjAlAXl, 0, 1024);
				}
				fqxZbchX.close();
				ku1G2u4E.close();
			}
			LsyJyrvc.close();
		} catch (Exception eU2T2Pvp) {
			System.out.println(eU2T2Pvp.getMessage());
			return false;
		}
		return true;
	}

}