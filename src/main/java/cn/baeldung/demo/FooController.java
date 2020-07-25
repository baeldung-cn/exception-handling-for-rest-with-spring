package cn.baeldung.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("foo")
public class FooController {
    @Autowired
    FooService fooService;

    @GetMapping(value = "/{id}")
    public Foo findById(@PathVariable Long id) {
        try {
            return this.fooService.findById(id);
        } catch (FooNotFoundException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }

    @ExceptionHandler({ CustomException1.class, CustomException2.class })
    public void handleException() {
        System.out.println("发生异常");
    }

    @GetMapping("test1")
    public void test1() {
        throw new CustomException1();
    }

    @GetMapping("test2")
    public void test2() {
        throw new CustomException2();
    }

    @GetMapping("test3")
    public void test3() {
        throw new IllegalArgumentException("参数非法");
    }

    @GetMapping("test4")
    public void test4() {
        throw new IllegalStateException("非法状态");
    }

    @GetMapping("test5")
    public void test5() {
        throw new CustomException3();
    }

    private class CustomException1 extends RuntimeException {
    }

    private class CustomException2 extends  RuntimeException {

    }
}

