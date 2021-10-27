class n11787058 {
	protected int authenticate(long DrQYdpT1, String ZdzQJY6p, String RvLKcAZT, String xAUeKO7l, Map l1r64cK3,
			Map Yk8dbgQQ) throws PortalException, SystemException {
		ZdzQJY6p = ZdzQJY6p.trim().toLowerCase();
		long XCmNSInd = GetterUtil.getLong(ZdzQJY6p);
		if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_EA)) {
			if (!Validator.isEmailAddress(ZdzQJY6p)) {
				throw new UserEmailAddressException();
			}
		} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_SN)) {
			if (Validator.isNull(ZdzQJY6p)) {
				throw new UserScreenNameException();
			}
		} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_ID)) {
			if (Validator.isNull(ZdzQJY6p)) {
				throw new UserIdException();
			}
		}
		if (Validator.isNull(RvLKcAZT)) {
			throw new UserPasswordException(UserPasswordException.PASSWORD_INVALID);
		}
		int EtOpWFxS = Authenticator.FAILURE;
		String[] zzLXu10c = PropsUtil.getArray(PropsUtil.AUTH_PIPELINE_PRE);
		if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_EA)) {
			EtOpWFxS = AuthPipeline.authenticateByEmailAddress(zzLXu10c, DrQYdpT1, ZdzQJY6p, RvLKcAZT, l1r64cK3,
					Yk8dbgQQ);
		} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_SN)) {
			EtOpWFxS = AuthPipeline.authenticateByScreenName(zzLXu10c, DrQYdpT1, ZdzQJY6p, RvLKcAZT, l1r64cK3,
					Yk8dbgQQ);
		} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_ID)) {
			EtOpWFxS = AuthPipeline.authenticateByUserId(zzLXu10c, DrQYdpT1, XCmNSInd, RvLKcAZT, l1r64cK3, Yk8dbgQQ);
		}
		User eHH9ykWF = null;
		try {
			if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_EA)) {
				eHH9ykWF = UserUtil.findByC_EA(DrQYdpT1, ZdzQJY6p);
			} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_SN)) {
				eHH9ykWF = UserUtil.findByC_SN(DrQYdpT1, ZdzQJY6p);
			} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_ID)) {
				eHH9ykWF = UserUtil.findByC_U(DrQYdpT1, GetterUtil.getLong(ZdzQJY6p));
			}
		} catch (NoSuchUserException n1GJ93So) {
			return Authenticator.DNE;
		}
		if (eHH9ykWF.isDefaultUser()) {
			_log.error("The default user should never be allowed to authenticate");
			return Authenticator.DNE;
		}
		if (!eHH9ykWF.isPasswordEncrypted()) {
			eHH9ykWF.setPassword(PwdEncryptor.encrypt(eHH9ykWF.getPassword()));
			eHH9ykWF.setPasswordEncrypted(true);
			UserUtil.update(eHH9ykWF);
		}
		checkLockout(eHH9ykWF);
		checkPasswordExpired(eHH9ykWF);
		if (EtOpWFxS == Authenticator.SUCCESS) {
			if (GetterUtil.getBoolean(PropsUtil.get(PropsUtil.AUTH_PIPELINE_ENABLE_LIFERAY_CHECK))) {
				String RRMBKOrF = PwdEncryptor.encrypt(RvLKcAZT, eHH9ykWF.getPassword());
				if (eHH9ykWF.getPassword().equals(RRMBKOrF)) {
					EtOpWFxS = Authenticator.SUCCESS;
				} else if (GetterUtil.getBoolean(PropsUtil.get(PropsUtil.AUTH_MAC_ALLOW))) {
					try {
						MessageDigest yjLcuAih = MessageDigest.getInstance(PropsUtil.get(PropsUtil.AUTH_MAC_ALGORITHM));
						yjLcuAih.update(ZdzQJY6p.getBytes("UTF8"));
						String urJZFqlP = PropsUtil.get(PropsUtil.AUTH_MAC_SHARED_KEY);
						RRMBKOrF = Base64.encode(yjLcuAih.digest(urJZFqlP.getBytes("UTF8")));
						if (RvLKcAZT.equals(RRMBKOrF)) {
							EtOpWFxS = Authenticator.SUCCESS;
						} else {
							EtOpWFxS = Authenticator.FAILURE;
						}
					} catch (NoSuchAlgorithmException OMwsGc1l) {
						throw new SystemException(OMwsGc1l);
					} catch (UnsupportedEncodingException xrD4Dp9c) {
						throw new SystemException(xrD4Dp9c);
					}
				} else {
					EtOpWFxS = Authenticator.FAILURE;
				}
			}
		}
		if (EtOpWFxS == Authenticator.SUCCESS) {
			String[] Gns8cMuC = PropsUtil.getArray(PropsUtil.AUTH_PIPELINE_POST);
			if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_EA)) {
				EtOpWFxS = AuthPipeline.authenticateByEmailAddress(Gns8cMuC, DrQYdpT1, ZdzQJY6p, RvLKcAZT, l1r64cK3,
						Yk8dbgQQ);
			} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_SN)) {
				EtOpWFxS = AuthPipeline.authenticateByScreenName(Gns8cMuC, DrQYdpT1, ZdzQJY6p, RvLKcAZT, l1r64cK3,
						Yk8dbgQQ);
			} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_ID)) {
				EtOpWFxS = AuthPipeline.authenticateByUserId(Gns8cMuC, DrQYdpT1, XCmNSInd, RvLKcAZT, l1r64cK3,
						Yk8dbgQQ);
			}
		}
		if (EtOpWFxS == Authenticator.FAILURE) {
			try {
				String[] Dq5cPOEK = PropsUtil.getArray(PropsUtil.AUTH_FAILURE);
				if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_EA)) {
					AuthPipeline.onFailureByEmailAddress(Dq5cPOEK, DrQYdpT1, ZdzQJY6p, l1r64cK3, Yk8dbgQQ);
				} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_SN)) {
					AuthPipeline.onFailureByScreenName(Dq5cPOEK, DrQYdpT1, ZdzQJY6p, l1r64cK3, Yk8dbgQQ);
				} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_ID)) {
					AuthPipeline.onFailureByUserId(Dq5cPOEK, DrQYdpT1, XCmNSInd, l1r64cK3, Yk8dbgQQ);
				}
				if (!PortalLDAPUtil.isPasswordPolicyEnabled(eHH9ykWF.getCompanyId())) {
					PasswordPolicy WCMSy4iv = eHH9ykWF.getPasswordPolicy();
					int gd0trstc = eHH9ykWF.getFailedLoginAttempts();
					int bwXJnTf6 = WCMSy4iv.getMaxFailure();
					if ((gd0trstc >= bwXJnTf6) && (bwXJnTf6 != 0)) {
						String[] FdxgpBPA = PropsUtil.getArray(PropsUtil.AUTH_MAX_FAILURES);
						if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_EA)) {
							AuthPipeline.onMaxFailuresByEmailAddress(FdxgpBPA, DrQYdpT1, ZdzQJY6p, l1r64cK3, Yk8dbgQQ);
						} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_SN)) {
							AuthPipeline.onMaxFailuresByScreenName(FdxgpBPA, DrQYdpT1, ZdzQJY6p, l1r64cK3, Yk8dbgQQ);
						} else if (xAUeKO7l.equals(CompanyImpl.AUTH_TYPE_ID)) {
							AuthPipeline.onMaxFailuresByUserId(FdxgpBPA, DrQYdpT1, XCmNSInd, l1r64cK3, Yk8dbgQQ);
						}
					}
				}
			} catch (Exception eowSLQ5W) {
				_log.error(eowSLQ5W, eowSLQ5W);
			}
		}
		return EtOpWFxS;
	}

}