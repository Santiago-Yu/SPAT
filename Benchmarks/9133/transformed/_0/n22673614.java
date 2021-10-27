class n22673614 {
	@SuppressWarnings("unchecked")
	private int syncCustomers() throws RemoteException, BasicException {
		dlintegration.syncCustomersBefore();
		ArrayList<String> nDpN2Ry3 = new ArrayList<String>();
		int Xt0dbx2k = 0;
		User[] lbz7Y8h0;
		int De0FLf4z = 0;
		do {
			lbz7Y8h0 = externalsales.getUsersBySteps(Xt0dbx2k);
			Xt0dbx2k++;
			if (lbz7Y8h0 == null) {
				throw new BasicException(AppLocal.getIntString("message.returnnull") + " > Customers null");
			}
			if (lbz7Y8h0.length > 0) {
				String O8gxQEk8;
				for (User qWMRpPQM : lbz7Y8h0) {
					if (nDpN2Ry3.contains(qWMRpPQM.getLogin()))
						continue;
					De0FLf4z++;
					String QoHwqZK3 = externalsales
							.encodeString((qWMRpPQM.getFirstname().trim() + " " + qWMRpPQM.getLastname()).trim());
					String qvQKKnaf = externalsales.encodeString(qWMRpPQM.getFirstname());
					String pNC02i6M = externalsales.encodeString(qWMRpPQM.getLastname());
					String zk4QGZKU = externalsales.encodeString(qWMRpPQM.getDescription());
					String HtITIyh9 = externalsales.encodeString(qWMRpPQM.getAddress());
					String TaDX9o1L = externalsales.encodeString(qWMRpPQM.getAddress2());
					String ivJLbefn = externalsales.encodeString(qWMRpPQM.getCity());
					String rATCTwgH = externalsales.encodeString(qWMRpPQM.getCountry());
					String StheUDJw = externalsales.encodeString(qWMRpPQM.getPhone());
					String EmVxPG4r = externalsales.encodeString(qWMRpPQM.getMobile());
					String oBQRIIEy = externalsales.encodeString(qWMRpPQM.getZipcode());
					CustomerSync VTztw0sg = new CustomerSync(qWMRpPQM.getId());
					if (qvQKKnaf == null || qvQKKnaf.equals(""))
						qvQKKnaf = " ";
					VTztw0sg.setFirstname(qvQKKnaf.toUpperCase());
					if (pNC02i6M == null || pNC02i6M.equals(""))
						pNC02i6M = " ";
					VTztw0sg.setLastname(pNC02i6M.toUpperCase());
					VTztw0sg.setTaxid(qWMRpPQM.getLogin());
					VTztw0sg.setSearchkey(qWMRpPQM.getLogin() + QoHwqZK3.toUpperCase());
					if (QoHwqZK3 == null || QoHwqZK3.equals(""))
						QoHwqZK3 = " ";
					VTztw0sg.setName(QoHwqZK3.toUpperCase());
					if (zk4QGZKU == null || zk4QGZKU.equals(""))
						zk4QGZKU = " ";
					VTztw0sg.setNotes(zk4QGZKU);
					VTztw0sg.setEmail(qWMRpPQM.getEmail());
					if (HtITIyh9 == null || HtITIyh9.equals(""))
						HtITIyh9 = " ";
					VTztw0sg.setAddress(HtITIyh9);
					if (TaDX9o1L == null || TaDX9o1L.equals(""))
						TaDX9o1L = " ";
					VTztw0sg.setAddress2(TaDX9o1L);
					if (ivJLbefn == null || ivJLbefn.equals(""))
						ivJLbefn = "Brussels";
					VTztw0sg.setCity(ivJLbefn);
					if (rATCTwgH == null || rATCTwgH.equals(""))
						rATCTwgH = "Belgium";
					VTztw0sg.setCountry(rATCTwgH);
					VTztw0sg.setMaxdebt(10000.0);
					if (StheUDJw == null || StheUDJw.equals(""))
						StheUDJw = " ";
					VTztw0sg.setPhone(StheUDJw);
					if (EmVxPG4r == null || EmVxPG4r.equals(""))
						EmVxPG4r = " ";
					VTztw0sg.setPhone2(EmVxPG4r);
					if (oBQRIIEy == null || oBQRIIEy.equals(""))
						oBQRIIEy = " ";
					VTztw0sg.setPostal(oBQRIIEy);
					if (TicketInfo.isWS() && TicketInfo.getPayID() == 2
							&& qWMRpPQM.getEmail().contains("@DONOTSENDME")) {
						nDpN2Ry3.add(VTztw0sg.getTaxid());
						continue;
					}
					dlintegration.syncCustomer(VTztw0sg);
					nDpN2Ry3.add(VTztw0sg.getTaxid());
				}
			}
		} while (lbz7Y8h0.length > 0);
		List<CustomerSync> TdSJsFQP = dlintegration.getCustomers();
		SimpleDateFormat AnnDQfLg = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (CustomerSync zeprwThw : TdSJsFQP) {
			Date lcIJ7UVo = new Date();
			if (nDpN2Ry3.contains(zeprwThw.getTaxid())) {
				continue;
			}
			De0FLf4z++;
			User PbI28pK9 = new User();
			PbI28pK9.setLogin(zeprwThw.getTaxid());
			PbI28pK9.setId(zeprwThw.getTaxid());
			PbI28pK9.setFirstname(" ");
			String DAiV4zOe = zeprwThw.getName().trim();
			DAiV4zOe = DAiV4zOe.replace("'", "");
			while (DAiV4zOe.charAt(0) == ' ') {
				DAiV4zOe = DAiV4zOe.substring(1);
			}
			PbI28pK9.setLastname(DAiV4zOe);
			char[] qq8RUZgC = new char[8];
			int p1pfw3er = 'A';
			int J81qzXsp = 0;
			for (int hJrTDUAW = 0; hJrTDUAW < 8; hJrTDUAW++) {
				J81qzXsp = (int) (Math.random() * 3);
				switch (J81qzXsp) {
				case 0:
					p1pfw3er = '0' + (int) (Math.random() * 10);
					break;
				case 1:
					p1pfw3er = 'a' + (int) (Math.random() * 26);
					break;
				case 2:
					p1pfw3er = 'A' + (int) (Math.random() * 26);
					break;
				}
				qq8RUZgC[hJrTDUAW] = (char) p1pfw3er;
			}
			String IKmuRHhE = new String(qq8RUZgC);
			byte[] UeEJTs99 = { 00 };
			try {
				MessageDigest Xu1JVzSO = MessageDigest.getInstance("MD5");
				Xu1JVzSO.update(IKmuRHhE.getBytes());
				UeEJTs99 = Xu1JVzSO.digest();
				PbI28pK9.setPassword(UeEJTs99.toString());
			} catch (NoSuchAlgorithmException zUjDwxco) {
				Logger.getLogger(UsersSync.class.getName()).log(Level.SEVERE, null, zUjDwxco);
				PbI28pK9.setPassword(IKmuRHhE);
			}
			PbI28pK9.setTitle("M");
			if (zeprwThw.getEmail() == null || zeprwThw.getEmail().trim().equals("")
					|| zeprwThw.getEmail().indexOf('@') <= 0)
				PbI28pK9.setEmail(zeprwThw.getTaxid() + defaultEmail);
			else
				PbI28pK9.setEmail(zeprwThw.getEmail());
			PbI28pK9.setDescription(zeprwThw.getNotes() + "");
			PbI28pK9.setAddress(zeprwThw.getAddress() + "");
			PbI28pK9.setAddress2(zeprwThw.getAddress2() + "");
			PbI28pK9.setState_region(zeprwThw.getRegion() + "");
			PbI28pK9.setCity(zeprwThw.getCity() + "");
			PbI28pK9.setCountry(zeprwThw.getCountry() + "");
			PbI28pK9.setZipcode(zeprwThw.getPostal() + "");
			PbI28pK9.setPhone(zeprwThw.getPhone() + "");
			PbI28pK9.setMobile(zeprwThw.getPhone2() + "");
			PbI28pK9.setFax(" ");
			try {
				PbI28pK9.setCdate(AnnDQfLg.format(zeprwThw.getCurdate()));
			} catch (NullPointerException cQQcE2E0) {
				PbI28pK9.setCdate(AnnDQfLg.format(lcIJ7UVo));
			}
			PbI28pK9.setPerms("shopper");
			PbI28pK9.setBank_account_nr("");
			PbI28pK9.setBank_account_holder("");
			PbI28pK9.setBank_account_type("");
			PbI28pK9.setBank_iban("");
			PbI28pK9.setBank_name("");
			PbI28pK9.setBank_sort_code("");
			PbI28pK9.setMdate(AnnDQfLg.format(lcIJ7UVo));
			PbI28pK9.setShopper_group_id("1");
			externalsales.addUser(PbI28pK9);
		}
		return De0FLf4z;
	}

}