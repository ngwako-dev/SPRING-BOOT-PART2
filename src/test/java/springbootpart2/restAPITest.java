package springbootpart2;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class restAPITest {

@LocalServerPort
private int port;


    @Autowired
    public TestRestTemplate template;
//injecting UserService dependencies
    @Autowired
    UserService userService;

    private URL base;

    @BeforeEach
    public void urlLink()throws Exception{
        this.base=new URL("http://localhost:"+port);
    }

    @Test
    //Testing the Cache annotation
    void getUser() {
        userService.addUser(1,"Gift","mos");

        String user1=userService.getUser(1);
        String user2=userService.getUser(1);
        String user3=userService.getUser(1);
        String user4=userService.getUser(1);



        System.out.print(user1+"\n"+ user2+"\n" + user3+"\n"+user4+"\n");
    }
    @Test
    //testing to show that your username and password actually work
    public void AuthenRequest()throws Exception{
        ResponseEntity<String> response = template.withBasicAuth("ngmoshobane","8g9FI10@").getForEntity(base.toString(),String.class);
    }


}


