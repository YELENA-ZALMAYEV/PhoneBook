package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider

    public Iterator <Object[]> example(){
        List <Object[]> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> loginData (){
        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{"pap@gmail.com","@1234567Qq@"});
        list.add(new Object[]{"pap@gmail.com","@1234567Qq@"});
        list.add(new Object[]{"pap@gmail.com","@1234567Qq@"});
        return list.iterator();
    }

    @DataProvider
    public  Iterator <Object []> loginsModels(){
        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@")});
        list.add(new Object[]{new User().withEmail("pap@gmail.com").withPassword("@1234567Qq@")});
        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> loginWrongEmail (){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("papgmail.com").withPassword("@1234567Qq@")});
        list.add(new Object[]{new User().withEmail("papgmail.com").withPassword("@1234567Qq@")});
        return list.iterator();
        }

    @DataProvider
    public Iterator <Object[]> loginWrongPassword (){
        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("pap@gmail.com").withPassword("@1234567q@")});
        list.add(new Object[]{new User().withEmail("pap@gmail.com").withPassword("@1234567q@")});
        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> loginUnregisteredUser (){
        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("asasa@gmail.com").withPassword("qwert!@#$@")});
        list.add(new Object[]{new User().withEmail("asasa@gmail.com").withPassword("qwert!@#$@")});
        list.add(new Object[]{new User().withEmail("asasa@gmail.com").withPassword("qwert!@#$@")});
        return list.iterator();

    }

    @DataProvider
    public  Iterator <Object[]> loginFile () throws IOException {
        List<Object[]> list = new ArrayList<>();
        //read from file ---> add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/data.csv")));
        String line = reader.readLine(); //pap@gmail.com,@1234567Qq@
        while (line!=null){
            String[] all = line.split(","); //[//pap@gmail.com,@1234567Qq@][//pap@gmail.com,@1234567Qq@]
            list.add(new Object[]{new User().withEmail(all[0]).withPassword(all[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    }



