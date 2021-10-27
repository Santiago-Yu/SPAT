class n7005222 {
	private void downloadResults() {
		GregorianCalendar VwjhLVUO = new GregorianCalendar();
		VwjhLVUO.setTimeInMillis(System.currentTimeMillis());
		String mjVQtwU5 = String.format("%s%sresult_%tF.xml", vysledky, File.separator, VwjhLVUO);
		String bECxe5as = "" + (char) 0x0D + (char) 0x0A;
		try {
			LogManager.getInstance().log("Stahuji soubor result.xml a ukl?d?m do vysledky ...");
			File tOaG0p7g = new File(mjVQtwU5);
			FileWriter jzLpHjMl = new FileWriter(tOaG0p7g);
			URL KHDlHMGK = new URL(Konfigurace.getInstance().getURLvysledkuValidatoru());
			BufferedReader rcjzomkq = new BufferedReader(new InputStreamReader(KHDlHMGK.openStream()));
			String mQzZ4mRb = "";
			while ((mQzZ4mRb = rcjzomkq.readLine()) != null) {
				jzLpHjMl.write(mQzZ4mRb + bECxe5as);
			}
			jzLpHjMl.write("</vysledky>" + bECxe5as);
			rcjzomkq.close();
			jzLpHjMl.close();
			LogManager.getInstance().changeLog("Stahuji soubor result.xml a ukl?d?m do slo?ky vysledky ... OK");
		} catch (IOException MVWrS6M5) {
			MVWrS6M5.printStackTrace();
			LogManager.getInstance().changeLog("Stahuji soubor result.xml a ukl?d?m do slo?ky vysledky ... X");
		}
	}

}