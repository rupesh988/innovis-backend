package com.atlas.research.controller;

import com.atlas.research.repository.Paperdb;
import com.atlas.research.repository.Projectdb;
import com.atlas.research.repository.applicantdb;
import com.atlas.research.repository.userdb;
import com.atlas.research.service.Applicants;
import com.atlas.research.service.Papers;
import com.atlas.research.service.Projects;
import com.atlas.research.service.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
public class cred {


    @Autowired
    users user1;
    @Autowired
    userdb userdb1;
    @Autowired
    applicantdb applicantdb1;
    @Autowired
    Applicants applicant;



    @RequestMapping("/")
    public String home(){
        return "access denied!";
    }


    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody users usr){
        HashMap<String,Object> json = new HashMap<>();
        user1 = userdb1.findByEmailAndPassword(usr.getEmail(), usr.getPassword());
        if(user1 != null){
            json.put("status",true);
        }else{
            json.put("status",false);
        }
        return json;
    }



    @PostMapping("/signup")
    public HashMap<String,Object> signup(@RequestBody users usr){
        HashMap<String,Object> json = new HashMap<>();
        user1 = userdb1.findByEmail(usr.getEmail());
        if(user1 != null){
            json.put("status",false);
            json.put("message","user exists..try resetting your password");
            return json;
        }



        try {
            userdb1.save(usr);
            json.put("status",true);
            json.put("message","signup success");
        } catch (Exception e) {
            json.put("status",false);
            json.put("message",e.getMessage());
        }

        return  json;
    }

    @PostMapping("/application")
    public HashMap<String,Object> application(@RequestBody  Applicants app1){
        HashMap<String,Object> json = new HashMap<>();
            applicantdb1.save(app1);
            json.put("status",true);


        return json;

    }

    @GetMapping("/getapp/{email}")
    public Applicants getapp(@PathVariable String email){
        System.out.println("got request");
        return applicantdb1.findByEmail(email);
    }
    @Autowired
    JavaMailSender ms;
    @Async
    @PostMapping("/passwdreset/{email}")
    public HashMap<String,Object> sendmail(@PathVariable String email){
        HashMap<String,Object> json = new HashMap<>();
        Random rand = new Random();
        SimpleMailMessage mail = new SimpleMailMessage();
        user1 = userdb1.findByEmail(email);
        if(user1 ==  null){
            json.put("status",false);
            json.put("message","no user exists");
        }else{
            mail.setTo(user1.getEmail());
            String otp = String.valueOf(rand.nextInt(10000,99999));
            mail.setText(otp);
            json.put("otp",Integer.valueOf(otp));
            mail.setFrom("inrupesh.in@gmail.com");
            mail.setSubject("password reset for innovis");
            ms.send(mail);
            json.put("status",true);
            json.put("message","mail sent.");

        }

        return json;
    }

    @PostMapping("/mail")
    public String mail(){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setSubject("from rupesh");
        mail.setTo("inrupesh.in@gmail.com");
        ms.send(mail);
        return "sent";
    }



    @Autowired
    private Papers paper;

    @Autowired
    private Paperdb pdb;

    @PostMapping("/paper")
    public HashMap<String,Object> paperCreate(@RequestBody Papers pr){
        HashMap<String,Object> json = new HashMap<>();




        try {
            pdb.save(pr);
            json.put("status",true);
            json.put("message","paper published ");
        } catch (Exception e) {
            json.put("status",false);
            json.put("message",e.getMessage());
        }

        return  json;
    }


    @GetMapping("/getpapers/{email}")
    public List<Papers> getpapers(@PathVariable String email){
        return pdb.findByEmail(email);
    }


    @Autowired
    private Projects project;

    @Autowired
    private Projectdb projectdb;

    @PostMapping("/projects")
    public HashMap<String,Object> ProjectCreate(@RequestBody Projects pr){
        HashMap<String,Object> json = new HashMap<>();




        try {
            projectdb.save(pr);
            json.put("status",true);
            json.put("message","paper published ");
        } catch (Exception e) {
            json.put("status",false);
            json.put("message",e.getMessage());
        }

        return  json;
    }


    @GetMapping("/getprojects/{email}")
    public List<Projects> getProjects(@PathVariable String email){
        return projectdb.findByEmail(email);
    }













}
