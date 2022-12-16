package demo;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.Micronaut;

@Controller("/")
public class Application {
    public static ApplicationContext ctx;
    public static void main(String[] args) {
        ctx = Micronaut.run(Application.class, args);
    }

    @Get("/{name}")
    public String Hello(String name) {
        UserRepository userRepository = ctx.getBean(UserRepository.class);
        return "Should only show the url user " + name +"\n" + userRepository.listUsersTainted(name);
    }
}
