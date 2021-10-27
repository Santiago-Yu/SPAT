class n20708362 {
	public void updateChecksum() {
		try {
			MessageDigest k0vGaEhK = MessageDigest.getInstance("SHA");
			List<Parameter> wYCVasbu = new ArrayList<Parameter>(parameter_instances.keySet());
			for (Parameter T6ixSBnF : wYCVasbu) {
				if (parameter_instances.get(T6ixSBnF) != null
						&& !(parameter_instances.get(T6ixSBnF) instanceof OptionalDomain.OPTIONS)
						&& !(parameter_instances.get(T6ixSBnF).equals(FlagDomain.FLAGS.OFF))) {
					k0vGaEhK.update(parameter_instances.get(T6ixSBnF).toString().getBytes());
				}
			}
			this.checksum = k0vGaEhK.digest();
		} catch (NoSuchAlgorithmException WgbyVHq5) {
			WgbyVHq5.printStackTrace();
		}
	}

}