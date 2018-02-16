package com.example.demo.mapper.slave;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Todo;

@Component
@Mapper
public interface TodoReaderMapper {

    @Select("SELECT id, title, body, finished FROM todo WHERE id = #{id}")
    public Todo select(int id);
}
