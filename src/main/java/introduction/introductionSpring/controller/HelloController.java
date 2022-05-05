package introduction.introductionSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // static
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!!");
        return "hello";
    }

    // MVC + template
    // template 엔진을 mvc별로 쪼개서 랜더링이 된 html(view)를 클라이언트에게 전송
    @GetMapping("hello-mvc") // view 영역으로 return
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    // API
    @GetMapping("hello-string")
    @ResponseBody // http's body
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    // JSon (key : value)
    @GetMapping("hello-api")
    @ResponseBody

    /*
         @ResponseBody  return "hello" -> HttpMessageConverter(return 타입에 따라 나뉨)
                                         (JsonConverter(객체), StringConverter(문자))

            return value(object) : defalut = (JsonConverter) (MappingJaskson2HttpMessageConverter)
                (JSON방식으로 data를 만들어서 http 응답에 반환)

            return String(literal) : defalut = (StringHttpMessageConverter)
     */
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
