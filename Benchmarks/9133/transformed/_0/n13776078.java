class n13776078 {
	private GmailContact convertContactToGmailContact(Contact TVAORYhh) throws GmailManagerException {
		boolean IYrH8Ro3 = false, JjlYKnHx = false, emsuaTOW = false, sMwBjv8C = false, Y6LOdFyu = false;
		boolean ez4NxsDq = false, B8rrHgJK = false, EgyTwVd6 = false, xmm4aRcO = false, Bj8TbV3o = false;
		boolean Fdeu6pGy = false, dQsMoM1h = false;
		if (log.isTraceEnabled())
			log.trace("Converting Foundation contact to Gmail contact: Name:"
					+ TVAORYhh.getName().getFirstName().getPropertyValueAsString());
		try {
			GmailContact xFvO6129 = new GmailContact();
			xFvO6129.setId(TVAORYhh.getUid());
			Name isBEe7bY = TVAORYhh.getName();
			if (isBEe7bY != null)
				if (isBEe7bY.getFirstName() != null && isBEe7bY.getFirstName().getPropertyValueAsString() != null) {
					StringBuffer iuMLk6UX = new StringBuffer();
					iuMLk6UX.append(isBEe7bY.getFirstName().getPropertyValueAsString()).append(" ");
					if (isBEe7bY.getMiddleName() != null && isBEe7bY.getMiddleName().getPropertyValueAsString() != null)
						iuMLk6UX.append(isBEe7bY.getMiddleName().getPropertyValueAsString()).append(" ");
					if (isBEe7bY.getLastName() != null && isBEe7bY.getLastName().getPropertyValueAsString() != null)
						iuMLk6UX.append(isBEe7bY.getLastName().getPropertyValueAsString()).append(" ");
					if (log.isDebugEnabled())
						log.debug("NAME: " + iuMLk6UX.toString().trim());
					xFvO6129.setName(iuMLk6UX.toString().trim());
				}
			if (TVAORYhh.getPersonalDetail() != null) {
				if (TVAORYhh.getPersonalDetail().getEmails() != null
						&& TVAORYhh.getPersonalDetail().getEmails().size() > 0) {
					if (TVAORYhh.getPersonalDetail().getEmails().get(0) != null) {
						Email yf9eBpnu = (Email) TVAORYhh.getPersonalDetail().getEmails().get(0);
						if (yf9eBpnu.getPropertyValueAsString() != null
								&& yf9eBpnu.getPropertyValueAsString().equals("") == false) {
							if (log.isDebugEnabled())
								log.debug("EMAIL1: " + yf9eBpnu.getPropertyValueAsString());
							xFvO6129.setEmail(yf9eBpnu.getPropertyValueAsString());
						}
					}
					if (TVAORYhh.getPersonalDetail().getEmails().size() > 1
							&& TVAORYhh.getPersonalDetail().getEmails().get(1) != null) {
						Email KwM8cMEA = (Email) TVAORYhh.getPersonalDetail().getEmails().get(1);
						if (KwM8cMEA.getPropertyValueAsString() != null
								&& KwM8cMEA.getPropertyValueAsString().equals("") == false) {
							if (log.isDebugEnabled())
								log.debug("EMAIL2: " + KwM8cMEA.getPropertyValueAsString());
							xFvO6129.setEmail2(KwM8cMEA.getPropertyValueAsString());
						}
					}
				}
				Address LopLdOTp = TVAORYhh.getPersonalDetail().getAddress();
				if (LopLdOTp != null)
					if (LopLdOTp.getStreet() != null)
						if (LopLdOTp.getStreet().getPropertyValueAsString() != null) {
							StringBuffer Frv4y3By = new StringBuffer();
							Frv4y3By.append(LopLdOTp.getStreet().getPropertyValueAsString()).append(" ");
							Frv4y3By.append(LopLdOTp.getPostalCode().getPropertyValueAsString()).append(" ");
							Frv4y3By.append(LopLdOTp.getCity().getPropertyValueAsString()).append(" ");
							Frv4y3By.append(LopLdOTp.getState().getPropertyValueAsString()).append(" ");
							Frv4y3By.append(LopLdOTp.getCountry().getPropertyValueAsString());
							if (log.isDebugEnabled())
								log.debug("HOME_ADDRESS: " + Frv4y3By.toString());
							xFvO6129.setHomeAddress(Frv4y3By.toString());
						}
				Address Ut7bBWBP = TVAORYhh.getPersonalDetail().getOtherAddress();
				if (Ut7bBWBP != null)
					if (Ut7bBWBP.getStreet() != null)
						if (Ut7bBWBP.getStreet().getPropertyValueAsString() != null) {
							StringBuffer w46wFTfP = new StringBuffer();
							w46wFTfP.append(Ut7bBWBP.getStreet().getPropertyValueAsString()).append(" ");
							w46wFTfP.append(Ut7bBWBP.getPostalCode().getPropertyValueAsString()).append(" ");
							w46wFTfP.append(Ut7bBWBP.getCity().getPropertyValueAsString()).append(" ");
							w46wFTfP.append(Ut7bBWBP.getState().getPropertyValueAsString()).append(" ");
							w46wFTfP.append(Ut7bBWBP.getCountry().getPropertyValueAsString());
							if (log.isDebugEnabled())
								log.debug("OTHER_ADDRESS: " + w46wFTfP.toString());
							xFvO6129.setOtherAddress(w46wFTfP.toString());
						}
				if (TVAORYhh.getPersonalDetail().getPhones() != null
						&& TVAORYhh.getPersonalDetail().getPhones().size() > 0) {
					for (int niat0sp3 = 0; niat0sp3 < TVAORYhh.getPersonalDetail().getPhones().size(); niat0sp3++) {
						Phone xVNXpqkx = (Phone) TVAORYhh.getPersonalDetail().getPhones().get(niat0sp3);
						if (log.isDebugEnabled())
							log.debug("PERSONAL_PHONE: " + xVNXpqkx.getPropertyValueAsString() + " type:"
									+ xVNXpqkx.getPhoneType());
						if (xVNXpqkx.getPhoneType().equals(SIFC.HOME_TELEPHONE_NUMBER) && IYrH8Ro3 == false) {
							xFvO6129.setHomePhone(xVNXpqkx.getPropertyValueAsString());
							IYrH8Ro3 = true;
						} else if (xVNXpqkx.getPhoneType().equals(SIFC.HOME2_TELEPHONE_NUMBER) && JjlYKnHx == false) {
							xFvO6129.setHomePhone2(xVNXpqkx.getPropertyValueAsString());
							JjlYKnHx = true;
						} else if (xVNXpqkx.getPhoneType().equals(SIFC.HOME_FAX_NUMBER) && emsuaTOW == false) {
							xFvO6129.setHomeFax(xVNXpqkx.getPropertyValueAsString());
							emsuaTOW = true;
						} else if ((xVNXpqkx.getPhoneType().equals(SIFC.MOBILE_TELEPHONE_NUMBER)
								|| xVNXpqkx.getPhoneType().equals(SIFC.MOBILE_HOME_TELEPHONE_NUMBER))
								&& sMwBjv8C == false) {
							xFvO6129.setMobilePhone(xVNXpqkx.getPropertyValueAsString());
							sMwBjv8C = true;
						} else if (xVNXpqkx.getPhoneType().equals(SIFC.PAGER_NUMBER) && Y6LOdFyu == false) {
							xFvO6129.setPager(xVNXpqkx.getPropertyValueAsString());
							Y6LOdFyu = true;
						} else if (xVNXpqkx.getPhoneType().equals(SIFC.OTHER_TELEPHONE_NUMBER) && Fdeu6pGy == false) {
							xFvO6129.setOtherPhone(xVNXpqkx.getPropertyValueAsString());
							Fdeu6pGy = true;
						} else if (xVNXpqkx.getPhoneType().equals(SIFC.OTHER_FAX_NUMBER) && dQsMoM1h == false) {
							xFvO6129.setOtherFax(xVNXpqkx.getPropertyValueAsString());
							dQsMoM1h = true;
						} else {
							if (log.isDebugEnabled())
								log.debug("GOOGLE - Whoops - Personal Phones UNKNOWN TYPE:" + xVNXpqkx.getPhoneType()
										+ " VALUE:" + xVNXpqkx.getPropertyValueAsString());
						}
					}
				}
			}
			if (TVAORYhh.getBusinessDetail() != null) {
				if (TVAORYhh.getBusinessDetail().getEmails() != null
						&& TVAORYhh.getBusinessDetail().getEmails().size() > 0) {
					if (TVAORYhh.getBusinessDetail().getEmails().get(0) != null) {
						Email Naaoo6Lz = (Email) TVAORYhh.getBusinessDetail().getEmails().get(0);
						if (Naaoo6Lz.getPropertyValueAsString() != null
								&& Naaoo6Lz.getPropertyValueAsString().equals("") == false) {
							if (log.isDebugEnabled())
								log.debug("EMAIL3: " + Naaoo6Lz.getPropertyValueAsString());
							xFvO6129.setEmail3(Naaoo6Lz.getPropertyValueAsString());
						}
					}
				}
				Address bYGGGF6i = TVAORYhh.getBusinessDetail().getAddress();
				if (bYGGGF6i != null)
					if (bYGGGF6i.getStreet() != null)
						if (bYGGGF6i.getStreet().getPropertyValueAsString() != null) {
							StringBuffer fIPSTMa4 = new StringBuffer();
							fIPSTMa4.append(bYGGGF6i.getStreet().getPropertyValueAsString()).append(" ");
							fIPSTMa4.append(bYGGGF6i.getPostalCode().getPropertyValueAsString()).append(" ");
							fIPSTMa4.append(bYGGGF6i.getCity().getPropertyValueAsString()).append(" ");
							fIPSTMa4.append(bYGGGF6i.getState().getPropertyValueAsString()).append(" ");
							fIPSTMa4.append(bYGGGF6i.getCountry().getPropertyValueAsString());
							if (log.isDebugEnabled())
								log.debug("BUSINESS_ADDRESS: " + fIPSTMa4.toString());
							xFvO6129.setBusinessAddress(fIPSTMa4.toString());
						}
				if (TVAORYhh.getBusinessDetail().getPhones() != null
						&& TVAORYhh.getBusinessDetail().getPhones().size() > 0) {
					for (int CChQoCsV = 0; CChQoCsV < TVAORYhh.getBusinessDetail().getPhones().size(); CChQoCsV++) {
						Phone foSvHiyB = (Phone) TVAORYhh.getBusinessDetail().getPhones().get(CChQoCsV);
						if (log.isDebugEnabled())
							log.debug("BUSINESS_PHONE: " + foSvHiyB.getPropertyValueAsString() + " type:"
									+ foSvHiyB.getPhoneType());
						if (foSvHiyB.getPhoneType().equals(SIFC.BUSINESS_TELEPHONE_NUMBER) && ez4NxsDq == false) {
							xFvO6129.setBusinessPhone(foSvHiyB.getPropertyValueAsString());
							ez4NxsDq = true;
						} else if (foSvHiyB.getPhoneType().equals(SIFC.BUSINESS2_TELEPHONE_NUMBER)
								&& B8rrHgJK == false) {
							xFvO6129.setBusinessPhone2(foSvHiyB.getPropertyValueAsString());
							B8rrHgJK = true;
						} else if (foSvHiyB.getPhoneType().equals(SIFC.BUSINESS_FAX_NUMBER) && EgyTwVd6 == false) {
							xFvO6129.setBusinessFax(foSvHiyB.getPropertyValueAsString());
							EgyTwVd6 = true;
						} else if (foSvHiyB.getPhoneType().equals(SIFC.MOBILE_BUSINESS_TELEPHONE_NUMBER)
								&& sMwBjv8C == false && xmm4aRcO == false) {
							xFvO6129.setMobilePhone(foSvHiyB.getPropertyValueAsString());
							xmm4aRcO = true;
						} else if (foSvHiyB.getPhoneType().equals(SIFC.PAGER_NUMBER) && Y6LOdFyu == false
								&& Bj8TbV3o == false) {
							xFvO6129.setPager(foSvHiyB.getPropertyValueAsString());
							Bj8TbV3o = true;
						} else {
							if (log.isDebugEnabled())
								log.debug("GOOGLE - Whoops - Business Phones UNKNOWN TYPE:" + foSvHiyB.getPhoneType()
										+ " VALUE:" + foSvHiyB.getPropertyValueAsString());
						}
					}
				}
				if (TVAORYhh.getBusinessDetail().getCompany() != null)
					if (TVAORYhh.getBusinessDetail().getCompany().getPropertyValueAsString() != null) {
						if (log.isDebugEnabled())
							log.debug(
									"COMPANY: " + TVAORYhh.getBusinessDetail().getCompany().getPropertyValueAsString());
						xFvO6129.setCompany(TVAORYhh.getBusinessDetail().getCompany().getPropertyValueAsString());
					}
				if (TVAORYhh.getBusinessDetail().getTitles() != null
						&& TVAORYhh.getBusinessDetail().getTitles().size() > 0) {
					if (TVAORYhh.getBusinessDetail().getTitles().get(0) != null) {
						Title nFv3K3nk = (Title) TVAORYhh.getBusinessDetail().getTitles().get(0);
						if (log.isDebugEnabled())
							log.debug("TITLE: " + nFv3K3nk.getPropertyValueAsString());
						xFvO6129.setJobTitle(nFv3K3nk.getPropertyValueAsString());
					}
				}
			}
			if (TVAORYhh.getNotes() != null && TVAORYhh.getNotes().size() > 0) {
				if (TVAORYhh.getNotes().get(0) != null) {
					Note uSKRdO12 = (Note) TVAORYhh.getNotes().get(0);
					if (uSKRdO12.getPropertyValueAsString() != null
							&& uSKRdO12.getPropertyValueAsString().equals("") == false) {
						if (log.isDebugEnabled())
							log.debug("NOTES: " + uSKRdO12.getPropertyValueAsString());
						xFvO6129.setNotes(uSKRdO12.getPropertyValueAsString());
					}
				}
			}
			MessageDigest EKCwP4rH = MessageDigest.getInstance("MD5");
			EKCwP4rH.update(TVAORYhh.toString().getBytes());
			xFvO6129.setMd5Hash(new BigInteger(EKCwP4rH.digest()).toString());
			return xFvO6129;
		} catch (Exception mpupL7Za) {
			throw new GmailManagerException(
					"GOOGLE Gmail - convertContactToGmailContact error: " + mpupL7Za.getMessage());
		}
	}

}