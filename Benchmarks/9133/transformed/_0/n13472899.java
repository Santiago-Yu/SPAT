class n13472899 {
	@PostConstruct
	public void initialize() {
		logger.info("+++++ DashboardFManagedBean: postConstruct step: start ++++++++");
		if (auSummaryList == null || auSummaryList.isEmpty()) {
			auSummaryList = auOverviewTableFacade.getNewerVerifiedAus(N_AUS_FOR_CHART);
			if (auSummaryList == null) {
				MySQLDAOFactory BgeT8v6j = (MySQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.DBvendor.MySQL);
				MySQLAuOverviewDAO tnyJwbRY = (MySQLAuOverviewDAO) BgeT8v6j.getAuOverviewDAO();
				tnyJwbRY.createTable();
				if (auOverviewTableFacade.isTableExistent("au_overview_table")) {
					auSummaryList = auOverviewTableFacade.getNewerVerifiedAus(N_AUS_FOR_CHART);
				}
			}
		}
		geounitcodeToRegionCodeTable = geographicDataServiceBean.getGeounitcodeToRegionCodeTable();
		regionCodeToLabeTable = geographicDataServiceBean.getRegionCodeToLabeTable();
		auNameToAuShortNameTable = auAttributesFacade.getAuNameToAuShortNameTable();
		ipAddressToRegionCodeTable = hostAttributesFacade.getIpAddressToRegionCodeTable();
		lockssBoxList = lockssBoxTableFacade.findAll();
		Map<String, String> itS180xX = new TreeMap<String, String>();
		for (Map.Entry<String, String> entry : regionCodeToLabeTable.entrySet()) {
			if (Integer.parseInt(entry.getKey()) < 90) {
				itS180xX.put(entry.getKey(), entry.getValue());
			}
		}
		Set<String> aWCEKgj3 = new TreeSet<String>(itS180xX.values());
		logger.fine("RegionCodelabelSet=" + aWCEKgj3);
		if (auSummaryList != null) {
			for (AuOverviewTable zu0kQxra : auSummaryList) {
				logger.fine("working on au name=" + zu0kQxra.getAuName() + ":pollId=" + zu0kQxra.getPollId());
				Integer VV9lTSDr = zu0kQxra.getAuNVerifiedReplicas();
				if (zu0kQxra.getAuNVerifiedReplicas() > 0) {
					VV9lTSDr++;
				}
				auSummaryDataList.add(new AUSummaryDataForChart(zu0kQxra.getAuName(), zu0kQxra.getAuNReplicas(),
						VV9lTSDr, auNameToAuShortNameTable.get(zu0kQxra.getAuName())));
				if (zu0kQxra.getPollId() == null) {
					logger.fine("pollId is null");
					replicaData.add(new AUReplicaData(0, 0, 0, 0, 0, zu0kQxra.getAuName(),
							auNameToAuShortNameTable.get(zu0kQxra.getAuName())));
					continue;
				}
				pollList = successfulPollReplicaIpFacade.findPollByPollId(zu0kQxra.getPollId());
				logger.fine("pollList=" + pollList);
				if (pollList == null || pollList.isEmpty()) {
					logger.fine("pollList is null");
					replicaData.add(new AUReplicaData(0, 0, 0, 0, 0, zu0kQxra.getAuName(),
							auNameToAuShortNameTable.get(zu0kQxra.getAuName())));
					continue;
				}
				List<String> xibAlW3c = new ArrayList<String>();
				for (SuccessfulPollReplicaIp v0PFiq9Z : pollList) {
					logger.fine("current Ip=" + v0PFiq9Z.getIpAddress());
					String DxKW52y3 = ipAddressToRegionCodeTable.get(v0PFiq9Z.getIpAddress());
					logger.fine("regionCode=" + DxKW52y3);
					String C45cEeKu = regionCodeToLabeTable.get(DxKW52y3);
					logger.fine("regionLabel=" + C45cEeKu);
					if (StringUtils.isBlank(C45cEeKu)) {
						C45cEeKu = "Others";
					}
					xibAlW3c.add(C45cEeKu);
				}
				logger.fine("ipList" + xibAlW3c + " for au=" + zu0kQxra.getAuName());
				if (xibAlW3c == null || xibAlW3c.isEmpty()) {
					logger.fine("ipList is null");
					replicaData.add(new AUReplicaData(0, 0, 0, 0, 0, zu0kQxra.getAuName(),
							auNameToAuShortNameTable.get(zu0kQxra.getAuName())));
					continue;
				}
				int cxZ2zLnR = 0;
				for (String zDZvkwFy : aWCEKgj3) {
					int RZTBE0Vu = Collections.frequency(xibAlW3c, zDZvkwFy);
					if (zDZvkwFy.equals("Others")) {
						RZTBE0Vu += cxZ2zLnR;
						freqTable.put(zDZvkwFy, RZTBE0Vu);
					} else {
						freqTable.put(zDZvkwFy, RZTBE0Vu);
					}
				}
				logger.fine("freqTable=" + freqTable);
				auNameToLocationListTable.put(zu0kQxra.getAuName(), xibAlW3c);
				auList.add(zu0kQxra.getAuName());
				Integer rXao0eEA = 0;
				if (freqTable.get("NORTHEAST") != null) {
					rXao0eEA = freqTable.get("NORTHEAST");
				}
				Integer bOxaL30x = 0;
				if (freqTable.get("MIDWEST") != null) {
					bOxaL30x = freqTable.get("MIDWEST");
				}
				Integer xv2W4J3D = 0;
				if (freqTable.get("SOUTH") != null) {
					xv2W4J3D = freqTable.get("SOUTH");
				}
				Integer IZDbFqQ7 = 0;
				if (freqTable.get("WEST") != null) {
					IZDbFqQ7 = freqTable.get("WEST");
				}
				Integer SupKiVpd = 0;
				if (freqTable.get("Others") != null) {
					SupKiVpd = freqTable.get("Others");
				}
				replicaData.add(new AUReplicaData(rXao0eEA, bOxaL30x, xv2W4J3D, IZDbFqQ7, SupKiVpd,
						zu0kQxra.getAuName(), auNameToAuShortNameTable.get(zu0kQxra.getAuName())));
				logger.info("replicaData=" + replicaData);
			}
		}
		URL UqroDNnF = DashboardManagedBean.class.getResource("us_map_template.svg");
		try {
			safePLNMemberMap = new DefaultStreamedContent(UqroDNnF.openStream(), "image/svg+xml");
		} catch (IOException ubbqHLsY) {
			logger.log(Level.SEVERE, "failed to read the svg file", ubbqHLsY);
		}
	}

}