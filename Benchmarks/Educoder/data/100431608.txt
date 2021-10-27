    public String getUser() {
        try {
            HttpGet get = new HttpGet("http://api.linkedin.com/v1/people/~");
            consumer.sign(get);
            HttpClient client = new DefaultHttpClient();
            HttpResponse response = client.execute(get);
            if (response != null) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != 200) {
                    this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
                }
                StringBuffer sBuf = new StringBuffer();
                String linea;
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                while ((linea = reader.readLine()) != null) {
                    sBuf.append(linea);
                }
                reader.close();
                response.getEntity().consumeContent();
                get.abort();
                String salida = sBuf.toString();
                String user_firstname = salida.split("</first-name>")[0].split("<first-name>")[1];
                String user_lastname = salida.split("</last-name>")[0].split("<last-name>")[1];
                return user_firstname + " " + user_lastname;
            }
        } catch (UnsupportedEncodingException e) {
            this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
        } catch (IOException e) {
            this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
        } catch (OAuthMessageSignerException e) {
            this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
        } catch (OAuthExpectationFailedException e) {
            this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
        } catch (OAuthCommunicationException e) {
            this.enviarMensaje("Error: Usuario no autenticado en la red de Linkedin");
        }
        return null;
    }
