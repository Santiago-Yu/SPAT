class n2305051 {
	public CandleSeries fetchSeries(final String VxAXeYu9) throws Exception {
		Calendar VNUkBeam = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		VNUkBeam.setTime(begin);
		String P0XF3kId = String.valueOf(VNUkBeam.get(Calendar.YEAR));
		String eNoNVowr = String.valueOf(VNUkBeam.get(Calendar.MONTH));
		String meuYt8gq = String.valueOf(VNUkBeam.get(Calendar.DAY_OF_MONTH));
		if (end == null) {
			GregorianCalendar E7YJhGTf = new GregorianCalendar();
			E7YJhGTf.add(Calendar.DATE, -1);
			end = E7YJhGTf.getTime();
		}
		VNUkBeam.setTime(end);
		String DjG8iOA8 = String.valueOf(VNUkBeam.get(Calendar.DAY_OF_MONTH));
		String B61x0Mpu = String.valueOf(VNUkBeam.get(Calendar.MONTH));
		String klJrRIMf = String.valueOf(VNUkBeam.get(Calendar.YEAR));
		String TGWgI6vs = "d";
		String cjETHP6u = MessageFormat.format(YAHOO_URL, VxAXeYu9, eNoNVowr, meuYt8gq, P0XF3kId, B61x0Mpu, DjG8iOA8,
				klJrRIMf, TGWgI6vs);
		BufferedReader CKKgwEwv;
		String W0379296;
		List<String> u83SU89Q = new ArrayList<String>();
		log.info("URL [" + cjETHP6u + "]");
		URL ZE1wKCYf = new URL(cjETHP6u);
		CKKgwEwv = new BufferedReader(new InputStreamReader(ZE1wKCYf.openStream()));
		W0379296 = CKKgwEwv.readLine();
		log.debug(W0379296);
		while ((W0379296 = CKKgwEwv.readLine()) != null) {
			u83SU89Q.add(0, W0379296);
		}
		List<Candle> wkSCcOxg = new ArrayList<Candle>();
		for (String kQDHpeiL : u83SU89Q) {
			log.debug(kQDHpeiL);
			StringTokenizer SgdklipE = new StringTokenizer(kQDHpeiL, ",");
			String AQuLOCBG = SgdklipE.nextToken();
			double t2m0He7b = round(Double.parseDouble(SgdklipE.nextToken()), 2);
			double xuXPplnO = Double.parseDouble(SgdklipE.nextToken());
			double d335HhnU = Double.parseDouble(SgdklipE.nextToken());
			double jPcGcSOz = Double.parseDouble(SgdklipE.nextToken());
			long Zm2W4Yjh = 0;
			double ggH1Dirz = 0;
			if (SgdklipE.hasMoreTokens()) {
				Zm2W4Yjh = Long.parseLong(SgdklipE.nextToken());
				if (splitAdjust) {
					ggH1Dirz = Double.parseDouble(SgdklipE.nextToken());
				}
			}
			Date bzCow0uf = sdf.parse(AQuLOCBG);
			Candle CtcMm7DF = null;
			if (splitAdjust) {
				double NPQkVeA4 = ggH1Dirz / jPcGcSOz;
				CtcMm7DF = new Candle(VxAXeYu9, bzCow0uf, round(t2m0He7b * NPQkVeA4, 2), round(xuXPplnO * NPQkVeA4, 2),
						round(d335HhnU * NPQkVeA4, 2), ggH1Dirz, Zm2W4Yjh);
			} else {
				CtcMm7DF = new Candle(VxAXeYu9, bzCow0uf, t2m0He7b, xuXPplnO, d335HhnU, jPcGcSOz, Zm2W4Yjh);
			}
			wkSCcOxg.add(CtcMm7DF);
		}
		return new CandleSeries(wkSCcOxg);
	}

}