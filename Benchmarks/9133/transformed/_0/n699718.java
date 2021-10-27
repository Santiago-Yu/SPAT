class n699718 {
	PasswordTableWindow(String Se0ZTXDg) {
        super(Se0ZTXDg + ", tecle a senha de uso ?nico");
        this.login = Se0ZTXDg;
        Error.log(4001, "Autentica??o etapa 3 iniciada.");
        Container ZTLbHP4V = getContentPane();
        ZTLbHP4V.setLayout(new FlowLayout());
        btnNumber = new JButton[10];
        btnOK = new JButton("OK");
        btnClear = new JButton("Limpar");
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 10));
        ResultSet bMR6MOcG;
        Statement SvsnPPoi;
        String xDD6gfvj;
        Vector<Integer> EWt2WYEs = new Vector<Integer>();
        xDD6gfvj = "select key from Senhas_De_Unica_Vez where login='" + Se0ZTXDg + "'";
        try {
            theConn = DatabaseConnection.getConnection();
            SvsnPPoi = theConn.createStatement();
            bMR6MOcG = SvsnPPoi.executeQuery(xDD6gfvj);
            while (bMR6MOcG.next()) {
                EWt2WYEs.add(bMR6MOcG.getInt("key"));
            }
            bMR6MOcG.close();
            SvsnPPoi.close();
        } catch (Exception zyVaFmhv) {
            zyVaFmhv.printStackTrace();
        } finally {
            try {
                if (theConn != null) theConn.close();
            } catch (Exception fMOBwI7q) {
            }
        }
        Random wMZfkamG = new Random();
        int vWkYTzIJ = wMZfkamG.nextInt();
        if (EWt2WYEs.size() == 0) {
            wMZfkamG = new Random();
            Vector<Integer> CT42pTDZ = new Vector<Integer>();
            Vector<String> SFJU78V3 = new Vector<String>();
            for (int Z2Ya3Glh = 0; Z2Ya3Glh < 10; Z2Ya3Glh++) {
                vWkYTzIJ = wMZfkamG.nextInt() % 10000;
                if (vWkYTzIJ < 0) vWkYTzIJ = vWkYTzIJ * (-1);
                CT42pTDZ.add(vWkYTzIJ);
            }
            try {
                BufferedWriter iKNkAnZS = new BufferedWriter(new FileWriter(Se0ZTXDg + ".txt", false));
                for (int hnRiClG6 = 0; hnRiClG6 < 10; hnRiClG6++) {
                    iKNkAnZS.append("" + hnRiClG6 + " " + CT42pTDZ.get(hnRiClG6) + "\n");
                }
                iKNkAnZS.close();
                try {
                    for (int ujx17XWn = 0; ujx17XWn < 10; ujx17XWn++) {
                        MessageDigest TEmzxcxp = MessageDigest.getInstance("SHA1");
                        TEmzxcxp.update(CT42pTDZ.get(ujx17XWn).toString().getBytes());
                        BigInteger wmECEfrP = new BigInteger(1, TEmzxcxp.digest());
                        String xcf3qoDT = wmECEfrP.toString(16);
                        xDD6gfvj = "insert into Senhas_De_Unica_Vez (login,key,password) values " + "('" + Se0ZTXDg + "'," + ujx17XWn + ",'" + xcf3qoDT + "')";
                        try {
                            theConn = DatabaseConnection.getConnection();
                            SvsnPPoi = theConn.createStatement();
                            SvsnPPoi.executeUpdate(xDD6gfvj);
                            SvsnPPoi.close();
                        } catch (Exception vr8qPI7j) {
                            vr8qPI7j.printStackTrace();
                        } finally {
                            try {
                                if (theConn != null) theConn.close();
                            } catch (Exception wmFKhjtP) {
                            }
                        }
                    }
                } catch (NoSuchAlgorithmException WjyV239W) {
                    WjyV239W.printStackTrace();
                }
            } catch (IOException yr9n2JFi) {
                yr9n2JFi.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "nova tabela de senhas criada para o usu?rio " + Se0ZTXDg + ".");
            Error.log(1002, "Sistema encerrado");
            System.exit(0);
        }
        if (vWkYTzIJ < 0) vWkYTzIJ = vWkYTzIJ * (-1);
        int IVRGlYGa = vWkYTzIJ % EWt2WYEs.size();
        if (IVRGlYGa > EWt2WYEs.size()) IVRGlYGa = 0;
        key = EWt2WYEs.get(IVRGlYGa);
        labelKey = new JLabel("Chave n?mero " + key + " ");
        passwordField = new JPasswordField(12);
        ButtonHandler e8ShwBt1 = new ButtonHandler();
        for (int uU6p9vBp = 0; uU6p9vBp < 10; uU6p9vBp++) {
            btnNumber[uU6p9vBp] = new JButton("" + uU6p9vBp);
            buttonPanel.add(btnNumber[uU6p9vBp]);
            btnNumber[uU6p9vBp].addActionListener(e8ShwBt1);
        }
        btnOK.addActionListener(e8ShwBt1);
        btnClear.addActionListener(e8ShwBt1);
        ZTLbHP4V.add(buttonPanel);
        ZTLbHP4V.add(passwordField);
        ZTLbHP4V.add(labelKey);
        ZTLbHP4V.add(btnOK);
        ZTLbHP4V.add(btnClear);
        setSize(325, 200);
        setVisible(true);
    }

}