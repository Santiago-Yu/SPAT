class n19695763 {
	private ContactModel convertJajahContactToContact(com.funambol.jajah.www.Contact jajahContact)
			throws JajahException {
		if (log.isTraceEnabled()) {
			log.trace("Converting Jajah contact to Foundation contact: Name:" + jajahContact.getName() + " Email:"
					+ jajahContact.getEmail());
		}
		String temp;
		try {
			Contact contact = new Contact();
			ContactModel contactModel;
			if (jajahContact.getName() != null && jajahContact.getName().equals("") == false) {
				if (log.isDebugEnabled()) {
					log.debug("NAME: " + jajahContact.getName());
				}
				contact.getName().getFirstName().setPropertyValue(jajahContact.getName());
			}
			if (jajahContact.getEmail() != null && jajahContact.getEmail().equals("") == false) {
				Email email1 = new Email();
				if (log.isDebugEnabled()) {
					log.debug("EMAIL1_ADDRESS: " + jajahContact.getEmail());
				}
				email1.setEmailType(SIFC.EMAIL1_ADDRESS);
				email1.setPropertyValue(jajahContact.getEmail());
				contact.getPersonalDetail().addEmail(email1);
			}
			if (jajahContact.getMobile() != null && jajahContact.getMobile().equals("") == false) {
				Phone phone = new Phone();
				if (log.isDebugEnabled()) {
					log.debug("MOBILE_TELEPHONE_NUMBER: " + jajahContact.getMobile());
				}
				phone.setPhoneType(SIFC.MOBILE_TELEPHONE_NUMBER);
				temp = jajahContact.getMobile().replace("-", "");
				if (!(temp.startsWith("+") || temp.startsWith("00")))
					temp = "+".concat(temp);
				phone.setPropertyValue(temp);
				contact.getPersonalDetail().addPhone(phone);
			}
			if (jajahContact.getLandline() != null && jajahContact.getLandline().equals("") == false) {
				Phone phone = new Phone();
				if (log.isDebugEnabled()) {
					log.debug("HOME_TELEPHONE_NUMBER: " + jajahContact.getLandline());
				}
				phone.setPhoneType(SIFC.HOME_TELEPHONE_NUMBER);
				temp = jajahContact.getLandline().replace("-", "");
				if (!(temp.startsWith("+") || temp.startsWith("00")))
					temp = "+".concat(temp);
				phone.setPropertyValue(temp);
				contact.getPersonalDetail().addPhone(phone);
			}
			if (jajahContact.getOffice() != null && jajahContact.getOffice().equals("") == false) {
				Phone phone = new Phone();
				if (log.isDebugEnabled()) {
					log.debug("BUSINESS_TELEPHONE_NUMBER: " + jajahContact.getOffice());
				}
				phone.setPhoneType(SIFC.BUSINESS_TELEPHONE_NUMBER);
				temp = jajahContact.getOffice().replace("-", "");
				if (!(temp.startsWith("+") || temp.startsWith("00")))
					temp = "+".concat(temp);
				phone.setPropertyValue(temp);
				contact.getBusinessDetail().addPhone(phone);
			}
			if (log.isDebugEnabled()) {
				log.debug("CONTACT_ID: " + jajahContact.getId());
			}
			ContactToSIFC convert = new ContactToSIFC(null, null);
			contactModel = new ContactModel(String.valueOf(jajahContact.getId()), contact);
			String sifObject = convert.convert(contactModel);
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(sifObject.getBytes());
			String md5Hash = (new BigInteger(m.digest())).toString();
			contactModel.setMd5Hash(md5Hash);
			return contactModel;
		} catch (Exception e) {
			throw new JajahException("JAJAH  - convertJajahContactToContact error: " + e.getMessage());
		}
	}

}