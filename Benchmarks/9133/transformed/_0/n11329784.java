class n11329784 {
	@PostConstruct
	public void init() {
		logger.info("+++++ TRACAuditChecklistWizardMB: init() start ++++++++");
		try {
			tracSectionAll = new ArrayList<TRACCriteriaCheckListItem>();
			List<TRACCriteriaCheckListItem> BjCx5Bbw = new ArrayList<TRACCriteriaCheckListItem>();
			List<TRACCriteriaCheckListItem> zEIqSnmU = new ArrayList<TRACCriteriaCheckListItem>();
			List<TRACCriteriaCheckListItem> SUs6k9yJ = new ArrayList<TRACCriteriaCheckListItem>();
			URL VAB5Uf9A = TRACAuditChecklistManagedBean.class.getResource(tracCriteriaPropertiesFileName);
			tracCriteriaCheckList = new LinkedProperties();
			tracCriteriaCheckList.load(VAB5Uf9A.openStream());
			Set<String> zrnU2cxJ = tracCriteriaCheckList.stringPropertyNames();
			List<String> L6aAI3kO = new ArrayList<String>();
			L6aAI3kO.addAll(zrnU2cxJ);
			sortList(L6aAI3kO);
			for (String JbW5J5l2 : L6aAI3kO) {
				String ZPYditbA = JbW5J5l2.substring(aspectCodeOffsetValue);
				logger.info("aspectCode=" + ZPYditbA);
				if (ZPYditbA.startsWith("A")) {
					if (ZPYditbA.equals("A")) {
						sectionAcaption = tracCriteriaCheckList.getProperty(JbW5J5l2);
					} else {
						if (ZPYditbA.length() == 4) {
							tracSectionAll.add(new TRACCriteriaCheckListItem(ZPYditbA,
									tracCriteriaCheckList.getProperty(JbW5J5l2), "", "", ""));
						}
					}
				} else if (ZPYditbA.startsWith("B")) {
					if (ZPYditbA.equals("B")) {
						sectionBcaption = tracCriteriaCheckList.getProperty(JbW5J5l2);
					} else {
						if (ZPYditbA.length() == 4) {
							tracSectionAll.add(new TRACCriteriaCheckListItem(ZPYditbA,
									tracCriteriaCheckList.getProperty(JbW5J5l2), "", "", ""));
						}
					}
				} else if (ZPYditbA.startsWith("C")) {
					if (ZPYditbA.equals("C")) {
						sectionCcaption = tracCriteriaCheckList.getProperty(JbW5J5l2);
					} else {
						if (ZPYditbA.length() == 4) {
							tracSectionAll.add(new TRACCriteriaCheckListItem(ZPYditbA,
									tracCriteriaCheckList.getProperty(JbW5J5l2), "", "", ""));
						}
					}
				} else {
					logger.warning("offset value is wrong: 16th character must be A or B or C");
				}
			}
		} catch (FileNotFoundException XUHCKDcZ) {
			logger.log(Level.WARNING, "specified properties file was not found", XUHCKDcZ);
		} catch (IOException wB1dePj8) {
			logger.log(Level.WARNING, "IO error occurred", wB1dePj8);
		} finally {
		}
		logger.info("+++++ TRACAuditChecklistWizardMB: init() end   ++++++++");
	}

}