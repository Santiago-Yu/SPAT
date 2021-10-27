class n564191 {
	private void processOrder() {
		double aROhVT8R = 0d;
		if (intMode == MODE_CHECKOUT) {
			if (round2Places(mBuf.getBufferTotal()) >= round2Places(order.getOrderTotal())) {
				double OzMW0Pot, AC8xEnRN, Z95Z3tx5 = 0d;
				Z95Z3tx5 = getStudentCredit();
				if (settings.get(DBSettings.MAIN_ALLOWNEGBALANCES).compareTo("1") == 0) {
					try {
						aROhVT8R = Double.parseDouble(settings.get(DBSettings.MAIN_MAXNEGBALANCE));
					} catch (NumberFormatException qudwpgB1) {
						System.err.println("NumberFormatException::Potential problem with setting MAIN_MAXNEGBALANCE");
						System.err.println("     * Note: If you enable negative balances, please don't leave this");
						System.err.println("             blank.  At least set it to 0.  For right now we are setting ");
						System.err.println("             the max negative balance to $0.00");
						System.err.println("");
						System.err.println("Exception Message:" + qudwpgB1.getMessage());
					}
					if (aROhVT8R < 0)
						aROhVT8R *= -1;
					Z95Z3tx5 += aROhVT8R;
				}
				if (round2Places(mBuf.getCredit()) <= round2Places(Z95Z3tx5)) {
					if (round2Places(mBuf.getCredit()) > round2Places(getStudentCredit()) && !student.isStudentSet()) {
						gui.setStatus("Can't allow negative balance on an anonymous student!", true);
					} else {
						if (round2Places(mBuf.getCredit()) > round2Places(order.getOrderTotal())) {
							AC8xEnRN = round2Places(order.getOrderTotal());
						} else {
							AC8xEnRN = round2Places(mBuf.getCredit());
						}
						if ((mBuf.getCash() + AC8xEnRN) >= order.getOrderTotal()) {
							OzMW0Pot = round2Places(order.getOrderTotal() - AC8xEnRN);
							double PxBWw2Vy = round2Places(mBuf.getCash() - OzMW0Pot);
							if (round2Places(OzMW0Pot + AC8xEnRN) == round2Places(order.getOrderTotal())) {
								Connection WXcZgJfG = null;
								Statement fijv8q6X = null;
								ResultSet CqwSEA5a = null;
								try {
									WXcZgJfG = dbMan.getPOSConnection();
									WXcZgJfG.setAutoCommit(false);
									fijv8q6X = WXcZgJfG.createStatement();
									String bOXooQtv = getHostName();
									String Bc4pt9i6 = student.getStudentNumber();
									String KCtHKa2j = settings.get(DBSettings.MAIN_BUILDING);
									String uArfhoUV = dbMan.getPOSUser();
									String UgngQBMr = "insert into " + strPOSPrefix
											+ "trans_master ( tm_studentid, tm_total, tm_cashtotal, tm_credittotal, tm_building, tm_register, tm_cashier, tm_datetime, tm_change ) values( '"
											+ Bc4pt9i6 + "', '" + round2Places(order.getOrderTotal()) + "', '"
											+ round2Places(OzMW0Pot) + "', '" + round2Places(AC8xEnRN) + "', '"
											+ KCtHKa2j + "', '" + bOXooQtv + "', '" + uArfhoUV + "', NOW(), '"
											+ round2Places(PxBWw2Vy) + "')";
									int oRv6pFyx = -1;
									int bAAXfLnd = -1;
									try {
										oRv6pFyx = fijv8q6X.executeUpdate(UgngQBMr, Statement.RETURN_GENERATED_KEYS);
										ResultSet xT7mrDVS = fijv8q6X.getGeneratedKeys();
										xT7mrDVS.next();
										bAAXfLnd = xT7mrDVS.getInt(1);
										xT7mrDVS.close();
										fijv8q6X.close();
									} catch (Exception vrC6qnjq) {
										System.err.println(
												vrC6qnjq.getMessage() + " (but pscafepos is attempting a work around)");
										oRv6pFyx = fijv8q6X.executeUpdate(UgngQBMr);
										bAAXfLnd = dbMan.getLastInsertIDWorkAround(fijv8q6X,
												strPOSPrefix + "trans_master_tm_id_seq");
										if (bAAXfLnd == -1)
											System.err.println(
													"It looks like the work around failed, please submit a bug report!");
										else
											System.err.println("work around was successful!");
									}
									if (oRv6pFyx == 1) {
										if (bAAXfLnd >= 0) {
											OrderItem[] Bm204hR0 = order.getOrderItems();
											if (Bm204hR0 != null && Bm204hR0.length > 0) {
												for (int Iee6LmHY = 0; Iee6LmHY < Bm204hR0.length; Iee6LmHY++) {
													if (Bm204hR0[Iee6LmHY] != null) {
														fijv8q6X = WXcZgJfG.createStatement();
														int dui2Oppe = Bm204hR0[Iee6LmHY].getDBID();
														double TIXLx6xJ = round2Places(
																Bm204hR0[Iee6LmHY].getEffectivePrice());
														int c0CUV7TZ, E3gzkW7d, HbQsIfuA;
														String ridKQRuM, ptC4539H, hFBWNI6X;
														c0CUV7TZ = 0;
														E3gzkW7d = 0;
														HbQsIfuA = 0;
														if (Bm204hR0[Iee6LmHY].isSoldAsFree()) {
															c0CUV7TZ = 1;
														}
														if (Bm204hR0[Iee6LmHY].isSoldAsReduced()) {
															E3gzkW7d = 1;
														}
														if (Bm204hR0[Iee6LmHY].isTypeA()) {
															HbQsIfuA = 1;
														}
														ridKQRuM = Bm204hR0[Iee6LmHY].getName();
														ptC4539H = (String) Bm204hR0[Iee6LmHY].getBuilding();
														hFBWNI6X = Bm204hR0[Iee6LmHY].getCategory();
														if (fijv8q6X.executeUpdate("insert into " + strPOSPrefix
																+ "trans_item ( ti_itemid, ti_tmid, ti_pricesold, ti_registerid, ti_cashier, ti_studentid, ti_isfree, ti_isreduced, ti_datetime, ti_istypea, ti_itemname, ti_itembuilding, ti_itemcat  ) values('"
																+ dui2Oppe + "', '" + bAAXfLnd + "', '"
																+ round2Places(TIXLx6xJ) + "', '" + bOXooQtv + "', '"
																+ uArfhoUV + "', '" + Bc4pt9i6 + "', '" + c0CUV7TZ
																+ "', '" + E3gzkW7d + "', NOW(), '" + HbQsIfuA + "', '"
																+ ridKQRuM + "', '" + ptC4539H + "', '" + hFBWNI6X
																+ "')") != 1) {
															gui.setCriticalMessage("Item insert failed");
															WXcZgJfG.rollback();
														}
														fijv8q6X.close();
														fijv8q6X = WXcZgJfG.createStatement();
														String dHCAYmm3 = "SELECT inv_id from " + strPOSPrefix
																+ "inventory where inv_menuid = " + dui2Oppe + "";
														if (fijv8q6X.execute(dHCAYmm3)) {
															ResultSet i5trUPjc = fijv8q6X.getResultSet();
															int KWfQzkO2 = -1;
															if (i5trUPjc.next()) {
																KWfQzkO2 = i5trUPjc.getInt("inv_id");
															}
															if (KWfQzkO2 != -1) {
																fijv8q6X.executeUpdate("delete from " + strPOSPrefix
																		+ "inventory where inv_id = " + KWfQzkO2);
															}
															fijv8q6X.close();
														}
													} else {
														gui.setCriticalMessage("Null Item");
														WXcZgJfG.rollback();
													}
												}
												boolean aWdC5DRY = true;
												if (round2Places(AC8xEnRN) > 0d) {
													if (round2Places(Z95Z3tx5) >= round2Places(AC8xEnRN)) {
														if (hasStudentCredit()) {
															fijv8q6X = WXcZgJfG.createStatement();
															if (fijv8q6X.executeUpdate("update " + strPOSPrefix
																	+ "studentcredit set credit_amount = credit_amount - "
																	+ round2Places(AC8xEnRN)
																	+ " where credit_active = '1' and credit_studentid = '"
																	+ Bc4pt9i6 + "'") == 1) {
																fijv8q6X.close();
																fijv8q6X = WXcZgJfG.createStatement();
																if (fijv8q6X.executeUpdate("update " + strPOSPrefix
																		+ "studentcredit set credit_lastused = NOW() where credit_active = '1' and credit_studentid = '"
																		+ Bc4pt9i6 + "'") == 1) {
																	fijv8q6X.close();
																	fijv8q6X = WXcZgJfG.createStatement();
																	if (fijv8q6X.executeUpdate("insert into "
																			+ strPOSPrefix
																			+ "studentcredit_log ( scl_studentid, scl_action, scl_transid, scl_datetime ) values( '"
																			+ Bc4pt9i6 + "', '"
																			+ round2Places((-1) * AC8xEnRN) + "', '"
																			+ bAAXfLnd + "', NOW() )") == 1) {
																		fijv8q6X.close();
																		aWdC5DRY = true;
																	} else {
																		gui.setCriticalMessage(
																				"Unable to update student credit log.");
																		aWdC5DRY = false;
																	}
																} else {
																	gui.setCriticalMessage(
																			"Unable to update student credit account.");
																	aWdC5DRY = false;
																}
															} else {
																gui.setCriticalMessage(
																		"Unable to update student credit account.");
																aWdC5DRY = false;
															}
														} else {
															fijv8q6X = WXcZgJfG.createStatement();
															if (fijv8q6X.executeUpdate("insert into " + strPOSPrefix
																	+ "studentcredit (credit_amount,credit_active,credit_studentid,credit_lastused) values('"
																	+ round2Places((-1) * AC8xEnRN) + "','1','"
																	+ Bc4pt9i6 + "', NOW())") == 1) {
																fijv8q6X.close();
																fijv8q6X = WXcZgJfG.createStatement();
																if (fijv8q6X.executeUpdate("insert into " + strPOSPrefix
																		+ "studentcredit_log ( scl_studentid, scl_action, scl_transid, scl_datetime ) values( '"
																		+ Bc4pt9i6 + "', '"
																		+ round2Places((-1) * AC8xEnRN) + "', '"
																		+ bAAXfLnd + "', NOW() )") == 1) {
																	fijv8q6X.close();
																	aWdC5DRY = true;
																} else {
																	gui.setCriticalMessage(
																			"Unable to update student credit log.");
																	aWdC5DRY = false;
																}
															} else {
																gui.setCriticalMessage(
																		"Unable to create new student credit account.");
																aWdC5DRY = false;
															}
														}
													} else {
														gui.setCriticalMessage("Student doesn't have enought credit.");
														aWdC5DRY = false;
													}
												}
												if (aWdC5DRY) {
													if (blDepositCredit && PxBWw2Vy > 0d) {
														try {
															if (doStudentCreditUpdate(PxBWw2Vy, Bc4pt9i6)) {
																PxBWw2Vy = 0d;
															} else
																aWdC5DRY = false;
														} catch (Exception fOCzxZve) {
															aWdC5DRY = false;
														}
													}
												}
												if (aWdC5DRY) {
													boolean sYLxhmUF = true;
													if (Bm204hR0 != null && Bm204hR0.length > 0) {
														for (int bvaRgZA5 = 0; bvaRgZA5 < Bm204hR0.length; bvaRgZA5++) {
															fijv8q6X = WXcZgJfG.createStatement();
															if (fijv8q6X.execute("select count(*) from " + strPOSPrefix
																	+ "hotbar where hb_itemid = '"
																	+ Bm204hR0[bvaRgZA5].getDBID()
																	+ "' and hb_building = '" + KCtHKa2j
																	+ "' and hb_register = '" + bOXooQtv
																	+ "' and hb_cashier = '" + uArfhoUV + "'")) {
																CqwSEA5a = fijv8q6X.getResultSet();
																CqwSEA5a.next();
																int v5ZUhDQS = CqwSEA5a.getInt(1);
																fijv8q6X.close();
																if (v5ZUhDQS == 1) {
																	fijv8q6X = WXcZgJfG.createStatement();
																	if (fijv8q6X.executeUpdate("update " + strPOSPrefix
																			+ "hotbar set hb_count = hb_count + 1 where hb_itemid = '"
																			+ Bm204hR0[bvaRgZA5].getDBID()
																			+ "' and hb_building = '" + KCtHKa2j
																			+ "' and hb_register = '" + bOXooQtv
																			+ "' and hb_cashier = '" + uArfhoUV
																			+ "'") != 1)
																		sYLxhmUF = false;
																} else {
																	fijv8q6X = WXcZgJfG.createStatement();
																	if (fijv8q6X.executeUpdate("insert into "
																			+ strPOSPrefix
																			+ "hotbar ( hb_itemid, hb_building, hb_register, hb_cashier, hb_count ) values( '"
																			+ Bm204hR0[bvaRgZA5].getDBID() + "', '"
																			+ KCtHKa2j + "', '" + bOXooQtv + "', '"
																			+ uArfhoUV + "', '1' )") != 1)
																		sYLxhmUF = false;
																}
																fijv8q6X.close();
															}
														}
													} else
														sYLxhmUF = false;
													if (sYLxhmUF) {
														WXcZgJfG.commit();
														gui.setStatus("Order Complete.");
														gui.disableUI();
														summary = new PSOrderSummary(gui);
														if (cashDrawer != null)
															cashDrawer.openDrawer();
														else
															summary.setPOSEventListener(this);
														summary.display(money.format(order.getOrderTotal()),
																money.format(mBuf.getCash()), money.format(AC8xEnRN),
																money.format(PxBWw2Vy),
																money.format(getStudentCredit()));
													} else {
														WXcZgJfG.rollback();
														gui.setStatus(
																"Failure during Hotbar update.  Transaction has been rolled back.",
																true);
													}
												} else {
													WXcZgJfG.rollback();
												}
											} else {
												gui.setCriticalMessage("Unable to fetch items.");
												WXcZgJfG.rollback();
											}
										} else {
											gui.setCriticalMessage("Unable to retrieve autoid");
											WXcZgJfG.rollback();
										}
									} else {
										gui.setCriticalMessage("Error During Writting of Transaction Master Record.");
										WXcZgJfG.rollback();
									}
								} catch (SQLException ln3nYweh) {
									System.err.println("SQLException: " + ln3nYweh.getMessage());
									System.err.println("SQLState: " + ln3nYweh.getSQLState());
									System.err.println("VendorError: " + ln3nYweh.getErrorCode());
									try {
										WXcZgJfG.rollback();
									} catch (SQLException K6GNxhtG) {
										System.err.println("Rollback failed: " + K6GNxhtG.getMessage());
									}
								} catch (Exception Xduzl1rd) {
									System.err.println("Exception: " + Xduzl1rd.getMessage());
									System.err.println(Xduzl1rd);
									try {
										WXcZgJfG.rollback();
									} catch (SQLException LNaHMDF2) {
										System.err.println("Rollback failed: " + LNaHMDF2.getMessage());
									}
								} finally {
									if (CqwSEA5a != null) {
										try {
											CqwSEA5a.close();
										} catch (SQLException tgEqvxVy) {
											CqwSEA5a = null;
										}
										if (fijv8q6X != null) {
											try {
												fijv8q6X.close();
											} catch (SQLException DTrmXQZh) {
												fijv8q6X = null;
											} catch (Exception GMVoTEpn) {
												System.err.println("Exception: " + GMVoTEpn.getMessage());
												System.err.println(GMVoTEpn);
											}
										}
									}
								}
							}
						} else {
							gui.setStatus("Credit total + Cash total is less then the order total! ", true);
						}
					}
				} else {
					if (settings.get(DBSettings.MAIN_ALLOWNEGBALANCES).compareTo("1") == 0) {
						gui.setStatus("Sorry, maximum negative balance is " + money.format(aROhVT8R) + "!", true);
					} else
						gui.setStatus("Student does not have enough credit to process this order.", true);
				}
			} else {
				gui.setStatus("Buffer total is less then the order total.", true);
			}
		}
	}

}