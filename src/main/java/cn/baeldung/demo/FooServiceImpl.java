package cn.baeldung.demo;

import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {
    @Override
    public Foo findById(Long id) {
        throw new FooNotFoundException();
    }
}
