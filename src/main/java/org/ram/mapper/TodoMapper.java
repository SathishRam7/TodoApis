package org.ram.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.ram.model.Tag;
import org.ram.model.Todo;

@Mapper
public interface TodoMapper {

	
    @Select("SELECT * FROM todos")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "tags", javaType = List.class, column = "id", many = @Many(select = "findTagsByTodoId"))
    })
    List<Todo> findAll();

    @Select("SELECT * FROM tag")
    List<Tag>getAllTags();

    @Select("SELECT * FROM todos WHERE id = #{id}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "tags", javaType = List.class, column = "id", many = @Many(select = "findTagsByTodoId"))
    })
    Todo findById(int id);

    @Insert("INSERT INTO todos(username, description, target_date, done) VALUES(#{username}, #{description}, #{target_date},#{done})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Todo todo);

    @Update("UPDATE todos SET username=#{username}, description=#{description}, target_date=#{target_date}, done=#{done} WHERE id=#{id}")
    void update(Todo todo);

    @Delete("DELETE FROM todos WHERE id=#{id}")
    void delete(int id);
    
    
    @Insert("INSERT INTO tag(tag_id,tag_name) VALUES(#{tag_id}, #{tag_name})")
    void insertTag(Tag tag);

    @Insert("INSERT INTO todo_tag_mapping(todo_id, tag_id) VALUES(#{todo_id}, #{tag_id})")
    void mapTagToTodo(@Param("todo_id") int todoId, @Param("tag_id") int tagId);


    @Select("SELECT tag.* FROM tag INNER JOIN todo_tag_mapping ON tag.tag_id = todo_tag_mapping.tag_id WHERE todo_tag_mapping.todo_id = #{todo_id}")
    List<Tag> findTagsByTodoId(int todo_id);
    
}
