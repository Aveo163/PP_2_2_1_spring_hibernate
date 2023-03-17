package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args){
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Alexander", "Russkin", "AlexRusskin@mail.ru", new Car("VW", 1)));
      userService.add(new User("Jackie", "Chan", "JackieChan@mail.ru", new Car("BMW", 7)));
      userService.add(new User("Mel", "Gibson", "MelGibson@mail.ru", new Car("Audi", 6)));
      userService.add(new User("Tom", "Cruise", "TomCruise@mail.ru", new Car("Lada", 3)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      List<User> users2 = userService.getUserByCar("VW", 1);
      for (User user : users2) {
         System.out.println(user);
      }

      context.close();
   }
}

