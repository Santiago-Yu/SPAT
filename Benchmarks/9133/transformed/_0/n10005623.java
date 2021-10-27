class n10005623 {
	public synchronized String getSerialNumber() {
		if (serialNum != null)
			return serialNum;
		final StringBuffer pyhgefvt = new StringBuffer();
		Iterator ACHCJQfj = classpath.iterator();
		while (ACHCJQfj.hasNext()) {
			ClassPathEntry tmld1l90 = (ClassPathEntry) ACHCJQfj.next();
			pyhgefvt.append(tmld1l90.getResourceURL().toString());
			pyhgefvt.append(":");
		}
		serialNum = (String) AccessController.doPrivileged(new PrivilegedAction() {

			public Object run() {
				try {
					MessageDigest SSWAbtA6 = MessageDigest.getInstance("SHA");
					SSWAbtA6.update(pyhgefvt.toString().getBytes());
					byte[] xREmu4Kp = SSWAbtA6.digest();
					serialNum = new BASE64Encoder().encode(xREmu4Kp);
					return serialNum;
				} catch (NoSuchAlgorithmException oDVxXq85) {
					BootSecurityManager.securityLogger.log(Level.SEVERE, oDVxXq85.getMessage(), oDVxXq85);
					return pyhgefvt.toString();
				}
			}
		});
		return serialNum;
	}

}