class n11329784 {
	@PostConstruct
	public void init() {
		logger.info("+++++ TRACAuditChecklistWizardMB: init() start ++++++++");
		try {
			tracSectionAll = new ArrayList<TRACCriteriaCheckListItem>();
			List<TRACCriteriaCheckListItem> tracSectionA = new ArrayList<TRACCriteriaCheckListItem>();
			List<TRACCriteriaCheckListItem> tracSectionB = new ArrayList<TRACCriteriaCheckListItem>();
			List<TRACCriteriaCheckListItem> tracSectionC = new ArrayList<TRACCriteriaCheckListItem>();
			URL url = TRACAuditChecklistManagedBean.class.getResource(tracCriteriaPropertiesFileName);
			tracCriteriaCheckList = new LinkedProperties();
			tracCriteriaCheckList.load(url.openStream());
			Set<String> tmpKeys = tracCriteriaCheckList.stringPropertyNames();
			List<String> sortWrkList = new ArrayList<String>();
			sortWrkList.addAll(tmpKeys);
			sortList(sortWrkList);
			for (String key : sortWrkList) {
				String aspectCode = key.substring(aspectCodeOffsetValue);
				logger.info("aspectCode=" + aspectCode);
				if (!(aspectCode.startsWith("A"))) {
					if (aspectCode.startsWith("B")) {
						if (aspectCode.equals("B")) {
							sectionBcaption = tracCriteriaCheckList.getProperty(key);
						} else {
							if (aspectCode.length() == 4) {
								tracSectionAll.add(new TRACCriteriaCheckListItem(aspectCode,
										tracCriteriaCheckList.getProperty(key), "", "", ""));
							}
						}
					} else if (aspectCode.startsWith("C")) {
						if (aspectCode.equals("C")) {
							sectionCcaption = tracCriteriaCheckList.getProperty(key);
						} else {
							if (aspectCode.length() == 4) {
								tracSectionAll.add(new TRACCriteriaCheckListItem(aspectCode,
										tracCriteriaCheckList.getProperty(key), "", "", ""));
							}
						}
					} else {
						logger.warning("offset value is wrong: 16th character must be A or B or C");
					}
				} else {
					if (aspectCode.equals("A")) {
						sectionAcaption = tracCriteriaCheckList.getProperty(key);
					} else {
						if (aspectCode.length() == 4) {
							tracSectionAll.add(new TRACCriteriaCheckListItem(aspectCode,
									tracCriteriaCheckList.getProperty(key), "", "", ""));
						}
					}
				}
			}
		} catch (FileNotFoundException ex) {
			logger.log(Level.WARNING, "specified properties file was not found", ex);
		} catch (IOException ex) {
			logger.log(Level.WARNING, "IO error occurred", ex);
		} finally {
		}
		logger.info("+++++ TRACAuditChecklistWizardMB: init() end   ++++++++");
	}

}