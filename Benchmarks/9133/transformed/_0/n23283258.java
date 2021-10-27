class n23283258 {
	public String login(HttpSession nL8hobHK, String mxlJzQo6, String pVGN84Nl) {
		String RT6P0fyr = null;
		String EbfCehWz = null;
		int Q9BuvRMa = 0;
		HashSet<Integer> sIrPbvva = new HashSet<Integer>();
		boolean lzAMyLhd = false;
		String K0WM0g0h = (String) em.createNamedQuery("getCustomerPasswordByUsername")
				.setParameter("username", mxlJzQo6).getSingleResult();
		if (K0WM0g0h.equals(pVGN84Nl)) {
			CustomerElement NafV1s16 = (CustomerElement) em.createNamedQuery("getCustomerByUsername")
					.setParameter("username", mxlJzQo6).getSingleResult();
			EbfCehWz = NafV1s16.getName();
			Q9BuvRMa = NafV1s16.getTimeout();
			String[] neGvooM4 = NafV1s16.getTileProvideridsArray();
			for (String VtJonv90 : neGvooM4)
				sIrPbvva.add(Integer.parseInt(VtJonv90));
			lzAMyLhd = true;
		}
		if (lzAMyLhd) {
			RT6P0fyr = SessionHandler.getInstance().alreadyGotValidSession(EbfCehWz);
			if (RT6P0fyr == null) {
				Random Pal6PLq6 = new Random();
				RT6P0fyr = nL8hobHK.getId() + new Date().getTime() + Pal6PLq6.nextLong();
				MessageDigest O8Su8LQl = null;
				try {
					O8Su8LQl = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException TK1WMOIV) {
					logger.error("Unable to digest the token.", TK1WMOIV);
				}
				O8Su8LQl.update(RT6P0fyr.getBytes());
				byte[] eO4jW3tA = O8Su8LQl.digest();
				StringBuffer H7G1vRPu = new StringBuffer();
				for (int lMyRPgZR = 0; lMyRPgZR < eO4jW3tA.length; ++lMyRPgZR) {
					int GuM4rOly = eO4jW3tA[lMyRPgZR] & 0xFF;
					if (GuM4rOly < 0x10)
						H7G1vRPu.append('0');
					H7G1vRPu.append(Integer.toHexString(GuM4rOly));
				}
				RT6P0fyr = H7G1vRPu.toString();
				SessionHandler.getInstance().registerValidSession(RT6P0fyr, EbfCehWz, Q9BuvRMa, sIrPbvva);
			}
		}
		return RT6P0fyr;
	}

}