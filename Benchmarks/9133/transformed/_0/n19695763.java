class n19695763 {
	private ContactModel convertJajahContactToContact(com.funambol.jajah.www.Contact gIRHaaeA) throws JajahException {
		String LkwE30N2;
		if (log.isTraceEnabled()) {
			log.trace("Converting Jajah contact to Foundation contact: Name:" + gIRHaaeA.getName() + " Email:"
					+ gIRHaaeA.getEmail());
		}
		try {
			ContactModel eoK8belX;
			Contact kyblvsDT = new Contact();
			if (gIRHaaeA.getName() != null && gIRHaaeA.getName().equals("") == false) {
				if (log.isDebugEnabled()) {
					log.debug("NAME: " + gIRHaaeA.getName());
				}
				kyblvsDT.getName().getFirstName().setPropertyValue(gIRHaaeA.getName());
			}
			if (gIRHaaeA.getEmail() != null && gIRHaaeA.getEmail().equals("") == false) {
				if (log.isDebugEnabled()) {
					log.debug("EMAIL1_ADDRESS: " + gIRHaaeA.getEmail());
				}
				Email aaxZqeVJ = new Email();
				aaxZqeVJ.setEmailType(SIFC.EMAIL1_ADDRESS);
				aaxZqeVJ.setPropertyValue(gIRHaaeA.getEmail());
				kyblvsDT.getPersonalDetail().addEmail(aaxZqeVJ);
			}
			if (gIRHaaeA.getMobile() != null && gIRHaaeA.getMobile().equals("") == false) {
				if (log.isDebugEnabled()) {
					log.debug("MOBILE_TELEPHONE_NUMBER: " + gIRHaaeA.getMobile());
				}
				Phone wBwzPD9B = new Phone();
				wBwzPD9B.setPhoneType(SIFC.MOBILE_TELEPHONE_NUMBER);
				LkwE30N2 = gIRHaaeA.getMobile().replace("-", "");
				if (!(LkwE30N2.startsWith("+") || LkwE30N2.startsWith("00")))
					LkwE30N2 = "+".concat(LkwE30N2);
				wBwzPD9B.setPropertyValue(LkwE30N2);
				kyblvsDT.getPersonalDetail().addPhone(wBwzPD9B);
			}
			if (gIRHaaeA.getLandline() != null && gIRHaaeA.getLandline().equals("") == false) {
				if (log.isDebugEnabled()) {
					log.debug("HOME_TELEPHONE_NUMBER: " + gIRHaaeA.getLandline());
				}
				Phone akFBUSOk = new Phone();
				akFBUSOk.setPhoneType(SIFC.HOME_TELEPHONE_NUMBER);
				LkwE30N2 = gIRHaaeA.getLandline().replace("-", "");
				if (!(LkwE30N2.startsWith("+") || LkwE30N2.startsWith("00")))
					LkwE30N2 = "+".concat(LkwE30N2);
				akFBUSOk.setPropertyValue(LkwE30N2);
				kyblvsDT.getPersonalDetail().addPhone(akFBUSOk);
			}
			if (gIRHaaeA.getOffice() != null && gIRHaaeA.getOffice().equals("") == false) {
				if (log.isDebugEnabled()) {
					log.debug("BUSINESS_TELEPHONE_NUMBER: " + gIRHaaeA.getOffice());
				}
				Phone FNfSWYEd = new Phone();
				FNfSWYEd.setPhoneType(SIFC.BUSINESS_TELEPHONE_NUMBER);
				LkwE30N2 = gIRHaaeA.getOffice().replace("-", "");
				if (!(LkwE30N2.startsWith("+") || LkwE30N2.startsWith("00")))
					LkwE30N2 = "+".concat(LkwE30N2);
				FNfSWYEd.setPropertyValue(LkwE30N2);
				kyblvsDT.getBusinessDetail().addPhone(FNfSWYEd);
			}
			if (log.isDebugEnabled()) {
				log.debug("CONTACT_ID: " + gIRHaaeA.getId());
			}
			eoK8belX = new ContactModel(String.valueOf(gIRHaaeA.getId()), kyblvsDT);
			ContactToSIFC tBpUNyuw = new ContactToSIFC(null, null);
			String vH1QKnDJ = tBpUNyuw.convert(eoK8belX);
			MessageDigest x1BGvhep = MessageDigest.getInstance("MD5");
			x1BGvhep.update(vH1QKnDJ.getBytes());
			String lBUHFm9l = (new BigInteger(x1BGvhep.digest())).toString();
			eoK8belX.setMd5Hash(lBUHFm9l);
			return eoK8belX;
		} catch (Exception DMLgTLL1) {
			throw new JajahException("JAJAH  - convertJajahContactToContact error: " + DMLgTLL1.getMessage());
		}
	}

}