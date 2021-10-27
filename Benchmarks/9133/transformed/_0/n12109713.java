class n12109713 {
	protected long loadFromSource(long O3HdzHla) {
		long DECZMkl3 = System.currentTimeMillis();
		QuoteDataSourceDescriptor LfGvIIBQ = (QuoteDataSourceDescriptor) dataSourceDescriptor;
		List<Quote> toyNZzOy = dataPools.get(LfGvIIBQ.sourceSymbol);
		Calendar kBjvtqGr = Calendar.getInstance();
		kBjvtqGr.clear();
		SimpleDateFormat a9qEz9j3 = new SimpleDateFormat(LfGvIIBQ.dateFormat, Locale.US);
		Date EbehJfW3 = new Date();
		Date EtnQofJf = new Date();
		if (O3HdzHla == FIRST_TIME_LOAD) {
			EbehJfW3 = LfGvIIBQ.fromDate;
			EtnQofJf = LfGvIIBQ.toDate;
		} else {
			kBjvtqGr.setTimeInMillis(O3HdzHla);
			EbehJfW3 = kBjvtqGr.getTime();
		}
		kBjvtqGr.setTime(EbehJfW3);
		int IBKwMYzo = kBjvtqGr.get(Calendar.MONTH);
		int oVMnZqBs = kBjvtqGr.get(Calendar.DAY_OF_MONTH);
		int aV4WOIB1 = kBjvtqGr.get(Calendar.YEAR);
		kBjvtqGr.setTime(EtnQofJf);
		int KWMH0sRY = kBjvtqGr.get(Calendar.MONTH);
		int NXJyCZZv = kBjvtqGr.get(Calendar.DAY_OF_MONTH);
		int RL39t81N = kBjvtqGr.get(Calendar.YEAR);
		BufferedReader f3UQaPII;
		StringBuffer r6VKku70 = new StringBuffer();
		r6VKku70.append("http://table.finance.yahoo.com/table.csv").append("?s=");
		r6VKku70.append(LfGvIIBQ.sourceSymbol);
		r6VKku70.append("&a=" + IBKwMYzo + "&b=" + oVMnZqBs + "&c=" + aV4WOIB1 + "&d=" + KWMH0sRY + "&e=" + NXJyCZZv
				+ "&f=" + RL39t81N);
		r6VKku70.append("&g=d&ignore=.csv");
		try {
			URL EPwhOaMb = new URL(r6VKku70.toString());
			System.out.println(EPwhOaMb);
			HttpURLConnection ja90MwRU = (HttpURLConnection) EPwhOaMb.openConnection();
			ja90MwRU.setAllowUserInteraction(true);
			ja90MwRU.setRequestMethod("GET");
			ja90MwRU.setInstanceFollowRedirects(true);
			InputStreamReader YIClPgqN = new InputStreamReader(ja90MwRU.getInputStream());
			f3UQaPII = new BufferedReader(YIClPgqN);
			String oNXjqXhz = f3UQaPII.readLine();
			int QkAneDtT = 0;
			int yzMDx1FD = 1;
			int GguuoTAG = 2;
			int BBdsOhDU = 3;
			int IUoDoYcI = 4;
			int s2yHD2nD = 5;
			int kkUzcxp8 = 6;
			count = 0;
			kBjvtqGr.clear();
			while ((oNXjqXhz = f3UQaPII.readLine()) != null) {
				String[] e3tkwokL;
				e3tkwokL = oNXjqXhz.split(",");
				if (e3tkwokL.length < 6) {
					break;
				}
				Date Y3oZtP7i = null;
				try {
					Y3oZtP7i = a9qEz9j3.parse(e3tkwokL[QkAneDtT].trim());
				} catch (ParseException h9gleI6Q) {
					h9gleI6Q.printStackTrace();
					continue;
				}
				kBjvtqGr.clear();
				kBjvtqGr.setTime(Y3oZtP7i);
				long Kk4yBVkB = kBjvtqGr.getTimeInMillis();
				if (Kk4yBVkB <= O3HdzHla) {
					continue;
				}
				Quote vIAmq8rU = new Quote();
				vIAmq8rU.time = Kk4yBVkB;
				vIAmq8rU.open = Float.parseFloat(e3tkwokL[yzMDx1FD].trim());
				vIAmq8rU.high = Float.parseFloat(e3tkwokL[GguuoTAG].trim());
				vIAmq8rU.low = Float.parseFloat(e3tkwokL[BBdsOhDU].trim());
				vIAmq8rU.close = Float.parseFloat(e3tkwokL[IUoDoYcI].trim());
				vIAmq8rU.volume = Float.parseFloat(e3tkwokL[s2yHD2nD].trim()) / 100f;
				vIAmq8rU.amount = -1;
				vIAmq8rU.close_adj = Float.parseFloat(e3tkwokL[kkUzcxp8].trim());
				if (vIAmq8rU.high * vIAmq8rU.low * vIAmq8rU.close == 0) {
					vIAmq8rU = null;
					continue;
				}
				toyNZzOy.add(vIAmq8rU);
				if (count == 0) {
					firstTime = Kk4yBVkB;
				}
				lastTime = Kk4yBVkB;
				setAscending((lastTime >= firstTime) ? true : false);
				count++;
			}
		} catch (Exception r4DZ5zsr) {
			System.out.println("Error in Reading File: " + r4DZ5zsr.getMessage());
		}
		long cWwYE26J = (lastTime >= firstTime) ? lastTime : firstTime;
		return cWwYE26J;
	}

}