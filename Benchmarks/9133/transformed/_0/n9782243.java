class n9782243 {
	private void updateUser(AddEditUserForm jbLjT18y, HttpServletRequest NL77LFI7) throws Exception {
		Session Ct5HQqTY = HibernateUtil.currentSession();
		try {
			Transaction kCIzQjJG = Ct5HQqTY.beginTransaction();
			NvUsers sKSQP6VX = (NvUsers) Ct5HQqTY.load(NvUsers.class, jbLjT18y.getLogin());
			if (!jbLjT18y.getPassword().equalsIgnoreCase("")) {
				MessageDigest J25gTk9n = (MessageDigest) MessageDigest.getInstance("MD5").clone();
				J25gTk9n.update(jbLjT18y.getPassword().getBytes("UTF-8"));
				byte[] cZLsWYfQ = J25gTk9n.digest();
				StringBuffer qx4DhLkN = new StringBuffer();
				for (int NUckOf8l = 0; NUckOf8l < cZLsWYfQ.length; NUckOf8l++) {
					String x1rzGPMX = Integer.toHexString(cZLsWYfQ[NUckOf8l] & 0xFF);
					qx4DhLkN.append((x1rzGPMX.length() == 1) ? "0" + x1rzGPMX : x1rzGPMX);
				}
				sKSQP6VX.setPassword(qx4DhLkN.toString());
			}
			ActionErrors YK4FICit = new ActionErrors();
			HashMap aOA0pVy2 = jbLjT18y.getCustomAttrs();
			Query GRBDy9gv = Ct5HQqTY.createQuery("from org.nodevision.portal.hibernate.om.NvCustomAttrs as a");
			Iterator zcoHSNZI = GRBDy9gv.iterate();
			HashMap s7wcJ4Nw = new HashMap();
			while (zcoHSNZI.hasNext()) {
				NvCustomAttrs FCbcQShy = (NvCustomAttrs) zcoHSNZI.next();
				s7wcJ4Nw.put(FCbcQShy.getAttrName(), FCbcQShy.getAttrType());
				NvCustomValuesId cCWaMepQ = new NvCustomValuesId();
				cCWaMepQ.setNvUsers(sKSQP6VX);
				NvCustomValues KkdsNCP3 = new NvCustomValues();
				cCWaMepQ.setNvCustomAttrs(FCbcQShy);
				KkdsNCP3.setId(cCWaMepQ);
				if (FCbcQShy.getAttrType().equalsIgnoreCase("String")) {
					ByteArrayOutputStream K0U7S7kT = new ByteArrayOutputStream();
					ObjectOutputStream ST3BTjjO = new ObjectOutputStream(K0U7S7kT);
					ST3BTjjO.writeObject(aOA0pVy2.get(FCbcQShy.getAttrName()).toString());
					KkdsNCP3.setAttrValue(Hibernate.createBlob(K0U7S7kT.toByteArray()));
				} else if (FCbcQShy.getAttrType().equalsIgnoreCase("Boolean")) {
					Boolean YpeaO2D9 = Boolean.FALSE;
					if (aOA0pVy2.get(FCbcQShy.getAttrName()) != null) {
						YpeaO2D9 = Boolean.TRUE;
					}
					ByteArrayOutputStream pnTOGAbX = new ByteArrayOutputStream();
					ObjectOutputStream uFEZq1GH = new ObjectOutputStream(pnTOGAbX);
					uFEZq1GH.writeObject(YpeaO2D9);
					KkdsNCP3.setAttrValue(Hibernate.createBlob(pnTOGAbX.toByteArray()));
				} else if (FCbcQShy.getAttrType().equalsIgnoreCase("Date")) {
					Date RK5WxGyS = new Date(0);
					if (!aOA0pVy2.get(FCbcQShy.getAttrName()).toString().equalsIgnoreCase("")) {
						String sqCNmlnh = aOA0pVy2.get(FCbcQShy.getAttrName()).toString();
						SimpleDateFormat gFkJvDSx = new SimpleDateFormat("dd-MM-yyyy");
						RK5WxGyS = gFkJvDSx.parse(sqCNmlnh);
					}
					ByteArrayOutputStream bq8oYSJu = new ByteArrayOutputStream();
					ObjectOutputStream Km7XalVO = new ObjectOutputStream(bq8oYSJu);
					Km7XalVO.writeObject(RK5WxGyS);
					KkdsNCP3.setAttrValue(Hibernate.createBlob(bq8oYSJu.toByteArray()));
				}
				Ct5HQqTY.saveOrUpdate(KkdsNCP3);
				Ct5HQqTY.flush();
			}
			String GgJ8jdao = jbLjT18y.getUser_bdate();
			SimpleDateFormat m0gVWMIo = new SimpleDateFormat("dd-MM-yyyy");
			Date ZhieyhCr = m0gVWMIo.parse(GgJ8jdao);
			sKSQP6VX.setTimezone(jbLjT18y.getTimezone());
			sKSQP6VX.setLocale(jbLjT18y.getLocale());
			sKSQP6VX.setBdate(new BigDecimal(ZhieyhCr.getTime()));
			sKSQP6VX.setGender(jbLjT18y.getUser_gender());
			sKSQP6VX.setEmployer(jbLjT18y.getEmployer());
			sKSQP6VX.setDepartment(jbLjT18y.getDepartment());
			sKSQP6VX.setJobtitle(jbLjT18y.getJobtitle());
			sKSQP6VX.setNamePrefix(jbLjT18y.getName_prefix());
			sKSQP6VX.setNameGiven(jbLjT18y.getName_given());
			sKSQP6VX.setNameFamily(jbLjT18y.getName_famliy());
			sKSQP6VX.setNameMiddle(jbLjT18y.getName_middle());
			sKSQP6VX.setNameSuffix(jbLjT18y.getName_suffix());
			sKSQP6VX.setHomeName(jbLjT18y.getHome_name());
			sKSQP6VX.setHomeStreet(jbLjT18y.getHome_street());
			sKSQP6VX.setHomeStateprov(jbLjT18y.getHome_stateprov());
			sKSQP6VX.setHomePostalcode(jbLjT18y.getHome_postalcode().equalsIgnoreCase("") ? new Integer(0)
					: new Integer(jbLjT18y.getHome_postalcode()));
			sKSQP6VX.setHomeOrganization(jbLjT18y.getHome_organization_name());
			sKSQP6VX.setHomeCountry(jbLjT18y.getHome_country());
			sKSQP6VX.setHomeCity(jbLjT18y.getHome_city());
			sKSQP6VX.setHomePhoneIntcode((jbLjT18y.getHome_phone_intcode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_phone_intcode()));
			sKSQP6VX.setHomePhoneLoccode((jbLjT18y.getHome_phone_loccode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_phone_loccode()));
			sKSQP6VX.setHomePhoneNumber((jbLjT18y.getHome_phone_number().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_phone_number()));
			sKSQP6VX.setHomePhoneExt((jbLjT18y.getHome_phone_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_phone_ext()));
			sKSQP6VX.setHomePhoneComment(jbLjT18y.getHome_phone_commment());
			sKSQP6VX.setHomeFaxIntcode((jbLjT18y.getHome_fax_intcode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_fax_intcode()));
			sKSQP6VX.setHomeFaxLoccode((jbLjT18y.getHome_fax_loccode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_fax_loccode()));
			sKSQP6VX.setHomeFaxNumber((jbLjT18y.getHome_fax_number().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_fax_number()));
			sKSQP6VX.setHomeFaxExt((jbLjT18y.getHome_fax_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_fax_ext()));
			sKSQP6VX.setHomeFaxComment(jbLjT18y.getHome_fax_commment());
			sKSQP6VX.setHomeMobileIntcode((jbLjT18y.getHome_mobile_intcode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_mobile_intcode()));
			sKSQP6VX.setHomeMobileLoccode((jbLjT18y.getHome_mobile_loccode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_mobile_loccode()));
			sKSQP6VX.setHomeMobileNumber((jbLjT18y.getHome_mobile_number().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_mobile_number()));
			sKSQP6VX.setHomeMobileExt((jbLjT18y.getHome_mobile_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_mobile_ext()));
			sKSQP6VX.setHomeMobileComment(jbLjT18y.getHome_mobile_commment());
			sKSQP6VX.setHomePagerIntcode((jbLjT18y.getHome_pager_intcode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_pager_intcode()));
			sKSQP6VX.setHomePagerLoccode((jbLjT18y.getHome_pager_loccode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_pager_loccode()));
			sKSQP6VX.setHomePagerNumber((jbLjT18y.getHome_pager_number().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_pager_number()));
			sKSQP6VX.setHomePagerExt((jbLjT18y.getHome_pager_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getHome_pager_ext()));
			sKSQP6VX.setHomePagerComment(jbLjT18y.getHome_pager_commment());
			sKSQP6VX.setHomeUri(jbLjT18y.getHome_uri());
			sKSQP6VX.setHomeEmail(jbLjT18y.getHome_email());
			sKSQP6VX.setBusinessName(jbLjT18y.getBusiness_name());
			sKSQP6VX.setBusinessStreet(jbLjT18y.getBusiness_street());
			sKSQP6VX.setBusinessStateprov(jbLjT18y.getBusiness_stateprov());
			sKSQP6VX.setBusinessPostalcode((jbLjT18y.getBusiness_postalcode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_postalcode()));
			sKSQP6VX.setBusinessOrganization(jbLjT18y.getBusiness_organization_name());
			sKSQP6VX.setBusinessCountry(jbLjT18y.getBusiness_country());
			sKSQP6VX.setBusinessCity(jbLjT18y.getBusiness_city());
			sKSQP6VX.setBusinessPhoneIntcode(
					(jbLjT18y.getBusiness_phone_intcode().equalsIgnoreCase("")) ? new Integer(0)
							: Integer.valueOf(jbLjT18y.getBusiness_phone_intcode()));
			sKSQP6VX.setBusinessPhoneLoccode(
					(jbLjT18y.getBusiness_phone_loccode().equalsIgnoreCase("")) ? new Integer(0)
							: Integer.valueOf(jbLjT18y.getBusiness_phone_loccode()));
			sKSQP6VX.setBusinessPhoneNumber((jbLjT18y.getBusiness_phone_number().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_phone_number()));
			sKSQP6VX.setBusinessPhoneExt((jbLjT18y.getBusiness_phone_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_phone_ext()));
			sKSQP6VX.setBusinessPhoneComment(jbLjT18y.getBusiness_phone_commment());
			sKSQP6VX.setBusinessFaxIntcode((jbLjT18y.getBusiness_fax_intcode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_fax_intcode()));
			sKSQP6VX.setBusinessFaxLoccode((jbLjT18y.getBusiness_fax_loccode().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_fax_loccode()));
			sKSQP6VX.setBusinessFaxNumber((jbLjT18y.getBusiness_fax_number().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_fax_number()));
			sKSQP6VX.setBusinessFaxExt((jbLjT18y.getBusiness_fax_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_fax_ext()));
			sKSQP6VX.setBusinessFaxComment(jbLjT18y.getBusiness_fax_commment());
			sKSQP6VX.setBusinessMobileIntcode(
					(jbLjT18y.getBusiness_mobile_intcode().equalsIgnoreCase("")) ? new Integer(0)
							: Integer.valueOf(jbLjT18y.getBusiness_mobile_intcode()));
			sKSQP6VX.setBusinessMobileLoccode(
					(jbLjT18y.getBusiness_mobile_loccode().equalsIgnoreCase("")) ? new Integer(0)
							: Integer.valueOf(jbLjT18y.getBusiness_mobile_loccode()));
			sKSQP6VX.setBusinessMobileNumber(
					(jbLjT18y.getBusiness_mobile_number().equalsIgnoreCase("")) ? new Integer(0)
							: Integer.valueOf(jbLjT18y.getBusiness_mobile_number()));
			sKSQP6VX.setBusinessMobileExt((jbLjT18y.getBusiness_mobile_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_mobile_ext()));
			sKSQP6VX.setBusinessMobileComment(jbLjT18y.getBusiness_mobile_commment());
			sKSQP6VX.setBusinessPagerIntcode(
					(jbLjT18y.getBusiness_pager_intcode().equalsIgnoreCase("")) ? new Integer(0)
							: Integer.valueOf(jbLjT18y.getBusiness_pager_intcode()));
			sKSQP6VX.setBusinessPagerLoccode(
					(jbLjT18y.getBusiness_pager_loccode().equalsIgnoreCase("")) ? new Integer(0)
							: Integer.valueOf(jbLjT18y.getBusiness_pager_loccode()));
			sKSQP6VX.setBusinessPagerNumber((jbLjT18y.getBusiness_pager_number().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_pager_number()));
			sKSQP6VX.setBusinessPagerExt((jbLjT18y.getBusiness_pager_ext().equalsIgnoreCase("")) ? new Integer(0)
					: Integer.valueOf(jbLjT18y.getBusiness_pager_ext()));
			sKSQP6VX.setBusinessPagerComment(jbLjT18y.getBusiness_pager_commment());
			sKSQP6VX.setBusinessUri(jbLjT18y.getBusiness_uri());
			sKSQP6VX.setBusinessEmail(jbLjT18y.getBusiness_email());
			String KpIoL4Fa = "delete org.nodevision.portal.hibernate.om.NvUserRoles where login = :login";
			int f81jsBz4 = Ct5HQqTY.createQuery(KpIoL4Fa).setString("login", sKSQP6VX.getLogin()).executeUpdate();
			String[] dxjO34SC = jbLjT18y.getSelectedGroups();
			Set JWSn4e4e = new HashSet();
			for (int rG4bMo4L = 0; rG4bMo4L < dxjO34SC.length; rG4bMo4L++) {
				NvUserRolesId TZyxSAGk = new NvUserRolesId();
				TZyxSAGk.setNvUsers(sKSQP6VX);
				TZyxSAGk.setNvRoles((NvRoles) Ct5HQqTY.load(NvRoles.class, dxjO34SC[rG4bMo4L]));
				NvUserRoles mpCiHAf5 = new NvUserRoles();
				mpCiHAf5.setId(TZyxSAGk);
				JWSn4e4e.add(mpCiHAf5);
			}
			sKSQP6VX.setSetOfNvUserRoles(JWSn4e4e);
			Ct5HQqTY.update(sKSQP6VX);
			Ct5HQqTY.flush();
			if (!Ct5HQqTY.connection().getAutoCommit()) {
				kCIzQjJG.commit();
			}
		} finally {
			HibernateUtil.closeSession();
		}
	}

}