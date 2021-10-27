class n4871307 {
	private boolean authenticateWithServer(String KZYHojnH, String hEo81Rfm) {
		Object PI8rVkQs;
		String cUWfPE4I;
		byte[] qtdmVdi2;
		try {
			PI8rVkQs = objectIn.readObject();
			if (PI8rVkQs instanceof String) {
				cUWfPE4I = (String) PI8rVkQs;
				Debug.netMsg("Connected to JFritz Server: " + cUWfPE4I);
				if (!cUWfPE4I.equals("JFRITZ SERVER 1.1")) {
					Debug.netMsg("Unkown Server version, newer JFritz protocoll version?");
					Debug.netMsg("Canceling login attempt!");
				}
				objectOut.writeObject(KZYHojnH);
				objectOut.flush();
				MessageDigest syA5xCe2 = MessageDigest.getInstance("MD5");
				syA5xCe2.update(hEo81Rfm.getBytes());
				DESKeySpec sQ7l14sk = new DESKeySpec(syA5xCe2.digest());
				SecretKeyFactory D7CHLqGP = SecretKeyFactory.getInstance("DES");
				SecretKey ArS3FrWA = D7CHLqGP.generateSecret(sQ7l14sk);
				Cipher AmxAmImb = Cipher.getInstance("DES/ECB/PKCS5Padding");
				AmxAmImb.init(Cipher.DECRYPT_MODE, ArS3FrWA);
				SealedObject pq66lL49 = (SealedObject) objectIn.readObject();
				PI8rVkQs = pq66lL49.getObject(AmxAmImb);
				if (PI8rVkQs instanceof byte[]) {
					qtdmVdi2 = (byte[]) PI8rVkQs;
					sQ7l14sk = new DESKeySpec(qtdmVdi2);
					ArS3FrWA = D7CHLqGP.generateSecret(sQ7l14sk);
					inCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
					outCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
					inCipher.init(Cipher.DECRYPT_MODE, ArS3FrWA);
					outCipher.init(Cipher.ENCRYPT_MODE, ArS3FrWA);
					SealedObject SfflJE79 = new SealedObject("OK", outCipher);
					objectOut.writeObject(SfflJE79);
					SealedObject um80Vcy5 = (SealedObject) objectIn.readObject();
					PI8rVkQs = um80Vcy5.getObject(inCipher);
					if (PI8rVkQs instanceof String) {
						if (PI8rVkQs.equals("OK")) {
							return true;
						} else {
							Debug.netMsg("Server sent wrong string as response to authentication challenge!");
						}
					} else {
						Debug.netMsg("Server sent wrong object as response to authentication challenge!");
					}
				} else {
					Debug.netMsg("Server sent wrong type for data key!");
				}
			}
		} catch (ClassNotFoundException fg5bYlJF) {
			Debug.error("Server authentication response invalid!");
			Debug.error(fg5bYlJF.toString());
			fg5bYlJF.printStackTrace();
		} catch (NoSuchAlgorithmException CVGgdBOh) {
			Debug.netMsg("MD5 Algorithm not present in this JVM!");
			Debug.error(CVGgdBOh.toString());
			CVGgdBOh.printStackTrace();
		} catch (InvalidKeySpecException VHTiySt1) {
			Debug.netMsg("Error generating cipher, problems with key spec?");
			Debug.error(VHTiySt1.toString());
			VHTiySt1.printStackTrace();
		} catch (InvalidKeyException qnwnGom6) {
			Debug.netMsg("Error genertating cipher, problems with key?");
			Debug.error(qnwnGom6.toString());
			qnwnGom6.printStackTrace();
		} catch (NoSuchPaddingException pdO0urSF) {
			Debug.netMsg("Error generating cipher, problems with padding?");
			Debug.error(pdO0urSF.toString());
			pdO0urSF.printStackTrace();
		} catch (EOFException ogjAnw4N) {
			Debug.error("Server closed Stream unexpectedly!");
			Debug.error(ogjAnw4N.toString());
			ogjAnw4N.printStackTrace();
		} catch (SocketTimeoutException MyBBggMy) {
			Debug.error("Read timeout while authenticating with server!");
			Debug.error(MyBBggMy.toString());
			MyBBggMy.printStackTrace();
		} catch (IOException m3M0nDWw) {
			Debug.error("Error reading response during authentication!");
			Debug.error(m3M0nDWw.toString());
			m3M0nDWw.printStackTrace();
		} catch (IllegalBlockSizeException m4A3xKrH) {
			Debug.error("Illegal block size exception!");
			Debug.error(m4A3xKrH.toString());
			m4A3xKrH.printStackTrace();
		} catch (BadPaddingException V43PCHYn) {
			Debug.error("Bad padding exception!");
			Debug.error(V43PCHYn.toString());
			V43PCHYn.printStackTrace();
		}
		return false;
	}

}