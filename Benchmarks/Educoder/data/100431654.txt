    public void conMail(MailObject mail) throws NetworkException, ContentException {
        HttpClient client = HttpConfig.newInstance();
        String url = HttpConfig.bbsURL() + HttpConfig.BBS_MAIL_CON + mail.getId() + "&" + HttpConfig.BBS_MAIL_N_PARAM_NAME + "=" + mail.getNumber();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            if (HTTPUtil.isXmlContentType(response)) {
                Document doc = XmlOperator.readDocument(entity.getContent());
                BBSBodyParseHelper.parseMailContent(doc, mail);
            } else {
                String msg = BBSBodyParseHelper.parseFailMsg(entity);
                throw new ContentException(msg);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            throw new NetworkException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new NetworkException(e);
        }
    }
