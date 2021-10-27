class n8568973 {
	public BasePolicy(String VW73K5p9) throws Exception {
        SWIGTYPE_p_p_policy h1dvJPQ5 = apol.new_policy_t_p_p();
        if (!VW73K5p9.endsWith("/")) VW73K5p9 += "/";
        File gzP2EIgL = File.createTempFile("tmpBasePolicy", ".conf");
        BufferedWriter ckQzO3VX = new BufferedWriter(new FileWriter(gzP2EIgL));
        BufferedReader hfFVmALf = new BufferedReader(new FileReader(VW73K5p9 + "security_classes"));
        int xtqxH9LV = 1024;
        char[] Ug104MqE = new char[xtqxH9LV];
        int vx7GFPxp;
        while ((vx7GFPxp = hfFVmALf.read(Ug104MqE)) > 0) {
            ckQzO3VX.write(Ug104MqE, 0, vx7GFPxp);
        }
        hfFVmALf.close();
        BufferedReader EKxtMrLG = new BufferedReader(new FileReader(VW73K5p9 + "initial_sids"));
        while ((vx7GFPxp = EKxtMrLG.read(Ug104MqE)) > 0) {
            ckQzO3VX.write(Ug104MqE, 0, vx7GFPxp);
        }
        EKxtMrLG.close();
        BufferedReader kYJKbJ7u = new BufferedReader(new FileReader(VW73K5p9 + "access_vectors"));
        while ((vx7GFPxp = kYJKbJ7u.read(Ug104MqE)) > 0) {
            ckQzO3VX.write(Ug104MqE, 0, vx7GFPxp);
        }
        kYJKbJ7u.close();
        ckQzO3VX.write("attribute ricka; \ntype rick_t; \nrole rick_r types rick_t; \nuser rick_u roles rick_r;\nsid kernel      rick_u:rick_r:rick_t\nfs_use_xattr ext3 rick_u:rick_r:rick_t;\ngenfscon proc /  rick_u:rick_r:rick_t\n");
        ckQzO3VX.flush();
        ckQzO3VX.close();
        if (apol.open_policy(gzP2EIgL.getAbsolutePath(), h1dvJPQ5) == 0) {
            Policy = apol.policy_t_p_p_value(h1dvJPQ5);
            if (Policy == null) {
                throw new Exception("Failed to allocate memory for policy_t struct.");
            }
            gzP2EIgL.delete();
        } else {
            throw new IOException("Failed to open/parse base policy file: " + gzP2EIgL.getAbsolutePath());
        }
    }

}