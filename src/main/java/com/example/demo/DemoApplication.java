package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Todo;
import com.example.demo.mapper.master.TodoWriterMapper;
import com.example.demo.mapper.slave.TodoReaderMapper;
import com.example.demo.system.config.db.MasterDataSourceProperties;
import com.example.demo.system.config.db.SlaveDataSourceProperties;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableConfigurationProperties({
    DataSourceProperties.class
    ,MasterDataSourceProperties.class
    ,SlaveDataSourceProperties.class
    })
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private TodoWriterMapper todoWriterMapper;
    @Autowired
    private TodoReaderMapper todoReaderMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Todo newTodo = new Todo();
        newTodo.setTitle("à˘Ç›âÔ");
        newTodo.setBody("ã‚ç¿ 19:00");
        todoWriterMapper.insert(newTodo);

        Todo loadedTodo = todoReaderMapper.select(newTodo.getId());
        Optional<Todo> optTodo = Optional.ofNullable(loadedTodo);
        optTodo.ifPresent(todo -> System.out.println(todo.getId()));
        optTodo.ifPresent(todo -> System.out.println(todo.getTitle()));
        optTodo.ifPresent(todo -> System.out.println(todo.getBody()));
        optTodo.ifPresent(todo -> System.out.println(todo.isFinished()));
    }
}
