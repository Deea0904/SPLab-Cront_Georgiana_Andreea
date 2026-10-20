package com.example.labsp;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class LabSpApplication {
//
//    public static void main(String[] args) throws Exception {
//        long startTime = System.currentTimeMillis();
//        Image img1 = new Image("Pamela Anderson");
//        Image img2 = new Image("Kim Kardashian");
//        Image img3 = new Image("Kirby Griffin");
//        Section playboyS1 = new Section("Front Cover");
//        playboyS1.add(img1);
//        Section playboyS2 = new Section("Summer Girls");
//        playboyS2.add(img2);
//        playboyS2.add(img3);
//        Book playboy = new Book("Playboy");
//
//        playboy.add(playboyS1);
//        playboy.add(playboyS2);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Creation of the content took " + (endTime -
//                startTime) + " milliseconds");
//        startTime = System.currentTimeMillis();
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing of the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//        startTime = System.currentTimeMillis();
//        playboyS1.print();
//        endTime = System.currentTimeMillis();
//        System.out.println("Printing again the section 1 took " + (endTime -
//                startTime) + " milliseconds");
//        BookStatistics stat= new BookStatistics();
//        playboy.accept(stat);
//        stat.printStatistics();
//    }
//
//
//}
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; import org.springframework.context.ApplicationContext;
import com.example.labsp.difexample.ClientComponent;
import com.example.labsp.difexample.SingletonComponent;
import com.example.labsp.difexample.TransientComponent;
@SpringBootApplication
public class LabSpApplication {
    public static void main(String[] args) {
//
// Run the main function and inspect the output in console // to learn about the lifecycle of objects within the // Spring Dependency Injection Context
//
// Gets a handle of dependency injection context
        ApplicationContext context =
                SpringApplication.run(LabSpApplication.class, args);
// Gets an instance of TransientComponent from the DI context
TransientComponent transientBean =  context.getBean(TransientComponent.class);
        transientBean.operation();
// Note that every time an instance is required,
// the DI context creates a new one
        transientBean = context.getBean(TransientComponent.class); transientBean.operation();
// Gets an instance of SingletonComponent from the DI context // Note that the unique instance was created while // application was loaded, before creating
// the transient instances
        SingletonComponent singletonBean =
                context.getBean(SingletonComponent.class);
        singletonBean.operation();

// Note that every time an instance is required,
// the DI returns the same unique one
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();
// Gets an instance of another class that
// requires singleton/transient components
// Note where this instance was created and what beans // were used to initialize it
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();
// One can also request an instance from DI context by name c = (ClientComponent)context.getBean("clientComponent"); c.operation();
    }
}
