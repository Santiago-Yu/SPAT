class n564199 {
	private boolean doStudentCreditUpdate(Double ZH7OmSMa, String b8ewITPV) throws Exception {
		Connection V2PC1kcg = null;
		Statement XllUfLld = null;
		ResultSet kuBWA7Bk = null;
		Boolean dqO4FyJf = false;
		String y8KNOUER = "";
		try {
			V2PC1kcg = dbMan.getPOSConnection();
			V2PC1kcg.setAutoCommit(false);
			XllUfLld = V2PC1kcg.createStatement();
			String ldxnoRe0 = getHostName();
			String AAnU3UiB = student.getStudentNumber();
			String QOAykRic = settings.get(DBSettings.MAIN_BUILDING);
			String yAUHbAED = dbMan.getPOSUser();
			if (hasStudentCredit()) {
				XllUfLld = V2PC1kcg.createStatement();
				if (XllUfLld.executeUpdate("UPDATE " + strPOSPrefix
						+ "studentcredit set credit_amount = credit_amount + " + round2Places(ZH7OmSMa)
						+ " WHERE credit_active = '1' and credit_studentid = '" + AAnU3UiB + "'") == 1) {
					XllUfLld.close();
					XllUfLld = V2PC1kcg.createStatement();
					if (XllUfLld.executeUpdate("UPDATE " + strPOSPrefix
							+ "studentcredit set credit_lastused = NOW() where credit_active = '1' and credit_studentid = '"
							+ AAnU3UiB + "'") == 1) {
						XllUfLld.close();
						XllUfLld = V2PC1kcg.createStatement();
						if (XllUfLld.executeUpdate("INSERT into " + strPOSPrefix
								+ "studentcredit_log ( scl_studentid, scl_action, scl_datetime ) values( '" + AAnU3UiB
								+ "', '" + round2Places(ZH7OmSMa) + "', NOW() )") == 1) {
							XllUfLld.close();
							dqO4FyJf = true;
						} else {
							y8KNOUER = "Unable to update student credit log.";
							dqO4FyJf = false;
						}
					} else {
						y8KNOUER = "Unable to update student credit account.";
						dqO4FyJf = false;
					}
				} else {
					y8KNOUER = "Unable to update student credit account.";
					dqO4FyJf = false;
				}
			} else {
				XllUfLld = V2PC1kcg.createStatement();
				if (XllUfLld.executeUpdate("insert into " + strPOSPrefix
						+ "studentcredit (credit_amount,credit_active,credit_studentid,credit_lastused) values('"
						+ round2Places(ZH7OmSMa) + "','1','" + AAnU3UiB + "', NOW())") == 1) {
					XllUfLld.close();
					XllUfLld = V2PC1kcg.createStatement();
					if (XllUfLld.executeUpdate("insert into " + strPOSPrefix
							+ "studentcredit_log ( scl_studentid, scl_action, scl_datetime ) values( '" + AAnU3UiB
							+ "', '" + round2Places(ZH7OmSMa) + "', NOW() )") == 1) {
						XllUfLld.close();
						dqO4FyJf = true;
					} else {
						y8KNOUER = "Unable to update student credit log.";
						dqO4FyJf = false;
					}
				} else {
					y8KNOUER = "Unable to create new student credit account.";
					dqO4FyJf = false;
				}
			}
			if (dqO4FyJf) {
				XllUfLld = V2PC1kcg.createStatement();
				if (XllUfLld.executeUpdate("insert into " + strPOSPrefix
						+ "creditTrans ( ctStudentNumber, ctCreditAction, ctBuilding, ctRegister, ctUser, ctDateTime ) values( '"
						+ AAnU3UiB + "', '" + round2Places(ZH7OmSMa) + "', '" + QOAykRic + "', '" + ldxnoRe0 + "', '"
						+ yAUHbAED + "', NOW() )") == 1) {
					XllUfLld.close();
					dqO4FyJf = true;
				} else
					dqO4FyJf = false;
			}
			if (dqO4FyJf) {
				V2PC1kcg.commit();
				return true;
			} else {
				V2PC1kcg.rollback();
				throw new Exception("Error detected during credit adjustment!  " + y8KNOUER);
			}
		} catch (Exception duh007Qb) {
			try {
				V2PC1kcg.rollback();
			} catch (SQLException juPW0drE) {
				System.err.println("Rollback failed: " + juPW0drE.getMessage());
				return false;
			} finally {
				if (kuBWA7Bk != null) {
					try {
						kuBWA7Bk.close();
					} catch (SQLException BJObABZo) {
						kuBWA7Bk = null;
					}
					if (XllUfLld != null) {
						try {
							XllUfLld.close();
						} catch (SQLException sDfhF0XP) {
							XllUfLld = null;
						} catch (Exception MWlXu8OZ) {
							System.err.println("Exception: " + MWlXu8OZ.getMessage());
							System.err.println(MWlXu8OZ);
						}
					}
				}
			}
			duh007Qb.printStackTrace();
			throw new Exception("Error detected during credit adjustment: " + duh007Qb.getMessage());
		}
	}

}