package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator <Object []> example(){
        List<Object []> list = new ArrayList<>();
      //  list.add(new Object[]{....});

        return list.iterator();
    }

    @DataProvider
    public Iterator <Object []> addNewContactSuccess(){
        List<Object []> list = new ArrayList<>();
        list.add(new Object[]{ Contact.builder()
                .name("Asenia")
                .lastName("Poroz")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("all fields")
                .build()});
        list.add(new Object[]{ Contact.builder()
                .name("Wsenia")
                .lastName("Qoroz")
                .phone("1234567891")
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .description("all fields")
                .build()});
        return list.iterator();
    }

    @DataProvider
    public  Iterator <Object[]> addContSuccessAllReqField (){
        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Bsenia")
                .lastName("oroz")
                .phone("1234457891" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("Wsenia")
                .lastName("Roroz")
                .phone("1234457891" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("Hsenia")
                .lastName("Noroz")
                .phone("1234457891" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("Gsenia")
                .lastName("Joroz")
                .phone("1234457891" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });

        return  list.iterator();
    }

    @DataProvider
    public  Iterator <Object[]>  wrongPhone (){
        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Bsenia")
                .lastName("oroz")
                .phone("12344578915467858766578" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("Wsenia")
                .lastName("Roroz")
                .phone("1234" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("Hsenia")
                .lastName("Noroz")
                .phone("ewfrergrg" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });
        list.add(new Object[]{Contact.builder()
                .name("Gsenia")
                .lastName("Foroz")
                .phone("--------" )
                .email("wer@Gmail.com")
                .address("Tel Aviv")
                .build()
        });
        return  list.iterator();
    }

    @DataProvider
    public Iterator <Object []> contactCSV() throws IOException {
        List<Object []> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line!=null){
            String [] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }


}
