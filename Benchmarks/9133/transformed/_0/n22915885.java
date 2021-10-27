class n22915885 {
	public Login authenticateClient() {
		Object BLKXo27e;
		String yMgdY6Qz, OTGds0jf;
		Vector<Login> AK1SBWDi = ClientLoginsTableModel.getClientLogins();
		Login Yd0uHBP1 = null;
		try {
			socket.setSoTimeout(25000);
			objectOut.writeObject("JFRITZ SERVER 1.1");
			objectOut.flush();
			BLKXo27e = objectIn.readObject();
			if (BLKXo27e instanceof String) {
				yMgdY6Qz = (String) BLKXo27e;
				objectOut.flush();
				for (Login bRGVLOiW : AK1SBWDi) {
					if (bRGVLOiW.getUser().equals(yMgdY6Qz)) {
						Yd0uHBP1 = bRGVLOiW;
						break;
					}
				}
				if (Yd0uHBP1 != null) {
					MessageDigest umq2FUXR = MessageDigest.getInstance("MD5");
					umq2FUXR.update(Yd0uHBP1.getPassword().getBytes());
					DESKeySpec jEz32rYr = new DESKeySpec(umq2FUXR.digest());
					SecretKeyFactory odEqGRO1 = SecretKeyFactory.getInstance("DES");
					SecretKey wQFugtVg = odEqGRO1.generateSecret(jEz32rYr);
					Cipher XWpODNym = Cipher.getInstance("DES/ECB/PKCS5Padding");
					XWpODNym.init(Cipher.ENCRYPT_MODE, wQFugtVg);
					byte[] lSKnkof6 = new byte[32];
					Random cSTlv597 = new Random();
					cSTlv597.nextBytes(lSKnkof6);
					umq2FUXR.reset();
					umq2FUXR.update(lSKnkof6);
					lSKnkof6 = umq2FUXR.digest();
					SealedObject KZZ0ek8F;
					KZZ0ek8F = new SealedObject(lSKnkof6, XWpODNym);
					objectOut.writeObject(KZZ0ek8F);
					objectOut.flush();
					jEz32rYr = new DESKeySpec(lSKnkof6);
					wQFugtVg = odEqGRO1.generateSecret(jEz32rYr);
					inCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
					outCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
					inCipher.init(Cipher.DECRYPT_MODE, wQFugtVg);
					outCipher.init(Cipher.ENCRYPT_MODE, wQFugtVg);
					SealedObject kWpDZqsp = (SealedObject) objectIn.readObject();
					BLKXo27e = kWpDZqsp.getObject(inCipher);
					if (BLKXo27e instanceof String) {
						String BKOCWmRz = (String) BLKXo27e;
						if (BKOCWmRz.equals("OK")) {
							SealedObject nqGOxO63 = new SealedObject("OK", outCipher);
							objectOut.writeObject(nqGOxO63);
							return Yd0uHBP1;
						} else {
							Debug.netMsg("Client sent false response to challenge!");
						}
					} else {
						Debug.netMsg("Client sent false object as response to challenge!");
					}
				} else {
					Debug.netMsg("client sent unkown username: " + yMgdY6Qz);
				}
			}
		} catch (IllegalBlockSizeException VoH1c9vU) {
			Debug.netMsg("Wrong blocksize for sealed object!");
			Debug.error(VoH1c9vU.toString());
			VoH1c9vU.printStackTrace();
		} catch (ClassNotFoundException XOtranGM) {
			Debug.netMsg("received unrecognized object from client!");
			Debug.error(XOtranGM.toString());
			XOtranGM.printStackTrace();
		} catch (NoSuchAlgorithmException AB8N8Wap) {
			Debug.netMsg("MD5 Algorithm not present in this JVM!");
			Debug.error(AB8N8Wap.toString());
			AB8N8Wap.printStackTrace();
		} catch (InvalidKeySpecException LZS613zo) {
			Debug.netMsg("Error generating cipher, problems with key spec?");
			Debug.error(LZS613zo.toString());
			LZS613zo.printStackTrace();
		} catch (InvalidKeyException fAEfnTDG) {
			Debug.netMsg("Error genertating cipher, problems with key?");
			Debug.error(fAEfnTDG.toString());
			fAEfnTDG.printStackTrace();
		} catch (NoSuchPaddingException OKbOdpHc) {
			Debug.netMsg("Error generating cipher, problems with padding?");
			Debug.error(OKbOdpHc.toString());
			OKbOdpHc.printStackTrace();
		} catch (IOException xRwboEo3) {
			Debug.netMsg("Error authenticating client!");
			Debug.error(xRwboEo3.toString());
			xRwboEo3.printStackTrace();
		} catch (BadPaddingException SclGr1nI) {
			Debug.netMsg("Bad padding exception!");
			Debug.error(SclGr1nI.toString());
			SclGr1nI.printStackTrace();
		}
		return null;
	}

}