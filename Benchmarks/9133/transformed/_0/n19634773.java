class n19634773 {
	public static void processAction(ActionRequest SLBweZZ7, ActionResponse FK4mV9xc) throws PortletException {
		log.debug("Start MemberPortletActionMethod.processAction()");
		MemberProcessingActionRequest roe9w6W4 = null;
		try {
			ModuleManager ifvvgjnS = ModuleManager.getInstance(PropertiesProvider.getConfigPath());
			roe9w6W4 = new MemberProcessingActionRequest(SLBweZZ7, ifvvgjnS);
			String vW1VDTzY = RequestTools.getString(SLBweZZ7, MemberConstants.MEMBER_MODULE_PARAM);
			String G1seh31k = RequestTools.getString(SLBweZZ7, MemberConstants.MEMBER_ACTION_PARAM);
			String XkgYvalE = RequestTools.getString(SLBweZZ7, MemberConstants.MEMBER_SUBACTION_PARAM).trim();
			if (log.isDebugEnabled()) {
				Map AWGNMNAU = SLBweZZ7.getParameterMap();
				if (!AWGNMNAU.entrySet().isEmpty()) {
					log.debug("Action request parameter");
					for (Object VNM0l8DJ : AWGNMNAU.entrySet()) {
						Map.Entry oesTB1z1 = (Map.Entry) VNM0l8DJ;
						log.debug("    key: " + oesTB1z1.getKey() + ", value: " + oesTB1z1.getValue());
					}
				} else {
					log.debug("Action request map is empty");
				}
				log.debug("   Point #4.1 module '" + vW1VDTzY + "'");
				log.debug("   Point #4.2 action '" + G1seh31k + "'");
				log.debug("   Point #4.3 subAction '" + XkgYvalE + "'");
			}
			if (roe9w6W4.mod == null) {
				FK4mV9xc.setRenderParameter(MemberConstants.ERROR_TEXT,
						"Point #4.2. Module '" + vW1VDTzY + "' not found");
				return;
			}
			if (roe9w6W4.mod.getType() != null && roe9w6W4.mod.getType().getType() == ModuleTypeTypeType.LOOKUP_TYPE
					&& (roe9w6W4.getFromParam() == null || roe9w6W4.getFromParam().length() == 0)) {
				FK4mV9xc.setRenderParameter(MemberConstants.ERROR_TEXT,
						"Point #4.4. Module " + vW1VDTzY + " is lookup module");
				return;
			}
			int IykiSbhy = ContentTypeActionType.valueOf(G1seh31k).getType();
			if (log.isDebugEnabled()) {
				log.debug("action name " + G1seh31k);
				log.debug("ContentTypeActionType " + ContentTypeActionType.valueOf(G1seh31k).toString());
				log.debug("action type " + IykiSbhy);
			}
			roe9w6W4.content = MemberServiceClass.getContent(roe9w6W4.mod, IykiSbhy);
			if (roe9w6W4.content == null) {
				FK4mV9xc.setRenderParameter(MemberConstants.ERROR_TEXT,
						"Module: '" + vW1VDTzY + "', action '" + G1seh31k + "', not found");
				return;
			}
			if (log.isDebugEnabled()) {
				log.debug("Debug. Unmarshal sqlCache object");
				synchronized (syncFile) {
					XmlTools.writeToFile(roe9w6W4.content.getQueryArea().getSqlCache(),
							SiteUtils.getTempDir() + File.separatorChar + "member-content-site-start-0.xml",
							"windows-1251");
				}
			}
			if (!MemberServiceClass.checkRole(SLBweZZ7, roe9w6W4.content)) {
				FK4mV9xc.setRenderParameter(MemberConstants.ERROR_TEXT, "Access denied");
				return;
			}
			if (log.isDebugEnabled()) {
				log.debug("Unmarshal sqlCache object");
				synchronized (syncFile) {
					XmlTools.writeToFile(roe9w6W4.content.getQueryArea().getSqlCache(),
							SiteUtils.getTempDir() + File.separatorChar + "member-content-site-start-2.xml",
							"windows-1251");
				}
			}
			initRenderParameters(SLBweZZ7.getParameterMap(), FK4mV9xc);
			if ("commit".equalsIgnoreCase(XkgYvalE)) {
				DatabaseAdapter EvkaawAn = null;
				PreparedStatement QEovtpOG = null;
				try {
					EvkaawAn = roe9w6W4.getDatabaseAdapter();
					int oLh4Otis;
					switch (IykiSbhy) {
					case ContentTypeActionType.INSERT_TYPE:
						if (log.isDebugEnabled())
							log.debug("Start prepare data for inserting.");
						String V7BdS2qn = roe9w6W4.validateFields(EvkaawAn);
						if (log.isDebugEnabled())
							log.debug("Validating status - " + V7BdS2qn);
						if (V7BdS2qn != null) {
							WebmillErrorPage.setErrorInfo(FK4mV9xc, V7BdS2qn, MemberConstants.ERROR_TEXT, null,
									"Continue", MemberConstants.ERROR_URL_NAME);
							return;
						}
						if (log.isDebugEnabled()) {
							log.debug("Unmarshal sqlCache object");
							synchronized (syncFile) {
								XmlTools.writeToFile(roe9w6W4.content.getQueryArea().getSqlCache(),
										SiteUtils.getTempDir() + File.separatorChar + "member-content-before-yesno.xml",
										"windows-1251");
							}
						}
						if (log.isDebugEnabled())
							log.debug(
									"Start looking for field with type " + FieldsTypeJspTypeType.YES_1_NO_N.toString());
						if (MemberServiceClass.hasYesNoField(SLBweZZ7.getParameterMap(), roe9w6W4.mod,
								roe9w6W4.content)) {
							if (log.isDebugEnabled())
								log.debug("Found field with type " + FieldsTypeJspTypeType.YES_1_NO_N.toString());
							roe9w6W4.process_Yes_1_No_N_Fields(EvkaawAn);
						} else {
							if (log.isDebugEnabled())
								log.debug("Field with type " + FieldsTypeJspTypeType.YES_1_NO_N.toString()
										+ " not found");
						}
						String SXRsqzE4 = MemberServiceClass.buildInsertSQL(roe9w6W4.content, roe9w6W4.getFromParam(),
								roe9w6W4.mod, EvkaawAn, SLBweZZ7.getServerName(), roe9w6W4.getModuleManager(),
								roe9w6W4.authSession);
						if (log.isDebugEnabled()) {
							log.debug("insert SQL:\n" + SXRsqzE4 + "\n");
							log.debug("Unmarshal sqlCache object");
							synchronized (syncFile) {
								XmlTools.writeToFile(roe9w6W4.content.getQueryArea().getSqlCache(),
										SiteUtils.getTempDir() + File.separatorChar + "member-content.xml",
										"windows-1251");
							}
						}
						boolean susYvfQx = false;
						switch (EvkaawAn.getFamaly()) {
						case DatabaseManager.MYSQL_FAMALY:
							break;
						default:
							susYvfQx = roe9w6W4.checkRestrict();
							if (!susYvfQx)
								throw new ServletException("check status of restrict failed");
							break;
						}
						if (log.isDebugEnabled())
							log.debug("check status - " + susYvfQx);
						QEovtpOG = EvkaawAn.prepareStatement(SXRsqzE4);
						Object YzhwHhBs = roe9w6W4.bindInsert(EvkaawAn, QEovtpOG);
						oLh4Otis = QEovtpOG.executeUpdate();
						if (log.isDebugEnabled())
							log.debug("Number of inserter record - " + oLh4Otis);
						DatabaseManager.close(QEovtpOG);
						QEovtpOG = null;
						if (log.isDebugEnabled()) {
							outputDebugOfInsertStatus(roe9w6W4, EvkaawAn, YzhwHhBs);
						}
						roe9w6W4.prepareBigtextData(EvkaawAn, YzhwHhBs, false);
						for (int bYHwEODU = 0; bYHwEODU < roe9w6W4.mod.getRelateClassCount(); bYHwEODU++) {
							RelateClassType B59IGXuA = roe9w6W4.mod.getRelateClass(bYHwEODU);
							if (log.isDebugEnabled())
								log.debug("#7.003.003 terminate class " + B59IGXuA.getClassName());
							CacheFactory.terminate(B59IGXuA.getClassName(), null,
									Boolean.TRUE.equals(B59IGXuA.getIsFullReinitCache()));
						}
						break;
					case ContentTypeActionType.CHANGE_TYPE:
						if (log.isDebugEnabled())
							log.debug("Commit change page");
						V7BdS2qn = roe9w6W4.validateFields(EvkaawAn);
						if (V7BdS2qn != null) {
							WebmillErrorPage.setErrorInfo(FK4mV9xc, V7BdS2qn, MemberConstants.ERROR_TEXT, null,
									"Continue", MemberConstants.ERROR_URL_NAME);
							return;
						}
						if (MemberServiceClass.hasYesNoField(SLBweZZ7.getParameterMap(), roe9w6W4.mod,
								roe9w6W4.content)) {
							if (log.isDebugEnabled())
								log.debug("Found field with type " + FieldsTypeJspTypeType.YES_1_NO_N);
							roe9w6W4.process_Yes_1_No_N_Fields(EvkaawAn);
						}
						Object nunyHq5h;
						if (log.isDebugEnabled())
							log.debug("PrimaryKeyType " + roe9w6W4.content.getQueryArea().getPrimaryKeyType());
						switch (roe9w6W4.content.getQueryArea().getPrimaryKeyType().getType()) {
						case PrimaryKeyTypeType.NUMBER_TYPE:
							log.debug("PrimaryKeyType - 'number'");
							nunyHq5h = PortletService.getLong(SLBweZZ7,
									roe9w6W4.mod.getName() + '.' + roe9w6W4.content.getQueryArea().getPrimaryKey());
							break;
						case PrimaryKeyTypeType.STRING_TYPE:
							log.debug("PrimaryKeyType - 'string'");
							nunyHq5h = RequestTools.getString(SLBweZZ7,
									roe9w6W4.mod.getName() + '.' + roe9w6W4.content.getQueryArea().getPrimaryKey());
							break;
						default:
							throw new Exception("Change. Wrong type of primary key - "
									+ roe9w6W4.content.getQueryArea().getPrimaryKeyType());
						}
						if (log.isDebugEnabled())
							log.debug("mp.isSimpleField(): " + roe9w6W4.isSimpleField());
						if (roe9w6W4.isSimpleField()) {
							log.debug("start build SQL");
							SXRsqzE4 = MemberServiceClass.buildUpdateSQL(EvkaawAn, roe9w6W4.content,
									roe9w6W4.getFromParam(), roe9w6W4.mod, true, SLBweZZ7.getParameterMap(),
									SLBweZZ7.getRemoteUser(), SLBweZZ7.getServerName(), roe9w6W4.getModuleManager(),
									roe9w6W4.authSession);
							if (log.isDebugEnabled())
								log.debug("update SQL:" + SXRsqzE4);
							QEovtpOG = EvkaawAn.prepareStatement(SXRsqzE4);
							roe9w6W4.bindUpdate(EvkaawAn, QEovtpOG, nunyHq5h, true);
							oLh4Otis = QEovtpOG.executeUpdate();
							if (log.isDebugEnabled())
								log.debug("Number of updated record - " + oLh4Otis);
						}
						log.debug("prepare big text");
						roe9w6W4.prepareBigtextData(EvkaawAn, nunyHq5h, true);
						if (roe9w6W4.content.getQueryArea().getPrimaryKeyType()
								.getType() != PrimaryKeyTypeType.NUMBER_TYPE)
							throw new Exception("PK of 'Bigtext' table must be a 'number' type");
						log.debug("start sync cache data");
						for (int yjHQhQPv = 0; yjHQhQPv < roe9w6W4.mod.getRelateClassCount(); yjHQhQPv++) {
							RelateClassType fW5VbsnS = roe9w6W4.mod.getRelateClass(yjHQhQPv);
							if (log.isDebugEnabled())
								log.debug("#7.003.002 terminate class " + fW5VbsnS.getClassName() + ", id_rec "
										+ nunyHq5h);
							if (roe9w6W4.content.getQueryArea().getPrimaryKeyType()
									.getType() == PrimaryKeyTypeType.NUMBER_TYPE) {
								CacheFactory.terminate(fW5VbsnS.getClassName(), (Long) nunyHq5h,
										Boolean.TRUE.equals(fW5VbsnS.getIsFullReinitCache()));
							} else {
								FK4mV9xc.setRenderParameter(MemberConstants.ERROR_TEXT,
										"Change. Wrong type of primary key - "
												+ roe9w6W4.content.getQueryArea().getPrimaryKeyType());
								return;
							}
						}
						break;
					case ContentTypeActionType.DELETE_TYPE:
						log.debug("Commit delete page<br>");
						Object sbFTjZly;
						if (roe9w6W4.content.getQueryArea().getPrimaryKeyType()
								.getType() == PrimaryKeyTypeType.NUMBER_TYPE) {
							sbFTjZly = PortletService.getLong(SLBweZZ7,
									roe9w6W4.mod.getName() + '.' + roe9w6W4.content.getQueryArea().getPrimaryKey());
						} else if (roe9w6W4.content.getQueryArea().getPrimaryKeyType()
								.getType() == PrimaryKeyTypeType.STRING_TYPE) {
							sbFTjZly = RequestTools.getString(SLBweZZ7,
									roe9w6W4.mod.getName() + '.' + roe9w6W4.content.getQueryArea().getPrimaryKey());
						} else {
							FK4mV9xc.setRenderParameter(MemberConstants.ERROR_TEXT,
									"Delete. Wrong type of primary key - "
											+ roe9w6W4.content.getQueryArea().getPrimaryKeyType());
							return;
						}
						if (EvkaawAn.getFamaly() == DatabaseManager.MYSQL_FAMALY)
							roe9w6W4.deleteBigtextData(EvkaawAn, sbFTjZly);
						SXRsqzE4 = MemberServiceClass.buildDeleteSQL(EvkaawAn, roe9w6W4.mod, roe9w6W4.content,
								roe9w6W4.getFromParam(), SLBweZZ7.getParameterMap(), SLBweZZ7.getRemoteUser(),
								SLBweZZ7.getServerName(), ifvvgjnS, roe9w6W4.authSession);
						if (log.isDebugEnabled())
							log.debug("delete SQL: " + SXRsqzE4 + "<br>\n");
						QEovtpOG = EvkaawAn.prepareStatement(SXRsqzE4);
						roe9w6W4.bindDelete(QEovtpOG);
						oLh4Otis = QEovtpOG.executeUpdate();
						if (log.isDebugEnabled())
							log.debug("Number of deleted record - " + oLh4Otis);
						if (sbFTjZly != null && (sbFTjZly instanceof Long)) {
							for (int Xppt1a3E = 0; Xppt1a3E < roe9w6W4.mod.getRelateClassCount(); Xppt1a3E++) {
								RelateClassType TM9gYBIM = roe9w6W4.mod.getRelateClass(Xppt1a3E);
								if (log.isDebugEnabled())
									log.debug("#7.003.001 terminate class " + TM9gYBIM.getClassName() + ", id_rec "
											+ sbFTjZly.toString());
								CacheFactory.terminate(TM9gYBIM.getClassName(), (Long) sbFTjZly,
										Boolean.TRUE.equals(TM9gYBIM.getIsFullReinitCache()));
							}
						}
						break;
					default:
						FK4mV9xc.setRenderParameter(MemberConstants.ERROR_TEXT, "Unknown type of action - " + G1seh31k);
						return;
					}
					log.debug("do commit");
					EvkaawAn.commit();
				} catch (Exception MY8viUpS) {
					try {
						EvkaawAn.rollback();
					} catch (Exception wOr2ENXb) {
						log.info("error in rolback()");
					}
					log.error("Error while processing this page", MY8viUpS);
					if (EvkaawAn.testExceptionIndexUniqueKey(MY8viUpS)) {
						WebmillErrorPage.setErrorInfo(FK4mV9xc,
								"You input value already exists in DB. Try again with other value",
								MemberConstants.ERROR_TEXT, null, "Continue", MemberConstants.ERROR_URL_NAME);
					} else {
						WebmillErrorPage.setErrorInfo(FK4mV9xc, "Error while processing request",
								MemberConstants.ERROR_TEXT, MY8viUpS, "Continue", MemberConstants.ERROR_URL_NAME);
					}
				} finally {
					DatabaseManager.close(EvkaawAn, QEovtpOG);
				}
			}
		} catch (Exception gyEOoOuS) {
			final String WMIDOUWf = "General processing error ";
			log.error(WMIDOUWf, gyEOoOuS);
			throw new PortletException(WMIDOUWf, gyEOoOuS);
		} finally {
			if (roe9w6W4 != null) {
				roe9w6W4.destroy();
			}
		}
	}

}