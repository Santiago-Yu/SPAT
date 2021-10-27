class n13472899{
    @PostConstruct
    public void initialize() {
        logger.info("+++++ DashboardFManagedBean: postConstruct step: start ++++++++");
        if (auSummaryList == null || auSummaryList.isEmpty()) {
            auSummaryList = auOverviewTableFacade.getNewerVerifiedAus(N_AUS_FOR_CHART);
            if (auSummaryList == null) {
                MySQLDAOFactory daof = (MySQLDAOFactory) DAOFactory.getDAOFactory(DAOFactory.DBvendor.MySQL);
                MySQLAuOverviewDAO maodao = (MySQLAuOverviewDAO) daof.getAuOverviewDAO();
                maodao.createTable();
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
        Map<String, String> regionCodeToLabeTableNew = new TreeMap<String, String>();
        for (Map.Entry<String, String> entry : regionCodeToLabeTable.entrySet()) {
            if (Integer.parseInt(entry.getKey()) < 90) {
                regionCodeToLabeTableNew.put(entry.getKey(), entry.getValue());
            }
        }
        Set<String> regionCodeSet = new TreeSet<String>(regionCodeToLabeTableNew.values());
        logger.fine("RegionCodelabelSet=" + regionCodeSet);
        if (auSummaryList != null) {
            for (AuOverviewTable auSummary : auSummaryList) {
                logger.fine("working on au name=" + auSummary.getAuName() + ":pollId=" + auSummary.getPollId());
                Integer verifiedReplicas = auSummary.getAuNVerifiedReplicas();
                if (auSummary.getAuNVerifiedReplicas() > 0) {
                    verifiedReplicas++;
                }
                auSummaryDataList.add(new AUSummaryDataForChart(auSummary.getAuName(), auSummary.getAuNReplicas(), verifiedReplicas, auNameToAuShortNameTable.get(auSummary.getAuName())));
                if (auSummary.getPollId() == null) {
                    logger.fine("pollId is null");
                    replicaData.add(new AUReplicaData(0, 0, 0, 0, 0, auSummary.getAuName(), auNameToAuShortNameTable.get(auSummary.getAuName())));
                    continue;
                }
                pollList = successfulPollReplicaIpFacade.findPollByPollId(auSummary.getPollId());
                logger.fine("pollList=" + pollList);
                if (pollList == null || pollList.isEmpty()) {
                    logger.fine("pollList is null");
                    replicaData.add(new AUReplicaData(0, 0, 0, 0, 0, auSummary.getAuName(), auNameToAuShortNameTable.get(auSummary.getAuName())));
                    continue;
                }
                List<String> ipList = new ArrayList<String>();
                for (SuccessfulPollReplicaIp row : pollList) {
                    logger.fine("current Ip=" + row.getIpAddress());
                    String regionCode = ipAddressToRegionCodeTable.get(row.getIpAddress());
                    logger.fine("regionCode=" + regionCode);
                    String regionLabel = regionCodeToLabeTable.get(regionCode);
                    logger.fine("regionLabel=" + regionLabel);
                    if (StringUtils.isBlank(regionLabel)) {
                        regionLabel = "Others";
                    }
                    ipList.add(regionLabel);
                }
                logger.fine("ipList" + ipList + " for au=" + auSummary.getAuName());
                if (ipList == null || ipList.isEmpty()) {
                    logger.fine("ipList is null");
                    replicaData.add(new AUReplicaData(0, 0, 0, 0, 0, auSummary.getAuName(), auNameToAuShortNameTable.get(auSummary.getAuName())));
                    continue;
                }
                int nonUS = 0;
                for (String label : regionCodeSet) {
                    int count = Collections.frequency(ipList, label);
                    if (label.equals("Others")) {
                        count += nonUS;
                        freqTable.put(label, count);
                    } else {
                        freqTable.put(label, count);
                    }
                }
                logger.fine("freqTable=" + freqTable);
                auNameToLocationListTable.put(auSummary.getAuName(), ipList);
                auList.add(auSummary.getAuName());
                Integer northeast = 0;
                if (freqTable.get("NORTHEAST") != null) {
                    northeast = freqTable.get("NORTHEAST");
                }
                Integer midwest = 0;
                if (freqTable.get("MIDWEST") != null) {
                    midwest = freqTable.get("MIDWEST");
                }
                Integer south = 0;
                if (freqTable.get("SOUTH") != null) {
                    south = freqTable.get("SOUTH");
                }
                Integer west = 0;
                if (freqTable.get("WEST") != null) {
                    west = freqTable.get("WEST");
                }
                Integer others = 0;
                if (freqTable.get("Others") != null) {
                    others = freqTable.get("Others");
                }
                replicaData.add(new AUReplicaData(northeast, midwest, south, west, others, auSummary.getAuName(), auNameToAuShortNameTable.get(auSummary.getAuName())));
                logger.info("replicaData=" + replicaData);
            }
        }
        URL url = DashboardManagedBean.class.getResource("us_map_template.svg");
        try {
            safePLNMemberMap = new DefaultStreamedContent(url.openStream(), "image/svg+xml");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "failed to read the svg file", ex);
        }
    }

}