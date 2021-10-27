class n12119068 {
	public String drive() {
		logger.info("\n");
		logger.info("===========================================================");
		logger.info("========== Start drive method =============================");
		logger.info("===========================================================");
		logger.entering(cl, "drive");
		xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias("AuditDiffFacade", AuditDiffFacade.class);
		File VTaiwjcw = null;
		File ttCcsQnw = null;
		try {
			if (configFile == null) {
				logger.severe("Request Failed: configFile is null");
				return null;
			} else {
				if (configFile.getAuditSchemaFile() != null) {
					logger.info("auditSchemaFile=" + configFile.getAuditSchemaFile());
					logger.info("auditSchemaXsdFile=" + configFile.getAuditSchemaXsdFile());
					logger.info("plnXpathFile=" + configFile.getPlnXpathFile());
					logger.info("auditSchemaFileDir=" + configFile.getAuditSchemaFileDir());
					logger.info("auditReportFile=" + configFile.getAuditReportFile());
					logger.info("auditReportXsdFile=" + configFile.getAuditReportXsdFile());
				} else {
					logger.severe("Request Failed: auditSchemaFile is null");
					return null;
				}
			}
			File eNURv85F = new File(configFile.getAuditSchemaFileDir() + File.separator + "temp.xml");
			VTaiwjcw = new File(configFile.getAuditSchemaFile());
			if (!VTaiwjcw.exists() || VTaiwjcw.length() == 0L) {
				logger.severe("Request Failed: the audit schema file does not exist or empty");
				return null;
			}
			ttCcsQnw = null;
			if (configFile.getAuditSchemaXsdFile() != null) {
				ttCcsQnw = new File(configFile.getAuditSchemaXsdFile());
			} else {
				logger.severe("Request Failed: the audit schema xsd file is null");
				return null;
			}
			if (!ttCcsQnw.exists() || ttCcsQnw.length() == 0L) {
				logger.severe("Request Failed: the audit schema xsd file does not exist or empty");
				return null;
			}
			SchemaFactory idUgFCLP = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema wUPn6LWN = idUgFCLP.newSchema(ttCcsQnw);
			Validator FJYTC2fP = wUPn6LWN.newValidator();
			Source WleQQxOU = new StreamSource(VTaiwjcw);
			FJYTC2fP.validate(WleQQxOU);
		} catch (SAXException dROjxij4) {
			logger.warning("SAXException caught trying to validate input Schema Files: ");
			dROjxij4.printStackTrace();
		} catch (IOException Dj9vV4Is) {
			logger.warning("IOException caught trying to read input Schema File: ");
			Dj9vV4Is.printStackTrace();
		}
		String xlji24M0 = null;
		if (configFile.getPlnXpathFile() != null) {
			xlji24M0 = configFile.getPlnXpathFile();
			logger.info("Attempting to retrieve xpaths from file: '" + xlji24M0 + "'");
			XpathUtility.readFile(xlji24M0);
		} else {
			logger.severe("Configuration file does not have a value for the Xpath Filename");
			return null;
		}
		Properties THMStB29 = XpathUtility.getXpathsProps();
		if (THMStB29 == null) {
			logger.severe(
					"No Xpaths could be extracted from file: '" + xlji24M0 + "' - xpath properties object is null");
			return null;
		}
		if (THMStB29.isEmpty()) {
			logger.severe(
					"No Xpaths could be extracted from file: '" + xlji24M0 + "' - xpath properties object is empty");
			return null;
		}
		logger.info(THMStB29.size() + " xpaths retrieved.");
		for (String ZeBbCNnR : THMStB29.stringPropertyNames()) {
			logger.info("Key=" + ZeBbCNnR + "   Value=" + THMStB29.getProperty(ZeBbCNnR));
		}
		logger.info("\n");
		logger.info("===========================================================");
		logger.info("========== Process XML Schema File BEGIN ==================");
		logger.info("===========================================================");
		SchemaSAXReader bOmOCukV = new SchemaSAXReader();
		ArrayList<String> NOKSotGN = new ArrayList<String>(bOmOCukV.parseDocument(VTaiwjcw, THMStB29));
		logger.info("Check Input xpath hash against xpaths found in Schema.");
		Comparison E1zn1Nhl = new Comparison();
		ArrayList<String> vmfaMYvn = new ArrayList<String>(E1zn1Nhl.keys_not_in_both_hashes(THMStB29,
				Utility.arraylist_to_map(NOKSotGN, "key_matches"), "xpath Properties", "hm_key_matches"));
		if (vmfaMYvn.size() > 0) {
			logger.severe("All XPaths in Input xpath Properties list were not found in Schema.");
			logger.severe("Xpaths in xpath Properties list missing from schema file:" + xstream.toXML(vmfaMYvn));
			logger.severe("Quitting.");
			return null;
		}
		Map<String, Map> K9Ug1S6T = bOmOCukV.get_audit_hashbox();
		logger.info("schema_audit_hashbox\n" + xstream.toXML(K9Ug1S6T));
		Map<String, Map> ff3doE4h = bOmOCukV.get_net_hashbox();
		logger.info("schema_network_hashbox\n" + xstream.toXML(ff3doE4h));
		Map<String, Map> i9yB2JiY = bOmOCukV.get_host_hashbox();
		Map<String, Map> QUaRATik = bOmOCukV.get_au_hashbox();
		logger.info("schema_au_hashbox\n" + xstream.toXML(QUaRATik));
		Hasherator dRIcWaJU = new Hasherator();
		Set<String> irNOPvsE = new HashSet<String>();
		irNOPvsE.add("/SSP/network/@network_id");
		i9yB2JiY = dRIcWaJU.copy_hashbox_entries(ff3doE4h, i9yB2JiY, irNOPvsE);
		logger.info("schema_host_hashbox(after adding network name)\n" + xstream.toXML(i9yB2JiY));
		Map<String, String> rvxAt7zK = new HashMap<String, String>();
		rvxAt7zK.put("/SSP/archivalUnits/au/auCapabilities/storageRequired/@max_size",
				"s_gigabytes_to_string_bytes_unformatted()");
		QUaRATik = dRIcWaJU.convert_hashbox_vals(QUaRATik, rvxAt7zK);
		Map<String, String> mcTGnTOS = new HashMap<String, String>();
		mcTGnTOS.put("/SSP/hosts/host/hostCapabilities/storageAvailable/@max_size",
				"s_gigabytes_to_string_bytes_unformatted()");
		i9yB2JiY = dRIcWaJU.convert_hashbox_vals(i9yB2JiY, mcTGnTOS);
		logger.info("schema_host_hashbox(after transformations)\n" + xstream.toXML(i9yB2JiY));
		logger.info("\n");
		logger.info("========== Process Schema  END ============================");
		logger.info("\n");
		logger.info("========== Database Operations ============================");
		MYSQLWorkPlnHostSummaryDAO gT1vtQMF = new MYSQLWorkPlnHostSummaryDAO();
		gT1vtQMF.drop();
		gT1vtQMF.create();
		gT1vtQMF.updateTimestamp();
		CachedRowSet LG7AV3R0 = gT1vtQMF.query_0_N();
		double WpOUI8FD = DBUtil.get_single_db_double_value(LG7AV3R0, "net_sum_repo_size");
		double sjnFmdfO = DBUtil.get_single_db_double_value(LG7AV3R0, "net_sum_used_space");
		double uWl42iAp = WpOUI8FD - sjnFmdfO;
		double KgkOTwDW = DBUtil.get_single_db_double_value(LG7AV3R0, "net_avg_uptime");
		long woBmlWXp = (long) WpOUI8FD;
		long vWkMnAzU = (long) sjnFmdfO;
		long fblmglff = woBmlWXp - vWkMnAzU;
		String YVMYZGGe = Utility.l_bytes_to_other_units_formatted(woBmlWXp, 3, "T");
		String FhJkQfv2 = Utility.l_bytes_to_other_units_formatted(vWkMnAzU, 3, "G");
		String DJGgWjms = Utility.l_bytes_to_other_units_formatted(fblmglff, 3, "T");
		String tBNOFzWV = Utility.l_bytes_to_other_units_formatted(fblmglff, 3, null);
		logger.info("d_space_total: " + WpOUI8FD + "\n" + "d_space_used: " + sjnFmdfO + "\n" + "space_total: "
				+ woBmlWXp + "\n" + "space_used: " + vWkMnAzU + "\n" + "space_free: " + fblmglff + "\n\n"
				+ "Double.toString( d_space_total ): " + Double.toString(WpOUI8FD) + "\n\n" + "f_space_total: "
				+ YVMYZGGe + "\n" + "f_space_used: " + FhJkQfv2 + "\n" + "f_space_free: " + DJGgWjms + "\n"
				+ "f_space_free2: " + tBNOFzWV);
		rprtCnst = new ReportData();
		logger.info("\n");
		logger.info("========== Load Report Constants from Calculations ===========");
		rprtCnst.addKV("REPORT_HOSTS_TOTAL_DISKSPACE", YVMYZGGe);
		rprtCnst.addKV("REPORT_HOSTS_TOTAL_DISKSPACE_USED", FhJkQfv2);
		rprtCnst.addKV("REPORT_HOSTS_TOTAL_DISKSPACE_FREE", DJGgWjms);
		rprtCnst.addKV("REPORT_HOSTS_MEAN_UPTIME", Utility.ms_to_dd_hh_mm_ss_formatted((long) KgkOTwDW));
		logger.info("r=\n" + rprtCnst.toString());
		logger.info("\n");
		logger.info("========== Load Report Constants from ConfigFile =============");
		rprtCnst.addKV("REPORT_FILENAME_SCHEMA_FILENAME", configFile.getAuditSchemaFile());
		rprtCnst.addKV("REPORT_FILENAME_SCHEMA_FILE_XSD_FILENAME", configFile.getAuditSchemaXsdFile());
		rprtCnst.addKV("REPORT_FILENAME_XML_DIFF_FILENAME", configFile.getAuditReportFile());
		rprtCnst.addKV("REPORT_FILENAME_XML_DIFF_FILE_XSD_FILENAME", configFile.getAuditReportXsdFile());
		logger.info("\n");
		logger.info("========== Load Report Constants from Hashboxes ==============");
		Set efLCWwvT = dRIcWaJU.getMapKeyset(K9Ug1S6T, "schema_audit_hashbox");
		String aoMIUwYa = dRIcWaJU.singleKeysetEntryToString(efLCWwvT);
		logger.info("audit_id: " + aoMIUwYa);
		Set kDO31bmZ = dRIcWaJU.getMapKeyset(ff3doE4h, "schema_network_hashbox");
		String QAyDj8Rm = dRIcWaJU.singleKeysetEntryToString(kDO31bmZ);
		logger.info("network_id: " + QAyDj8Rm);
		rprtCnst.addKV("REPORT_AUDIT_ID", aoMIUwYa);
		rprtCnst.addKV("REPORT_AUDIT_REPORT_EMAIL", dRIcWaJU.extractSingleValueFromHashbox(K9Ug1S6T,
				"schema_audit_hashbox", aoMIUwYa, "/SSP/audit/auditReportEmail"));
		rprtCnst.addKV("REPORT_AUDIT_INTERVAL", dRIcWaJU.extractSingleValueFromHashbox(K9Ug1S6T, "schema_audit_hashbox",
				aoMIUwYa, "/SSP/audit/auditReportInterval/@maxDays"));
		rprtCnst.addKV("REPORT_SCHEMA_VERSION", dRIcWaJU.extractSingleValueFromHashbox(K9Ug1S6T, "schema_audit_hashbox",
				aoMIUwYa, "/SSP/audit/schemaVersion"));
		rprtCnst.addKV("REPORT_CLASSIFICATION_GEOGRAPHIC_SUMMARY_SCHEME", dRIcWaJU.extractSingleValueFromHashbox(
				K9Ug1S6T, "schema_audit_hashbox", aoMIUwYa, "/SSP/audit/geographicSummaryScheme"));
		rprtCnst.addKV("REPORT_CLASSIFICATION_SUBJECT_SUMMARY_SCHEME", dRIcWaJU.extractSingleValueFromHashbox(K9Ug1S6T,
				"schema_audit_hashbox", aoMIUwYa, "/SSP/audit/subjectSummaryScheme"));
		rprtCnst.addKV("REPORT_CLASSIFICATION_OWNER_INSTITUTION_SUMMARY_SCHEME", dRIcWaJU.extractSingleValueFromHashbox(
				K9Ug1S6T, "schema_audit_hashbox", aoMIUwYa, "/SSP/audit/ownerInstSummaryScheme"));
		rprtCnst.addKV("REPORT_NETWORK_ID", QAyDj8Rm);
		rprtCnst.addKV("REPORT_NETWORK_ADMIN_EMAIL", dRIcWaJU.extractSingleValueFromHashbox(ff3doE4h,
				"schema_network_hashbox", QAyDj8Rm, "/SSP/network/networkIdentity/accessBase/@adminEmail"));
		rprtCnst.addKV("REPORT_GEOGRAPHIC_CODING", dRIcWaJU.extractSingleValueFromHashbox(ff3doE4h,
				"schema_network_hashbox", QAyDj8Rm, "/SSP/network/networkIdentity/geographicCoding"));
		logger.info("\n");
		logger.info("===========================================================");
		logger.info("========== Process Network Data BEGIN======================");
		logger.info("===========================================================");
		Set<String> kw4Qdiu2 = reportAuOverviewFacade.findAllTables();
		String XxQkpDvV = "report_au_overview";
		int dVvCcZoK = 0;
		if (kw4Qdiu2 != null && !kw4Qdiu2.isEmpty()) {
			logger.fine("Table List N=" + kw4Qdiu2.size());
			for (String spAdO1rx : kw4Qdiu2) {
				dVvCcZoK++;
				if (spAdO1rx.equalsIgnoreCase(XxQkpDvV)) {
					logger.fine(dVvCcZoK + " " + spAdO1rx + " <--");
				} else {
					logger.fine(dVvCcZoK + " " + spAdO1rx);
				}
			}
		} else {
			logger.fine("No tables found in DB.");
		}
		if (!kw4Qdiu2.contains(XxQkpDvV)) {
			logger.info("Database does not contain table '" + XxQkpDvV + "'");
		}
		List<ReportAuOverview> aYHObvLB = null;
		aYHObvLB = reportAuOverviewFacade.findAll();
		if (aYHObvLB != null && !(aYHObvLB.isEmpty())) {
			logger.fine("\n" + XxQkpDvV + " table has " + aYHObvLB.size() + " rows.");
			int C08vrvGT = 0;
			for (ReportAuOverview uRJdBKFq : aYHObvLB) {
				C08vrvGT++;
				logger.fine(C08vrvGT + " " + uRJdBKFq.toString());
			}
		} else {
			logger.fine(XxQkpDvV + " is null, empty, or nonexistent.");
		}
		logger.fine("report_au_overview Table xstream Dump:\n" + xstream.toXML(aYHObvLB));
		logger.fine("\n");
		logger.fine("Iterate over repAuOvTabAllData 2");
		Iterator L7aL6NGU = aYHObvLB.iterator();
		int JCUsKbYu = 0;
		while (L7aL6NGU.hasNext()) {
			++JCUsKbYu;
			String J4c6lftp = L7aL6NGU.next().toString();
			logger.fine(JCUsKbYu + ". " + J4c6lftp);
		}
		Class jjxzf7rR = edu.harvard.iq.safe.saasystem.entities.ReportAuOverview.class;
		String Qj6SIozR = reportAuOverviewFacade.getTableName();
		logger.fine("\n");
		logger.fine("EntityManager Tests");
		logger.fine("Table: " + Qj6SIozR);
		logger.fine("\n");
		logger.fine("Schema: " + reportAuOverviewFacade.getSchema());
		logger.fine("\n");
		Set Y19h2tDZ = reportAuOverviewFacade.getColumnList(reportAuOverviewFacade.getTableName());
		logger.fine("Columns (fields) in table '" + Qj6SIozR + "' (N=" + Y19h2tDZ.size() + ")");
		Set<String> PSF1hDuk = new HashSet();
		Iterator acbBOTdd = Y19h2tDZ.iterator();
		int tGv3I4hC = 0;
		while (acbBOTdd.hasNext()) {
			++tGv3I4hC;
			String wM42as7t = acbBOTdd.next().toString();
			logger.fine(tGv3I4hC + ". " + wM42as7t);
			PSF1hDuk.add(wM42as7t);
		}
		logger.fine(PSF1hDuk.size() + " entries in Set 'colList' ");
		logger.info("========== Query 'au_overview_table'=============");
		MySQLAuOverviewDAO YUJfdlBs = new MySQLAuOverviewDAO();
		CachedRowSet RSX8WZPe = YUJfdlBs.query_q1_A();
		int[] WlQkwq0S = DBUtil.get_rs_dims(RSX8WZPe);
		logger.info("Au Table Query ResultSet has " + WlQkwq0S[0] + " rows and " + WlQkwq0S[1] + " columns.");
		rprtCnst.addKV("REPORT_N_AUS_IN_NETWORK", Integer.toString(WlQkwq0S[0]));
		logger.info("========== Create 'network_au_hashbox' ==========");
		Map<String, Map> t3DBf9mR = new TreeMap<String, Map>(DBUtil.rs_to_hashbox(RSX8WZPe, null, "au_id"));
		logger.info("network_au_hashbox before transformations\n" + xstream.toXML(t3DBf9mR));
		Map<String, String> gGoUmvqO = new HashMap<String, String>();
		gGoUmvqO.put("last_s_crawl_end", "ms_to_decimal_days_elapsed()");
		gGoUmvqO.put("last_s_poll_end", "ms_to_decimal_days_elapsed()");
		gGoUmvqO.put("crawl_duration", "ms_to_decimal_days()");
		t3DBf9mR = dRIcWaJU.convert_hashbox_vals(t3DBf9mR, gGoUmvqO);
		Map<String, String> NIEy4Nnd = reportAuOverviewFacade.getAuNVerifiedRegions();
		logger.fine("auNVerifiedRegions\n" + xstream.toXML(NIEy4Nnd));
		t3DBf9mR = dRIcWaJU.addNewInnerHashEntriesToHashbox(t3DBf9mR, NIEy4Nnd, "au_n_verified_regions");
		logger.info("network_au_hashbox after Transformations and Addition of 'au_n_verified_regions'"
				+ xstream.toXML(t3DBf9mR));
		logger.info("========== Compare AUs BEGIN ==============================");
		ArrayList<String> xcem2Eyu = new ArrayList<String>(
				E1zn1Nhl.keys_not_in_both_hashes(QUaRATik, t3DBf9mR, "schema_aus", "network_aus"));
		Map<String, String> xwuip3tu = dRIcWaJU.get_names_from_id_list(QUaRATik, xcem2Eyu,
				"/SSP/archivalUnits/au/auIdentity/name");
		rprtCnst.addKV("REPORT_N_AUS_IN_SCHEMA_NOT_IN_NETWORK", Integer.toString(xcem2Eyu.size()));
		rprtCnst.set_h_aus_in_schema_not_in_network(xwuip3tu);
		MYSQLReportAusInSchemaNotInNetworkDAO SE3HppuH = new MYSQLReportAusInSchemaNotInNetworkDAO();
		SE3HppuH.create();
		SE3HppuH.update(xwuip3tu);
		ArrayList<String> cgvl9Dhu = new ArrayList<String>(
				E1zn1Nhl.keys_not_in_both_hashes(t3DBf9mR, QUaRATik, "network_aus", "schema_aus"));
		Utility.print_arraylist(cgvl9Dhu, "aus in_network_not_in_schema");
		Map<String, String> FHcYsy6N = dRIcWaJU.get_names_from_id_list(t3DBf9mR, cgvl9Dhu, "au_name");
		rprtCnst.addKV("REPORT_N_AUS_IN_NETWORK_NOT_IN_SCHEMA", Integer.toString(cgvl9Dhu.size()));
		rprtCnst.set_h_aus_in_network_not_in_schema(FHcYsy6N);
		MYSQLReportAusInNetworkNotInSchemaDAO CHu4BjSY = new MYSQLReportAusInNetworkNotInSchemaDAO();
		CHu4BjSY.create();
		CHu4BjSY.update(FHcYsy6N);
		Comparison TvvmGDCs = new Comparison(QUaRATik, "Schema_AU", t3DBf9mR, "Network_AU",
				XpathUtility.getXpathToDbColumnMap(), XpathUtility.getXpathToCompOpMap());
		TvvmGDCs.init();
		logger.info("Attempting to create DB table 'lockss_audit.audit_results_au'");
		MYSQLAuditResultsAuDAO WjMGNf76 = new MYSQLAuditResultsAuDAO();
		WjMGNf76.create();
		String V4AE7BOY = "audit_results_au";
		String j9lyDlg3 = TvvmGDCs.iterate_hbs_au(WjMGNf76, V4AE7BOY, "au", FHcYsy6N);
		CachedRowSet hQSmfeLn = WjMGNf76.query_q1_RA();
		String floKy6PW = DBUtil.get_single_count_from_rs(hQSmfeLn);
		rprtCnst.addKV("REPORT_N_AUS_NOT_VERIFIED", DBUtil.get_single_count_from_rs(hQSmfeLn));
		logger.info("\nInstantiating Result Class from main()");
		DiffResult YzxcT2K6 = new DiffResult();
		Map hLooTJwR = YzxcT2K6.get_result_hash("au");
		logger.info("========== Compare AUs END ================================");
		logger.info("========== Process Network Host Table =====================");
		logger.info("========== Query 'lockss_box_table' and =========");
		logger.info("================ 'repository_space_table' =======\n");
		MySQLLockssBoxRepositorySpaceDAO z96roawn = new MySQLLockssBoxRepositorySpaceDAO();
		CachedRowSet ewkA6rJ6 = z96roawn.query_q1_H();
		int[] g7eYZQIZ = DBUtil.get_rs_dims(ewkA6rJ6);
		logger.info("Host Table Query ResultSet has " + g7eYZQIZ[0] + " rows and " + g7eYZQIZ[1] + " columns.");
		rprtCnst.addKV("REPORT_N_HOSTS_IN_NETWORK", Integer.toString(g7eYZQIZ[0]));
		Long S2XOHjDd;
		if (StringUtils
				.isNotBlank(saasConfigurationRegistry.getSaasConfigProperties().getProperty("saas.ip.fromlockssxml"))) {
			S2XOHjDd = Long.parseLong(Integer.toString(saasConfigurationRegistry.getSaasConfigProperties()
					.getProperty("saas.ip.fromlockssxml").split(",").length));
		} else {
			if (StringUtils.isNotBlank(
					saasConfigurationRegistry.getSaasAuditConfigProperties().getProperty("saas.targetIp"))) {
				S2XOHjDd = Long.parseLong(Integer.toString(saasConfigurationRegistry.getSaasAuditConfigProperties()
						.getProperty("saas.targetIp").split(",").length));
			} else {
				S2XOHjDd = 0L;
			}
		}
		rprtCnst.addKV("REPORT_N_HOSTS_IN_NETWORK_2", Long.toString(S2XOHjDd));
		Long DHhbcVNH;
		DHhbcVNH = lockssBoxFacade.getTotalHosts();
		rprtCnst.addKV("REPORT_N_HOSTS_IN_NETWORK_REACHABLE", Long.toString(DHhbcVNH));
		Map<String, Map> TuG9ZW84 = new TreeMap<String, Map>(DBUtil.rs_to_hashbox(ewkA6rJ6, null, "ip_address"));
		logger.info("network_host_hashbox before transformations\n" + xstream.toXML(TuG9ZW84));
		Map<String, String> BlBiM3k2 = new HashMap<String, String>();
		BlBiM3k2.put("repo_size", "SciToStr2()");
		BlBiM3k2.put("used_space", "SciToStr2()");
		TuG9ZW84 = dRIcWaJU.convert_hashbox_vals(TuG9ZW84, BlBiM3k2);
		logger.info("network_host_hashbox(after transformations)\n" + xstream.toXML(TuG9ZW84));
		Map<String, String> AFhQjMr1 = dRIcWaJU.join_hash_pk_to_inner_hash_value(TuG9ZW84, "used_space");
		Map<String, String> ApKSJI9u = dRIcWaJU.join_hash_pk_to_inner_hash_value(i9yB2JiY,
				"/SSP/hosts/host/hostCapabilities/storageAvailable/@max_size");
		logger.info("\n========== Process Network  END ===========================");
		logger.info("========== Compare Key Sets (IDs)==========================");
		Set<String> btIL31ig = dRIcWaJU.gen_hash_keyset(QUaRATik, "schema_au_hashbox");
		dRIcWaJU.set_hash_keyset(btIL31ig, "s_au_hb");
		Set<String> nTLyaK48 = dRIcWaJU.gen_hash_keyset(i9yB2JiY, "schema_host_hashbox");
		dRIcWaJU.set_hash_keyset(nTLyaK48, "s_h_hb");
		Set<String> CP9alJxc = dRIcWaJU.gen_hash_keyset(t3DBf9mR, "network_au_hashbox");
		dRIcWaJU.set_hash_keyset(CP9alJxc, "n_au_hb");
		Set<String> xk3gNm70 = dRIcWaJU.gen_hash_keyset(TuG9ZW84, "network_host_hashbox");
		dRIcWaJU.set_hash_keyset(xk3gNm70, "n_h_hb");
		Set<String> fXDBH0vC = new TreeSet<String>(dRIcWaJU.get_hash_keyset("s_au_hb"));
		fXDBH0vC.removeAll(dRIcWaJU.get_hash_keyset("n_au_hb"));
		Set<String> z2GwBQKs = new TreeSet<String>(dRIcWaJU.get_hash_keyset("n_au_hb"));
		z2GwBQKs.removeAll(dRIcWaJU.get_hash_keyset("s_au_hb"));
		Set<String> Vnupjg37 = new HashSet<String>(dRIcWaJU.get_hash_keyset("s_au_hb"));
		Vnupjg37.addAll(dRIcWaJU.get_hash_keyset("n_au_hb"));
		Set<String> A1591FSE = new HashSet<String>(dRIcWaJU.get_hash_keyset("s_au_hb"));
		A1591FSE.retainAll(dRIcWaJU.get_hash_keyset("n_au_hb"));
		Vnupjg37.removeAll(A1591FSE);
		Set<String> mOqOjbJZ = new TreeSet<String>(dRIcWaJU.get_hash_keyset("n_h_hb"));
		mOqOjbJZ.removeAll(dRIcWaJU.get_hash_keyset("s_h_hb"));
		Set<String> yfjLUBtO = new TreeSet<String>(dRIcWaJU.get_hash_keyset("s_h_hb"));
		yfjLUBtO.removeAll(dRIcWaJU.get_hash_keyset("n_h_hb"));
		ArrayList<String> WPfoSAZq = new ArrayList<String>(
				E1zn1Nhl.keys_not_in_both_hashes(i9yB2JiY, TuG9ZW84, "schema_hosts", "network_hosts"));
		Map<String, String> IVhAo3ub = dRIcWaJU.get_names_from_id_list(i9yB2JiY, WPfoSAZq,
				"/SSP/hosts/host/hostIdentity/name");
		rprtCnst.addKV("REPORT_N_HOSTS_IN_SCHEMA_NOT_IN_NETWORK", Integer.toString(WPfoSAZq.size()));
		rprtCnst.set_h_hosts_in_schema_not_in_network(IVhAo3ub);
		MYSQLReportHostsInSchemaNotInNetworkDAO NOr3UP86 = new MYSQLReportHostsInSchemaNotInNetworkDAO();
		NOr3UP86.create();
		NOr3UP86.update(IVhAo3ub);
		ArrayList<String> XyRRVQip = new ArrayList<String>(
				E1zn1Nhl.keys_not_in_both_hashes(TuG9ZW84, i9yB2JiY, "network_hosts", "schema_hosts"));
		Map<String, String> TVLUy5FM = dRIcWaJU.get_names_from_id_list(TuG9ZW84, XyRRVQip, "host_name");
		rprtCnst.addKV("REPORT_N_HOSTS_IN_NETWORK_NOT_IN_SCHEMA", Integer.toString(XyRRVQip.size()));
		rprtCnst.set_h_hosts_in_network_not_in_schema(TVLUy5FM);
		MYSQLReportHostsInNetworkNotInSchemaDAO yHXHSR3Z = new MYSQLReportHostsInNetworkNotInSchemaDAO();
		yHXHSR3Z.create();
		yHXHSR3Z.update(TVLUy5FM);
		logger.info("========== Compare Hosts BEGIN ============================");
		Comparison fmpnoQ89 = new Comparison(i9yB2JiY, "Schema_Host", TuG9ZW84, "Network_Host",
				XpathUtility.getXpathToDbColumnMap(), XpathUtility.getXpathToCompOpMap());
		fmpnoQ89.init();
		MYSQLAuditResultsHostDAO aPNOdOcw = new MYSQLAuditResultsHostDAO();
		aPNOdOcw.create();
		String FEBZh3bv = fmpnoQ89.iterate_hbs_host(aPNOdOcw, "audit_results_host", "host", TVLUy5FM);
		CachedRowSet mgVk4WWb = aPNOdOcw.query_q1_RH();
		String O7wU7l68 = DBUtil.get_single_count_from_rs(mgVk4WWb);
		rprtCnst.addKV("REPORT_N_HOSTS_NOT_MEETING_STORAGE", O7wU7l68);
		logger.info("Calling result.get_result_hash( \"host\" ) from main()");
		Map f4m7siYa = YzxcT2K6.get_result_hash("host");
		Map Bg6MWu0P = YzxcT2K6.get_result_hash("au");
		logger.info("========== Compare Hosts END ==============================");
		Map<String, String> vgPSC89o = dRIcWaJU.make_id_hash(i9yB2JiY, "/SSP/hosts/host/hostIdentity/name");
		rprtCnst.addKV("REPORT_N_HOSTS_IN_SCHEMA", Integer.toString(vgPSC89o.size()));
		String[] pgKvaCFb = dRIcWaJU.hash_keys_to_array(i9yB2JiY);
		String[][] fw0LNi1D = Utility.add_column_to_array1(vgPSC89o.values().toArray(new String[0]), pgKvaCFb, null);
		Map<String, String> atxb6usk = dRIcWaJU.make_id_hash(QUaRATik, "/SSP/archivalUnits/au/auIdentity/name");
		logger.info("Length map_au_key_string_to_au_name.values().toArray(new String[0]: "
				+ atxb6usk.values().toArray(new String[0]).length);
		rprtCnst.addKV("REPORT_N_AUS_IN_SCHEMA", Integer.toString(atxb6usk.size()));
		MySQLLockssBoxArchivalUnitStatusDAO COe8GRdV = new MySQLLockssBoxArchivalUnitStatusDAO();
		int[] RaSFe1R9 = COe8GRdV.getResultSetDimensions();
		int si9CiFfk = RaSFe1R9[0];
		int Hkt8u1fM = RaSFe1R9[1];
		logger.info("\n" + si9CiFfk + " rows (Host-AU's). " + Hkt8u1fM + " columns.");
		rprtCnst.addKV("REPORT_N_HOST_AUS_IN_NETWORK", Integer.toString(si9CiFfk));
		logger.info("================== Query 'audit_results_host' Table ==========");
		CachedRowSet abDAvTgY = WjMGNf76.getNNonCompliantAUs();
		String rt8SmQRs = DBUtil.get_single_count_from_rs(abDAvTgY);
		rprtCnst.addKV("REPORT_N_AUS_NONCOMPLIANT", rt8SmQRs);
		logger.info("================== Query 'audit_results_host' Table END ======");
		logger.info("========== Output Report ==================================");
		MYSQLReportConstantsDAO pkZZx7Yu = new MYSQLReportConstantsDAO();
		pkZZx7Yu.create();
		pkZZx7Yu.update(rprtCnst.getBox());
		MYSQLReportHostSummaryDAO oqT93rxf = new MYSQLReportHostSummaryDAO();
		oqT93rxf.create();
		CachedRowSet MJVU6nuQ = aPNOdOcw.queryAll();
		oqT93rxf.update(MJVU6nuQ);
		oqT93rxf.update_new_column("space_offered", ApKSJI9u);
		oqT93rxf.update_new_column("space_used", AFhQjMr1);
		Map<String, String> z2nyDCsi = new HashMap<String, String>();
		z2nyDCsi.put("space_total", "1");
		z2nyDCsi.put("space_used", "2");
		oqT93rxf.update_compute_column("space_free", z2nyDCsi);
		logger.info("========== Audit Report Writer ======================================");
		AuditReportXMLWriter Z8Z9r9yM = new AuditReportXMLWriter(rprtCnst, configFile.getAuditReportFile());
		Set<String> nWZtgKdC = tracAuditChecklistDataFacade.findAllTables();
		String iR60FXPg = "trac_audit_checklist_data";
		List<TracAuditChecklistData> g7BxDTDh = null;
		if (nWZtgKdC.contains(iR60FXPg)) {
			g7BxDTDh = tracAuditChecklistDataFacade.findAll();
			logger.info("TRAC evidence list is size:" + g7BxDTDh.size());
		} else {
			logger.info("Database does not contain table 'trac_audit_checklist_data'");
		}
		Map<String, String> CB3cxx8s = new LinkedHashMap<String, String>();
		for (TracAuditChecklistData IP5zNRGs : g7BxDTDh) {
			CB3cxx8s.put(IP5zNRGs.getAspectId(), IP5zNRGs.getEvidence());
		}
		String FPw54GDm = Z8Z9r9yM.write(aPNOdOcw, WjMGNf76, pkZZx7Yu, CB3cxx8s);
		File Df5ywmEk = new File(configFile.getAuditReportFileDir() + File.separator
				+ configFile.getAuditSchemaFileName() + "." + FPw54GDm);
		FileChannel BIpEgeYz = null;
		FileChannel mXyj4rm3 = null;
		try {
			BIpEgeYz = new FileInputStream(VTaiwjcw).getChannel();
			mXyj4rm3 = new FileOutputStream(Df5ywmEk).getChannel();
			mXyj4rm3.transferFrom(BIpEgeYz, 0, BIpEgeYz.size());
		} catch (IOException k9vr8IJq) {
			logger.log(Level.SEVERE, "IO exception occurred while copying file", k9vr8IJq);
		} finally {
			try {
				if (BIpEgeYz != null) {
					BIpEgeYz.close();
				}
				if (mXyj4rm3 != null) {
					mXyj4rm3.close();
				}
			} catch (IOException rbL2vRjy) {
				logger.info("closing channels failed");
			}
		}
		logger.info("\n========== EXIT drive() ===========================================");
		return FPw54GDm;
	}

}