package org.ram.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.ram.model.Todo;

@Mapper
public interface TodoMapper {

	
    @Select("SELECT * FROM todos")
    List<Todo> findAll();

    

    @Select("SELECT * FROM todos WHERE id = #{id}")
    Todo findById(int id);

    @Insert("INSERT INTO todos(username, description, target_date, done) VALUES(#{username}, #{description}, #{target_date},#{done})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Todo todo);

    @Update("UPDATE todos SET username=#{username}, description=#{description}, target_date=#{target_date}, done=#{done} WHERE id=#{id}")
    void update(Todo todo);

    @Delete("DELETE FROM todos WHERE id=#{id}")
    void delete(int id);
    
    
}
