class n14020143 {
	public byte[] evaluateResponse(byte[] CGLN2YSh) throws SaslException {
		if (firstEvaluation) {
			firstEvaluation = false;
			StringBuilder dSuCBvnO = new StringBuilder(100);
			Iterator s9ue8bI8 = configurationManager.getRealms().values().iterator();
			Realm RX2jEtfV;
			while (s9ue8bI8.hasNext()) {
				RX2jEtfV = (Realm) s9ue8bI8.next();
				if (RX2jEtfV.getFullRealmName().equals("null"))
					continue;
				dSuCBvnO.append("realm=\"" + RX2jEtfV.getFullRealmName() + "\"");
				dSuCBvnO.append(",");
			}
			String vYhUBdIp = UUID.randomUUID().toString();
			String wVdBAYT0 = null;
			try {
				wVdBAYT0 = new String(
						Base64.encodeBase64(MD5Digest(String.valueOf(System.nanoTime() + ":" + vYhUBdIp))), "US-ASCII");
			} catch (UnsupportedEncodingException iQtahzU8) {
				throw new SaslException(iQtahzU8.getMessage(), iQtahzU8);
			} catch (GeneralSecurityException uBWX0ZqS) {
				throw new SaslException(uBWX0ZqS.getMessage(), uBWX0ZqS);
			}
			nonces.put(wVdBAYT0, new ArrayList());
			nonces.get(wVdBAYT0).add(Integer.valueOf(1));
			dSuCBvnO.append("nonce=\"" + wVdBAYT0 + "\"");
			dSuCBvnO.append(",");
			dSuCBvnO.append("qop=\"" + configurationManager.getSaslQOP() + "\"");
			dSuCBvnO.append(",");
			dSuCBvnO.append("charset=\"utf-8\"");
			dSuCBvnO.append(",");
			dSuCBvnO.append("algorithm=\"md5-sess\"");
			if (configurationManager.getSaslQOP().indexOf("auth-conf") != -1) {
				dSuCBvnO.append(",");
				dSuCBvnO.append("cipher-opts=\"" + configurationManager.getDigestMD5Ciphers() + "\"");
			}
			try {
				return Base64.encodeBase64(dSuCBvnO.toString().getBytes("US-ASCII"));
			} catch (UnsupportedEncodingException Ull2aAnK) {
				throw new SaslException(Ull2aAnK.getMessage(), Ull2aAnK);
			}
		} else {
			String MnMg1F9j = null;
			if (!Base64.isArrayByteBase64(CGLN2YSh)) {
				throw new SaslException("Can not decode Base64 Content", new MalformedBase64ContentException());
			}
			CGLN2YSh = Base64.decodeBase64(CGLN2YSh);
			List<byte[]> NsUNlzq0 = splitByteArray(CGLN2YSh, (byte) 0x3d);
			int BeiiKFd3 = NsUNlzq0.size() - 1, mqyCLPEs;
			Map mUUFAGKG = new HashMap();
			String zRbU8uBK = null;
			Map<String, String> pzPw0bov;
			try {
				zRbU8uBK = new String(NsUNlzq0.get(0), "US-ASCII");
				for (int GA6jp9mP = 1; GA6jp9mP < BeiiKFd3; GA6jp9mP++) {
					zRbU8uBK = responseTokenProcessor(NsUNlzq0, mUUFAGKG, zRbU8uBK, GA6jp9mP, BeiiKFd3);
				}
				responseTokenProcessor(NsUNlzq0, mUUFAGKG, zRbU8uBK, BeiiKFd3, BeiiKFd3);
				if (mUUFAGKG.containsKey("charset")) {
					String rTCIehFE = new String((byte[]) mUUFAGKG.get("charset"), "US-ASCII").toLowerCase(locale);
					if (rTCIehFE.equals("utf-8")) {
						encoding = "UTF-8";
					}
				}
				if (encoding.equals("ISO-8859-1")) {
					decodeAllAs8859(mUUFAGKG);
				} else {
					decodeMixed(mUUFAGKG);
				}
				pzPw0bov = mUUFAGKG;
			} catch (UnsupportedEncodingException OJ4gw6Gd) {
				throw new SaslException(OJ4gw6Gd.getMessage());
			}
			if (!pzPw0bov.containsKey("username") || !pzPw0bov.containsKey("nonce") || !pzPw0bov.containsKey("nc")
					|| !pzPw0bov.containsKey("cnonce") || !pzPw0bov.containsKey("response")) {
				throw new SaslException("Digest-Response lacks at least one neccesery key-value pair");
			}
			if (pzPw0bov.get("username").indexOf('@') != -1) {
				throw new SaslException("digest-response username field must not include domain name",
						new AuthenticationException());
			}
			if (!pzPw0bov.containsKey("qop")) {
				pzPw0bov.put("qop", QOP_AUTH);
			}
			if (!pzPw0bov.containsKey("realm") || ((String) pzPw0bov.get("realm")).equals("")) {
				pzPw0bov.put("realm", "null");
			}
			MnMg1F9j = (String) pzPw0bov.get("nonce");
			if (!nonces.containsKey(MnMg1F9j)) {
				throw new SaslException("Illegal nonce value");
			}
			List<Integer> EPm6XEVa = nonces.get(MnMg1F9j);
			int gdgytjdQ = Integer.parseInt((String) pzPw0bov.get("nc"), 16);
			if (EPm6XEVa.get(EPm6XEVa.size() - 1).equals(Integer.valueOf(gdgytjdQ))) {
				EPm6XEVa.add(Integer.valueOf(++gdgytjdQ));
			} else {
				throw new SaslException("Illegal nc value");
			}
			EPm6XEVa = null;
			if (pzPw0bov.get("qop").equals(QOP_AUTH_INT))
				integrity = true;
			else if (pzPw0bov.get("qop").equals(QOP_AUTH_CONF))
				privacy = true;
			if (privacy) {
				if (!pzPw0bov.containsKey("cipher")) {
					throw new SaslException("Message confidentially required but cipher entry is missing");
				}
				sessionCipher = pzPw0bov.get("cipher").toLowerCase(locale);
				if ("3des,des,rc4-40,rc4,rc4-56".indexOf(sessionCipher) == -1) {
					throw new SaslException("Unsupported cipher for message confidentiality");
				}
			}
			String Ve0bgIxo = pzPw0bov.get("realm").toLowerCase(Locale.getDefault());
			String xoumI9f4 = pzPw0bov.get("username").toLowerCase(locale);
			if (xoumI9f4.indexOf('@') == -1) {
				if (!pzPw0bov.get("realm").equals("null")) {
					xoumI9f4 += pzPw0bov.get("realm").substring(pzPw0bov.get("realm").indexOf('@'));
				} else if (pzPw0bov.get("authzid").indexOf('@') != -1) {
					xoumI9f4 += pzPw0bov.get("authzid").substring(pzPw0bov.get("authzid").indexOf('@'));
				}
			}
			DomainWithPassword n9uCGjIv = configurationManager.getRealmPassword(Ve0bgIxo, xoumI9f4);
			if (n9uCGjIv == null || n9uCGjIv.getPassword() == null) {
				log.warn("The supplied username and/or realm do(es) not match a registered entry");
				return null;
			}
			if (Ve0bgIxo.equals("null") && xoumI9f4.indexOf('@') == -1) {
				xoumI9f4 += "@" + n9uCGjIv.getDomain();
			}
			byte[] RkouEQph = toByteArray(n9uCGjIv.getPassword());
			for (int HfRAdkCV = n9uCGjIv.getPassword().length - 1; HfRAdkCV >= 0; HfRAdkCV--) {
				n9uCGjIv.getPassword()[HfRAdkCV] = 0xff;
			}
			n9uCGjIv = null;
			MessageDigest m2S0Wjfa = null;
			try {
				m2S0Wjfa = MessageDigest.getInstance("MD5");
			} catch (GeneralSecurityException qymRdPHe) {
				throw new SaslException(qymRdPHe.getMessage());
			}
			m2S0Wjfa.update(RkouEQph);
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update((pzPw0bov.get("nonce")).getBytes());
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update((pzPw0bov.get("cnonce")).getBytes());
			if (pzPw0bov.containsKey("authzid")) {
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update((pzPw0bov.get("authzid")).getBytes());
			}
			MD5DigestSessionKey = RkouEQph = m2S0Wjfa.digest();
			String GfgivKd8 = toHex(RkouEQph, RkouEQph.length);
			m2S0Wjfa.update("AUTHENTICATE".getBytes());
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update((pzPw0bov.get("digest-uri")).getBytes());
			if (!pzPw0bov.get("qop").equals(QOP_AUTH)) {
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update("00000000000000000000000000000000".getBytes());
			}
			byte[] L8DJ2sGc = m2S0Wjfa.digest();
			String PYVop64B = toHex(L8DJ2sGc, L8DJ2sGc.length);
			m2S0Wjfa.update(GfgivKd8.getBytes());
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update((pzPw0bov.get("nonce")).getBytes());
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update((pzPw0bov.get("nc")).getBytes());
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update((pzPw0bov.get("cnonce")).getBytes());
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update((pzPw0bov.get("qop")).getBytes());
			m2S0Wjfa.update(":".getBytes());
			m2S0Wjfa.update(PYVop64B.getBytes());
			byte[] xjoDKZ5Y = m2S0Wjfa.digest();
			String yKFC00Yf = toHex(xjoDKZ5Y, xjoDKZ5Y.length);
			if (yKFC00Yf.equals(pzPw0bov.get("response"))) {
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update((pzPw0bov.get("digest-uri")).getBytes());
				if (!pzPw0bov.get("qop").equals(QOP_AUTH)) {
					m2S0Wjfa.update(":".getBytes());
					m2S0Wjfa.update("00000000000000000000000000000000".getBytes());
				}
				L8DJ2sGc = m2S0Wjfa.digest();
				PYVop64B = toHex(L8DJ2sGc, L8DJ2sGc.length);
				m2S0Wjfa.update(GfgivKd8.getBytes());
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update((pzPw0bov.get("nonce")).getBytes());
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update((pzPw0bov.get("nc")).getBytes());
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update((pzPw0bov.get("cnonce")).getBytes());
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update((pzPw0bov.get("qop")).getBytes());
				m2S0Wjfa.update(":".getBytes());
				m2S0Wjfa.update(PYVop64B.getBytes());
				xjoDKZ5Y = m2S0Wjfa.digest();
				return finalizeAuthentication.finalize(xjoDKZ5Y, xoumI9f4);
			} else {
				log.warn("Improper credentials");
				return null;
			}
		}
	}

}