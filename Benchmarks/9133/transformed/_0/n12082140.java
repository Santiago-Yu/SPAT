class n12082140 {
	public static Set<Street> getVias(String T4sBdqEp) {
		Set<Street> ez8n6yg8 = new HashSet<Street>();
		String SbILB0cL = "<cuerr>";
		String EL7ZNe1T = "</cuerr>";
		String ztcsiPMN = "<des>";
		String BwybCFOQ = "</des>";
		String mrNfME59 = "<calle>";
		String qwiufyFA = "</calle>";
		String I0voV8lC = "<cv>";
		String LN6P4IBc = "</cv>";
		String F6DoGljS = "<tv>";
		String mWfZPp3z = "</tv>";
		String X3OaGMWl = "<nv>";
		String rIC4Bs5g = "</nv>";
		boolean QQHFaAMi = false;
		int T8TceOVU, X2WZr7u4;
		try {
			URL EHaFuKhq = new URL(T4sBdqEp);
			BufferedReader ctJXJD9o = new BufferedReader(new InputStreamReader(EHaFuKhq.openStream()));
			String C9mDu3tK;
			Street UUlUF6FZ;
			while ((C9mDu3tK = ctJXJD9o.readLine()) != null) {
				if (C9mDu3tK.contains(SbILB0cL)) {
					T8TceOVU = C9mDu3tK.indexOf(SbILB0cL) + SbILB0cL.length();
					X2WZr7u4 = C9mDu3tK.indexOf(EL7ZNe1T);
					if (Integer.parseInt(C9mDu3tK.substring(T8TceOVU, X2WZr7u4)) > 0)
						QQHFaAMi = true;
				}
				if (QQHFaAMi) {
					if (C9mDu3tK.contains(ztcsiPMN)) {
						T8TceOVU = C9mDu3tK.indexOf(ztcsiPMN) + ztcsiPMN.length();
						X2WZr7u4 = C9mDu3tK.indexOf(BwybCFOQ);
						throw (new Exception(C9mDu3tK.substring(T8TceOVU, X2WZr7u4)));
					}
				} else {
					if (C9mDu3tK.contains(mrNfME59)) {
						UUlUF6FZ = new Street();
						while ((C9mDu3tK = ctJXJD9o.readLine()) != null && !C9mDu3tK.contains(qwiufyFA)) {
							if (C9mDu3tK.contains(I0voV8lC)) {
								T8TceOVU = C9mDu3tK.indexOf(I0voV8lC) + I0voV8lC.length();
								X2WZr7u4 = C9mDu3tK.indexOf(LN6P4IBc);
								UUlUF6FZ.setCodeStreet(Integer.parseInt(C9mDu3tK.substring(T8TceOVU, X2WZr7u4)));
							}
							if (C9mDu3tK.contains(F6DoGljS)) {
								TypeStreet rji05Jcs = new TypeStreet();
								if (!C9mDu3tK.contains(mWfZPp3z))
									rji05Jcs.setCodetpStreet("");
								else {
									T8TceOVU = C9mDu3tK.indexOf(F6DoGljS) + F6DoGljS.length();
									X2WZr7u4 = C9mDu3tK.indexOf(mWfZPp3z);
									rji05Jcs.setCodetpStreet(C9mDu3tK.substring(T8TceOVU, X2WZr7u4));
								}
								rji05Jcs.setDescription(getDescripcionTipoVia(rji05Jcs.getCodetpStreet()));
								UUlUF6FZ.setTypeStreet(rji05Jcs);
							}
							if (C9mDu3tK.contains(X3OaGMWl)) {
								T8TceOVU = C9mDu3tK.indexOf(X3OaGMWl) + X3OaGMWl.length();
								X2WZr7u4 = C9mDu3tK.indexOf(rIC4Bs5g);
								UUlUF6FZ.setStreetName(C9mDu3tK.substring(T8TceOVU, X2WZr7u4).trim());
							}
						}
						ez8n6yg8.add(UUlUF6FZ);
					}
				}
			}
			ctJXJD9o.close();
		} catch (Exception d6RxakRq) {
			System.err.println(d6RxakRq);
		}
		return ez8n6yg8;
	}

}