package com.tpe.app;

import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.FileRepository;
import com.tpe.repository.Repo;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;

public class MyApplication {

    public static void main(String[] args) {

        Message message = new Message();
        message.setMessage("Siparisiniz kargoya verildi");

        //maille mesaj gonderelim.
//        MailService mailService = new MailService();
//        mailService.sendMessage(message);

        //vazgectik sms ile gonderelim.
//        SmsService smsService = new SmsService();
//        smsService.sendMessage(message);

        //bu boyle gitmez...inteface cozum olabilir mi?

        //MessageService service = new SmsService();
        //MessageService service = new MailService();
        //service.sendMessage(message);

        //run time da hangi servisi kullanacagimizi belirtmek istesek

//        MessageService service=null;
//        String serviceName=null;
//
//        if(args.length>0){
//            serviceName=args[0];
//        }
//        if (serviceName.equalsIgnoreCase("MailService")){
//            service=new MailService();
//        }else{
//            service=new SmsService();
//        }
//        service.sendMessage(message);

        //mesajlari kalici hale getirmek istersek
        Repo repo = new DbRepository(); //veya DbRepo
        MessageService service = new MailService(repo); //DI
        service.sendMessage(message);
        service.saveMessage(message); //file a kaydetmek istersek


        MessageService service2 = new SmsService(repo); //DI
        service2.saveMessage(message);


        //ancak hala newleme yapiyoruz.






    }
}
