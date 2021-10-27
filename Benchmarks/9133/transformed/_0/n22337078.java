class n22337078 {
	private List getPluginClassList(List so9ZzgZT) {
		ArrayList Pqm5URQc = new ArrayList();
		for (Iterator SrbArkw6 = so9ZzgZT.iterator(); SrbArkw6.hasNext();) {
			URL wTpKgaif = (URL) SrbArkw6.next();
			log.debug("Trying file " + wTpKgaif.toString());
			try {
				BufferedReader TMbtHbut = new BufferedReader(new InputStreamReader(wTpKgaif.openStream(), "utf-8"));
				String duvW638a;
				while ((duvW638a = TMbtHbut.readLine()) != null) {
					duvW638a = duvW638a.trim();
					if (duvW638a.length() == 0 || duvW638a.charAt(0) == '#')
						continue;
					Pqm5URQc.add(duvW638a);
				}
			} catch (Exception Z90cDBni) {
				log.warn("Could not load " + wTpKgaif, Z90cDBni);
			}
		}
		return Pqm5URQc;
	}

}