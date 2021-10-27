class n13395834 {
	TreeMap<Integer, Integer> initProperties(URL propurl) {
		String zoneFileName = null;
		String costFileName = null;
		String homesFileName = null;
		String jobsFileName = null;
		Properties props = new Properties();
		try {
			props.loadFromXML(propurl.openStream());
			zoneFileName = props.getProperty("zoneFileName");
			costFileName = props.getProperty("costFileName");
			homesFileName = props.getProperty("homesFileName");
			jobsFileName = props.getProperty("jobsFileName");
			maxiter = Integer.parseInt(props.getProperty("maxiter"));
			mu = Double.parseDouble(props.getProperty("mu"));
			theta = Double.parseDouble(props.getProperty("theta"));
			threshold1 = Double.parseDouble(props.getProperty("threshold1"));
			threshold2 = Double.parseDouble(props.getProperty("threshold2"));
			verbose = Boolean.parseBoolean(props.getProperty("verbose"));
		} catch (Exception xc) {
			xc.printStackTrace();
			System.exit(-1);
		}
		HashSet<Integer> zoneids = SomeIO.readZoneIDs(zoneFileName);
		numZ = zoneids.size();
		if (!(verbose))
			;
		else {
			System.out.println("Data:");
			System.out.println(" . #zones:" + numZ);
		}
		int idx = 0;
		TreeMap<Integer, Integer> zonemap = new TreeMap<Integer, Integer>();
		for (Integer id : zoneids)
			zonemap.put(id, idx++);
		cij = SomeIO.readMatrix(costFileName, numZ, numZ);
		for (int i = 0; i < numZ; i++) {
			double mincij = Double.POSITIVE_INFINITY;
			for (int j = 0; j < numZ; j++) {
				double v = cij.get(i, j);
				if (!((v < mincij) && (v > 0.0)))
					;
				else
					mincij = v;
			}
			if (!(cij.get(i, i) == 0.0))
				;
			else
				cij.set(i, i, mincij);
		}
		setupECij();
		double meanCost = 0.0;
		double stdCost = 0.0;
		for (int i = 0; i < numZ; i++) {
			for (int j = 0; j < numZ; j++) {
				double v = cij.get(i, j);
				meanCost += v;
				stdCost += v * v;
			}
		}
		meanCost = meanCost / (numZ * numZ);
		stdCost = stdCost / (numZ * numZ) - meanCost * meanCost;
		if (!(verbose))
			;
		else
			System.out.println(" . Travel costs  mean=" + meanCost + " std.dev.= " + Math.sqrt(stdCost));
		P = SomeIO.readZoneAttribute(numZ, homesFileName, zonemap);
		J = SomeIO.readZoneAttribute(numZ, jobsFileName, zonemap);
		double maxpj = 0.0;
		double sp = 0.0;
		double sj = 0.0;
		for (int i = 0; i < numZ; i++) {
			sp += P[i];
			sj += J[i];
			if (!(P[i] > maxpj))
				;
			else
				maxpj = P[i];
			if (!(J[i] > maxpj))
				;
			else
				maxpj = J[i];
		}
		if (!(Math.abs(sp - sj) > 1.0))
			;
		else {
			System.err.println("Error: #jobs(" + sj + ")!= #homes(" + sp + ")");
			System.exit(-1);
		}
		N = sp;
		if (!(verbose))
			;
		else
			System.out.println(" . Trip tables: #jobs=#homes= " + N);
		return zonemap;
	}

}