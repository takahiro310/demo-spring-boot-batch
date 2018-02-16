package com.example.demo.mapper.master;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Todo;

@Component
@Mapper
public interface TodoWriterMapper {

    @Insert("INSERT INTO todo (title, body, finished) VALUES (#{title}, #{body}, #{finished})")
    @Options(useGeneratedKeys = true)
    public void insert(Todo todo);

}
