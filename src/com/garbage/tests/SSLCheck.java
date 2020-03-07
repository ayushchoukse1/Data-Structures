package com.garbage.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Iterator;

public class SSLCheck {
	private static final String URL = "https://httpbin.org/user-agent";

	public static void main(String[] args) throws FileNotFoundException {
		 String filename = System.getProperty("java.home") + "/lib/security/cacerts".replace('/', File.separatorChar);

         FileInputStream is = new FileInputStream(filename);
         KeyStore keystore =null;
		try {
			keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		} catch (KeyStoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         String password = "changeit";
         try {
			keystore.load(is, password.toCharArray());
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         // This class retrieves the most-trusted CAs from the keystore
         PKIXParameters params = null;
		try {
			params = new PKIXParameters(keystore);
		} catch (KeyStoreException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         // Get the set of trust anchors, which contain the most-trusted CA certificates
         Iterator it = params.getTrustAnchors().iterator();
         while( it.hasNext() ) {
             TrustAnchor ta = (TrustAnchor)it.next();
             // Get certificate
             X509Certificate cert = ta.getTrustedCert();
             System.out.println(cert);
         }
	}

}
