/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bee.plataforma.config;

import com.bee.correo.daoImpl.EnvioDaoImpl;
import com.bee.correo.model.EnvioModel;
import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lealva
 */
public class EnvioMail {

    public Response sendMail(String fromMail, String toMail, String subjectMail, String body) throws IOException, Exception {
        Email from = new Email(fromMail);
        String subject = subjectMail;
        Content content = new Content("text/html", body);
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.addContent(content);
        mail.addCategory("bee");
        mail.addCategory("8");
        EncryptKeyMail key = new EncryptKeyMail();
        String keyenvio = key.getRandomKey("8", toMail);
        mail.addCategory(keyenvio);
        Personalization pers = new Personalization();
        pers.addTo(new Email(toMail.trim()));
        mail.addPersonalization(pers);
        EnvioModel envio = new EnvioModel();
        envio.setCanalenvio(8);
        envio.setEmail(toMail);
        envio.setKey(keyenvio);
        boolean respuesta = new EnvioDaoImpl().guardarCorreo(envio);
        System.out.println("RESPUESTA REGISTRO  " + respuesta);
        Response response = null;
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
            System.out.println(response.getStatusCode());
        } catch (IOException ex) {
            //  logger.log(Level.SEVERE, "error del sistema", ex);
            throw ex;
        }
        return response;
    }

    public Response sendMailTicketPrimerEnvio(String fromMail, String toMail, String subjectMail, String body, String base64PDF, String fileName, String base64FE, String fileNameFE) throws IOException, Exception {
        Map<String, String> resp = new HashMap<String, String>();
        Email from = new Email(fromMail);
        String subject = subjectMail;
        Content content = new Content("text/html", body);
        //Mail mail = new Mail(from, subject, to, content);
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.addContent(content);
        mail.addCategory("bee");
        mail.addCategory("8");
        EncryptKeyMail key = new EncryptKeyMail();
        mail.addCategory(key.getRandomKey("8", toMail));
        Personalization pers = new Personalization();
        mail.addCategory(key.getRandomKey("8", toMail));
        pers.addCc(new Email(toMail.trim()));
        mail.addPersonalization(pers);

        Attachments attachments2 = new Attachments();
        attachments2.setFilename(fileName);
        attachments2.setType("application/pdf");
        attachments2.setDisposition("attachment");
        String attachmentContent2 = base64PDF;
        attachments2.setContent(attachmentContent2);
        mail.addAttachments(attachments2);

        Attachments attachments3 = new Attachments();
        attachments3.setFilename(fileNameFE);
        attachments3.setType("application/pdf");
        attachments3.setDisposition("attachment");
        String attachmentContent3 = base64FE;
        attachments3.setContent(attachmentContent3);
        mail.addAttachments(attachments3);

        // seteo del key
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        //preparando el envio
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            Logger.getLogger("Estado Email API").log(Level.WARNING, "{0}", response.getStatusCode());
            return response;
        } catch (Exception e) {
            //logger.log(Level.SEVERE, "error del sistema", e);
            return null;
        }
    }

    public Response sendMailTicket(String fromMail, String toMail, String subjectMail, String body, String base64PDF, String fileName, String base64FE, String fileNameFE, String base64FEXML, String fileNameXML) throws IOException, Exception {
        Map<String, String> resp = new HashMap<String, String>();
        Email from = new Email(fromMail);
        String subject = subjectMail;
        Content content = new Content("text/html", body);
        //Mail mail = new Mail(from, subject, to, content);
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setSubject(subject);
        mail.addContent(content);
        mail.addCategory("bee");
        mail.addCategory("8");
        EncryptKeyMail key = new EncryptKeyMail();
        mail.addCategory(key.getRandomKey("8", toMail));
        Personalization pers = new Personalization();
        mail.addCategory(key.getRandomKey("8", toMail));
        pers.addCc(new Email(toMail.trim()));
        mail.addPersonalization(pers);

        Attachments attachments2 = new Attachments();
        attachments2.setFilename(fileName);
        attachments2.setType("application/pdf");
        attachments2.setDisposition("attachment");
        String attachmentContent2 = base64PDF;
        attachments2.setContent(attachmentContent2);
        mail.addAttachments(attachments2);

        Attachments attachments3 = new Attachments();
        attachments3.setFilename(fileNameFE);
        attachments3.setType("application/pdf");
        attachments3.setDisposition("attachment");
        String attachmentContent3 = base64FE;
        attachments3.setContent(attachmentContent3);
        mail.addAttachments(attachments3);

        Attachments attachments4 = new Attachments();
        attachments4.setFilename(fileNameXML);
        attachments4.setType("application/pdf");
        attachments4.setDisposition("attachment");
        String attachmentContent4 = base64FEXML;
        attachments4.setContent(attachmentContent4);
        mail.addAttachments(attachments4);

        // seteo del key
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        //preparando el envio
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            Logger.getLogger("Estado Email API").log(Level.WARNING, "{0}", response.getStatusCode());
            return response;
        } catch (Exception e) {
            //logger.log(Level.SEVERE, "error del sistema", e);
            return null;
        }
    }

    public Response sendMail_lib(String fromMail, String toMail, String subjectMail, String body, String archivo) throws IOException {
        //logger.info("llegando a sendmail2 & " + fromMail+"°pp°" + toMail+"°pp°"+subjectMail+"°pp°"+"°pp°");
        Email from = new Email(fromMail);
        String subject = subjectMail;
        Email to = new Email(toMail);
        Content content = new Content("text/html", body);
        Mail mail = new Mail(from, subject, to, content);
        //logger.info("1 -");

        if (!archivo.equals("")) {
            String[] parts;
            parts = archivo.split("¦");
            String base_doc = parts[0], nom_doc = parts[1], ext_doc = parts[2];
            //logger.info("2 -" + nom_doc + " "+ext_doc +" '" + base_doc );
            Attachments attachments = new Attachments();
            attachments.setFilename(nom_doc + "." + ext_doc);
            if (ext_doc.equals("doc")) {
                attachments.setType("application/msword");
                //logger.info("1*");
            } else if (ext_doc.equals("docx")) {
                attachments.setType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                //logger.info("2*");
            } else if ((ext_doc.equals("jpg")) || (ext_doc.equals("jpeg")) || (ext_doc.equals("png"))) {
                attachments.setType("image/*");
                //logger.info("3*");
            } else {
                attachments.setType("application/pdf");
                //logger.info("4*");
            }
            //logger.info("3 -");
            attachments.setDisposition("attachment");
            //logger.info("4 -");
            //byte[] attachmentContentBytes = archivobytes;
            // logger.info("4.5  +  "+ archivobytes);
            String attachmentContent = base_doc;
            //logger.info("4.5 -");
            attachments.setContent(attachmentContent);
            mail.addAttachments(attachments);
            //logger.info("5 -");
            //
        }

        System.out.println("Error " + mail);
        Response response = null;
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            //logger.info("error del sistema"+ ex);
            throw ex;
        }
        return response;
    }
    /*
     public static void main(String[] args) throws IOException {
     EnvioMail envioMail = new EnvioMail();
     Response resp = envioMail.sendMail("socios@prize.com.pe", "Alicia_16_17@hotmail.com", "Prueba", new cuerpoenvio().cuerpo("202020"));
     System.out.println("Respuesta: " + resp.getStatusCode());
     }
     */
}
