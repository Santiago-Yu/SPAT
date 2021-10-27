class n16360226 {
	public static void main(String[] gGvyBxx1) {
		if (gGvyBxx1.length < 1) {
			System.out.println("Parameters:  method arg1 arg2 arg3 etc");
			System.out.println("");
			System.out.println("Methods:");
			System.out.println("    reloadpolicies");
			System.out.println("    migratedatastreamcontrolgroup");
			System.exit(0);
		}
		String h5m1WWwQ = gGvyBxx1[0].toLowerCase();
		if (h5m1WWwQ.equals("reloadpolicies")) {
			if (gGvyBxx1.length == 4) {
				try {
					reloadPolicies(gGvyBxx1[1], gGvyBxx1[2], gGvyBxx1[3]);
					System.out.println("SUCCESS: Policies have been reloaded");
					System.exit(0);
				} catch (Throwable SpvQ8KzA) {
					SpvQ8KzA.printStackTrace();
					System.err.println("ERROR: Reloading policies failed; see above");
					System.exit(1);
				}
			} else {
				System.err.println("ERROR: Three arguments required: " + "http|https username password");
				System.exit(1);
			}
		} else if (h5m1WWwQ.equals("migratedatastreamcontrolgroup")) {
			if (gGvyBxx1.length > 10) {
				System.err.println("ERROR: too many arguments provided");
				System.exit(1);
			}
			if (gGvyBxx1.length < 7) {
				System.err.println("ERROR: insufficient arguments provided.  Arguments are: ");
				System.err.println("    protocol [http|https]");
				System.err.println("    user");
				System.err.println("    password");
				System.err.println("    pid - either");
				System.err.println("        a single pid, eg demo:object");
				System.err.println("        list of pids separated by commas, eg demo:object1,demo:object2");
				System.err.println("        name of file containing pids, eg file:///path/to/file");
				System.err.println("    dsid - either");
				System.err.println("        a single datastream id, eg DC");
				System.err.println("        list of ids separated by commas, eg DC,RELS-EXT");
				System.err.println("    controlGroup - target control group (note only M is implemented)");
				System.err
						.println("    addXMLHeader - add an XML header to the datastream [true|false, default false]");
				System.err.println("    reformat - reformat the XML [true|false, default false]");
				System.err.println(
						"    setMIMETypeCharset - add charset=UTF-8 to the MIMEType [true|false, default false]");
				System.exit(1);
			}
			try {
				boolean nnFxPzNx = getArgBoolean(gGvyBxx1, 7, false);
				boolean fdyNfsGU = getArgBoolean(gGvyBxx1, 8, false);
				boolean QibrVpfQ = getArgBoolean(gGvyBxx1, 9, false);
				;
				InputStream MK2OlCfQ = modifyDatastreamControlGroup(gGvyBxx1[1], gGvyBxx1[2], gGvyBxx1[3], gGvyBxx1[4],
						gGvyBxx1[5], gGvyBxx1[6], nnFxPzNx, fdyNfsGU, QibrVpfQ);
				IOUtils.copy(MK2OlCfQ, System.out);
				MK2OlCfQ.close();
				System.out.println("SUCCESS: Datastreams modified");
				System.exit(0);
			} catch (Throwable vlZ8Bph5) {
				vlZ8Bph5.printStackTrace();
				System.err.println("ERROR: migrating datastream control group failed; see above");
				System.exit(1);
			}
		} else {
			System.err.println("ERROR: unrecognised method " + h5m1WWwQ);
			System.exit(1);
		}
	}

}